package ro.anud.xml_xsd.implementation.javascriptContext;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import ro.anud.xml_xsd.implementation.javascriptContext.api.JavascriptAPI;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.Scripts.Scripts;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.io.IOException;
import java.util.*;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class JavascriptRunner {


    private Context context = initializeContext();

    private final WorldStepInstance worldStepInstance;
    private JavascriptAPI javascriptContext;

    public HashMap<String, Runnable> onServerTickMap = new HashMap<>();

    public JavascriptRunner(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        javascriptContext = new JavascriptAPI(worldStepInstance, this);
    }

    public void onServerTick() {
        try (var scope = logScope()) {
            onServerTickMap.values().forEach(Runnable::run);
        }
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

    public WorldStepInstance getWorldStepInstance() {
        return worldStepInstance;
    }
}
