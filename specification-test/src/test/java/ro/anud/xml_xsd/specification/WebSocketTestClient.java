package ro.anud.xml_xsd.specification;

import jakarta.websocket.*;

import java.net.URI;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@ClientEndpoint
public class WebSocketTestClient {
    private Session session;
    private String receivedMessage;
    private final CountDownLatch latch = new CountDownLatch(1);

    public void connect(String uri) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(this, new URI(uri));
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        this.receivedMessage = message;
        latch.countDown();
    }

    @OnClose
    public void onClose() {
        this.session = null;
    }

    public void sendMessage(String message) throws Exception {
        session.getBasicRemote().sendText(message);
    }

    public String getReceivedMessage()  {
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return null;
        }
        return receivedMessage;
    }
}
