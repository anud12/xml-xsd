package ro.anud.xml_xsd.implementation.service.location_graph;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.repository.LocationGraphRepository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.location_graph.repository.NodeRepository;

import java.util.List;
import java.util.Optional;

public class Repository {

    private final NodeRepository nodeRepository = new NodeRepository();
    private final LocationGraphRepository locationGraphRepository = new LocationGraphRepository();

    public void index(final WorldStepInstance worldStepInstance) {
        nodeRepository.index(worldStepInstance);
        locationGraphRepository.index(worldStepInstance);
    }

    public Optional<Node> getNodeById(String id) {
        return nodeRepository.nodeById.getOrDefault(id, List.of()).stream().findFirst();
    }

    public Optional<LocationGraph> getLocationGraphById(final String locationGraphIdRef) {
        return locationGraphRepository.getLocationGraphById(locationGraphIdRef);
    }
}
