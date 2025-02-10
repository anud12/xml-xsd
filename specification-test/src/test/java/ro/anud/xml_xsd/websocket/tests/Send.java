package ro.anud.xml_xsd.websocket.tests;

import org.assertj.core.api.Assertions;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.specification.WebSocketTestClient;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Send {
    public static TestStrategy run(
        final Class<?> runningClass,
        WebSocketTestClient.Command command,
        String sendFileName,
        String expectedFileName,
        String expectedOtherFileName) {
        return TestStrategy.group("Send")
            .and(
                "connect clients", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";

                    WebSocketTestClient mainClient = new WebSocketTestClient();
                    mainClient.connect(uri);

                    WebSocketTestClient otherClient = new WebSocketTestClient();
                    otherClient.connect(uri);

                    record Entry(WebSocketTestClient mainClient, WebSocketTestClient otherClient) {}
                    return new Entry(mainClient, otherClient);
                })
            .and(
                "send command", entry -> {
                    String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                    var payload = new String(Files.readAllBytes(Path.of(
                        relativePath,
                        sendFileName))
                    ).replaceFirst("\r\n", "\n");

                    var mainClient = entry.mainClient;

                    record Entry(String main, String other) {}
                    return new Entry(
                        mainClient.sendMessageSync(command.value + "\n" + payload),
                        entry.otherClient.getLastReceivedMessage()
                    );
                })
            .and(
                "assert main response", response -> {
                    String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                    Assertions.assertThat(response.main).isEqualTo(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        expectedFileName))
                    ).replaceFirst("\r\n", "\n"));

                    return response;
                })
            .and(
                "assert other response", response -> {
                    String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                    Assertions.assertThat(response.other).isEqualTo(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        expectedOtherFileName))
                    ).replaceFirst("\r\n", "\n"));

                });
    }
}
