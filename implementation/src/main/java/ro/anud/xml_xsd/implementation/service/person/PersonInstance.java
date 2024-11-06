package ro.anud.xml_xsd.implementation.service.person;

import ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation;
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
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.*;

public class PersonInstance {

    private final WorldStepInstance worldStepInstance;
    private final SelectionInstance selectionInstance;

    public PersonInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        selectionInstance = new SelectionInstance(worldStepInstance);

    }

    public SelectionInstance selection() {
        return selectionInstance;
    }

    private Optional<Integer> getBaseProperty(final Person person, final String propertyRef) {
        var logger = logEnter("personId:", person.getId(), "propertyRef:", propertyRef);
        var property = worldStepInstance.getRuleRepository().getPropertyById(propertyRef)
                .stream();
        var personDefaultOptional = property.flatMap(Entry::streamPersonDefault).findAny();

        var returnValue = personDefaultOptional
                .map(personDefault1 -> {
                    log("personId:", person.getId(), "propertyRef:", propertyRef);
                    var propertyInstance = worldStepInstance
                            .getPropertyInstance();
                    var result = propertyInstance.computeOperation(
                            personDefault1,
                            propertyRef1 -> worldStepInstance.getPersonInstance().getProperty(
                                    person,
                                    propertyRef1
                            )
                    );
                    return logReturn(result, "personId:", person.getId(), "propertyRef:", propertyRef);
                })
                .orElseGet(Optional::empty);

        return logger.logReturn(returnValue);
    }

    private Optional<Integer> getRaceProperty(final Person person, String propertyRef, String raceRef) {
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
            return Optional.empty();
        }

        logger.log("Computing base property");
        var base = getBaseProperty(person, propertyRef).orElse(0);

        Optional<PropertyBonus> propertyBonusOptional = raceMetadata.get().getPropertyBonus()
                .stream().filter(groupMathOperations -> groupMathOperations.getPropertyRuleRef().equals(propertyRef))
                .findFirst();
        var bonus = propertyBonusOptional.map(propertyBonus -> {
            worldStepInstance.getPropertyInstance().computeOperation(
                    propertyBonus,
                    propertyRef1 -> worldStepInstance.getPersonInstance().getProperty(
                            person,
                            propertyRef1
                    ));
            return 0;
        }).orElse(0);

        return Optional.ofNullable(base + bonus);
    }


    private Optional<Integer> computeProperty(final Person person, final String propertyRef) {
        var logger = logEnter("personId:", person.getId(), "propertyRef:", propertyRef);
        worldStepInstance.getRuleRepository().getPropertyById(propertyRef);
        var personProperty = person.streamProperties()
                .flatMap(Properties::streamProperty)
                .filter(property -> propertyRef.equals(property.getPropertyRuleRef()))
                .findFirst();
        if (personProperty.isPresent()) {
            return personProperty.map(Property::getValue);
        }
        var personRaceOptional = person.getRace();

        var raceValue = personRaceOptional
                .map(Race::getRaceRuleRef)
                .flatMap(raceRule -> getRaceProperty(person, propertyRef, raceRule));

        if (raceValue.isPresent()) {
            logger.log("raceValue is present");
            return logger.logReturn(raceValue);
        }
        var baseValue = getBaseProperty(person, propertyRef);
        if (baseValue.isPresent()) {
            logger.log("baseValue is present");
            return logger.logReturn(baseValue);
        }
        return logger.logReturn(Optional.empty());
    }

    public Optional<Integer> getProperty(final Person person, final String propertyRef) {
        var logger = logEnter("personId:", person.getId(), "propertyRef:", propertyRef);
        var value = computeProperty(person, propertyRef);
        if (value.isEmpty()) {
            return Optional.empty();
        }
        person.streamProperties().findFirst().ifPresent(properties -> {
            properties.addProperty(Property.builder()
                    .value(value.get())
                    .propertyRuleRef(propertyRef)
                    .build()
            );
        });
        return logger.logReturn(value);

    }

    public Consumer<WorldStepInstance> applyPropertyMutation(
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
        Stream<Consumer<WorldStepInstance>> returnList = typePropertyMutation.streamFrom()
                .map(from -> {
                    logger.log("participant:", from.getParticipant());
                    var person = switch (from.getParticipant()) {
                        case "self" -> originPerson;
                        default -> targetPerson;
                    };
                    logger.log("on personId:", from.getParticipant());
                    var newValueOptional = worldStepInstance.getPropertyInstance().computeOperation(
                            from.getOperation(),
                            person);
                    if (newValueOptional.isEmpty()) {
                        return worldStepInstance1 -> {};
                    }
                    var deltaValue = newValueOptional.get();

                    return outWorldStepInstance -> outWorldStepInstance
                            .getPersonRepository()
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

        return outWorldStepInstance -> returnList.forEach(o -> o.accept(outWorldStepInstance));
    }
}
