package ro.anud.xml_xsd.implementation.validator;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.attributeValidator.*;

import java.util.List;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class AtrributeValidator {

    List<AttributeValidator> attributeValidatorList = List.of(
            new ClassificationRuleRefValidator(),
            new LocationClassificationRuleRefValidator(),
            new LinkGroupRuleRefValidator(),
            new NameRuleRefValidator(),
            new NodeRuleRefValidator(),
            new NodeIdRefValidator(),
            new LocationGraphIdRefValidator(),
            new EntityRuleRefValidator(),
            new ContainerRuleRefValidator()
            );

    public List<AttributeValidator.InvalidAttribute> validate(Optional<WorldStep> worldStep) {
        try (var logger = logScope("validate")) {
            return worldStep.map(step -> attributeValidatorList.stream()
                            .flatMap(attributeValidator -> {
                                logger.log("validating using", attributeValidator.getClass().getSimpleName());
                                return attributeValidator.validate(step).stream();
                            })
                            .toList())
                    .orElseGet(List::of);
        }
    }
}
