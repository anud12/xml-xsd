package ro.anud.xml_xsd.implementation.service.location_graph.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class CreateLocationGraph {

    public static Optional<Mutation<LocationGraph>> createLocationGraph(
        WorldStepInstance worldStepInstance,
        String ref) {
        var logger = logEnter("ref", ref);
        var ruleOptional = worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamRuleGroup)
            .flatMap(RuleGroup::streamLocationGraphRule)
            .filter(locationGraphRule -> locationGraphRule.getId().equals(ref))
            .findFirst();

        if (ruleOptional.isEmpty()) {
            logger.log("no rule found");
            return logger.logReturn(Optional.empty());
        }
        var rule = ruleOptional.get();
        var setup = rule.getSetup();

        var startNodeRef = setup.getStartingNode().getNodeRuleRef();

        var locationGraph = initializeLocationGraph(worldStepInstance, ref);

        logger.log("creating startNode");
        var startNodeOptional = worldStepInstance.locationGraph.createGraphNode(locationGraph, startNodeRef);

        if (startNodeOptional.isEmpty()) {
            logger.log("startNode is empty");
            return Optional.empty();
        }


        return Optional.of(Mutation.of(outInstance -> {

            startNodeOptional.get().personList().forEach(outInstance.person.repository::getOrCreate);
            var outLocationGraph = outInstance.locationGraph.locationGraphRepository.getLocationGraphOrDefault(locationGraph);

            var createdNode = new ArrayList<Node>();
            outLocationGraph.addNode(startNodeOptional.get().node());
            createdNode.add(startNodeOptional.get().node());

            while (!isNecessaryNodeSatisfied(rule, createdNode)) {
                if (createdNode.isEmpty()) {
                    break;
                }
                Optional<Node> adjacentNode = worldStepInstance
                    .locationGraph
                    .createAdjacent(
                        outLocationGraph,
                        createdNode.getFirst().getId()
                    ).map(nodeMutation -> nodeMutation.apply(outInstance));
                if (adjacentNode.isEmpty()) {
                    createdNode.removeFirst();
                    continue;
                }
                outLocationGraph.addNode(adjacentNode.get());
                createdNode.add(adjacentNode.get());
            }
            return outLocationGraph;
        }));

    }

    private static boolean isNecessaryNodeSatisfied(final LocationGraphRule rule, final ArrayList<Node> createdNode) {
        var logger = logEnter();
        var necessaryNodeList = rule.getSetup().streamNecessaryNode();
        var nodeRuleIdToNumberMap = new HashMap<String, Integer>();
        createdNode.forEach(node -> {
            Integer value = nodeRuleIdToNumberMap.getOrDefault(node.getNodeRuleRef(), 0);
            nodeRuleIdToNumberMap.put(node.getNodeRuleRef(), value + 1);
        });
        var unsatisfiedRules = necessaryNodeList.filter(necessaryNode -> {
            var nodeRuleId = necessaryNode.getNodeRuleRef();
            var minCount = necessaryNode.getMin();
            var nodeCount = nodeRuleIdToNumberMap.getOrDefault(nodeRuleId, 0);
            if (nodeCount < minCount) {
                logger.logTodo("change nodeCount - minCount to nodeCount - 1");
                nodeRuleIdToNumberMap.put(nodeRuleId, nodeCount - minCount);
                return true;
            }
            return false;
        });

        return unsatisfiedRules.findAny().isEmpty();
    }

    private static LocationGraph initializeLocationGraph(final WorldStepInstance worldStepInstance, final String ref) {
        return new LocationGraph()
            .setRule(new Rule().setLocationGraphRuleRef(ref))
            .setId(worldStepInstance.getNextId());
    }
}
