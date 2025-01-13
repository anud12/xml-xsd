package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

@Component
public record EchoHandler() implements WebSocketHandler.Factory {
    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add("echo",(client, string) -> {
            client.broadcast(new TextMessage(string));
        });
    }
}
