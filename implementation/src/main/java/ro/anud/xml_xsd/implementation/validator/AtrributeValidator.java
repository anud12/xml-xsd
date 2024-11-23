package ro.anud.xml_xsd.implementation.validator;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.attributeValidator.*;

import java.util.List;

public class AtrributeValidator {

    List<AttributeValidator> attributeValidatorList = List.of(
        new PropertyRefValidator(),
        new RaceRefValidator(),
        new ActionRuleRefValidation(),
        new ClassificationRuleRefValidator(),
        new LocationClassificationRuleRefValidator(),
        new LinkGroupRuleRefValidator(),
        new PersonRefValidator(),
        new NameRuleRefValidator(),
        new NodeRuleRefValidator(),
        new NodeIdRefValidator(),
        new LocationGraphIdRefValidator()
    );

    public List<AttributeValidator.InvalidAttribute> validate(WorldStep worldStep) {
        return attributeValidatorList.stream()
            .flatMap(attributeValidator -> attributeValidator.validate(worldStep).stream())
            .toList();

    }
}
