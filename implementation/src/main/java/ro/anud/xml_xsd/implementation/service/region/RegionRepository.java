package ro.anud.xml_xsd.implementation.service.region;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.Zone.Region.Region;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.ZoneList.ZoneList;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class RegionRepository {

    private final HashMap<String, HashMap<String, Region>> zoneIdRegionIdMap = new HashMap<>();

    public void index(final List<Data> data) {
        try (var logger = logScope()){
            zoneIdRegionIdMap.clear();
            data.stream()
                    .flatMap(Data::streamZoneList)
                    .flatMap(ZoneList::streamZone)
                    .forEach(zone -> zone.getRegion()
                            .forEach(region -> {
                                zoneIdRegionIdMap.compute(
                                        zone.getId(), (string, stringRegionHashMap) -> {
                                            var map = Optional.ofNullable(stringRegionHashMap)
                                                    .orElseGet(HashMap::new);
                                            map.put(region.getId(), region);
                                            return map;
                                        });
                            }));
        }
    }

    public Optional<Region> findByZoneIdAndRegionId(String zoneId, String regionId) {
        try (var logger = logScope()){
            return logger.logReturn(Optional.ofNullable(zoneIdRegionIdMap.getOrDefault(zoneId, new HashMap<>()).get(regionId)));
        }

    }
}
