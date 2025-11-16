package ro.anud.xml_xsd.websocket.tests;

import org.assertj.core.api.Assertions;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.specification.WebSocketTestClient;

public class LoadStep {

    public static TestStrategy.AndLambda<TestStrategy.Unit> runValidated(
        final Class<?> runningClass,
        String fileName) {

        return caseBuilder -> caseBuilder.and(TestStrategy.group(LoadStep.class.getSimpleName())
            .and(ReadFromFileStep.run(runningClass, fileName))
            .and(
                "connecting", (fileString) -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";
                    WebSocketTestClient loadClient = new WebSocketTestClient();
                    loadClient.connect(uri);
                    record Entry(String fileString, WebSocketTestClient webSocketTestClient) {}
                    return new Entry(fileString, loadClient);
                })
            .and(
                "sending", entry -> {
                    var webSocketTestClient = entry.webSocketTestClient;
                    webSocketTestClient.sendMessage(WebSocketTestClient.Command.Load.value + entry.fileString);

                    while (true) {
                        var value = webSocketTestClient.getAllResponses().stream()
                            .filter(responseMessage -> responseMessage
                                .response()
                                .equals(WebSocketTestClient.Response.Load)
                            ).findFirst();
                        if (value.isPresent()) {
                            webSocketTestClient.disconnect();
                            return value.get().body();
                        }
                        Thread.sleep(1);
                    }
                })
            .and("assert response",string -> {
                Assertions.assertThat(string).isEqualTo("");
            }));

    }

    public static TestStrategy.AndLambda<TestStrategy.Value<String>> run(
        final Class<?> runningClass,
        String fileName) {

        return caseBuilder -> caseBuilder.and(TestStrategy.group(LoadStep.class.getSimpleName())
            .and(ReadFromFileStep.run(runningClass, fileName))
            .and(
                "connecting", (fileString) -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";
                    WebSocketTestClient loadClient = new WebSocketTestClient();
                    loadClient.connect(uri);
                    record Entry(String fileString, WebSocketTestClient webSocketTestClient) {}
                    return new Entry(fileString, loadClient);
                })
            .and(
                "sending", entry -> {
                    var webSocketTestClient = entry.webSocketTestClient;
                    webSocketTestClient.sendMessage(WebSocketTestClient.Command.Load.value + entry.fileString);

                    while (true) {
                        var value = webSocketTestClient.getAllResponses().stream()
                            .filter(responseMessage -> responseMessage
                                .response()
                                .equals(WebSocketTestClient.Response.Load)
                            ).findFirst();
                        if (value.isPresent()) {
                            return value.get().body();
                        }
                        Thread.sleep(10);
                    }
                }));

    }

}
