package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Properties;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Property.Property;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.Entry.PropertyBonus.PropertyBonus;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RaceRule.RaceRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;
import java.util.function.Consumer;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.*;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class GetProperty {

    private static Optional<Integer> getBaseProperty(
        final WorldStepInstance worldStepInstance,
        final Person person,
        final String propertyRef) {
        var logger = logEnter("personId:", person.getId(), "propertyRef:", propertyRef);
        var property = worldStepInstance.ruleRepository.getPropertyById(propertyRef).stream();
        var personDefaultOptional = property.flatMap(Entry::streamPersonDefault).findAny();

        var returnValue = personDefaultOptional.flatMap(personDefault1 -> logger
            .log("personId:", person.getId(), "propertyRef:", propertyRef)
            .logReturn(worldStepInstance.computeOperation(personDefault1, person))
        );

        return logger.logReturn(returnValue);
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

        logger.log("on race not present");
        var baseValue = getBaseProperty(worldStepInstance, person, propertyRef);
        if (baseValue.isPresent()) {
            logger.log("base value is present");
            return logger.logReturn(baseValue);
        }
        logger.log("base value is not present");
        return logger.logReturn(Optional.empty());
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
                        logger.log("setting property on person:", innerPerson.getId(), "propertyRef:", propertyRef, "value:", value);
                        property1.setValue(value.get());
                    },
                    () -> {

                        logger.log("adding property to person:", innerPerson.getId(), "propertyRef:", propertyRef, "value:", value);
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
