package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class ClassificationRuleRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamRuleGroup()
            .flatMap(RuleGroup::streamClassificationRule)
            .flatMap(ClassificationRule::streamEntry)
            .map(Entry::getId);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "classification_rule_ref";
    }
}
