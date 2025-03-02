package ro.anud.xml_xsd.specification;

import jakarta.websocket.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@ClientEndpoint
public class WebSocketTestClient {
    private Session session;
    private List<String> receivedMessage = new ArrayList<>();

    public record ResponseMessage(Response response, String body) {
        static ResponseMessage fromFullString(String message) {
            var split = message.split("\n");
            var response = Response.fromString(split[0]);
            return new ResponseMessage(response, message.replaceFirst(response.command, ""));
        }
    }

    public enum Response {
        Ok("ok\n"),
        Update("update\n"),
        Other(""),
        StartStop("startStop\n"),
        Load("load\n"),
        Put("put\n");

        public final String command;
        public static Response fromString(String string) {
            return Arrays.stream(Response.values())
                .filter(response -> response.command.equals(string + "\n"))
                .findFirst()
                .orElse(Other);
        }

        Response(final String command) {this.command = command;}
    }

    public enum Command {
        Echo("echo\n"),
        Load("load\n"),
        Download("download\n"),
        StartStop("startStop\n"),
        Update("update\n"),
        Start("start\n"),
        Stop("stop\n"),
        Put("put\n");
        public final String value;

        Command(final String value) {
            this.value = value;
        }
    }

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
        System.out.println("Received: " + message);
        this.receivedMessage.add(message);
    }

    @OnClose
    public void onClose() {
        this.session = null;
    }

    public void sendMessage(String message) throws Exception {
        System.out.println("Sending: " + message);
        session.getBasicRemote().sendText(message);
    }

    public String sendMessageSync(String message) throws Exception {
        // Reset the latch and received message for a new operation
        var messageCount = receivedMessage.size();
        var future = CompletableFuture.runAsync(() -> {
            while (receivedMessage.size() == messageCount) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Send the message
        sendMessage(message);
        future.get();
        if (receivedMessage.isEmpty()) {
            return "";
        }
        return receivedMessage.getLast();
    }

    public WebSocketTestClient clearMessages() {
        receivedMessage = new ArrayList<>();
        return this;
    }

    public List<String> getAllMessages() {
        return receivedMessage;
    }

    public List<ResponseMessage> getAllResponses() {
        return new ArrayList<>(getAllMessages()).stream()
            .map(ResponseMessage::fromFullString)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public String getLastReceivedMessage() {
        var message = receivedMessage.getLast();
        return message;
    }

}
