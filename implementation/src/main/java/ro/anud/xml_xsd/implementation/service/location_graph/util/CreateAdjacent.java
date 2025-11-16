package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classification.Classification;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classifications;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.LinkGroupRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroup.LinkGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.LinkGroupList;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.LinkGroupList.Reference.Reference;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.NodeRule;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_linkGroup.IType_linkGroup;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.service.location_graph.util.CreateGraphNode.createGraphNode;
import static ro.anud.xml_xsd.implementation.service.location_graph.util.CreateLinkTo.createLinkTo;
import static ro.anud.xml_xsd.implementation.service.location_graph.util.GetAdjacentNodes.getAdjacentNodes;
import static ro.anud.xml_xsd.implementation.service.location_graph.util.KeepNotFullLinkGroupElements.*;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class CreateAdjacent {


    public static Optional<Mutation<Node>> createAdjacent(
            WorldStepInstance worldStepInstance,
            LocationGraph locationGraphElement,
            String nodeRef) {
        try (var scope = logScope()) {
            var nodeGraphElementResult = locationGraphElement.streamNode()
                    .filter(node -> node.getId().equals(nodeRef))
                    .findFirst();
            if (nodeGraphElementResult.isEmpty()) {
                scope.log("nodeGraphElement is empty");
                return scope.logReturn(Optional.empty());
            }
            var nodeGraphElement = nodeGraphElementResult.get();
            return scope.logReturn(createAdjacent(worldStepInstance, locationGraphElement, nodeGraphElement));
        }

    }

    public static Optional<Mutation<Node>> createAdjacent(
            WorldStepInstance worldStepInstance,
            LocationGraph locationGraphElement,
            Node nodeGraphElement) {
        try (var logger = logScope()) {

            var nodeRule = worldStepInstance.ruleRepository.nodeRule.streamNodeRuleByLocationGraphAndNode(
                    locationGraphElement,
                    nodeGraphElement
            ).toList();

            logger.log("getLinkRules");
            var linkGroupElementList = getLinkRules(worldStepInstance, nodeRule);
            var notFullLinkGroupElementList = keepNotFullLinkGroupElements(
                    locationGraphElement,
                    nodeGraphElement,
                    linkGroupElementList
            );
            var linkGroupElementResult = worldStepInstance.randomFrom(notFullLinkGroupElementList);
            if (linkGroupElementResult.isEmpty()) {
                logger.log("linkGroupElement is empty");
                return Optional.empty();
            }
            var linkGroupElement = linkGroupElementResult.get();
            var position = positionBasedOnLink(worldStepInstance, linkGroupElement, nodeGraphElement);
            var classificationLocationList = nodeGraphElement.streamClassifications()
                    .flatMap(Classifications::streamClassification)
                    .map(Classification::getLocationClassificationRuleRef);

            var toOptionElementResult = worldStepInstance.randomFrom(linkGroupElement.getToOption());
            if (toOptionElementResult.isEmpty()) {
                logger.log("toOptionElement is empty");
                return Optional.empty();
            }
            var toOptionElement = toOptionElementResult.get();
            var resultOptional = createGraphNode(
                    worldStepInstance,
                    locationGraphElement,
                    toOptionElement.getNodeRuleRef(),
                    position,
                    classificationLocationList
            );
            if (resultOptional.isEmpty()) {
                logger.log("newGraphNode is empty");
                return Optional.empty();
            }
            var result = resultOptional.get();
            var newGraphNode = result.node();

            logger.logTodo("use random between int for distance");
            var adjacentDistanceMin = toOptionElement.getDistance();
            var adjacentDistance = toOptionElement.getMaxDistance().orElse(adjacentDistanceMin);
            var adjacentNodes = getAdjacentNodes(
                    worldStepInstance,
                    locationGraphElement,
                    nodeGraphElement,
                    toOptionElement.getAdjacentDepthLimit()
            ).stream().toList();

            return Optional.of(Mutation.of(outInstance -> {
                try (var outLogger = logScope()) {
                    var outNodeGraphElement = outInstance.locationGraph.nodeRepository.getNodeOrDefault(nodeGraphElement);
                    var outAdjacentNodes = adjacentNodes.stream().map(outInstance.locationGraph.nodeRepository::getNodeOrDefault);

                    result.personList().forEach(outInstance.person.repository::getOrCreate);

                    createLinkTo(worldStepInstance, toOptionElement, outNodeGraphElement, newGraphNode)
                            .ifPresent(linkTo -> newGraphNode.getLinksOrDefault().addLinkTo(linkTo));
                    createLinkTo(worldStepInstance, toOptionElement, newGraphNode, outNodeGraphElement)
                            .ifPresent(linkTo -> outNodeGraphElement.getLinksOrDefault().addLinkTo(linkTo));

                    outAdjacentNodes.filter(node ->
                                    isDistanceBetweenPointsLessThan(node, newGraphNode, adjacentDistanceMin) &&
                                            isDistanceBetweenPointsGreaterThan(node, newGraphNode, adjacentDistance)
                            )
                            .forEach(node -> {
                                Optional<ToOption> option = canCreateLinkBetween(
                                        worldStepInstance,
                                        locationGraphElement,
                                        node,
                                        newGraphNode);
                                option.ifPresent(object -> {
                                    createLinkTo(worldStepInstance, object, node, newGraphNode)
                                            .ifPresent(linkTo -> newGraphNode.getLinksOrDefault().addLinkTo(linkTo));
                                    createLinkTo(worldStepInstance, object, newGraphNode, node)
                                            .ifPresent(linkTo -> node.getLinksOrDefault().addLinkTo(linkTo));
                                });
                            });

                    return newGraphNode;
                }
            }));
        }
    }

    private static Optional<ToOption> canCreateLinkBetween(
            final WorldStepInstance worldStepInstance,
            final LocationGraph locationGraph,
            final Node node,
            final Node targetGraphNode) {
        try (var scope = logScope()) {
            var nodeRule = worldStepInstance.ruleRepository.nodeRule
                    .streamNodeRuleByLocationGraphAndNode(locationGraph, node)
                    .toList();

            var linkGroups = getLinkRules(worldStepInstance, nodeRule);

            var notFullLinkGroupElementList = keepNotFullLinkGroupElements(
                    locationGraph,
                    node,
                    linkGroups
            );
            if (notFullLinkGroupElementList.isEmpty()) {
                scope.log("notFullLinkGroupElementList is empty");
                return Optional.empty();
            }
            var applicableLinkGroup = notFullLinkGroupElementList.stream()
                    .filter(linkGroup -> linkGroup.streamToOption()
                            .anyMatch(toOption -> toOption.getNodeRuleRef().equals(targetGraphNode.getNodeRuleRef()))
                    )
                    .findFirst();
            if (applicableLinkGroup.isEmpty()) {
                scope.log("applicableLinkGroup is empty");
                return Optional.empty();
            }
            var targetNodeRule = worldStepInstance.ruleRepository.nodeRule
                    .streamNodeRuleByLocationGraphAndNode(locationGraph, targetGraphNode)
                    .toList();
            var linkGroupList = getLinkRules(worldStepInstance, targetNodeRule);

            var targetNotFullLinkGroupElementList = keepNotFullLinkGroupElements(
                    locationGraph,
                    targetGraphNode,
                    linkGroupList
            );
            if (targetNotFullLinkGroupElementList.isEmpty()) {
                scope.log("targetNotFullLinkGroupElementList is empty");
                return Optional.empty();
            }
            var foundOption = targetNotFullLinkGroupElementList.stream()
                    .flatMap(linkGroup -> linkGroup.streamToOption()
                            .filter(toOption -> toOption.getNodeRuleRef().equals(node.getNodeRuleRef()))
                    )
                    .findFirst();
            if (foundOption.isEmpty()) {
                scope.log("foundOption is empty");
                return Optional.empty();
            }
            return scope.logReturn(foundOption);
        }
    }


    public static record XYPosition(Integer x, Integer y) {
    }

    private static XYPosition positionBasedOnLink(
            final WorldStepInstance worldStepInstance,
            final IType_linkGroup<?> linkGroupElement,
            final Node node) {
        try (var scope = logScope()) {
            var angle = linkGroupElement.getAngle();

            scope.logTodo("use random between int for angle");
            if (linkGroupElement.getAngleMax().isPresent()) {
                var angleMax = linkGroupElement.getAngleMax().get();
                if (!angle.equals(angleMax)) {
                    angle = angleMax + (int) (worldStepInstance.random() * angleMax);
                }
            }
            angle = angle % 360;
            if (angle < 0) {
                angle += 360;
            }
            scope.log("angle", angle);
            var toOptionElement = worldStepInstance.randomFrom(linkGroupElement.getToOption()).get();
            var distance = toOptionElement.getDistance();
            scope.logTodo("use random between int for distance");
            if (toOptionElement.getMaxDistance().isPresent()) {
                var maxDistance = toOptionElement.getMaxDistance().get();
                if (!maxDistance.equals(distance)) {
                    distance = distance + (int) (maxDistance * worldStepInstance.random());
                }
            }
            scope.log("distance", distance);
            var originPosition = node.getPosition().get();
            var newX = originPosition.getX() + distance * PreComputeTrig.getCosByAngle(angle);
            var newY = originPosition.getY() + distance * PreComputeTrig.getSinByAngle(angle);

            return scope.logReturn(new XYPosition((int) newX, (int) newY));
        }

    }

    private static List<IType_linkGroup<?>> getLinkRules(
            final WorldStepInstance worldStepInstance,
            final List<NodeRule> nodeRuleList) {
        try (var scope = logScope()) {
            List<LinkGroup> inlineLinkGroups = nodeRuleList.stream()
                    .flatMap(NodeRule::streamLinkGroupList)
                    .flatMap(LinkGroupList::streamLinkGroup)
                    .toList();

            List<LinkGroupRule> referencedLinkRuleList = nodeRuleList.stream()
                    .flatMap(NodeRule::streamLinkGroupList)
                    .flatMap(LinkGroupList::streamReference)
                    .map(Reference::getLinkGroupRuleRef)
                    .flatMap(worldStepInstance.ruleRepository.linkGroupRule::streamById)
                    .toList();
            var result = new ArrayList<IType_linkGroup<?>>(referencedLinkRuleList);
            result.addAll(inlineLinkGroups);
            scope.log("linkGroup count", result.size());
            return result;

        }
    }
}
