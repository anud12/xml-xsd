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
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class CreateGraphNode {

    public record Result(Node node, List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person> personList) {
    }


    public static Optional<Result> createGraphNode(
        WorldStepInstance worldStepInstance,
        LocationGraph locationGraph,
        String startNodeRef) {
        try (var scope = logScope("locationGraphId", locationGraph.getId(), "nodeRef", startNodeRef)) {
            var rule = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamLocationGraphRule)
                    .filter(locationGraphRule -> locationGraphRule.getId().equals(locationGraph.getRule().getLocationGraphRuleRef()))
                    .flatMap(LocationGraphRule::streamNodeRule)
                    .filter(nodeRule -> nodeRule.getId().equals(startNodeRef))
                    .findFirst();

            if(rule.isEmpty()) {
                scope.log("rule not found");
                return Optional.empty();
            }
            var createdNode = instantiateGraphNode(worldStepInstance, rule.get(), startNodeRef);


            var personList = computeRuleExistingPerson(worldStepInstance, rule.get());
            personList
                    .stream()
                    .map(person -> new Person().setPersonIdRef(person.getId()))
                    .forEach(person -> {
                        var peopleElement = createdNode.getPeopleOrDefault();
                        peopleElement.addPerson(person);
                    });

            return scope.logReturn(Optional.of(new Result(createdNode, personList)));
        }
        
    }

    public static Optional<Result> createGraphNode(
        WorldStepInstance worldStepInstance,
        LocationGraph locationGraph,
        String startNodeRef,
        final CreateAdjacent.XYPosition position,
        final Stream<String> classificationLocationList) {
        try (var scope = logScope()){

            var result = createGraphNode(worldStepInstance, locationGraph, startNodeRef);

            if (result.isEmpty()) {
                return result;
            }
            var createdNode = result.get().node;

            createdNode.getPosition().ifPresent(position1 -> {
                position1.setX(position.x());
                position1.setY(position.y());
            });
            classificationLocationList.forEach(string -> createdNode
                    .getClassificationsOrDefault()
                    .addClassification(new Classification()
                            .setLocationClassificationRuleRef(string)
                    ));

            return scope.logReturn(result);
        }
    }

    private static List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person> computeRuleExistingPerson(
        WorldStepInstance worldStepInstance,
        NodeRule nodeRule) {
        try (var scope = logScope("locationGraphId", nodeRule.getId(), "nodeRule", nodeRule.getId())) {
            scope.log("adding existing person");
            var existingPersonRule = nodeRule.getExistingPerson();
            var personList = existingPersonRule
                    .stream()
                    .flatMap(existingPerson -> {
                        var min = existingPerson.getMin();
                        var max = existingPerson.getMax().orElse(min);
                        var iterations = worldStepInstance.randomBetweenInt(min, max);
                        scope.log("min", min, "max", max, "iterations", iterations);
                        return IntStream.range(0, iterations)
                                .boxed()
                                .map(ignored -> {
                                    var personMutation = worldStepInstance.person.createPerson(existingPerson.getPersonSelection());
                                    personMutation.apply(worldStepInstance.getOutInstance());
                                    var person = personMutation.apply(worldStepInstance);
                                    scope.logTodo("Remove mutation on outInstance");
                                    scope.log("adding personId ", person.getId());
                                    return person;
                                });
                    });
            if (existingPersonRule.isEmpty()) {
                scope.log("no existing person rule");
                return List.of();
            }
            return scope.logReturn(personList.toList());
        }

    }

    private static Node instantiateGraphNode(
        WorldStepInstance worldStepInstance,
        NodeRule nodeRule,
        String startNodeRef) {
        try (var scope = logScope()){
            var logger = logEnter();
            logger.log("creating node");
            var nodeElement = new Node()
                    .setNodeRuleRef(startNodeRef)
                    .setId(worldStepInstance.getNextId());

            logger.log("addingName");
            var nameRule = nodeRule.getName()
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

            logger.log("setting position");
            nodeElement.setPosition(new Position()
                    .setX(0)
                    .setY(0)
            );

            nodeRule.streamClassifications()
                    .flatMap(Classifications::streamClassification)
                    .forEach(classification -> {
                        nodeElement.getClassificationsOrDefault().addClassification(new Classification()
                                .setLocationClassificationRuleRef(classification.getLocationClassificationRuleRef())
                        );
                    });

            return scope.logReturn(nodeElement);
        }
    }
}
