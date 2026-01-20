package ro.anud.xml_xsd.websocket.tests;

import org.assertj.core.api.Assertions;
import org.xmlunit.XMLUnitException;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.ElementSelectors;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.specification.WebSocketTestClient;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ro.anud.xml_xsd.specification.HttpTestBase.prettyFormat;

public class Download {
    public static TestStrategy run(final Class<?> runningClass, String fileName) {

        return TestStrategy.group(Download.class.getSimpleName())
            .and(
                "connecting and downloading", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";
                    WebSocketTestClient loadClient = new WebSocketTestClient();
                    loadClient.connect(uri);
                    var message = loadClient.sendMessageSync(WebSocketTestClient.Command.Download.value);
                    loadClient.disconnect();
                    return message;
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

    public static TestStrategy assertXml(final Class<?> runningClass, String fileName) {

        return TestStrategy.group(Download.class.getSimpleName())
            .and(
                "connecting and downloading", () -> {
                    String uri = "ws://localhost:" + 8080 + "/ws";
                    WebSocketTestClient loadClient = new WebSocketTestClient();
                    loadClient.connect(uri);
                    var message = loadClient.sendMessageSync(WebSocketTestClient.Command.Download.value);
                    loadClient.disconnect();
                    return message;
                })
            .and(
                "assert received message", (message) -> {
                    var strippedMessage = message.replace(WebSocketTestClient.Command.Download.value,"");
                    String relativePath = Paths.get(runningClass.getResource("").toURI()).toString();

                    var expected = new String(Files.readAllBytes(Path.of(
                        relativePath,
                        fileName)));

                    try {
                        Diff diff = DiffBuilder.compare(prettyFormat(strippedMessage)).withTest(prettyFormat(expected))
                            .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
                            .checkForSimilar()
                            .ignoreWhitespace()
                            .ignoreComments()
                            .build();

                        if(diff.hasDifferences()) {
                            Assertions.assertThat(prettyFormat(strippedMessage)).isEqualTo(prettyFormat(expected));
                        }
                    } catch (XMLUnitException e) {
                        Assertions.assertThat(prettyFormat(strippedMessage)).isEqualTo(prettyFormat(expected));
                    }
                });
    }

}
