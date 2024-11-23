package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class RaceRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamRuleGroup()
            .flatMap(RuleGroup::streamRaceRule)
            .flatMap(RaceRule::streamEntry)
            .map(Entry::getId);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "race_rule_ref";
    }
}
