package ro.anud.xml_xsd.websocket;

import org.junit.jupiter.api.DynamicTest;
import ro.anud.xml_xsd.specification.WebSocketTestClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebSocketTestBase {

    public static Collection<DynamicTest> runTestRelativeToClass(
        final Class<?> aClass,
        WebSocketTestClient.Command command) {
        return List.of(
            send(aClass, command)
        );
    }


    static public DynamicTest send(final Class<?> aClass, WebSocketTestClient.Command command) {
        return DynamicTest.dynamicTest(
            "sending", () -> {
                String relativePath = Paths.get(aClass.getResource("").toURI()).toString();

                String uri = "ws://localhost:" + 8080 + "/ws";

                try {
                    WebSocketTestClient loadClient = new WebSocketTestClient();
                    loadClient.connect(uri);
                    Optional.of(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        "/1_load.xml")))
                    ).ifPresent(string -> {
                        try {
                            loadClient.sendMessageSync(WebSocketTestClient.Command.Load.value + "\n" + string);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                } catch (IOException ignored) {}

                WebSocketTestClient mainClient = new WebSocketTestClient();
                mainClient.connect(uri);

                WebSocketTestClient otherClient = new WebSocketTestClient();
                otherClient.connect(uri);

                var mainExpected = Optional.<String>empty();
                var otherExpected = Optional.<String>empty();

                try {
                    mainExpected = Optional.of(new String(Files.readAllBytes(Path.of(
                            relativePath,
                            "/3_main_expected.txt"))
                        ).replaceAll("\r\n", "\n")
                    );
                } catch (IOException ignored) {}

                try {
                    otherExpected = Optional.of(new String(Files.readAllBytes(Path.of(
                            relativePath,
                            "/3_other_expected.txt"))
                        ).replaceAll("\r\n", "\n")
                    );
                } catch (IOException ignored) {}

                var sendText = Optional.empty();

                try {
                    sendText = Optional.of(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        "/2_send.txt"))
                    ).replaceAll("\r\n", "\n"));
                } catch (Exception ignored) {

                }
                try {
                    sendText = Optional.of(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        "/2_send.xml"))
                    ).replaceAll("\r\n", "\n"));
                } catch (Exception ignored) {
                }
                sendText.ifPresent(object -> {
                    try {
                        mainClient.sendMessageSync(command.value + "\n" + object);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                final Optional<String> finalMainExpected = mainExpected;
                sendText.ifPresent(object -> {
                    finalMainExpected.ifPresent(string -> {

                        assertEquals(string, mainClient.getLastReceivedMessage());
                    });
                });

                otherExpected.ifPresent(string -> {
                    if (!string.isBlank()) {
                        assertEquals(string, otherClient.getLastReceivedMessage());
                    }
                });
            });
    }
}
