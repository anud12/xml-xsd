package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class AddClassificationsBasedOnProperty {

    public static Stream<Entry> addClassificationsBasedOnProperty(WorldStepInstance worldStepInstance, Person person) {
        try (var scope = logScope("personId", person.getId())){

            var ruleEntryList = worldStepInstance.ruleRepository
                    .streamAllClassificationRuleEntry()
                    .toList();

            if (ruleEntryList.isEmpty()) {
                scope.log("empty list returned");
            }

            return ruleEntryList.stream()
                    .filter(entry -> {
                        var result = entry.streamProperty().findAny().isPresent();
                        scope.log("filter entry:", entry.getId(), "result:", result);
                        return result;
                    })
                    .filter(entry -> {
                        try (var scope2 = logScope("entryId:", entry.getId())){
                            return entry.streamProperty()
                                    .reduce(true, (acc, property) -> {
                                        try (var propertyLogger = logScope("propertyRuleRef:", property.getPropertyRuleRef())){
                                            var propertyValue = worldStepInstance.person.getProperty(person, property.getPropertyRuleRef());
                                            if (propertyValue.isEmpty()) {
                                                propertyLogger.log("propertyValue is empty");
                                                return false;
                                            }
                                            var value = worldStepInstance.computeOperation(property.getOperation(), person);
                                            if (value.isEmpty()) {
                                                propertyLogger.log("value is empty");
                                                return false;
                                            }
                                            propertyLogger.logTodo("should add enum values to property 'is'");
                                            var isValue = property.rawNode().getAttribute("is").get();
                                            return switch (isValue) {
                                                case "lessThan": {
                                                    var result = (propertyValue.get() < value.get());
                                                    propertyLogger.log("'lessThan'",
                                                            result,
                                                            "propertyValue:",
                                                            propertyValue.get(),
                                                            "value",
                                                            value.get());
                                                    yield acc && result;
                                                }
                                                case "lessThanOrEqual": {
                                                    var result = (propertyValue.get() <= value.get());
                                                    propertyLogger.log("'lessThanOrEqual'",
                                                            result,
                                                            "propertyValue:",
                                                            propertyValue.get(),
                                                            "value",
                                                            value.get());
                                                    yield acc && result;
                                                }
                                                case "greaterThan": {
                                                    var result = (propertyValue.get() > value.get());
                                                    propertyLogger.log("'greaterThan'",
                                                            result,
                                                            "propertyValue:",
                                                            propertyValue.get(),
                                                            "value",
                                                            value.get());
                                                    yield acc && result;
                                                }
                                                case "greaterThanOrEqual": {
                                                    var result = (propertyValue.get() >= value.get());
                                                    propertyLogger.log("'greaterThanOrEqual'",
                                                            result,
                                                            "propertyValue:",
                                                            propertyValue.get(),
                                                            "value",
                                                            value.get());
                                                    yield acc && result;
                                                }
                                                case "equal": {
                                                    var result = (propertyValue.get().equals(value.get()));
                                                    propertyLogger.log("'equal'",
                                                            result,
                                                            "propertyValue:",
                                                            propertyValue.get(),
                                                            "value",
                                                            value.get());
                                                }
                                                default: {
                                                    throw new RuntimeException("Unknown operation " + isValue);
                                                }
                                            };
                                        }

                                    }, (aBoolean, aBoolean2) -> aBoolean && aBoolean2);
                        }

                    })
                    .toList()
                    .stream();
        }

    }
}
