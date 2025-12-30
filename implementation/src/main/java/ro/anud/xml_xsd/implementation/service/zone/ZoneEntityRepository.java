package ro.anud.xml_xsd.implementation.service.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.EntityList.EntityList;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.repository.NonNullableIndex;
import ro.anud.xml_xsd.implementation.util.repository.NullableIndex;

public class ZoneEntityRepository implements Repository<Entity> {

    public final NullableIndex<String, Entity, Entity> byId = NullableIndex.ofNullable(Entity.class, Entity::classTypeId);

    public final NonNullableIndex<String, Zone, NullableIndex<String, Entity, Entity>> byZoneIdAndByEntityIdRef = NullableIndex.ofNullable(Zone.class, Zone::getId)
            .compose(() -> NullableIndex.ofNullable(Entity.class, Entity::getEntityIdRef),
                    zone -> zone.streamRegion()
                            .flatMap(Region::streamEntityList)
                            .flatMap(EntityList::streamEntity)
            );

    private final WorldStepInstance worldStepInstance;

    public ZoneEntityRepository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    @Override
    public void index() {
        var zoneList = worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamData)
                .flatMap(Data::streamZoneList)
                .flatMap(ZoneList::streamZone)
                .toList();

        byZoneIdAndByEntityIdRef.reIndex(zoneList);

    }

    @Override
    public void loadData() {
        byZoneIdAndByEntityIdRef.addListeners(worldStepInstance);
    }

}
