package ro.anud.xml_xsd.implementation.service.location_graph.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.Subscription;

import java.util.HashMap;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class LinkToRepository implements Repository<LinkTo> {

    private final WorldStepInstance worldStepInstance;

    private final HashMap<Node, HashMap<String, LinkTo>> linkToByTargetNodeIdMapByNode = new HashMap<>();
    private Optional<Subscription> subscription = Optional.empty();

    public LinkToRepository(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
        }
    }

    public void index() {
        try (var scope = logScope()) {
            subscription.ifPresent(Subscription::unsubscribe);
            subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange((objects, worldStepNode) -> {
                if(objects instanceof LocationGraph) {
                    loadData();
                }
            }));
        }

    }

    public void loadData() {
        try (var scope = logScope()) {
            linkToByTargetNodeIdMapByNode.clear();
            worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamData)
                .flatMap(Data::streamLocation)
                .flatMap(Location::streamLocationGraph)
                .flatMap(LocationGraph::streamNode)
                .forEach(node -> node
                    .streamLinks()
                    .flatMap(Links::streamLinkTo)
                    .forEach(linkTo -> linkToByTargetNodeIdMapByNode
                        .computeIfAbsent(node, k -> new HashMap<>())
                        .put(linkTo.getNodeIdRef(), linkTo)
                    ));
        }

    }

    public Optional<LinkTo> getByParentNodeAndNodeIdRef(Node parentNode, String nodeIdRef) {
        try (var scope = logScope("parentNode: " + parentNode.getId() + " and nodeIdRef: " + nodeIdRef)) {
            var nodeMap = linkToByTargetNodeIdMapByNode.getOrDefault(parentNode, new HashMap<>());
            if (nodeMap.containsKey(nodeIdRef)) {
                return scope.logReturn(Optional.of(nodeMap.get(nodeIdRef)));
            }
            return scope.logReturn(Optional.empty());
        }
    }

    public LinkTo getOrDefault(LinkTo linkTo) {
        try (var scope = logScope("linkTo", linkTo)) {

            var parentNode = linkTo.parentAsLinks().flatMap(Links::parentAsNode);
            if (parentNode.isEmpty()) {
                scope.log("parentNode is empty");
                throw new RuntimeException("parentNode is empty");
            }
            var link = getByParentNodeAndNodeIdRef(parentNode.get(), linkTo.getNodeIdRef());
            return scope.logReturn(link.orElseGet(() -> {
                scope.log("getting nodeOrDefault");
                var links = worldStepInstance.locationGraph.nodeRepository.getNodeOrDefault(parentNode.get())
                    .getLinksOrDefault();
                return links
                    .streamLinkTo()
                    .filter(linkTo1 -> linkTo1.getNodeIdRef().equals(linkTo.getNodeIdRef()))
                    .findFirst()
                    .orElseGet(() -> {
                        scope.log("creating new linkTo");
                        var newLinkTo = LinkTo.fromRawNode(linkTo.serializeIntoRawNode());
                        links.addLinkTo(newLinkTo);
                        return newLinkTo;
                    });
            }));
        }
    }
}
