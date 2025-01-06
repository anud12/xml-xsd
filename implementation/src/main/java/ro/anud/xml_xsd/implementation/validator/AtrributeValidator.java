package ro.anud.xml_xsd.implementation.validator;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.attributeValidator.*;

import java.util.List;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class AtrributeValidator {

    List<AttributeValidator> attributeValidatorList = List.of(
        new PropertyRefValidator(),
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
        var logger = logEnter("validate");
        return attributeValidatorList.stream()
            .flatMap(attributeValidator -> {
                logger.log("validating using", attributeValidator.getClass().getSimpleName());
                return attributeValidator.validate(worldStep).stream();
            })
            .toList();

    }
}
