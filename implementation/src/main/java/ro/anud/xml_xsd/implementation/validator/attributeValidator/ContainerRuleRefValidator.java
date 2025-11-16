package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class ContainerRuleRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamRuleGroup()
            .flatMap(RuleGroup::streamContainerRule)
            .flatMap(ContainerRule::streamEntry)
            .map(Entry::getName);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "container_rule_ref";
    }
}
