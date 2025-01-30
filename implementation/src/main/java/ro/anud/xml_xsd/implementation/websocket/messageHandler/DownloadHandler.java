package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.util.LocalLogger;
import ro.anud.xml_xsd.implementation.util.RawNode;
import ro.anud.xml_xsd.implementation.websocket.Client;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

@Component
public record DownloadHandler() implements WebSocketHandler.Factory {
    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add(
            "download", (client, string) -> {
                var logger = LocalLogger.logEnter("download");
                webSocketHandler.getWorldStepInstance().getWorldStep().map(WorldStep::serializeIntoRawNode)
                        .map(RawNode::toDocumentString)
                            .ifPresent(string1 -> client.send(Client.ReturnCode.Download, string1));
                logger.logReturnVoid();
            });
    }
}
