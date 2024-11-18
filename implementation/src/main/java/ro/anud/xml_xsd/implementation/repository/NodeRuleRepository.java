package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.NodeRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class NodeRuleRepository {
    private final HashMap<String, HashMap<String, NodeRule>> nodeRuleByLocationGraphIdByNodeRuleId = new HashMap<>();


    public void index(List<RuleGroup> ruleGroupList) {
        var logger = logEnter();
        ruleGroupList.stream().flatMap(RuleGroup::streamLocationGraphRule)
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
