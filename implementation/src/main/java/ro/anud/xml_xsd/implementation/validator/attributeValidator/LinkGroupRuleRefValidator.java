package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRule.LinkGroupRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LinkGroupRuleList.LinkGroupRuleList;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class LinkGroupRuleRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamRuleGroup()
            .flatMap(RuleGroup::streamLinkGroupRuleList)
            .flatMap(LinkGroupRuleList::streamLinkGroupRule)
            .map(LinkGroupRule::getId);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "link_group_rule_ref";
    }
}
