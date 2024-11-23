package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.PersonToPerson.PersonToPerson;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class ActionRuleRefValidation implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamRuleGroup()
            .flatMap(RuleGroup::streamActionRule)
            .flatMap(ActionRule::streamPersonToPerson)
            .map(PersonToPerson::getId);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "action_rule_ref";
    }
}
