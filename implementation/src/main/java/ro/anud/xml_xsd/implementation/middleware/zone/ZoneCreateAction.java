package ro.anud.xml_xsd.implementation.middleware.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Zone_create.Zone_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.List;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ZoneCreateAction {
    public static void zoneCreateAction(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamZone_create)
                    .forEach(zoneCreate -> {
                        var zoneRule = worldStepInstance.ruleRepository.zoneRule.getById(zoneCreate.getZoneRuleRef()).get();
                        worldStepInstance.getOutInstance().streamWorldStep()
                                .flatMap(WorldStep::streamDataOrDefault)
                                .flatMap(Data::streamZoneListOrDefault)
                                .findFirst()
                                .ifPresent(zoneList -> {
                                    var zone = Zone.builder()
                                            .id(worldStepInstance.getNextId())
                                            .region(List.of(
                                                    worldStepInstance.region.createStartingRegion(zoneRule))
                                            )
                                            .build();
                                    zoneList.addZone(zone);
                                });
                    });
            worldStepInstance.getOutInstance().streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamZone_create)
                    .toList()
                    .forEach(Zone_create::removeFromParent);
        }

    }
}
