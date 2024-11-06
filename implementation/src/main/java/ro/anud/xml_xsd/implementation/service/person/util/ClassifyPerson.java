package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classification.Classification;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classifications;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.service.person.util.AddClassificationsBasedOnProperty.addClassificationsBasedOnProperty;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class ClassifyPerson {


    public static Stream<String> getPersonClassifications(WorldStepInstance worldStepInstance, final Person person) {
        var logger = logEnter("personId", person);
        var computedClassificationList = addClassificationsBasedOnProperty(worldStepInstance, person)
            .map(Entry::getId);

        var emptyClassificationRules = worldStepInstance.ruleRepository.streamClassificationRuleEntryByNoProperties()
            .map(Entry::getId)
            .toList();

        var staticClassificationId = person.streamClassifications()
            .flatMap(Classifications::streamClassification)
            .map(Classification::getClassificationRuleRef)
            .filter(emptyClassificationRules::contains);

        BiConsumer<Person, String> setClassification = (person1, string) -> {
            person1.getClassificationsOrDefault().addClassification(Classification.builder()
                .classificationRuleRef(string)
                .build());
        };
        var outPerson = worldStepInstance.getOutInstance().person.repository.personById(person.getId());
        return logger.logReturn(Stream.concat(computedClassificationList, staticClassificationId)
            .peek(string -> {
                outPerson.ifPresent(out -> setClassification.accept(out, string));
                setClassification.accept(person, string);
            }));
    }
}
