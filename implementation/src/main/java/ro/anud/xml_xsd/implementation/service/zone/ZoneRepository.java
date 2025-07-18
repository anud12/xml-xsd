package ro.anud.xml_xsd.implementation.service.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Zone;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ZoneRepository {

    private final HashMap<String, Zone> idZoneMap = new HashMap<>();

    public void index(final List<Data> data) {
        idZoneMap.clear();
        data.stream()
            .flatMap(Data::streamZoneList)
            .flatMap(ZoneList::streamZone)
            .forEach(zone -> {
                idZoneMap.put(zone.getId(), zone);
            });
    }

    public Optional<Zone> findById(String id) {
        return Optional.ofNullable(idZoneMap.get(id));
    }
}
