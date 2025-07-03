package ro.anud.xml_xsd.websocket.tests;

import org.assertj.core.api.Assertions;
import ro.anud.xml_xsd.specification.WebSocketTestClient;
import ro.anud.xml_xsd.strategy.TestStrategy;

public class AppendHandler {
    private static TestStrategy.AndLambda<TestStrategy.Value<String>> run(
        final Class<?> runningClass,
        String fileName,
        WebSocketTestClient.Response response) {

        return caseBuilder -> caseBuilder.and(TestStrategy.group(AppendHandler.class.getSimpleName())
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
                    webSocketTestClient.sendMessage(WebSocketTestClient.Command.Append.value + entry.fileString);

                    while (true) {
                        var value = webSocketTestClient.getAllResponses().stream()
                            .filter(responseMessage -> responseMessage
                                .response()
                                .equals(response)
                            ).findFirst();
                        if (value.isPresent()) {
                            return value.get().body();
                        }
                        Thread.sleep(1);
                    }
                }));
    }

    public static TestStrategy.AndLambda<TestStrategy.Unit> runNodeNotFound(
        final Class<?> runningClass,
        String fileName,
        String expectedFileName) {

        return caseBuilder -> caseBuilder.and(run(runningClass, fileName, WebSocketTestClient.Response.Append_nodeNotFound))
            .and(ReadFromFileStep.wrap(runningClass,expectedFileName))
            .and(
                "assert response" + expectedFileName, stringFileResult ->  {
                    Assertions.assertThat(stringFileResult.parent()).isEqualTo(stringFileResult.fileString());
                });
    }


    public static TestStrategy.AndLambda<TestStrategy.Unit> runValidated(
        final Class<?> runningClass,
        String fileName,
        String expectedFileName) {

        return caseBuilder -> caseBuilder.and(run(runningClass, fileName, WebSocketTestClient.Response.Append))
            .and(ReadFromFileStep.wrap(runningClass,expectedFileName))
            .and(
                "assert response " + expectedFileName, stringFileResult ->  {
                    Assertions.assertThat(stringFileResult.parent()).isEqualTo(stringFileResult.fileString());
                });
    }
}
