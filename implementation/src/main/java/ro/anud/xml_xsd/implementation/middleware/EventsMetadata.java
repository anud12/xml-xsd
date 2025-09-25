package ro.anud.xml_xsd.implementation.middleware;

import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.Entry.Then.Then;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EventsRule.EventsRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class EventsMetadata {

    public static void apply(WorldStepInstance worldStepInstance) {
        try(var scope = logScope()) {
            var entryList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamEventsRule)
                    .flatMap(EventsRule::streamEntry)
                    .toList();

            entryList.forEach(entry -> {
                applyFromPersonActionUsed(worldStepInstance, entry);
            });
        }

    }

    private static void applyFromPersonActionUsed(final WorldStepInstance worldStepInstance, final Entry entry) {
        try (var scope = logScope("entry", entry.buildPath())){
            var byList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamActions)
                    .flatMap(Actions::streamBy)
                    .filter(by -> by.getDoElement()
                            .getActionRuleRef()
                            .map(ref -> entry.streamWhen()
                                    .anyMatch(typeTrigger -> typeTrigger.getPersonActionUsed()
                                            .getActionRuleRef()
                                            .equals(ref))
                            )
                            .orElse(false));

            byList.forEach(by -> {
                entry.streamThen()
                        .forEach(then -> {
                            then.streamSelectPerson()
                                    .forEach(selectPerson -> {
                                        scope.logTodo("selectPerson", selectPerson.buildPath());
                                        var targetElement = worldStepInstance.person.selection.selectPersonOrCreate(selectPerson);
                                        targetElement.forEach(person -> {
                                            applyPropertyMutationToPerson(worldStepInstance, then, person.apply(worldStepInstance));
                                        });
                                    });

                        });
            });
        }

    }

    private static void applyPropertyMutationToPerson(
        final WorldStepInstance worldStepInstance,
        final Then then,
        final Person person) {
        try (var scope = logScope("then", then.buildPath(), "person", person.getId())){
            then.streamPropertyMutation()
                    .forEach(propertyMutation -> {
                        worldStepInstance.person.mutateProperty(
                                person, propertyMutation.getPropertyRuleRef(), (value) -> {
                                    var newValueOptional = worldStepInstance.computeOperation(propertyMutation, person);
                                    var deltaValue = newValueOptional
                                            .map(integer -> integer + value.orElse(0))
                                            .orElse(value.orElse(0));
                                    scope.log("deltaValue", deltaValue);
                                    return deltaValue;
                                });
                    });
        }
    }
}
