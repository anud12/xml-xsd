package ro.anud.xml_xsd.implementation.middleware.locationGraph;

import org.springframework.stereotype.Service;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_createAdjacent.LocationGraph_node_createAdjacent;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LocationGraphCreateAdjacent {
    public static void apply(WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamActions)
            .flatMap(Actions::streamLocationGraph_node_createAdjacent)
            .forEach(locationGraphNodeCreateAdjacent -> worldStepInstance
                .locationGraph
                .createAdjacent(
                    locationGraphNodeCreateAdjacent.getLocationGraphIdRef(),
                    locationGraphNodeCreateAdjacent.getNodeIdRef()
                )
                .ifPresent(node -> {
                    var outInstance = worldStepInstance.getOutInstance();
                    var createdNode = node.apply(outInstance);
                    outInstance.locationGraph.locationGraphRepository.getLocationGraphById(locationGraphNodeCreateAdjacent.getLocationGraphIdRef())
                        .ifPresent(locationGraph -> locationGraph.addNode(createdNode));
//                    worldStepInstance.getOutInstance()
//                        .locationGraph
//                        .locationGraphRepository
//                        .getLocationGraphById(locationGraphNodeCreateAdjacent.getLocationGraphIdRef())
//                        .ifPresent(locationGraph -> locationGraph.addNode(node))
                })
            );

        worldStepInstance.getOutInstance().streamWorldStep()
            .flatMap(WorldStep::streamActions)
            .flatMap(Actions::streamLocationGraph_node_createAdjacent)
            .toList()
            .forEach(LocationGraph_node_createAdjacent::removeFromParent);
    }
}
