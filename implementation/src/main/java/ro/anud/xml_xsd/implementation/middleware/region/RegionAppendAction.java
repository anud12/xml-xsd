package ro.anud.xml_xsd.implementation.middleware.region;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_appendNew.Region_appendNew;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

public class RegionAppendAction {
    public static void regionAppendNewAction(final WorldStepInstance worldStepInstance) {
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
                        worldStepInstance.region.appendTo(parentRegion);
                    });
            });
        worldStepInstance.getOutInstance().streamWorldStep()
            .flatMap(WorldStep::streamActions)
            .flatMap(Actions::streamRegion_appendNew)
            .toList()
            .forEach(Region_appendNew::removeFromParent);
    }
}
