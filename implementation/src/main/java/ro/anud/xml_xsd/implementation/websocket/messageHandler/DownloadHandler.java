package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import ro.anud.xml_xsd.implementation.util.LocalLogger;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import javax.xml.transform.TransformerException;

import static ro.anud.xml_xsd.implementation.controller.http.AnalyzeController.serializeWorldStepInstance;

@Component
public record DownloadHandler() implements WebSocketHandler.Factory {
    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add(
            "download", (client, string) -> {
                var logger = LocalLogger.logEnter("download");
                try {
                    serializeWorldStepInstance(client.worldStepInstance())
                        .ifPresent(client::sendOk);
                } catch (TransformerException e) {
                    client.broadcastNOk(e.toString());
                    throw new RuntimeException(e);
                }
                logger.logReturnVoid();
            });
    }
}
