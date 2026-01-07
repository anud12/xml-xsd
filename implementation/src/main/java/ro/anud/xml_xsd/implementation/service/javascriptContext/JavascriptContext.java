package ro.anud.xml_xsd.implementation.service.javascriptContext;

import org.graalvm.polyglot.HostAccess;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class JavascriptContext {
    private final WorldStepInstance worldStepInstance;

    public JavascriptContext(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    @HostAccess.Export
    public void sendMessageBroadcast(String message) {
        try (var scope = logScope("called with " + message)){
            worldStepInstance.broadcastDebug(message);
        }
    }
}
