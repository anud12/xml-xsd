package ro.anud.xml_xsd.implementation.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component()
public class WebSocketHandler extends TextWebSocketHandler {

    private static Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @FunctionalInterface
    public interface MessageHandler {
        void handle(Client client, String message) throws IOException;
    }

    public interface Factory {
        void instantiate(WebSocketHandler webSocketHandler);
    }

    private final HashMap<String, MessageHandler> handlerHashMap = new HashMap<>();
    private final HashMap<String, Client> clientMap = new HashMap();

    public WebSocketHandler(List<Factory> factoryList) {
        factoryList.forEach(factory -> factory.instantiate(this));
    }

    @Override
    public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        clientMap.put(session.getId(), new Client(this, session));
    }

    @Override
    public void afterConnectionClosed(final WebSocketSession session, final CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        clientMap.remove(session.getId());
    }


    public void broadCastMessage(final WebSocketMessage<?> message) throws IOException {
        for (Map.Entry<String, Client> entry : clientMap.entrySet()) {;
            entry.getValue().send(message);
        }
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        var handledMessageCount = handlerHashMap.entrySet()
            .stream()
            .filter((entry) -> {
                var key = entry.getKey() + "\n";
                if (payload.startsWith(key)) {
                    try {
                        entry.getValue().handle(clientMap.get(session.getId()), payload.replaceFirst(key, ""));
                        return true;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return false;
            })
            .count();
        if (handledMessageCount <= 0) {
            session.sendMessage(new TextMessage("not handled"));
        }
    }

    public WebSocketHandler add(String command, MessageHandler consumer) {
        logger.info("registering command :" + command);
        handlerHashMap.put(command, consumer);
        return this;
    }
}
