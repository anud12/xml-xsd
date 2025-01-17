package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList;
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

public class NodeRuleRepository {
    private final WorldStepInstance worldStepInstance;
    private Optional<Subscription> subscription = Optional.empty();
    private final HashMap<String, HashMap<String, NodeRule>> nodeRuleByLocationGraphIdByNodeRuleId = new HashMap<>();

    public NodeRuleRepository(final WorldStepInstance worldStepInstance) {this.worldStepInstance = worldStepInstance;}


    public void index(List<RuleGroup> ruleGroupList) {
        var logger = logEnter("LinkGroupRuleRepository indexing");
        subscription.ifPresent(Subscription::unsubscribe);
        subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(objects -> {
            logger.logTodo("Streamline checking");
            if (objects.stream().map(Object::getClass).anyMatch(o -> o.equals(NodeRule.class))) {
                loadData();
            }
        }));
        loadData();
    }

    private void loadData() {
        var logger = logEnter();
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
        logger.logReturnVoid();
    }

    public Optional<NodeRule> getNodeRuleByLocationGraphAndNode(final LocationGraph locationGraph, final Node node) {
        var logger = logEnter();
        var result = nodeRuleByLocationGraphIdByNodeRuleId.getOrDefault(
            locationGraph.getRule().getLocationGraphRuleRef(),
            new HashMap<>()
        );
        return logger.logReturn(Optional.ofNullable(result.get(node.getNodeRuleRef())));
    }

    public Stream<NodeRule> streamNodeRuleByLocationGraphAndNode(final LocationGraph locationGraph, final Node node) {
        var logger = logEnter();
        return logger.logReturn(getNodeRuleByLocationGraphAndNode(locationGraph, node).stream());
    }

}
