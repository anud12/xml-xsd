package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.Type_linkTo_selection.Type_linkTo_selection;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_linkTo_selection.IType_linkTo_selection;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.List;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class SelectLinkTo {

    public static Stream<LinkTo> selectLinkTo(
        WorldStepInstance worldStepInstance,
        IType_linkTo_selection<?> selection) {
        var logger = logEnter(selection.buildPath());
        var originNode = selection.getOrigin_nodeGraph_selection()
            .map(worldStepInstance.locationGraph::selectNodeGraph)
            .orElse(Stream.empty())
            .toList();
        var destinationNode = selection.getDestination_nodeGraph_selection()
            .map(worldStepInstance.locationGraph::selectNodeGraph)
            .orElse(Stream.empty())
            .toList();

        if ((!originNode.isEmpty()) && destinationNode.isEmpty()) {
            return originNode.stream()
                .flatMap(Node::streamLinks)
                .flatMap(Links::streamLinkTo);
        }
        if ((!destinationNode.isEmpty()) && originNode.isEmpty()) {
            return destinationNode.stream()
                .flatMap(Node::streamLinks)
                .flatMap(Links::streamLinkTo);
        }
        var destinationNodeId = destinationNode.stream()
            .map(Node::getId)
            .toList();
        return originNode
            .stream().flatMap(Node::streamLinks)
            .flatMap(Links::streamLinkTo)
            .filter(linkTo -> destinationNodeId.contains(linkTo.getNodeIdRef()));
    }
}
