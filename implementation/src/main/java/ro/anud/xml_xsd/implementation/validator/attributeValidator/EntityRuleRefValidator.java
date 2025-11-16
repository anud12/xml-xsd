package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class EntityRuleRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamRuleGroup()
                .flatMap(RuleGroup::streamEntityRule)
                .flatMap(EntityRule::streamEntry)
                .map(Entry::getName);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "entity_rule_ref";
    }
}
