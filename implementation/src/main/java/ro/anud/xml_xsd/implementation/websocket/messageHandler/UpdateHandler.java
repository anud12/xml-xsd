package ro.anud.xml_xsd.implementation.websocket.messageHandler;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import ro.anud.xml_xsd.implementation.WorldStepRunner;
import ro.anud.xml_xsd.implementation.util.LocalLogger;
import ro.anud.xml_xsd.implementation.validator.AtrributeValidator;
import ro.anud.xml_xsd.implementation.websocket.Client;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.controller.http.AnalyzeController.buildWorldStep;

@Component
public record UpdateHandler(WorldStepRunner worldStepRunner) implements WebSocketHandler.Factory {

    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add(
            "update", (client, string) -> {
                var logger = LocalLogger.logEnter("update");
                worldStepRunner.stop();
                try {
                    var worldStep = buildWorldStep(string);

                    logger.log("validating");
                    var validationResult = new AtrributeValidator()
                        .validate(Optional.ofNullable(worldStep));
                    if (!validationResult.isEmpty()) {
                        logger.log("validation failed");
                        client.send(Client.ReturnCode.Load, validationResult.stream()
                            .map(invalidAttribute -> {
                                var allowedValues = String.join(", ", invalidAttribute.allowedValues());
                                return "ValidationError: " + invalidAttribute.value() + " at " + invalidAttribute.path() + " not in [" + allowedValues + "]";
                            })
                            .collect(Collectors.joining("\n")));
                        return;
                    }

                    webSocketHandler.getWorldStepInstance().setWorldStep(worldStep);
                    webSocketHandler.getWorldStepInstance().getOutInstance().setWorldStep(buildWorldStep(string));

                    client.broadcast(Client.ReturnCode.Load);
                } catch (SAXException e) {
                    client.broadcastNOk(e.toString());
                }
                logger.logReturnVoid();
            });
    }
}
