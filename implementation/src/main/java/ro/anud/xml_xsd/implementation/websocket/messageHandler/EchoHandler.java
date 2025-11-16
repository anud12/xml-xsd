package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@Component
public record EchoHandler() implements WebSocketHandler.Factory {
    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add("echo",(client, string) -> {
            try (var logger = logScope("echo");){
                client.broadcastOk(string);
            }

        });
    }
}
