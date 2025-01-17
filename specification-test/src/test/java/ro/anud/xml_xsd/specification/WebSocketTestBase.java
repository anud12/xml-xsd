package ro.anud.xml_xsd.specification;

import org.junit.jupiter.api.DynamicTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebSocketTestBase {

    public enum Command {
        Echo("echo"),
        Load("load"),
        Download("download");

        public final String value;

        Command(final String value) {
            this.value = value;
        }
    }

    public static Collection<DynamicTest> runTestRelativeToClass(
        final Class<?> aClass,
        Command command) {
        return List.of(
            send(aClass, command)
        );
    }


    static public DynamicTest send(final Class<?> aClass, Command command) {
        return DynamicTest.dynamicTest(
            "sending", () -> {
                String relativePath = Paths.get(aClass.getResource("").toURI()).toString();

                String uri = "ws://localhost:" + 8080 + "/ws";
                WebSocketTestClient loadClient = new WebSocketTestClient();
                loadClient.connect(uri);
                try {
                    Optional.of(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        "/1_load.xml")))
                    ).ifPresent(string -> {
                        try {
                            loadClient.sendMessageSync(Command.Load.value + "\n" + string);
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
                        "/3_main_expected.txt")))
                    );
                } catch (IOException ignored) {}

                try {
                    otherExpected = Optional.of(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        "/3_other_expected.txt")))
                    );
                } catch (IOException ignored) {}


                mainClient.sendMessageSync(command.value + "\n" + new String(Files.readAllBytes(Path.of(
                    relativePath,
                    "/2_send.txt"))
                ));
                mainExpected.ifPresent(string -> {
                    assertEquals(string, mainClient.getReceivedMessage());
                });
                otherExpected.ifPresent(string ->  {
                    if(!string.isBlank()) {
                        assertEquals(string, otherClient.getReceivedMessage());
                    }
                });
            });
    }
}
