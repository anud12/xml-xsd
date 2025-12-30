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

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class CreateLocationGraph {

    public static Optional<Mutation<LocationGraph>> createLocationGraph(
        WorldStepInstance worldStepInstance,
        String ref) {
        try (var scope = logScope("ref", ref)){
            var ruleOptional = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamLocationGraphRule)
                    .filter(locationGraphRule -> locationGraphRule.getId().equals(ref))
                    .findFirst();

            if (ruleOptional.isEmpty()) {
                scope.log("no rule found");
                return scope.logReturn(Optional.empty());
            }
            var rule = ruleOptional.get();
            var setup = rule.getSetup();

            var startNodeRef = setup.getStartingNode().getNodeRuleRef();

            var locationGraph = initializeLocationGraph(worldStepInstance, ref);

            scope.log("creating startNode");
            var startNodeOptional = worldStepInstance.locationGraph.createGraphNode(locationGraph, startNodeRef);

            if (startNodeOptional.isEmpty()) {
                scope.log("startNode is empty");
                return Optional.empty();
            }
            return Optional.of(Mutation.of(outInstance -> {

                var outLocationGraph = outInstance.locationGraph.locationGraphRepository.getLocationGraphOrDefault(locationGraph);

                var createdNode = new ArrayList<Node>();
                outLocationGraph.addNode(startNodeOptional.get());
                createdNode.add(startNodeOptional.get());

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
    }

    private static boolean isNecessaryNodeSatisfied(final LocationGraphRule rule, final ArrayList<Node> createdNode) {
        try (var scope = logScope()){
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
                    scope.logTodo("change nodeCount - minCount to nodeCount - 1");
                    nodeRuleIdToNumberMap.put(nodeRuleId, nodeCount - minCount);
                    return true;
                }
                return false;
            });

            return unsatisfiedRules.findAny().isEmpty();
        }

    }

    private static LocationGraph initializeLocationGraph(final WorldStepInstance worldStepInstance, final String ref) {
        return new LocationGraph()
            .setRule(new Rule().setLocationGraphRuleRef(ref))
            .setId(worldStepInstance.getNextId());
    }
}
