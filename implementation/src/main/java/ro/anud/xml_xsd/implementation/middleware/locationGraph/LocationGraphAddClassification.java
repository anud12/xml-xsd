package ro.anud.xml_xsd.implementation.middleware.locationGraph;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_node_addClassification.LocationGraph_node_addClassification;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classification.Classification;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LocationGraphAddClassification {
    public static void apply(WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        worldStepInstance.getWorldStep().streamActions()
            .flatMap(Actions::streamLocationGraph_node_addClassification)
            .peek(locationGraphNodeAddClassification -> {
                worldStepInstance.locationGraph.selectNodeGraph(locationGraphNodeAddClassification.getNodeGraphSelection())
                    .forEach(node -> {

                        var toBeAddedClassification = locationGraphNodeAddClassification.getToBeAdded_classification();

                        node.getClassificationsOrDefault().addClassification(new Classification()
                            .setLocationClassificationRuleRef(toBeAddedClassification.getLocationClassificationRuleRef()));
                        toBeAddedClassification.streamAnd().forEach(and -> {
                            node.getClassificationsOrDefault().addClassification(new Classification()
                                .setLocationClassificationRuleRef(toBeAddedClassification.getLocationClassificationRuleRef())
                            );
                        });
                    });
            })
            .toList()
            .forEach(LocationGraph_node_addClassification::removeFromParent);

    }
}
