package ro.anud.xml_xsd.specification;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.xmlunit.XMLUnitException;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.ElementSelectors;
import ro.anud.xml_xsd.specification.websocket.echo.EchoTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ro.anud.xml_xsd.specification.HttpTestBase.prettyFormat;

public class WebSocketTestBase {

    public enum Command {
        Echo("echo");

        public final String value;

        Command(final String value) {
            this.value = value;
        }
    }

    public static Collection<DynamicTest> runTestRelativeToClass(
        final Class<? extends EchoTest> aClass,
        Command command) {
        return List.of(
            send(aClass, command)
        );
    }

    static public DynamicTest send(final Class<? extends EchoTest> aClass, Command command) {
        return DynamicTest.dynamicTest(
            "sending", () -> {
                String relativePath = Paths.get(aClass.getResource("").toURI()).toString();

                String uri = "ws://localhost:" + 8080 + "/ws";
                WebSocketTestClient mainClient = new WebSocketTestClient();
                mainClient.connect(uri);


                var mainExpected = Optional.<String>empty();
                var otherExpected = Optional.<String>empty();

                try {
                    mainExpected = Optional.of(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        "/2_main_expected.txt")))
                    );
                } catch (IOException ignored) {}

                try {
                    otherExpected = Optional.of(new String(Files.readAllBytes(Path.of(
                        relativePath,
                        "/2_other_expected.txt")))
                    );
                } catch (IOException ignored) {}

                WebSocketTestClient otherClient = new WebSocketTestClient();
                otherClient.connect(uri);

                mainClient.sendMessage(command.value + "\n" + new String(Files.readAllBytes(Path.of(
                    relativePath,
                    "/1_send.txt"))
                ));
                mainExpected.ifPresent(string -> {
                    assertEquals(string, mainClient.getReceivedMessage());
                });
                otherExpected.ifPresent(string -> {
                    assertEquals(string, otherClient.getReceivedMessage());
                });
            });
    }
}
