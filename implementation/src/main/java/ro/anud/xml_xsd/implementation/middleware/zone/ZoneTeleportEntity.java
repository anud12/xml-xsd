package ro.anud.xml_xsd.implementation.middleware.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Region_teleportEntity.Region_teleportEntity;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Position.Position;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

public class ZoneTeleportEntity {

    public static void zoneTeleportEntity(final WorldStepInstance worldStepInstance) {
        worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamActions)
                .flatMap(Actions::streamRegion_teleportEntity)
                .toList()
                .forEach(regionTeleportEntity -> {
                    var entity = worldStepInstance.zone.entities.byZoneIdAndByEntityIdRef.get(regionTeleportEntity.getZoneIdRef())
                            .get(regionTeleportEntity.getEntityIdRef())
                            .orElse(Entity.builder()
                                    .entityIdRef(regionTeleportEntity.getEntityIdRef())
                                    .build()
                            );
                    entity.setPosition(Position.builder()
                                    .x(regionTeleportEntity.getX())
                                    .y(regionTeleportEntity.getY())
                            .build());
                    worldStepInstance.getOutInstance().zone.entities.byZoneIdAndByEntityIdRef.get(regionTeleportEntity.getZoneIdRef())
                            .get(regionTeleportEntity.getEntityIdRef())
                            .ifPresent(Entity::removeFromParent);

                    var outRegion = worldStepInstance.getOutInstance().zone.region.byId.get(regionTeleportEntity.getRegionIdRef()).orElse(Region.builder()
                                    .id(regionTeleportEntity.getRegionIdRef())
                            .build());

                    outRegion.getEntityListOrDefault().addEntity(entity);
                    worldStepInstance.getOutInstance().zone.region.addIfNotExist(outRegion);
                    regionTeleportEntity.removeFromParent();
                });

        worldStepInstance.getOutInstance().streamWorldStep()
                .flatMap(WorldStep::streamActions)
                .flatMap(Actions::streamRegion_teleportEntity)
                .toList()
                .forEach(Region_teleportEntity::removeFromParent);
    }
}
