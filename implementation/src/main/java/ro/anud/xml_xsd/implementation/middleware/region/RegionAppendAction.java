package ro.anud.xml_xsd.implementation.middleware.region;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class RegionAppendAction {
    public static void regionAppendNewAction(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()){
            worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamRegion_appendNew)
                    .forEach(regionAppend -> {
                        var parentRegion = worldStepInstance.region.repository.findByZoneIdAndRegionId(
                                regionAppend.getZoneIdRef(),
                                regionAppend.getRegionIdRef()).get();

                        worldStepInstance.getOutInstance().streamWorldStep()
                                .flatMap(WorldStep::streamDataOrDefault)
                                .flatMap(Data::streamZoneListOrDefault)
                                .findFirst()
                                .ifPresent(zoneList -> {
                                    worldStepInstance.region.appendTo(parentRegion, regionAppend.getPortalIdRef());
                                });
                    });
            worldStepInstance.getOutInstance().streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamRegion_appendNew)
                    .toList()
                    .forEach(Region_appendNew::removeFromParent);
        }

    }
}
