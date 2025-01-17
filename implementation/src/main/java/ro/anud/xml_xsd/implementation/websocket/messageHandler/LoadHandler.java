package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import ro.anud.xml_xsd.implementation.util.LocalLogger;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import static ro.anud.xml_xsd.implementation.controller.http.AnalyzeController.buildWorldStep;

@Component
public record LoadHandler() implements WebSocketHandler.Factory {
    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add(
            "load", (client, string) -> {
                var logger = LocalLogger.logEnter("load");
                try {
                    var worldStep = buildWorldStep(string);
                    client.worldStepInstance().setWorldStep(worldStep);
                    client.broadcastOk();
                } catch (SAXException e) {
                    client.broadcastNOk(e.toString());
                }
                logger.logReturnVoid();
            });
    }
}
