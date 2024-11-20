package ro.anud.xml_xsd.implementation.service.name;

import ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class CalculateName {
    public static Optional<String> calculateNameFromRefString(WorldStepInstance worldStepInstance, String ref) {
        var logger = logEnter();
        return logger.logReturn(worldStepInstance.name
            .repository
            .getNameTokenById(ref)
            .flatMap(iTypeNameToken -> calculateNameFromChildren(worldStepInstance, iTypeNameToken))
        );
    }

    private static Optional<String> calculateNameFromChildren(WorldStepInstance worldStepInstance, Entry rule) {
        var logger = logEnter();
        var result = rule.streamNameToken().map(nameToken -> {
            return calculateChildren(worldStepInstance, nameToken);
        }).collect(Collectors.joining(""));

        return logger.logReturn(Optional.of(result));
    }

    private static String calculateChildren(final WorldStepInstance worldStepInstance, final NameToken nameToken) {
        var logger = logEnter();
        var value = nameToken.getPrefix();
        var refResult = nameToken.get_ref()
            .flatMap(ref -> calculateNameFromRefString(worldStepInstance, ref.getNameRuleRef()))
            .orElse("");
        logger.log("refResult", refResult);
        var nameResult = nameToken.getOneOf().flatMap(groupNameToken -> {
            var nameTokenList = groupNameToken.getNameToken();
            return worldStepInstance.randomFrom(nameTokenList).map(nameToken1 -> calculateChildren(
                worldStepInstance,
                nameToken1));
        }).orElse("");
        logger.log("nameResult", nameResult);
        value += refResult;
        value += nameResult;
        return logger.logReturn(value);
    }
}
