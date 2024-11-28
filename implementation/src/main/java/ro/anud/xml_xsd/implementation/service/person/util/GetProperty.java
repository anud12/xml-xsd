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

    private static Optional<Integer> getRaceProperty(
        final WorldStepInstance worldStepInstance,
        final Person person,
        String propertyRef,
        String raceRef) {
        var logger = logEnter("personId", person.getId(), "propertyRef:", propertyRef, "raceRef:", raceRef);
        var personRaceOptional = person.getRace();
        var personRace = personRaceOptional.get();
        var raceMetadataList = worldStepInstance.getWorldStep()
            .streamRuleGroup()
            .flatMap(RuleGroup::streamRaceRule)
            .flatMap(RaceRule::streamEntry)
            .toList();
        var raceMetadata = raceMetadataList.stream().filter(entry -> {
                if (entry.getName().isPresent()) {
                    return personRace.getRaceRuleRef().equals(entry.getName().get());
                }
                return false;
            })
            .findFirst();
        if (raceMetadata.isEmpty()) {
            return java.util.Optional.empty();
        }

        logger.log("Computing base property");
        var base = getBaseProperty(worldStepInstance, person, propertyRef).orElse(0);

        Optional<PropertyBonus> propertyBonusOptional = raceMetadata.get().getPropertyBonus()
            .stream().filter(groupMathOperations -> groupMathOperations.getPropertyRuleRef().equals(propertyRef))
            .findFirst();
        var bonus = propertyBonusOptional
            .flatMap(propertyBonus -> worldStepInstance.computeOperation(propertyBonus, person))
            .orElse(0);

        return java.util.Optional.ofNullable(base + bonus);
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
        logger.log("on person not present");
        var personRaceOptional = person.getRace();

        var raceValue = personRaceOptional
            .map(Race::getRaceRuleRef)
            .flatMap(raceRule -> getRaceProperty(worldStepInstance, person, propertyRef, raceRule));

        if (raceValue.isPresent()) {
            logger.log("on race is present");
            return logger.logReturn(raceValue);
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
        var outInstance = worldStepInstance.getOutInstance();

        var value = computeProperty(worldStepInstance, person, propertyRef);
        if (value.isEmpty()) {
            return Optional.empty();
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
                        property.addProperty(Property.builder()
                            .value(value.get())
                            .propertyRuleRef(propertyRef)
                            .build());
                    }
                );
        };


        logger.log("setting property on person:", person.getId(), "propertyRef:", propertyRef, "value:", value);
        outInstance.person.repository.personById(person.getId())
            .ifPresent(applyValue);
        applyValue.accept(person);

        return logger.logReturn(value);

    }

}
