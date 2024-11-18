package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.Links;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_linkGroup.IType_linkGroup;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class KeepNotFullLinkGroupElements {

    private static boolean filterLinkGroupElementsAngle(
        Map<String, List<Node>> nodeMap,
        Node originNode,
        IType_linkGroup<?> linkGroup) {
        var logger = logEnter();
        var limit = linkGroup.getLimit().orElse(0);
        if (limit <= 0) {
            return true;
        }
        var minAngle = linkGroup.getAngle();
        var maxAngle = linkGroup.getAngleMax().orElse(minAngle);

        List<String> allowedRuleList = linkGroup.streamToOption().map(ToOption::getNodeRuleRef)
            .toList();

        var adjacentNodeList = originNode.streamLinks()
            .flatMap(Links::streamLinkTo)
            .flatMap(linkTo -> nodeMap.getOrDefault(
                linkTo.getNodeIdRef(),
                List.of()).stream().findFirst().stream())
            .filter(node -> allowedRuleList.contains(node.getNodeRuleRef()))
            .toList();

        if (adjacentNodeList.isEmpty()) {
            return true;
        }

        var validAngleNodes = adjacentNodeList.stream().filter(adjacentNode -> {
            var angle = angleBetweenPoints(originNode, adjacentNode);
            if (angle > maxAngle) {
                return false;
            }
            if (angle < minAngle) {
                return false;
            }
            return true;
        }).toList();
        validAngleNodes.forEach(node -> nodeMap.remove(node.getId()));
        return validAngleNodes.size() < limit;
    }

    private static Integer angleBetweenPoints(final Node firstNode, final Node secondNode) {
        var firstPosition = firstNode.getPosition().get();
        var secondPosition = secondNode.getPosition().get();
        var deltaX = secondPosition.getX() - firstPosition.getX();
        var deltaY = secondPosition.getY() - firstPosition.getX();
        var angleInRadiants = Math.atan2(deltaY, deltaX);
        int angleInDegrees = (int) (angleInRadiants * (180 / Math.PI));
        if (angleInDegrees < 0) {
            return angleInDegrees + 360;
        }
        return angleInDegrees;

    }

    public static List<IType_linkGroup<?>> keepNotFullLinkGroupElements(
        final LocationGraph locationGraph,
        final Node originNode,
        final List<IType_linkGroup<?>> linkGroupElementList) {
        var logger = logEnter();
        Map<String, List<Node>> nodeMap = locationGraph.streamNode()
            .collect(Collectors.groupingBy(Node::getId));
//        var validAngleList = filterLinkGroupElementsAngle(nodeMap,  originNode, linkGroupElementList);
//        var validDistanceList = filterLinkGroupElementsDistance(nodeMap, originNode, validAngleList);
        var result = linkGroupElementList.stream()
            .filter(iTypeLinkGroup -> filterLinkGroupElementsAngle(nodeMap,  originNode, iTypeLinkGroup))
            .filter(iTypeLinkGroup -> filterLinkGroupElementsDistance(nodeMap,  originNode, iTypeLinkGroup))
            .toList();
        logger.log("kept linkGroup size", result.size());
        return result;
    }

    private static boolean filterLinkGroupElementsDistance(
        Map<String, List<Node>> nodeMap,
        final Node originNode,
        final IType_linkGroup<?> linkGroup) {
        var logger = logEnter();
        var limit = linkGroup.getLimit().orElse(0);
        if (limit <= 0) {
            return true;
        }
        List<String> allowedRuleList = linkGroup.streamToOption().map(ToOption::getNodeRuleRef)
            .toList();
        var adjacentNodeList = originNode.streamLinks()
            .flatMap(Links::streamLinkTo)
            .flatMap(linkTo -> nodeMap.getOrDefault(
                linkTo.getNodeIdRef(),
                List.of()).stream().findFirst().stream())
            .filter(node -> allowedRuleList.contains(node.getNodeRuleRef()))
            .toList();
        if (adjacentNodeList.isEmpty()) {
            return true;
        }
        var toOptionList = linkGroup.getToOption();
        var validDistanceNodes = adjacentNodeList.stream().filter(adjacentNode -> {
            toOptionList.stream().filter(toOption -> toOption.getNodeRuleRef().equals(adjacentNode.getNodeRuleRef()))
                .filter(toOption -> {
                    var distance = toOption.getDistance();
                    if (isDistanceBetweenPointsLessThan(originNode, adjacentNode, distance)) {
                        return false;
                    }
                    var maxDistance = toOption.getMaxDistance().orElse(distance);
                    if (isDistanceBetweenPointsGreaterThan(originNode, adjacentNode, maxDistance)) {
                        return false;
                    }
                    return true;
                })
                .toList();
            logger.logTodo("Check ignored stream result");
            if (toOptionList.isEmpty()) {
                return false;
            }
            return true;
        }).toList();
        validDistanceNodes.forEach(node -> nodeMap.remove(node.getId()));
        return validDistanceNodes.size() < limit;
    }

    public static boolean isDistanceBetweenPointsGreaterThan(
        final Node firstNode,
        final Node secondNode,
        final Integer minDistance) {
        var firstPosition = firstNode.getPosition().get();
        var secondPosition = secondNode.getPosition().get();

        var positionDistanceSquared = Math.pow(firstPosition.getX() - secondPosition.getX(), 2)
            + Math.pow(firstPosition.getY() - secondPosition.getY(), 2);
        var minDistanceSquared = Math.pow(minDistance, 2);
        return minDistanceSquared >= positionDistanceSquared;
    }

    public static boolean isDistanceBetweenPointsLessThan(
        final Node firstNode,
        final Node secondNode,
        final Integer maxDistance) {
        var firstPosition = firstNode.getPosition().get();
        var secondPosition = secondNode.getPosition().get();

        var positionDistanceSquared = Math.pow(firstPosition.getX() - secondPosition.getX(), 2)
            + Math.pow(firstPosition.getY() - secondPosition.getY(), 2);
        var maxDistaneSquared = Math.pow(maxDistance, 2);
        return maxDistaneSquared <= positionDistanceSquared;
    }
}
