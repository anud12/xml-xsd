package ro.anud.xml_xsd.implementation.websocket.messageHandler;


import org.springframework.stereotype.Component;
import ro.anud.xml_xsd.implementation.WorldStepRunner;
import ro.anud.xml_xsd.implementation.util.LocalLogger;
import ro.anud.xml_xsd.implementation.websocket.Client;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@Component
public record StopHandler(WorldStepRunner worldStepRunner) implements WebSocketHandler.Factory {

    @Override
    public void instantiate(final WebSocketHandler webSocketHandler) {
        webSocketHandler.add(
            "stop", (client, string) -> {
                try (var logger = logScope("start")){
                    var worldStepInstance = webSocketHandler.getWorldStepInstance();
                    worldStepRunner.stop();
                    worldStepInstance.getOutInstance().setWebSocketHandler(null);
                    worldStepInstance.setWebSocketHandler(null);

                    client.send(Client.ReturnCode.Stop);
                }
            });
    }
}
