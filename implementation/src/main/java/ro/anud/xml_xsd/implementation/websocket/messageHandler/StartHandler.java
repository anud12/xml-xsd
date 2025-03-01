package ro.anud.xml_xsd.implementation.websocket.messageHandler;


import org.springframework.stereotype.Component;
import ro.anud.xml_xsd.implementation.WorldStepRunner;
import ro.anud.xml_xsd.implementation.util.LocalLogger;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import static ro.anud.xml_xsd.implementation.websocket.Client.ReturnCode.StartStop;

@Component
public record StartHandler(WorldStepRunner worldStepRunner) implements WebSocketHandler.Factory {

    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add(
            "start", (client, string) -> {
                var logger = LocalLogger.logEnter("startStop");

                var worldStepInstance = webSocketHandler.getWorldStepInstance();
                worldStepInstance.getOutInstance().setWebSocketHandler(webSocketHandler);
                worldStepRunner.stop()
                    .start(worldStepInstance, webSocketHandler);
                worldStepInstance.getOutInstance().setWebSocketHandler(null);
                webSocketHandler.setWorldStepInstance(worldStepInstance.getOutInstance());

                client.send(Start);
                logger.logReturnVoid();
            });
    }
}
