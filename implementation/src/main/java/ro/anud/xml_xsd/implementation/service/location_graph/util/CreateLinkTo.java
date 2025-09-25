package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.Type_linkGroup.ToOption.ToOption;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Links.LinkTo.LinkTo;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class CreateLinkTo {

    public static Optional<LinkTo> createLinkTo(
            WorldStepInstance worldStepInstance,
            ToOption toOption,
            Node node,
            Node targetNode) {
        try (var scope = logScope()) {
            var logger = logEnter("node", node.getId(), "targetNode", targetNode.getId());
            var ratio = toOption.getDistanceToProgressMultiplier()
                    .flatMap(worldStepInstance::computeOperation)
                    .orElse(1);
            logger.log("ratio", ratio);
            var distance = distanceBetweenNodes(node, targetNode);
            if (distance.isEmpty()) {
                logger.log("distance is empty");
                return logger.logReturn(Optional.empty());
            }
            var totalProgress = (distance.get() * ratio);
            logger.log("totalProgress", totalProgress);
            var linkTo = new LinkTo()
                    .setNodeIdRef(node.getId())
                    .setTotalProgress((int) totalProgress);
            logger.log("setting personProgressProperty");
            var personProgressProperty = toOption.getPersonProgressProperty();
            if (personProgressProperty.isEmpty()) {
                logger.log("personProgressProperty is empty");
            }
            toOption.getPersonProgressProperty().ifPresent(linkTo::setPersonProgressProperty);

            return scope.logReturn(Optional.of(linkTo));
        }
    }

    private static Optional<Double> distanceBetweenNodes(Node node1, Node node2) {
        try (var scope = logScope("node1", node1.getId(), "node2", node2.getId())) {
            var node1Position = node1.getPosition();
            var node2Position = node2.getPosition();
            if (node1Position.isEmpty()) {
                return Optional.empty();
            }
            if (node2Position.isEmpty()) {
                return Optional.empty();
            }

            return scope.logReturn(Optional.of(Math.sqrt(
                    Math.pow(node1Position.get().getX() - node2Position.get().getX(), 2)
                            + Math.pow(node1Position.get().getY() - node2Position.get().getY(), 2)))
            );
        }
    }
}
