package ro.anud.xml_xsd.implementation.service.person;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classification.Classification;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection.IType_personSelection;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;


public class SelectionInstance {
    private WorldStepInstance worldStepInstance;

    public SelectionInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }
    public SelectionInstance index() {
        return this;
    }

    public boolean isSelectionApplicableTo(IType_personSelection<?> selectPerson, Person person) {
        var logger = logEnter("personId", person.getId());
        return logger.logReturn(filterBasedOnProperties(selectPerson, person)
            && filterPersonListBasedOnClassification(selectPerson, person));
    }

    private boolean filterBasedOnProperties(IType_personSelection<?> selectPerson, Person person) {
        var logger = logEnter("personId", person.getId());
        if (selectPerson.streamProperty().findAny().isEmpty()) {
            logger.log("empty list");
            return logger.logReturn(true);
        }
        var ruleStream = selectPerson.streamProperty();
        var filteredRules = ruleStream.filter(propertyRule -> {
            var value = worldStepInstance.person.getProperty(person, propertyRule.getPropertyRuleRef());
            if (value.isEmpty()) {
                return false;
            }
            var minValue = propertyRule.streamMin()
                .flatMap(min -> worldStepInstance.computeOperation(min, person).stream())
                .findFirst();
            if (minValue.isPresent()) {
                if (minValue.get() > value.get()) {
                    return false;
                }
            }

            var maxValue = propertyRule.streamMax()
                .flatMap(max -> worldStepInstance.computeOperation(max, person).stream())
                .findFirst();
            if (maxValue.isPresent()) {
                if (value.get() > maxValue.get()) {
                    return false;
                }
            }
            return true;
        });
        return logger.logReturn(filteredRules.count() == selectPerson.streamProperty().count());
    }

    private boolean filterPersonListBasedOnClassification(
        final IType_personSelection<?> selectPerson,
        final Person person) {
        var logger = logEnter("personId", person.getId());
        var ruleList = selectPerson.streamClassification().toList();
        if (ruleList.isEmpty()) {
            logger.log("empty list");
            return logger.logReturn(true);
        }
        var personRef = person.streamClassifications()
            .flatMap(Classifications::streamClassification)
            .map(Classification::getClassificationRuleRef)
            .toList();

        var filteredRules = ruleList.stream()
            .map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification::getClassificationRuleRef)
            .filter(ruleRef -> personRef.stream().anyMatch(string -> string.equals(ruleRef)));
        return logger.logReturn(filteredRules.count() == ruleList.size());
    }


    public List<Mutation<Person>> selectPersonOrCreate(final IType_personSelection<?> selectPerson) {
        var logger = logEnter();
        var filteredPersonList = worldStepInstance.person.repository.streamPerson()
            .filter(person -> isSelectionApplicableTo(selectPerson, person))
            .map(person -> Mutation.of(person))
            .collect(Collectors.toCollection(ArrayList::new));
        logger.log("filteredPersonList count", filteredPersonList.size());
        int min = selectPerson.getMin().flatMap(worldStepInstance::computeOperation).orElse(0);
        logger.log("min", min);
        while (filteredPersonList.size() < min) {
            filteredPersonList.add(worldStepInstance.person.createPerson(selectPerson));
        }
        var max = selectPerson.getMax().flatMap(worldStepInstance::computeOperation)
            .orElse(filteredPersonList.size());
        return logger.logReturn(filteredPersonList.subList(0, max));
    }

}
