package ro.anud.xml_xsd.implementation.middleware.locationGraph;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classification.Classification;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LocationGraphAddClassification {
    public static void locationGraphAddClassification(WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        worldStepInstance.getWorldStep().streamActions()
            .flatMap(Actions::streamLocationGraph_node_addClassification)
            .forEach(locationGraphNodeAddClassification -> {
                worldStepInstance.locationGraph.selectNodeGraph(locationGraphNodeAddClassification.getNodeGraphSelection())
                    .forEach(node -> {

                        var toBeAddedClassification = locationGraphNodeAddClassification.getToBeAdded_classification();

                        var outNodeClassification = worldStepInstance.getOutInstance()
                            .locationGraph
                            .nodeRepository
                            .getNodeOrDefault(node)
                            .getClassificationsOrDefault();
                        outNodeClassification.addClassification(new Classification()
                            .setLocationClassificationRuleRef(toBeAddedClassification.getLocationClassificationRuleRef())
                        );
                        toBeAddedClassification.streamAnd().forEach(and -> {
                            outNodeClassification.addClassification(new Classification()
                                .setLocationClassificationRuleRef(and.getLocationClassificationRuleRef())
                            );
                        });
                    });
            });

        worldStepInstance.getOutInstance().getWorldStep()
            .streamActions()
            .flatMap(Actions::streamLocationGraph_node_addClassification)
            .toList()
            .forEach(LocationGraph_node_addClassification::removeFromParent);
    }
}
