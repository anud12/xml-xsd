package ro.anud.xml_xsd.implementation.service.location_graph.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.NodeRule;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.log;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class NodeRepository {
    private final WorldStepInstance worldStepInstance;
    public Map<String, List<Node>> nodeById = new HashMap<>();
    public Map<String, Map<String, List<Node>>> nodeByGraphIdAndNodeId = new HashMap<>();

    public NodeRepository(final WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        this.worldStepInstance = worldStepInstance;
        worldStepInstance.getWorldStep().onChange(objects -> {
            logger.logTodo("Streamline checking for Node.class");
            if (objects.stream().map(Object::getClass).anyMatch(o -> o.equals(Node.class))) {
                index(this.worldStepInstance);
            }
        });
    }

    public NodeRepository index(final WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        worldStepInstance.getWorldStep()
            .streamData()
            .flatMap(Data::streamLocation)
            .flatMap(Location::streamLocationGraph)
            .forEach(locationGraph -> {
                var nodeById = locationGraph.streamNode().collect(Collectors.groupingBy(Node::getId));
                nodeByGraphIdAndNodeId.put(locationGraph.getId(), nodeById);
                this.nodeById.putAll(nodeById);
            });
        return this;
    }

    public Optional<Node> getNodeById(final String id) {
        return nodeById.getOrDefault(id, List.of()).stream().findFirst();
    }

    public Optional<Node> getNodeByGraphIdAndNodeId(final String graphId, final String nodeId) {
        return Optional.ofNullable(nodeByGraphIdAndNodeId.get(graphId))
            .map(map -> map.getOrDefault(nodeId, List.of()))
            .flatMap(nodes -> nodes.stream().findFirst());
    }

    public Node getNodeOrDefault(Node node) {
        var logger = logEnter("nodeId", node.getId());
        var locationGraphOptional = node.parentAsLocationGraph();
        if (locationGraphOptional.isEmpty()) {
            throw new RuntimeException("locationGraph not found");
        }
        Optional<Node> nodeRuleOptional = getNodeByGraphIdAndNodeId(locationGraphOptional.get().getId(), node.getId());
        return logger.logReturn(nodeRuleOptional.orElseGet(() -> {
                logger.log("creating new");
                var newNode = Node.fromRawNode(node.serializeIntoRawNode());
                worldStepInstance.locationGraph.locationGraphRepository
                    .getLocationGraphOrDefault(locationGraphOptional.get())
                    .addNode(newNode);
                return newNode;
            })
        );

    }
}
