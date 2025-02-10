package ro.anud.xml_xsd.implementation.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public record Client(WebSocketHandler handler, WebSocketSession webSocketSession) {



    public enum ReturnCode {
        Ok("Ok\n"),
        Download("download\n"),
        StartStop("startStop\n"),
        Load("load\n");

        private final String value;

        ReturnCode(final String value) {
            this.value = value;
        }
    }

    public void send(WebSocketMessage<?> message) throws IOException {
        handler.sendMessage(webSocketSession, message);
    }

    public void broadcast(WebSocketMessage<?> message) throws IOException {
        handler.broadCastMessage(message);
    }
    public void broadcast(final ReturnCode returnCode) {
        try {
            handler.broadCastMessage(new TextMessage(returnCode.value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void sendOk(String message) {
        try {
            handler.sendMessage(webSocketSession, new TextMessage("Ok\n" + message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(ReturnCode returnCode) {
        send(returnCode, "");
    }

    public void send(ReturnCode returnCode, String message) {
        try {
            logEnter("sending ", returnCode.value);
            handler.sendMessage(webSocketSession, new TextMessage(returnCode.value + message));
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
