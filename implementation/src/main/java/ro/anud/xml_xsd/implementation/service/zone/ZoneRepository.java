package ro.anud.xml_xsd.implementation.service.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ZoneRepository {

    private final HashMap<String, Zone> idZoneMap = new HashMap<>();
    private final WorldStepInstance worldStepInstance;

    public ZoneRepository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public void index(final List<Data> data) {
        try (var scope = logScope()){
            idZoneMap.clear();
            data.stream()
                    .flatMap(Data::streamZoneList)
                    .flatMap(ZoneList::streamZone)
                    .forEach(zone -> {
                        idZoneMap.put(zone.getId(), zone);
                    });
        }

    }

    public Optional<Zone> findById(String id) {
        try (var scope = logScope("id: " + id)) {
            return Optional.ofNullable(idZoneMap.get(id));
        }
    }

    public void addIfNotExist(Zone zone) {
        try (var scope = logScope("id: " + zone.getId())) {
            if(idZoneMap.containsKey(zone.getId())) {
                scope.log("Skipping adding due to found in idZoneMap");
                return;
            }
            worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamDataOrDefault)
                    .flatMap(Data::streamZoneList)
                    .findFirst()
                    .ifPresent(zoneList -> zoneList.addZone(zone));
        }
    }
}
