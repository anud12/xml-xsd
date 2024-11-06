package ro.anud.xml_xsd.implementation.service.person;

import ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classification.Classification;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Race.Race;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection.IType_personSelection;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Objects;


public class SelectionInstance {
    private WorldStepInstance worldStepInstance;

    public SelectionInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public boolean isSelectionApplicableTo(IType_personSelection<?> selectPerson, Person person) {

        return filterBasedOnProperties(selectPerson, person)
                && filterPersonListBasedOnClassification(selectPerson, person)
                && filterPersonListBasedOnRace(selectPerson, person);
    }

    private boolean filterBasedOnProperties(IType_personSelection<?> selectPerson, Person person) {
        var propertyInstance = worldStepInstance.getPropertyInstance();
        if (selectPerson.streamProperty().findAny().isEmpty()) {
            return true;
        }
        var ruleStream = selectPerson.streamProperty();
        var filteredRules = ruleStream.filter(propertyRule -> {
            var value = worldStepInstance.getPersonInstance().getProperty(person, propertyRule.getPropertyRuleRef());
            if (value.isEmpty()) {
                return false;
            }
            var minValue = propertyRule.streamMin()
                    .flatMap(min -> propertyInstance.computeOperation(min, person).stream())
                    .findFirst();
            if (minValue.isPresent()) {
                if (minValue.get() > value.get()) {
                    return false;
                }
            }

            var maxValue = propertyRule.streamMax()
                    .flatMap(max -> propertyInstance.computeOperation(max, person).stream())
                    .findFirst();
            if (maxValue.isPresent()) {
                if (value.get() > maxValue.get()) {
                    return false;
                }
            }
            return true;
        });
        return filteredRules.count() == selectPerson.streamProperty().count();
    }

    private boolean filterPersonListBasedOnClassification(
            final IType_personSelection<?> selectPerson,
            final Person person) {
        if (selectPerson.streamClassification().findAny().isEmpty()) {
            return true;
        }
        var personRef = person.streamClassifications()
                .flatMap(Classifications::streamClassification)
                .map(Classification::getClassificationRuleRef)
                .toList();

        var filteredRules = selectPerson.streamClassification()
                .map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification::getClassificationRuleRef)
                .filter(ruleRef -> personRef.stream().anyMatch(string -> string.equals(ruleRef)));
        return filteredRules.count() == selectPerson.streamRace().count();
    }

    private boolean filterPersonListBasedOnRace(
            final IType_personSelection<?> selectPerson,
            final Person person) {
        if (selectPerson.streamRace().findAny().isEmpty()) {
            return true;
        }
        var personRaceRef = person.getRace().map(Race::getRaceRuleRef);
        if (personRaceRef.isEmpty()) {
            return false;
        }
        var filteredRules = selectPerson.streamRace()
                .map(ro.anud.xml_xsd.implementation.model.Type_personSelection.Race.Race::getRaceRuleRef)
                .filter(ref -> Objects.equals(ref, personRaceRef.get()));
        return filteredRules.count() == selectPerson.streamRace().count();
    }

}
