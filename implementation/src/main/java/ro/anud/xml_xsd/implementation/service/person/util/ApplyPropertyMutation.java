package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutation.IType_propertyMutation;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ApplyPropertyMutation {

    public static Mutation<Person> applyPropertyMutation(
        final WorldStepInstance worldStepInstance,
        final Person applicablePerson,
        final IType_propertyMutation<?> typePropertyMutation,
        final Person selfPerson,
        final Person targetPerson) {
        try (var scope = logScope(
                "applicablePerson",
                applicablePerson.getId(),
                "selfPerson",
                selfPerson.getId(),
                "targetPerson",
                targetPerson.getId()
        )) {

            var result = ComputePropertyMutation.computePropertyMutation(
                    worldStepInstance,
                    typePropertyMutation,
                    selfPerson,
                    targetPerson);

            scope.log("applying mutation");

            return Mutation.of(outInstance -> {
                        var outPerson = outInstance
                                .person.repository.getOrCreate(applicablePerson);
                        result.forEach(mutation -> {
                            scope.log("outPerson", outPerson.getId(), "propertyRuleRef", mutation.propertyRuleRef(), "deltaValue", mutation.deltaValue());
                            outInstance.person.mutatePropertyIfPresent(
                                    outPerson,
                                    mutation.propertyRuleRef(),
                                    integer -> integer + mutation.deltaValue()
                            );
                        });
                        return outPerson;
                    }
            );
        }

    }
}
