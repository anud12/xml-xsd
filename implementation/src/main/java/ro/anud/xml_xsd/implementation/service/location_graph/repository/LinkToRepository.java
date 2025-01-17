package ro.anud.xml_xsd.implementation.service.location_graph.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.Subscription;

import java.util.HashMap;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LinkToRepository {

    private final WorldStepInstance worldStepInstance;

    private final HashMap<Node, HashMap<String, LinkTo>> linkToByTargetNodeIdMapByNode = new HashMap<>();
    private Optional<Subscription> subscription = Optional.empty();

    public LinkToRepository(WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        this.worldStepInstance = worldStepInstance;
    }

    public LinkToRepository index() {
        var logger = logEnter("LinkToRepository indexing");

        subscription.ifPresent(Subscription::unsubscribe);
        subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(objects -> {
            logger.logTodo("Streamline checking");
            if (objects.stream().map(Object::getClass).anyMatch(o -> o.equals(LocationGraph.class))) {
                loadData();
            }
        }));

        logger.logReturnVoid();
        return this;
    }
    private void loadData() {
        var logger = logEnter("loadData");
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
        logger.logReturnVoid();
    }

    public Optional<LinkTo> getByParentNodeAndNodeIdRef(Node parentNode, String nodeIdRef) {
        var logger = logEnter("parentNode", parentNode.getId(), "nodeIdRef", nodeIdRef);
        var nodeMap = linkToByTargetNodeIdMapByNode.getOrDefault(parentNode, new HashMap<>());
        if (nodeMap.containsKey(nodeIdRef)) {
            return logger.logReturn(Optional.of(nodeMap.get(nodeIdRef)));
        }
        return logger.logReturn(Optional.empty());
    }

    public LinkTo getOrDefault(LinkTo linkTo) {
        var logger = logEnter("linkTo", linkTo);
        var parentNode = linkTo.parentAsLinks().flatMap(Links::parentAsNode);
        if (parentNode.isEmpty()) {
            logger.log("parentNode is empty");
            throw new RuntimeException("parentNode is empty");
        }
        var link = getByParentNodeAndNodeIdRef(parentNode.get(), linkTo.getNodeIdRef());
        return logger.logReturn(link.orElseGet(() -> {
            logger.log("getting nodeOrDefault");
            var links = worldStepInstance.locationGraph.nodeRepository.getNodeOrDefault(parentNode.get())
                .getLinksOrDefault();
            return links
                .streamLinkTo()
                .filter(linkTo1 -> linkTo1.getNodeIdRef().equals(linkTo.getNodeIdRef()))
                .findFirst()
                .orElseGet(() -> {
                    logger.log("creating new linkTo");
                    var newLinkTo = LinkTo.fromRawNode(linkTo.serializeIntoRawNode());
                    links.addLinkTo(newLinkTo);
                    return newLinkTo;
                });
        }));

    }
}
