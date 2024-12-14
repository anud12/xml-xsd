package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutation.IType_propertyMutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class ApplyPropertyMutation {

    public static Stream<WorldStepInstance.Mutation> applyPropertyMutation(
        final WorldStepInstance worldStepInstance,
        final Person selfPerson,
        final IType_propertyMutation<?> typePropertyMutation,
        final Person originPerson,
        final Person targetPerson) {
        var logger = logEnter(
            "selfPerson",
            selfPerson.getId(),
            "originPerson",
            originPerson.getId(),
            "targetPerson",
            targetPerson.getId()
        );
        var propertyRuleRef = typePropertyMutation.getPropertyRuleRef();
        logger.log("propertyRuleRef:", propertyRuleRef);
        return typePropertyMutation.streamFrom()
            .flatMap(from -> {
                logger.log("participant:", from.getParticipant());
                var person = switch (from.getParticipant()) {
                    case "self" -> originPerson;
                    default -> targetPerson;
                };
                var innerLog = logger.log("on personId:", person.getId());
                var newValueOptional = worldStepInstance.computeOperation(
                    from.getOperation(),
                    person);
                if (newValueOptional.isEmpty()) {
                    return Stream.empty();
                }

                var deltaValue = newValueOptional.get();
                innerLog.log("deltaValue", deltaValue);
                innerLog.log("searching person in outInstance");
                return Stream.of(outInstance -> {
                    var outPerson = worldStepInstance.getOutInstance()
                        .person
                        .repository
                        .personById(selfPerson.getId());
                    var propertyElementList = outPerson
                        .stream()
                        .flatMap(Person::streamPropertiesOrDefault)
                        .flatMap(Properties::streamProperty)
                        .filter(property -> property.getPropertyRuleRef().equals(propertyRuleRef))
                        .toList();
                    innerLog.log("found properties of ref", propertyRuleRef, "size", propertyElementList.size());
                    if (propertyElementList.isEmpty()) {
                        innerLog.log("creating property");

                        outInstance.person.mutateProperty(
                            outPerson.get(),
                            propertyRuleRef,
                            integer -> integer + deltaValue
                        );
                    }
                    propertyElementList
                        .forEach(property -> {
                            innerLog.log("currentValue", property.getValue());
                            var newValue = property.getValue() + deltaValue;
                            innerLog.log("newValue:", newValue);
                            property.setValue(newValue);
                        });
                });
            });
    }
}
