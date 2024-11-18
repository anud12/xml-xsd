package ro.anud.xml_xsd.implementation.middleware.locationGraph;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.LocationGraph_create.LocationGraph_create;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;


public class LocationGraphCreate {

    public static void apply(final WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        var actionList = worldStepInstance.getWorldStep().streamActions()
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
            worldStepInstance.getOutInstance().getWorldStep().getData().getLocationOrDefault().addLocationGraph(
                locationGraphResult.orElseThrow());
        });

        worldStepInstance.getOutInstance().getWorldStep().streamActions()
            .flatMap(Actions::streamLocationGraph_create)
            .toList()
            .forEach(LocationGraph_create::removeFromParent);
    }
}
