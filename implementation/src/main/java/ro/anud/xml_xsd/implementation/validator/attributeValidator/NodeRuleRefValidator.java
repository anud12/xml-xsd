package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.LocationGraphRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.LocationGraphRule.NodeRule.NodeRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class NodeRuleRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamRuleGroup()
            .flatMap(RuleGroup::streamLocationGraphRule)
            .flatMap(LocationGraphRule::streamNodeRule)
            .map(NodeRule::getId);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "node_rule_ref";
    }
}
