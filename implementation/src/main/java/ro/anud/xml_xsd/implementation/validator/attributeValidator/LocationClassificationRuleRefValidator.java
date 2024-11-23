package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationClassificationRule.LocationClassificationRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class LocationClassificationRuleRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamRuleGroup()
            .flatMap(RuleGroup::streamLocationClassificationRule)
            .flatMap(LocationClassificationRule::streamEntry)
            .map(Entry::getId);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "location_classification_rule_ref";
    }
}
