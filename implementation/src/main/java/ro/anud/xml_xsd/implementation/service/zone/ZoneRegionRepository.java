package ro.anud.xml_xsd.implementation.service.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.repository.NullableIndex;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ZoneRegionRepository implements Repository<Region>  {

    public final NullableIndex<String, Region, Region> byId = NullableIndex.ofNullable(Region.class, Region::getId);

    private final WorldStepInstance worldStepInstance;

    public ZoneRegionRepository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    @Override
    public void index() {
        var regionList = worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamData)
                .flatMap(Data::streamZoneList)
                .flatMap(ZoneList::streamZone)
                .flatMap(Zone::streamRegion)
                .toList();

        byId.reIndex(regionList);
    }

    @Override
    public void loadData() {
        byId.addListeners(worldStepInstance);
    }

    public void addIfNotExist(Region outRegion) {
        try (var scope = logScope("id:" + outRegion.getId())) {
            if(byId.get(outRegion.getId()).isPresent()) {
                scope.log("Skipping adding due to found in byId");
                return;
            }
            var parentZone = outRegion.parentAsZone().get();
            worldStepInstance.zone.repository.addIfNotExist(parentZone);
        }
    }
}
