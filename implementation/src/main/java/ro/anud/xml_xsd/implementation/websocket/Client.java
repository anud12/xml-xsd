package ro.anud.xml_xsd.implementation.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.io.IOException;

public record Client(WorldStepInstance worldStepInstance, WebSocketHandler handler, WebSocketSession webSocketSession) {

    public void send(WebSocketMessage<?> message) throws IOException {
        handler.sendMessage(webSocketSession, message);
    }
    public void broadcast(WebSocketMessage<?> message) throws IOException {
        handler.broadCastMessage(message);
    }
    public void sendOk(String message) {
        try {
            handler.sendMessage(webSocketSession, new TextMessage("Ok\n" + message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void broadcastOk() {
        try {
            handler.broadCastMessage(new TextMessage("Ok"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void broadcastOk(String message) {
        try {
            handler.broadCastMessage(new TextMessage("Ok\n" + message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void broadcastNOk() {
        try {
            handler.broadCastMessage(new TextMessage("NOk"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void broadcastNOk(String message) {
        try {
            handler.broadCastMessage(new TextMessage("NOk\n" + message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
