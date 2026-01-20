package ro.anud.xml_xsd.implementation.service.javascriptContext;

import lombok.Getter;
import org.graalvm.polyglot.HostAccess;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.javascriptContext.entity.EntityJavascriptContext;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@Getter
public class JavascriptContext {
    @HostAccess.Export
    public final EntityJavascriptContext entity;

    private final WorldStepInstance worldStepInstance;
    private final JavascriptRunner javascriptRunner;

    public JavascriptContext(WorldStepInstance worldStepInstance, JavascriptRunner javascriptRunner) {
        this.worldStepInstance = worldStepInstance;
        this.javascriptRunner = javascriptRunner;
        entity = new EntityJavascriptContext(javascriptRunner);
    }


    @HostAccess.Export
    public void sendMessageBroadcast(String message) {
        try (var scope = logScope("called with " + message)) {
            worldStepInstance.broadcastDebug(message);
        }
    }
}
