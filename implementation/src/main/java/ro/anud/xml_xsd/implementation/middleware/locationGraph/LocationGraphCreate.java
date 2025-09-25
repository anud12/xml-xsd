package ro.anud.xml_xsd.implementation.middleware.locationGraph;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;


public class LocationGraphCreate {

    public static void apply(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()){
            var actionList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamLocationGraph_create)
                    .toList();

            actionList.forEach(locationGraphCreate -> {
                scope.log("creating locationGraph");
                var locationGraphResult = worldStepInstance.locationGraph.createLocationGraph(locationGraphCreate.getLocationGraphRuleRef());
                if (locationGraphResult.isEmpty()) {
                    scope.log("empty locationGraph result");
                    return;
                }
                locationGraphResult.get().apply(worldStepInstance.getOutInstance());
            });

            worldStepInstance.getOutInstance().streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamLocationGraph_create)
                    .toList()
                    .forEach(LocationGraph_create::removeFromParent);
        }

    }
}
