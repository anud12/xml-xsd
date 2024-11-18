package ro.anud.xml_xsd.implementation.service.location_graph.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class NodeRepository {
    public Map<String, List<Node>> nodeById = new HashMap<>();

    public void index(final WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        worldStepInstance.getWorldStep()
            .streamData()
            .flatMap(Data::streamLocation)
            .flatMap(Location::streamLocationGraph)
            .forEach(locationGraph -> {
                nodeById = locationGraph.streamNode().collect(Collectors.groupingBy(Node::getId));
            });
    }
}
