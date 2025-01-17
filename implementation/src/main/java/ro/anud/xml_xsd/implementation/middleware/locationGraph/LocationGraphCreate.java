package ro.anud.xml_xsd.implementation.middleware.locationGraph;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;


public class LocationGraphCreate {

    public static void apply(final WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        var actionList = worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamActions)
            .flatMap(Actions::streamLocationGraph_create)
            .toList();

        actionList.forEach(locationGraphCreate -> {
            logger.log("creating locationGraph");
            var locationGraphResult = worldStepInstance.locationGraph.createLocationGraph(locationGraphCreate.getLocationGraphRuleRef());
            if (locationGraphResult.isEmpty()) {
                logger.log("empty locationGraph result");
                logger.logReturnVoid();
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
