package ro.anud.xml_xsd.websocket.tests;

import org.assertj.core.api.Assertions;
import ro.anud.xml_xsd.cases.CaseBuilder;
import ro.anud.xml_xsd.specification.WebSocketTestClient;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Download {
    public static CaseBuilder run(final Class<?> runningClass, String fileName) {

        return CaseBuilder.group(Download.class.getSimpleName())
            .and(
                "connecting and downloading", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";
                    WebSocketTestClient loadClient = new WebSocketTestClient();
                    loadClient.connect(uri);
                    return loadClient.sendMessageSync(WebSocketTestClient.Command.Download.value);
                })
            .and(
                "assert received message", (message) -> {
                    String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();
                    Assertions.assertThat(message).isEqualToNormalizingNewlines(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        fileName))
                    ));
                });
    }
}
