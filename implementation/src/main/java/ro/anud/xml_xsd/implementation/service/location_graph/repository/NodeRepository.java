package ro.anud.xml_xsd.implementation.service.location_graph.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.Subscription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class NodeRepository {
    private final WorldStepInstance worldStepInstance;
    public Map<String, List<Node>> nodeById = new HashMap<>();
    public Map<String, Map<String, List<Node>>> nodeByGraphIdAndNodeId = new HashMap<>();
    private Optional<Subscription> subscription = Optional.empty();

    public NodeRepository(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
        }
    }

    public NodeRepository index() {
        try (var scope = logScope()) {
            subscription.ifPresent(Subscription::unsubscribe);
            subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange((objects, worldStepNode) -> {
                if(objects instanceof Node) {
                    loadData();
                }
            }));

            loadData();
            return this;
        }

    }

    private void loadData() {
        try (var scope = logScope()) {
            worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamData)
                .flatMap(Data::streamLocation)
                .flatMap(Location::streamLocationGraph)
                .forEach(locationGraph -> {
                    var nodeById = locationGraph.streamNode().collect(Collectors.groupingBy(Node::getId));
                    nodeByGraphIdAndNodeId.put(locationGraph.getId(), nodeById);
                    this.nodeById.putAll(nodeById);
                });
        }

    }

    public Optional<Node> getNodeById(final String id) {
        try (var scope = logScope("id: " + id)) {
            return scope.logReturn(nodeById.getOrDefault(id, List.of()).stream().findFirst());
        }
    }

    public Optional<Node> getNodeByGraphIdAndNodeId(final String graphId, final String nodeId) {
        try (var scope = logScope("graphId: " + graphId + ", nodeId: " + nodeId)) {
            return scope.logReturn(Optional.ofNullable(nodeByGraphIdAndNodeId.get(graphId))
                .map(map -> map.getOrDefault(nodeId, List.of()))
                .flatMap(nodes -> nodes.stream().findFirst()));

        }
    }

    public Node getNodeOrDefault(Node node) {
        try (var scope = logScope("nodeId: " + node.getId())) {
            var locationGraphOptional = node.parentAsLocationGraph();
            if (locationGraphOptional.isEmpty()) {
                throw new RuntimeException("locationGraph not found");
            }
            Optional<Node> nodeRuleOptional = getNodeByGraphIdAndNodeId(
                locationGraphOptional.get().getId(),
                node.getId());
            return scope.logReturn(nodeRuleOptional.orElseGet(() -> {
                    scope.log("creating new");
                    var newNode = Node.fromRawNode(node.serializeIntoRawNode());
                    worldStepInstance.locationGraph.locationGraphRepository
                        .getLocationGraphOrDefault(locationGraphOptional.get())
                        .addNode(newNode);
                    return newNode;
                })
            );
        }


    }
}
