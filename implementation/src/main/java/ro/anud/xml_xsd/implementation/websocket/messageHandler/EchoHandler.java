package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import ro.anud.xml_xsd.implementation.util.LocalLogger;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

@Component
public record EchoHandler() implements WebSocketHandler.Factory {
    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add("echo",(client, string) -> {
            var logger = LocalLogger.logEnter("echo");
            client.broadcastOk(string);
            logger.logReturnVoid();
        });
    }
}
