package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutation.IType_propertyMutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.List;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ComputePropertyMutation {

    public record Result(String propertyRuleRef, int deltaValue) {}
    public static List<Result> computePropertyMutation(
        final WorldStepInstance worldStepInstance,
        final IType_propertyMutation<?> typePropertyMutation,
        final Person selfPerson,
        final Person targetPerson) {
        try (var scope = logScope(
                "selfPerson",
                selfPerson.getId(),
                "targetPerson",
                targetPerson.getId()
        )){
            var propertyRuleRef = typePropertyMutation.getPropertyRuleRef();
            scope.log("propertyRuleRef:", propertyRuleRef);
            return typePropertyMutation.streamFrom()
                    .flatMap(from -> {
                        scope.log("participant:", from.getParticipant());
                        var person = switch (from.getParticipant()) {
                            case "self" -> selfPerson;
                            default -> targetPerson;
                        };
                        try (var innerLog = logScope()){
                            var newValueOptional = worldStepInstance.computeOperation(
                                    from.getOperation(),
                                    person);
                            if (newValueOptional.isEmpty()) {
                                return Stream.empty();
                            }

                            var deltaValue = newValueOptional.get();
                            innerLog.log("deltaValue", deltaValue);
                            var result = new Result(propertyRuleRef, deltaValue);
                            innerLog.log("result", result);
                            return Stream.of(result);
                        }

                    })
                    .toList();
        }

    }
}
