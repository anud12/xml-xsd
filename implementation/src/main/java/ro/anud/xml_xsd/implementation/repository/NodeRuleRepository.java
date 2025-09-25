package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.NodeRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.Subscription;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class NodeRuleRepository {
    private final WorldStepInstance worldStepInstance;
    private Optional<Subscription> subscription = Optional.empty();
    private final HashMap<String, HashMap<String, NodeRule>> nodeRuleByLocationGraphIdByNodeRuleId = new HashMap<>();

    public NodeRuleRepository(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()){
            this.worldStepInstance = worldStepInstance;
        }
    }


    public void index(List<RuleGroup> ruleGroupList) {
        try (var scope = logScope()){
            subscription.ifPresent(Subscription::unsubscribe);
            subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(objects -> {
                scope.logTodo("Streamline checking");
                if (objects.stream().map(Object::getClass).anyMatch(o -> o.equals(NodeRule.class))) {
                    loadData();
                }
            }));
            loadData();
        }
    }

    private void loadData() {
        try (var scope = logScope()) {
            worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamRuleGroup)
                .flatMap(RuleGroup::streamLocationGraphRule)
                .forEach(locationGraphRule -> locationGraphRule.streamNodeRule()
                    .forEach(nodeRule -> {
                        var innerMap = nodeRuleByLocationGraphIdByNodeRuleId.getOrDefault(
                            locationGraphRule.getId(),
                            new HashMap<>()
                        );
                        innerMap.put(nodeRule.getId(), nodeRule);
                        nodeRuleByLocationGraphIdByNodeRuleId.put(locationGraphRule.getId(), innerMap);
                    })
                );
        }

    }

    public Optional<NodeRule> getNodeRuleByLocationGraphAndNode(final LocationGraph locationGraph, final Node node) {
        try (var scope = logScope("LocationGraph id: " + locationGraph.getId() + " and Node id: " + node.getId())) {
            var result = nodeRuleByLocationGraphIdByNodeRuleId.getOrDefault(
                locationGraph.getRule().getLocationGraphRuleRef(),
                new HashMap<>()
            );
            return scope.logReturn(Optional.ofNullable(result.get(node.getNodeRuleRef())));
        }

    }

    public Stream<NodeRule> streamNodeRuleByLocationGraphAndNode(final LocationGraph locationGraph, final Node node) {
        try (var scope = logScope("LocationGraph id: " + locationGraph.getId() + " and Node id: " + node.getId())) {
            return scope.logReturn(getNodeRuleByLocationGraphAndNode(locationGraph, node).stream());
        }
    }

}
