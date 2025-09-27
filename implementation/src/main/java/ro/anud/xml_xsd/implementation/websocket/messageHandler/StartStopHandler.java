package ro.anud.xml_xsd.implementation.websocket.messageHandler;


import org.springframework.stereotype.Component;
import ro.anud.xml_xsd.implementation.WorldStepRunner;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;
import static ro.anud.xml_xsd.implementation.websocket.Client.ReturnCode.StartStop;

@Component
public record StartStopHandler(WorldStepRunner worldStepRunner) implements WebSocketHandler.Factory {

    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add(
                "startStop", (client, string) -> {
                    try (var logger = logScope("startStop")) {
                        var worldStepInstance = webSocketHandler.getWorldStepInstance();
                        worldStepInstance.getOutInstance().setWebSocketHandler(webSocketHandler);
                        worldStepRunner.stop()
                                .start(worldStepInstance, webSocketHandler)
                                .stop();
                        worldStepInstance.getOutInstance().setWebSocketHandler(null);
                        webSocketHandler.setWorldStepInstance(worldStepInstance.getOutInstance());

                        client.send(StartStop);

                    }
                });
    }
}
