package ro.anud.xml_xsd.websocket.tests;

import ro.anud.xml_xsd.cases.CaseBuilder;
import ro.anud.xml_xsd.specification.WebSocketTestClient;

import java.util.concurrent.atomic.AtomicReference;

public class StartStop {
    private final AtomicReference<WebSocketTestClient> atomicReference = new AtomicReference<>();


    public CaseBuilder send() {
        return CaseBuilder.group(this.getClass().getSimpleName())
            .and(
                "connect clients", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";

                    WebSocketTestClient mainClient = new WebSocketTestClient();
                    mainClient.connect(uri);
                    atomicReference.set(mainClient);
                    return mainClient;
                })
            .and(
                "send startStep", mainClient -> {
                    mainClient.sendMessage(WebSocketTestClient.Command.StartStop.value);
                });
    }

    public CaseBuilder waitUntilFinished() {
        return CaseBuilder.group(this.getClass().getSimpleName())
            .and(
                "reading response", () -> {
                    while (true) {
                        var count = atomicReference.get().getAllResponses().stream().anyMatch(responseMessage -> responseMessage.response().equals(
                            WebSocketTestClient.Response.StartStop));
                        if (count) {
                            return;
                        }
                        Thread.sleep(1);
                    }

                });
    }
}
