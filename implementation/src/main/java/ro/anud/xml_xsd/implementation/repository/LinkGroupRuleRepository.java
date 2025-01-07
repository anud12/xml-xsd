package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.LinkGroupRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class LinkGroupRuleRepository {

    private HashMap<String, LinkGroupRule> map = new HashMap<>();

    public void index(final List<RuleGroup> ruleGroupList) {
        var logger = logEnter();
        ruleGroupList.stream()
            .flatMap(RuleGroup::streamLinkGroupRuleList)
            .flatMap(LinkGroupRuleList::streamLinkGroupRule)
            .forEach(linkGroupRule -> {
                map.put(linkGroupRule.getId(), linkGroupRule);
            });
        logger.logReturnVoid();
    }

    public Optional<LinkGroupRule> getById(String id) {
        return logEnter().logReturn(Optional.ofNullable(map.get(id)));
    }

    public Stream<LinkGroupRule> streamById(String id) {
        return logEnter().logReturn(getById(id).stream());
    }
}
