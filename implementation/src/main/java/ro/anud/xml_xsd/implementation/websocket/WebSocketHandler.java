package ro.anud.xml_xsd.implementation.websocket;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

@Component()
@Setter
@Getter
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
    private final HashMap<String, Client> clientMap = new HashMap<>();
    private WorldStepInstance worldStepInstance = new WorldStepInstance();
    private final Object syncronizer = new Object();

    public WebSocketHandler(List<Factory> factoryList) {
        factoryList.forEach(factory -> factory.instantiate(this));
    }

    @Override
    public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
        var logger = logEnter("afterConnectionEstablished", session.getId());
        super.afterConnectionEstablished(session);
        clientMap.put(session.getId(), new Client(this, session));
    }

    @Override
    public void afterConnectionClosed(final WebSocketSession session, final CloseStatus status) throws Exception {
        var logger = logEnter("afterConnectionClosed", session.getId());
        super.afterConnectionClosed(session, status);
        clientMap.remove(session.getId());
    }

    public void sendMessage(WebSocketSession webSocketSession, final WebSocketMessage<?> message) throws IOException {
        synchronized (syncronizer) {
            if(webSocketSession.isOpen()) {
                webSocketSession.sendMessage(message);
            }
        }
    }
    public void broadCastMessage(final WebSocketMessage<?> message) throws IOException {
        synchronized (syncronizer) {
            for (Map.Entry<String, Client> entry : clientMap.entrySet()) {
                entry.getValue().send(message);
            }
        }

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        var logger = logEnter("handleTextMessage", message.getPayload());
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
            logger.log("send not handled");
            session.sendMessage(new TextMessage("not handled"));
        }
    }

    public WebSocketHandler add(String command, MessageHandler consumer) {
        logger.info("registering command :" + command);
        handlerHashMap.put(command, consumer);
        return this;
    }
}
