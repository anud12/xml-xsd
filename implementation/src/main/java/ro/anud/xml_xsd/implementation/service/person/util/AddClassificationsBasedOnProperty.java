package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class AddClassificationsBasedOnProperty {

    public static Stream<Entry> addClassificationsBasedOnProperty(WorldStepInstance worldStepInstance, Person person) {
        var logger = logEnter("personId", person.getId());

        var ruleEntryList = worldStepInstance.ruleRepository
            .streamAllClassificationRuleEntry()
            .toList();

        if (ruleEntryList.isEmpty()) {
            logger.log("empty list returned");
        }

        return ruleEntryList.stream()
            .filter(entry -> {
                var result = entry.streamProperty().findAny().isPresent();
                logger.log("filter entry:", entry.getId(), "result:", result);
                return result;
            })
            .filter(entry -> {
                var entryLogger = logger.logEnter("entryId:", entry.getId());
                return entry.streamProperty()
                    .reduce(true, (acc, property) -> {
                        var propertyLogger = entryLogger.logEnter("propertyRuleRef:", property.getPropertyRuleRef());
                        var propertyValue = worldStepInstance.person.getProperty(person, property.getPropertyRuleRef());
                        if (propertyValue.isEmpty()) {
                            propertyLogger.logReturnVoid("propertyValue is empty");
                            return false;
                        }
                        var value = worldStepInstance.computeOperation(property.getOperation(), person);
                        if (value.isEmpty()) {
                            propertyLogger.logReturnVoid("value is empty");
                            return false;
                        }
                        logger.logTodo("should add enum values to property 'is'");
                        var isValue = property.getRawNode().getAttribute("is").get();
                        return switch (isValue) {
                            case "lessThan": {
                                var result = (propertyValue.get() < value.get());
                                propertyLogger.log("'lessThan'").log(
                                    result,
                                    "propertyValue:",
                                    propertyValue.get(),
                                    "value",
                                    value.get());
                                yield acc && result;
                            }
                            case "lessThanOrEqual": {
                                var result = (propertyValue.get() <= value.get());
                                propertyLogger.log("'lessThanOrEqual'").log(
                                    result,
                                    "propertyValue:",
                                    propertyValue.get(),
                                    "value",
                                    value.get());
                                yield acc && result;
                            }
                            case "greaterThan": {
                                var result = (propertyValue.get() > value.get());
                                propertyLogger.log("'greaterThan'").log(
                                    result,
                                    "propertyValue:",
                                    propertyValue.get(),
                                    "value",
                                    value.get());
                                yield acc && result;
                            }
                            case "greaterThanOrEqual": {
                                var result = (propertyValue.get() >= value.get());
                                propertyLogger.log("'greaterThanOrEqual'").log(
                                    result,
                                    "propertyValue:",
                                    propertyValue.get(),
                                    "value",
                                    value.get());
                                yield acc && result;
                            }
                            case "equal": {
                                var result = (propertyValue.get().equals(value.get()));
                                propertyLogger.log("'equal'").log(
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
                    }, (aBoolean, aBoolean2) -> aBoolean && aBoolean2);
            });
    }
}
