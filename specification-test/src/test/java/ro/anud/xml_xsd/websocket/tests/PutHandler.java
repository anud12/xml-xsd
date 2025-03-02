package ro.anud.xml_xsd.websocket.tests;

import org.assertj.core.api.Assertions;
import ro.anud.xml_xsd.specification.WebSocketTestClient;
import ro.anud.xml_xsd.strategy.TestStrategy;

public class PutHandler {
    public static TestStrategy.AndLambda<TestStrategy.Unit> runValidated(
        final Class<?> runningClass,
        String fileName) {

        return caseBuilder -> caseBuilder.and(TestStrategy.group(PutHandler.class.getSimpleName())
            .and(ReadFromFileStep.run(runningClass, fileName))
            .and(
                "connecting", (fileString) -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";
                    WebSocketTestClient client = new WebSocketTestClient();
                    client.connect(uri);
                    record Entry(String fileString, WebSocketTestClient webSocketTestClient) {}
                    return new Entry(fileString, client);
                })
            .and(
                "sending", entry -> {
                    var webSocketTestClient = entry.webSocketTestClient;
                    webSocketTestClient.sendMessage(WebSocketTestClient.Command.Put.value + entry.fileString);

                    while (true) {
                        var value = webSocketTestClient.getAllResponses().stream()
                            .filter(responseMessage -> responseMessage
                                .response()
                                .equals(WebSocketTestClient.Response.Put)
                            ).findFirst();
                        if (value.isPresent()) {
                            return value.get().body();
                        }
                        Thread.sleep(1);
                    }
                })
            .and("assert response",string -> {
                Assertions.assertThat(string).isEqualTo("");
            }));

    }
}
