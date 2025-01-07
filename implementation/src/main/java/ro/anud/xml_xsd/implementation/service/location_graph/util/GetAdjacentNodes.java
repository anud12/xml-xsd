package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class GetAdjacentNodes {
    public static List<Node> getAdjacentNodes(
        final WorldStepInstance worldStepInstance,
        final LocationGraph locationGraph,
        final Node originNode,
        final Integer maxDepth,
        ArrayList<Node> excludeNodes) {
        var logger = logEnter();
        if (maxDepth.equals(0)) {
            return new ArrayList<>();
        }
        excludeNodes.add(originNode);
        var allNodes = locationGraph.streamNode()
            .filter(node -> excludeNodes.stream().noneMatch(element -> element.getId().equals(node.getId())))
            .collect(Collectors.groupingBy(Node::getId));

        var linkedNodes = originNode.streamLinks()
            .flatMap(Links::streamLinkTo)
            .flatMap(linkTo -> allNodes.getOrDefault(linkTo.getNodeIdRef(), List.of()).stream())
            .toList();
        excludeNodes.addAll(linkedNodes);

        var childrenNode = linkedNodes.stream().flatMap(node -> getAdjacentNodes(
            worldStepInstance,
            locationGraph,
            node,
            maxDepth - 1,
            excludeNodes).stream()
        ).toList();
        var resultList = new ArrayList<Node>();
        resultList.addAll(linkedNodes);
        resultList.addAll(childrenNode);
        return logger.logReturn(resultList);
    }


    public static List<Node> getAdjacentNodes(
        final WorldStepInstance worldStepInstance,
        final LocationGraph locationGraph,
        final Node originNode,
        final Integer maxDepth) {
        return getAdjacentNodes(worldStepInstance, locationGraph, originNode, maxDepth, new ArrayList<>());
    }
}
