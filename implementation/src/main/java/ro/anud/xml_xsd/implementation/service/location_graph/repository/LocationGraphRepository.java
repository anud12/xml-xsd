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
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class LocationGraphRepository {
    private Map<String, List<LocationGraph>> locationGraphById = new HashMap<>();
    private final WorldStepInstance worldStepInstance;
    private Optional<Subscription> subscription = Optional.empty();

    public LocationGraphRepository(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
        }
    }

    public LocationGraphRepository index() {
        try (var scope = logScope()) {
            subscription.ifPresent(Subscription::unsubscribe);
            subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(objects -> {
                scope.logTodo("Streamline checking for Node.class");
                if (objects.stream().map(Object::getClass).anyMatch(o -> o.equals(LocationGraph.class))) {
                    loadData();
                }
            }));
            loadData();
            return this;
        }


    }

    private void loadData() {
        try (var scope = logScope("loadData")) {
            locationGraphById = worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamData)
                .flatMap(Data::streamLocation)
                .flatMap(Location::streamLocationGraph)
                .collect(Collectors.groupingBy(LocationGraph::getId));
        }
    }

    public Optional<LocationGraph> getLocationGraphById(String id) {
        try (var scope = logScope("id: " + id)) {
            return scope.logReturn(locationGraphById.getOrDefault(id, List.of()).stream().findFirst());

        }
    }

    public Stream<LocationGraph> streamLocationGraphById(String id) {
        try (var scope = logScope("id: " + id)) {
            return scope.logReturn(locationGraphById.getOrDefault(id, List.of()).stream());
        }
    }

    public LocationGraph getLocationGraphOrDefault(final LocationGraph locationGraph) {
        try ( var scope = logScope() ){
            Optional<LocationGraph> locationGraphOptional = getLocationGraphById(locationGraph.getId());
            return locationGraphOptional.orElseGet(() -> {
                scope.log("creating new");
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
}
