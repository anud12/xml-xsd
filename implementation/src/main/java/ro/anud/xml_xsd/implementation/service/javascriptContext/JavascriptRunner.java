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
import ro.anud.xml_xsd.implementation.service.javascriptContext.mutation.Mutation;

import java.io.IOException;
import java.util.*;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class JavascriptRunner {


    private Context context = initializeContext();

    private final WorldStepInstance worldStepInstance;
    private JavascriptContext javascriptContext;
    public final JavascriptExecutor executor = new JavascriptExecutor();

    public HashMap<String, Runnable> onServerTickMap = new HashMap<>();

    public JavascriptRunner(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        javascriptContext = new JavascriptContext(worldStepInstance, this);
    }

    public void onServerTick() {
        onServerTickMap.values().forEach(Runnable::run);
        executor.executeMutations(worldStepInstance);
        executor.clearMutations();
    }

    private static Context initializeContext() {
        try (var scope = logScope()) {
            return Context.newBuilder("js")
                    .allowHostAccess(HostAccess.EXPLICIT)
                    .allowAllAccess(false)
                    .option("engine.WarnInterpreterOnly", "false")
                    .option("js.esm-eval-returns-exports", "true")
                    .build();
        }
    }

    public void load(String name, String code) {
        try (var scope = logScope("loading script " + name)) {
            Source src = Source.newBuilder("js", code, name)
                    .mimeType("application/javascript+module")
                    .build();
            Value module = context.eval(src);
            onServerTickMap.put(name, () -> {
                module.getMember("onServerTick").execute(javascriptContext);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void reloadScripts() {
        try (var scope = logScope("reloadScripts")) {
            scope.log("clear onServerTickMap");
            onServerTickMap.clear();
            scope.log("initializing context");
            context = initializeContext();
            worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamScripts)
                    .flatMap(Scripts::streamFile)
                    .forEach(file -> {
                        load(file.getName(), file.rawNode().getChildrenFirst("text").get().getStringBody());
                    });
            scope.log("onServerTickMap keys: ", onServerTickMap.keySet());
        }
    }
}
