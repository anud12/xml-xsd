package ro.anud.xml_xsd.websocket.tests;

import org.assertj.core.api.Assertions;
import ro.anud.xml_xsd.cases.CaseBuilder;
import ro.anud.xml_xsd.specification.WebSocketTestClient;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

public class ReadUpdates {

    private final AtomicReference<WebSocketTestClient> mainClient = new AtomicReference<>();
    private final AtomicReference<WebSocketTestClient> otherClient = new AtomicReference<>();

    public CaseBuilder connect() {
        return CaseBuilder.group(this.getClass().getSimpleName())
            .and(
                "connect main client", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";
                    mainClient.getAndUpdate(webSocketTestClient -> new WebSocketTestClient());
                    mainClient.get().connect(uri);
                })
            .and(
                "connect other client", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";
                    otherClient.getAndUpdate(webSocketTestClient -> new WebSocketTestClient());
                    otherClient.get().connect(uri);
                })
            .and(
                "waiting", () -> {
                    Thread.sleep(10);
                });
    }

    public CaseBuilder assertResponse(
        final Class<?> runningClass,
        final String mainExpected,
        final String otherExpected) {
        return CaseBuilder.group(this.getClass().getSimpleName())
            .and(
                "assert receivedMessage", () -> {
                    String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                    var payload = new String(
                        Files.readAllBytes(Path.of(
                            relativePath,
                            mainExpected)
                        )).replaceFirst("\r\n", "\n");

                    var message = String.join(
                        "\n---\n",
                        mainClient.get().getAllResponses()
                            .stream()
                            .filter(responseMessage -> responseMessage.response().equals(
                                WebSocketTestClient.Response.Update))
                            .map(WebSocketTestClient.ResponseMessage::body).toList()
                    );
                    Assertions.assertThat(message).isEqualToNormalizingNewlines(payload);


                    var otherPayload = new String(
                        Files.readAllBytes(Path.of(
                            relativePath,
                            mainExpected)
                        )).replaceFirst("\r\n", "\n");

                    var otherMessage = String.join(
                        "\n---\n",
                        otherClient.get().getAllResponses()
                            .stream()
                            .filter(responseMessage -> responseMessage.response().equals(
                                WebSocketTestClient.Response.Update))
                            .map(WebSocketTestClient.ResponseMessage::body).toList()
                    );
                    Assertions.assertThat(otherMessage).isEqualToNormalizingNewlines(otherPayload);
                });
    }
}
