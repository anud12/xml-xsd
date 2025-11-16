package ro.anud.xml_xsd.websocket.tests;

import ro.anud.xml_xsd.specification.WebSocketTestClient;
import ro.anud.xml_xsd.strategy.TestStrategy;

public class StopHandler {
    public static TestStrategy send() {
        return TestStrategy.group(TestStrategy.class.getSimpleName())
            .and(
                "connect clients", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";

                    WebSocketTestClient mainClient = new WebSocketTestClient();
                    mainClient.connect(uri);
                    return mainClient;
                })
            .and(
                "send stop", mainClient -> {
                    mainClient.sendMessage(WebSocketTestClient.Command.Stop.value);
                    mainClient.disconnect();
                });
    }
}
