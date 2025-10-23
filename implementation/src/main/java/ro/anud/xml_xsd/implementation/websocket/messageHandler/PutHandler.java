package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import ro.anud.xml_xsd.implementation.WorldStepRunner;
import ro.anud.xml_xsd.implementation.util.RawNode;
import ro.anud.xml_xsd.implementation.websocket.Client;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@Component
public record PutHandler(WorldStepRunner worldStepRunner) implements WebSocketHandler.Factory {

    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        try {
            webSocketHandler.add(
                "put", (client, string) -> {
                    try (var putLogger = logScope("put")){
                        putLogger.log("Received message: " + string);

                        var token = string.split("\n");
                        var path = token[0];
                        var subPath = path.replace("world_step[0].", "");
                        var xmlString = token[1];

                        putLogger.log("Parsed path: " + path);
                        putLogger.log("Parsed subPath: " + subPath);
                        putLogger.log("Parsed XML string: " + xmlString);

                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        Document document = builder.parse(new InputSource(new StringReader(xmlString)));
                        var rawNode = RawNode.fromNode(document.getDocumentElement());

                        putLogger.log("Created RawNode from XML document");

                        worldStepRunner.queueMutation(worldStepInstance -> {
                            try (var mutationLogger = logScope("put mutation")){
                                worldStepInstance.getOutInstance().getWorldStep().ifPresent(worldStep -> {
                                    var deserializedNode = worldStep.deserializeAtPath(subPath, rawNode);
                                    mutationLogger.log("Deserialized node at path: " + deserializedNode.buildPath());
                                });
                            }

                        });

                        putLogger.log("Sent Put return code to client");
                        client.send(Client.ReturnCode.Put);
                    } catch (Exception e) {
                        e.printStackTrace();
                        client.broadcastNOk(e.toString());
                    }
                });
        } catch (Exception e) {
            throw new RuntimeException("Error during WebSocketHandler instantiation", e);
        }
    }
}
