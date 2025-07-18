package ro.anud.xml_xsd.implementation.middleware.region;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_append.Region_append;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Portals.Portals;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

public class RegionAppendAction {
    public static void regionAppendAction(final WorldStepInstance worldStepInstance) {
        worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamActions)
            .flatMap(Actions::streamRegion_append)
            .forEach(regionAppend -> {
                var parentRegion = worldStepInstance.region.repository.findByZoneIdAndRegionId(
                    regionAppend.getZoneIdRef(),
                    regionAppend.getRegionIdRef()).get();

                var parentPortal = parentRegion.streamPortals()
                    .flatMap(Portals::streamPortal)
                    .filter(portal -> portal.getId().equals(regionAppend.getPortalIdRef()))
                    .filter(portal -> portal.getTo().isEmpty())
                    .findFirst()
                    .get();

                worldStepInstance.getOutInstance().streamWorldStep()
                    .flatMap(WorldStep::streamDataOrDefault)
                    .flatMap(Data::streamZoneListOrDefault)
                    .findFirst()
                    .ifPresent(zoneList -> {
                        worldStepInstance.region.appendFromPortal(parentPortal);
                    });
            });
        worldStepInstance.getOutInstance().streamWorldStep()
            .flatMap(WorldStep::streamActions)
            .flatMap(Actions::streamRegion_append)
            .toList()
            .forEach(Region_append::removeFromParent);
    }
}
