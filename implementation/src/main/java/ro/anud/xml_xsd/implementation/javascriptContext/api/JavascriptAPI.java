package ro.anud.xml_xsd.implementation.javascriptContext.api;

import lombok.Getter;
import org.graalvm.polyglot.HostAccess;
import ro.anud.xml_xsd.implementation.javascriptContext.JavascriptRunner;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.javascriptContext.api.entity.EntityJSApi;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@Getter
public class JavascriptAPI {
    @HostAccess.Export
    public final EntityJSApi entity;

    private final WorldStepInstance worldStepInstance;
    private final JavascriptRunner javascriptRunner;

    public JavascriptAPI(WorldStepInstance worldStepInstance, JavascriptRunner javascriptRunner) {
        this.worldStepInstance = worldStepInstance;
        this.javascriptRunner = javascriptRunner;
        entity = new EntityJSApi(javascriptRunner);
    }


    @HostAccess.Export
    public void sendMessageBroadcast(String message) {
        try (var scope = logScope("called with " + message)) {
            worldStepInstance.broadcastDebug(message);
        }
    }
}
