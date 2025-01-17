package ro.anud.xml_xsd.implementation.service.location_graph.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.Subscription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LocationGraphRepository {
    private Map<String, List<LocationGraph>> locationGraphById = new HashMap<>();
    private final WorldStepInstance worldStepInstance;
    private Optional<Subscription> subscription = Optional.empty();

    public LocationGraphRepository(WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        this.worldStepInstance = worldStepInstance;
    }

    public LocationGraphRepository index() {
        var logger = logEnter("LocationGraphRepository indexing");

        subscription.ifPresent(Subscription::unsubscribe);
        subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(objects -> {
            logger.logTodo("Streamline checking for Node.class");
            if (objects.stream().map(Object::getClass).anyMatch(o -> o.equals(LocationGraph.class))) {
                loadData();
            }
        }));
        loadData();
        return this;
    }

    private void loadData() {
        var logger = logEnter("logData");
        locationGraphById = worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamData)
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

    public LocationGraph getLocationGraphOrDefault(final LocationGraph locationGraph) {
        var logger = logEnter("locationGraphIdId", locationGraph.getId());
        Optional<LocationGraph> locationGraphOptional = getLocationGraphById(locationGraph.getId());
        return locationGraphOptional.orElseGet(() -> {
            logger.log("creating new");
            var newLocationGraph = LocationGraph.fromRawNode(locationGraph.serializeIntoRawNode());
            worldStepInstance.getWorldStep()
                .flatMap(WorldStep::getData)
                .ifPresent(data -> data
                .getLocationOrDefault()
                .addLocationGraph(newLocationGraph)
            );
            return newLocationGraph;
        });

    }
}
