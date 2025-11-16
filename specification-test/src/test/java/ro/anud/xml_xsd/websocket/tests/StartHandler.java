package ro.anud.xml_xsd.websocket.tests;

import ro.anud.xml_xsd.specification.WebSocketTestClient;
import ro.anud.xml_xsd.strategy.TestStrategy;

public class StartHandler {
    public static TestStrategy send() {
        return TestStrategy.group(StartHandler.class.getSimpleName())
            .and(
                "connect clients", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";

                    WebSocketTestClient mainClient = new WebSocketTestClient();
                    mainClient.connect(uri);
                    return mainClient;
                })
            .and(
                "send start", mainClient -> {
                    mainClient.sendMessage(WebSocketTestClient.Command.Start.value);
                    mainClient.disconnect();
                });
    }
}
