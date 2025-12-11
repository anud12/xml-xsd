package ro.anud.xml_xsd.implementation.middleware.operation;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Operation_echo.Operation_echo;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class OperationEchoAction {
    public static void apply(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .peek(scope::log)
                    .flatMap(Actions::streamOperation_echo)
                    .peek(scope::log)
                    .forEach(operationEcho -> {
                        try (var innerScope = logScope()) {
                            var entity = worldStepInstance.entity.repository.byId.get(operationEcho.getEntityIdRef()).get();
                            var result = worldStepInstance.computeOperation(operationEcho, entity);
                            worldStepInstance.getOutInstance().broadcastDebug(OperationEchoAction.class.getSimpleName() + " with id, " + operationEcho.getId() + ", has result: " + result.get());
                        }
                    });

            worldStepInstance.getOutInstance().streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamOperation_echo)
                    .forEach(Operation_echo::removeFromParent);
        }

    }
}
