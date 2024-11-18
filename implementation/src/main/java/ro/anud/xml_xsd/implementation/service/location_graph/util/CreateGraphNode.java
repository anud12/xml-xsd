package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Classifications.Classification.Classification;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Position.Position;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Classifications.Classifications;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.Name.Name;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.NodeRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_linkGroup.IType_linkGroup;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class CreateGraphNode {

    public static Optional<Node> createGraphNode(
        WorldStepInstance worldStepInstance,
        LocationGraph locationGraph,
        String startNodeRef,
        final CreateAdjacent.XYPosition position,
        final Stream<String> classificationLocationList) {
        var createdNode = createGraphNode(worldStepInstance, locationGraph, startNodeRef);

        createdNode.flatMap(Node::getPosition).ifPresent(position1 -> {
            position1.setX(position.x());
            position1.setY(position.y());
        });
        createdNode.ifPresent(node -> {
            classificationLocationList.forEach(string -> node
                .getClassificationsOrDefault()
                .addClassification(new Classification()
                    .setLocationClassificationRuleRef(string)
                ));
        });

        return createdNode;
    }

    public static Optional<Node> createGraphNode(
        WorldStepInstance worldStepInstance,
        LocationGraph locationGraph,
        String startNodeRef) {
        var logger = logEnter("locationGraphId", locationGraph.getId(), "nodeRef", startNodeRef);
        var rule = worldStepInstance.getWorldStep()
            .streamRuleGroup()
            .flatMap(RuleGroup::streamLocationGraphRule)
            .filter(locationGraphRule -> locationGraphRule.getId().equals(locationGraph.getRule().getLocationGraphRuleRef()))
            .flatMap(LocationGraphRule::streamNodeRule)
            .filter(nodeRule -> nodeRule.getId().equals(startNodeRef))
            .findFirst();

        if (rule.isEmpty()) {
            logger.log("rule not found");
            return Optional.empty();
        }
        logger.log("creating node");
        var nodeElement = new Node()
            .setNodeRuleRef(startNodeRef)
            .setId(worldStepInstance.getNextId());

        logger.log("addingName");
        var nameRule = rule.flatMap(NodeRule::getName)
            .map(Name::getNameRuleRef);
        nameRule
            .flatMap(worldStepInstance.name::calculateNameFromRefString)
            .ifPresent(s -> {
                logger.log("setting name", s);
                nodeElement.getNameOrDefault().setValue(s);
            });
        if (nameRule.isEmpty()) {
            logger.log("no name rule");
        }
        logger.log("adding existing person");
        var existingPersonRule = rule.flatMap(NodeRule::getExistingPerson).stream().toList();
        existingPersonRule
            .stream().findFirst()
            .ifPresent(existingPerson -> {
                var min = existingPerson.getMin();
                var max = existingPerson.getMax().orElse(min);
                var iterations = worldStepInstance.randomBetweenInt(min, max);
                logger.log("min", min, "max", max, "iterations", iterations);
                var peopleElement = nodeElement.getPeopleOrDefault();
                IntStream.range(0, iterations)
                    .forEach(ignored -> {
                        var person = worldStepInstance.person.createPerson(existingPerson.getPersonSelection());
                        logger.log("adding personId ", person.getId());
                        peopleElement.addPerson(new Person().setPersonIdRef(person.getId()));
                    });
            });
        if (existingPersonRule.isEmpty()) {
            logger.log("no existing person rule");
        }
        logger.log("setting position");
        nodeElement.setPosition(new Position()
            .setX(0)
            .setY(0)
        );

        rule.stream()
            .flatMap(NodeRule::streamClassifications)
            .flatMap(Classifications::streamClassification)
            .forEach(classification -> {
                nodeElement.getClassificationsOrDefault().addClassification(new Classification()
                    .setLocationClassificationRuleRef(classification.getLocationClassificationRuleRef())
                );
            });

        return Optional.of(nodeElement);
    }
}
