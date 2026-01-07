package ro.anud.xml_xsd.implementation.service.javascriptContext;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.proxy.ProxyObject;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.Scripts.Scripts;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class JavascriptRunner {

    private final WorldStepInstance worldStepInstance;
    private static Optional<Context> context = Optional.empty();
    private JavascriptContext javascriptContext;
    private ProxyObject serverContext;
    public HashMap<String, Runnable> onServerTickMap = new HashMap<>();

    public JavascriptRunner(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        if (context.isEmpty()) {
            context = Optional.of(Context.newBuilder("js")
                    .allowHostAccess(HostAccess.EXPLICIT)
                    .allowAllAccess(false)
                    .option("js.esm-eval-returns-exports", "true")
                    .build());
        }
        javascriptContext = new JavascriptContext(worldStepInstance);
    }

    public void onServerTick() {
        onServerTickMap.values().forEach(Runnable::run);
    }

    public void load(String name, String code) {
        try (var scope = logScope("loading script " + name)) {
            Source src = Source.newBuilder("js", code, name)
                    .mimeType("application/javascript+module")
                    .build();

            Value module = context.get().eval(src);
            onServerTickMap.put(name, () -> {
                module.getMember("onServerTick").execute(javascriptContext);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void reloadScripts() {
        worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamRuleGroup)
                .flatMap(RuleGroup::streamScripts)
                .flatMap(Scripts::streamFile)
                .forEach(file -> {
                    load(file.getName(), file.rawNode().getChildrenFirst("text").get().getStringBody());
                });
    }
}
