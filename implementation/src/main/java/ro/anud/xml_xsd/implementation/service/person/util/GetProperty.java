package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Property.Property;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;
import java.util.function.Consumer;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class GetProperty {


    public static Optional<Integer> computeBaseProperty(
        final WorldStepInstance worldStepInstance,
        final Person person,
        final String propertyRef) {
        var logger = logEnter( "propertyRef:", propertyRef);
        var property = worldStepInstance.ruleRepository.getPropertyById(propertyRef).stream();
        var personDefaultOptional = property.flatMap(Entry::streamPersonDefault).findAny();

        return logger.logReturn(worldStepInstance.computeOperation(personDefaultOptional, person));

    }

    private static Optional<Mutation<Integer>> getBaseProperty(
        final WorldStepInstance worldStepInstance,
        final Person person,
        final String propertyRef) {
        var logger = logEnter("personId:", person.getId(), "propertyRef:", propertyRef);
        var value = computeBaseProperty(worldStepInstance,person,propertyRef);
        var innerLog = logger.log("computed value", value);
        return value.map(integer -> Mutation.of(outInstance -> {
            var properties = outInstance.person.repository.getOrCreate(person)
                .getPropertiesOrDefault();

            var outProperty = properties.streamProperty()
                .filter(property1 -> property1.getPropertyRuleRef().equals(propertyRef))
                .findAny();
            if(outProperty.isEmpty()){
                innerLog.log("adding default property");
                properties.addProperty(new Property()
                    .setValue(integer)
                    .setPropertyRuleRef(propertyRef)
                );
            }
            return integer;
        }));
    }


    private static Optional<Integer> computeProperty(
        final WorldStepInstance worldStepInstance,
        final Person person,
        final String propertyRef) {
        var logger = logEnter("personId:", person.getId(), "propertyRef:", propertyRef);
        worldStepInstance.ruleRepository.getPropertyById(propertyRef);
        var personProperty = person.streamProperties()
            .flatMap(Properties::streamProperty)
            .filter(property -> propertyRef.equals(property.getPropertyRuleRef()))
            .findFirst();

        if (personProperty.isPresent()) {
            logger.log("on person is present");
            return logger.logReturn(personProperty.map(Property::getValue));
        }

        var baseValue = getBaseProperty(worldStepInstance, person, propertyRef);
        return baseValue.map(integerMutation -> {
            logger.log("base value is present");
            integerMutation.apply(worldStepInstance.getOutInstance());
            return integerMutation.apply(worldStepInstance);
        }).or(() -> {
            logger.log("base value is not present");
            return Optional.empty();
        });
    }

    public static Optional<Integer> getProperty(
        final WorldStepInstance worldStepInstance,
        final Person person,
        final String propertyRef) {
        var logger = logEnter("personId:", person.getId(), "propertyRef:", propertyRef);
        var value = computeProperty(worldStepInstance, person, propertyRef);
        if (value.isEmpty()) {
            return logger.logReturn(value, "value is empty");
        }

        Consumer<Person> applyValue = innerPerson -> {
            var property = innerPerson.getPropertiesOrDefault();
            property.streamProperty().filter(property1 -> property1.getPropertyRuleRef().equals(propertyRef))
                .findFirst()
                .ifPresentOrElse(
                    property1 -> {
                        logger.log(
                            "setting property on person:",
                            innerPerson.getId(),
                            "propertyRef:",
                            propertyRef,
                            "value:",
                            value);
                        property1.setValue(value.get());
                    },
                    () -> {

                        logger.log(
                            "adding property to person:",
                            innerPerson.getId(),
                            "propertyRef:",
                            propertyRef,
                            "value:",
                            value);
                        var newProperty = Property.builder()
                            .value(value.get())
                            .propertyRuleRef(propertyRef)
                            .build();
                        property.addProperty(newProperty);

                    }
                );
        };


        logger.log("setting property on person:", person.getId(), "propertyRef:", propertyRef, "value:", value);
        applyValue.accept(person);

        return logger.logReturn(value);

    }

}
