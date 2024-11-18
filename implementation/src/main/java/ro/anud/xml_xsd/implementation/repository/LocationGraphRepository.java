package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LocationGraphRepository {
    private Map<String, List<LocationGraph>> locationGraphById = new HashMap<>();

    public void index(final WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        locationGraphById = worldStepInstance.getWorldStep().streamData()
            .flatMap(Data::streamLocation)
            .flatMap(Location::streamLocationGraph)
            .collect(Collectors.groupingBy(LocationGraph::getId));
    }

    public Optional<LocationGraph> getLocationGraphById(String id) {
        return locationGraphById.getOrDefault(id, List.of()).stream().findFirst();
    }

    public Stream<LocationGraph> streamLocationGraphById(String id) {
        return locationGraphById.getOrDefault(id, List.of()).stream();
    }
}
