package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class ApplyPropertyMutation {

    public static void applyPropertyMutation(
        final WorldStepInstance worldStepInstance,
        final Person selfPerson,
        final Type_propertyMutation typePropertyMutation,
        final Person originPerson,
        final Person targetPerson) {
        var logger = logEnter(
            "selfPerson:",
            selfPerson.getId(),
            "originPerson",
            originPerson.getId(),
            "targetPerson",
            targetPerson.getId()
        );
        var propertyRuleRef = typePropertyMutation.getPropertyRuleRef();
        logger.log("propertyRuleRef:", propertyRuleRef);
        typePropertyMutation.streamFrom()
            .forEach(from -> {
                logger.log("participant:", from.getParticipant());
                var person = switch (from.getParticipant()) {
                    case "self" -> originPerson;
                    default -> targetPerson;
                };
                logger.log("on personId:", from.getParticipant());
                var newValueOptional = worldStepInstance.computeOperation(
                    from.getOperation(),
                    person);
                if (newValueOptional.isEmpty()) {
                    return;
                }
                var deltaValue = newValueOptional.get();

                worldStepInstance.getOutInstance()
                    .person
                    .repository
                    .personById(person.getId())
                    .stream()
                    .flatMap(Person::streamProperties)
                    .flatMap(Properties::streamProperty)
                    .filter(property -> property.getPropertyRuleRef().equals(propertyRuleRef))
                    .forEach(property -> {
                        var newValue = property.getValue() + deltaValue;
                        logger.log("newValue:", newValue);
                        property.setValue(newValue);
                    });
            });
    }
}
