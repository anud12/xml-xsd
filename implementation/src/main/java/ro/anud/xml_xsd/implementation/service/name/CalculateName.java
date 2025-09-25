package ro.anud.xml_xsd.implementation.service.name;

import ro.anud.xml_xsd.implementation.model.Type_nameToken.NameToken.NameToken;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class CalculateName {
    public static Optional<String> calculateNameFromRefString(WorldStepInstance worldStepInstance, String ref) {
        try (var scope = logScope()){
            return scope.logReturn(worldStepInstance.name
                    .repository
                    .getNameTokenById(ref)
                    .flatMap(iTypeNameToken -> calculateNameFromChildren(worldStepInstance, iTypeNameToken))
            );
        }

    }

    private static Optional<String> calculateNameFromChildren(WorldStepInstance worldStepInstance, Entry rule) {
        try (var scope = logScope()){
            var result = rule.streamNameToken()
                    .map(nameToken -> calculateChildren(worldStepInstance, nameToken))
                    .collect(Collectors.joining(""));

            return scope.logReturn(Optional.of(result));
        }
    }

    private static String calculateChildren(final WorldStepInstance worldStepInstance, final NameToken nameToken) {
        try (var scope = logScope()){
            var value = nameToken.getPrefix();
            var refResult = nameToken.get_ref()
                    .flatMap(ref -> calculateNameFromRefString(worldStepInstance, ref.getNameRuleRef()))
                    .orElse("");
            scope.log("refResult", refResult);
            var nameResult = nameToken.getOneOf().flatMap(groupNameToken -> {
                var nameTokenList = groupNameToken.getNameToken();
                return worldStepInstance.randomFrom(nameTokenList).map(nameToken1 -> calculateChildren(
                        worldStepInstance,
                        nameToken1));
            }).orElse("");
            scope.log("nameResult", nameResult);
            value += refResult;
            value += nameResult;
            return scope.logReturn(value);

        }
    }
}
