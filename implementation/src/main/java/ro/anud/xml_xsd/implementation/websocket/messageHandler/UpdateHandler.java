package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import ro.anud.xml_xsd.implementation.WorldStepRunner;
import ro.anud.xml_xsd.implementation.util.LocalLogger;
import ro.anud.xml_xsd.implementation.util.RawNode;
import ro.anud.xml_xsd.implementation.websocket.Client;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@Component
public record UpdateHandler(WorldStepRunner worldStepRunner) implements WebSocketHandler.Factory {

    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add(
            "put", (client, string) -> {
                var logger = LocalLogger.logEnter("put");
                worldStepRunner.stop();

                var token = string.split("\n");
                var path = token[0];
                var subPath = path.replace("world_step[0].","");
                var xmlString = token[1];


                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse(new InputSource(new StringReader(xmlString)));
                    var rawNode = RawNode.fromNode(document.getDocumentElement());
                    var instance = webSocketHandler.getWorldStepInstance().getOutInstance();
                    instance.getWorldStep().ifPresent(worldStep -> {
                        var deserializedNode = worldStep.deserializeAtPath(subPath, rawNode);
                        instance.sendLinkNode(deserializedNode);
                    });
                    client.send(Client.ReturnCode.Put);
                } catch (Exception e) {
                    client.broadcastNOk(e.toString());
                }
                logger.logReturnVoid();
            });
    }
}
