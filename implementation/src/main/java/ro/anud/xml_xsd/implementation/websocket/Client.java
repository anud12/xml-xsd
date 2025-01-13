package ro.anud.xml_xsd.implementation.websocket;

import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public record Client(WebSocketHandler handler, WebSocketSession webSocketSession) {

    public void send(WebSocketMessage<?> message) throws IOException {
        webSocketSession.sendMessage(message);
    }
    public void broadcast(WebSocketMessage<?> message) throws IOException {
        handler.broadCastMessage(message);
    }
}
