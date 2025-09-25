package ro.anud.xml_xsd.implementation.service.person.util;

import ro.anud.xml_xsd.implementation.model.Type_personSelection.Classification.Classification;
import ro.anud.xml_xsd.implementation.model.Type_personSelection.Property.Property;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection.IType_personSelection;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class CreatePerson {
    public static Mutation<Person> createPerson(
        WorldStepInstance worldStepInstance,
        IType_personSelection<?> typePersonSelection) {
        try (var logger = logScope()){
            logger.log("creating");
            var person = createNewPerson(worldStepInstance, typePersonSelection);

            logger.log("applyProperty");
            applyProperty(worldStepInstance, typePersonSelection, person);

            logger.log("applyClassifications");
            typePersonSelection.streamClassification().forEach(classification -> {
                applyClassification(worldStepInstance, classification, person);
            });
            return Mutation.of(outInstance -> {

                return outInstance.person.repository.getOrCreate(person);

            });
        }
    }

    private static void applyProperty(
        final WorldStepInstance worldStepInstance,
        final IType_personSelection<?> typePersonSelection,
        final Person person) {
        try (var logger = logScope()){
            typePersonSelection.streamProperty()
                    .forEach(property -> {
                        try (var innerLogger = logScope("personSelection", property.getPropertyRuleRef())) {
                            innerLogger.log("compute max");
                            var maxOptional = worldStepInstance.computeOperation(property.getMax(), person);
                            innerLogger.log("compute min");
                            var minOptional = worldStepInstance.computeOperation(property.getMin(), person);

                            if (minOptional.isEmpty() && maxOptional.isEmpty()) {
                                innerLogger.log("min and max are empty");
                                worldStepInstance.person.getProperty(person, property.getPropertyRuleRef());
                                return;
                            }
                            var min = minOptional.orElse(maxOptional.orElse(0));
                            var max = maxOptional.orElse(minOptional.orElse(0));
                            innerLogger.log("min:", min, "max:", max);
                            int value = worldStepInstance.randomBetweenInt(min, max);
                            innerLogger.log("setting value:", value);
                            person.getPropertiesOrDefault()
                                    .addProperty(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Property.Property()
                                            .setPropertyRuleRef(property.getPropertyRuleRef())
                                            .setValue(value));

                        }

                    });
            var propertyRuleRefList = typePersonSelection.streamProperty().map(Property::getPropertyRuleRef).toList();
            worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamPropertyRule)
                    .flatMap(PropertyRule::streamEntry)
                    .forEach(entry -> {
                        entry.getPersonDefault().ifPresent(personDefault -> {
                            try (var innerLogger = logScope()){
                                if (propertyRuleRefList.contains(entry.getId())) {
                                    innerLogger.log("already has", entry.getId());
                                    return;
                                }
                                worldStepInstance.computeOperation(personDefault, person)
                                        .ifPresent(integer -> {
                                            innerLogger.log("setting computed value", integer);
                                            person.getPropertiesOrDefault()
                                                    .addProperty(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Property.Property()
                                                            .setValue(integer)
                                                            .setPropertyRuleRef(entry.getId())
                                                    );
                                        });
                            }
                        });
                    });
        }

    }

    private static void applyClassification(
        final WorldStepInstance worldStepInstance,
        final Classification classification,
        final Person person) {
        try (var logger = logScope("classification:", classification.getClassificationRuleRef(), "person", person.getId())){
            var classificationRuleOptional = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamClassificationRule)
                    .flatMap(ClassificationRule::streamEntry)
                    .filter(entry -> entry.getId().equals(classification.getClassificationRuleRef()))
                    .findAny();
            if (classificationRuleOptional.isEmpty()) {
                logger.log("classificationRule not found");
                return;
            }
            var classificationRule = classificationRuleOptional.get();
            person.getClassificationsOrDefault().addClassification(new ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Classifications.Classification.Classification()
                    .setClassificationRuleRef(classificationRule.getId())
            );
            classificationRule.streamProperty()
                    .forEach(property -> {
                        try (var innerLogger = logScope("property", property.getPropertyRuleRef())){
                            var propertyRef = property.getPropertyRuleRef();
                            int classificationValue = worldStepInstance.computeOperation(property.getOperation(), person).orElse(0);
                            int propertyValue = worldStepInstance.person.getProperty(person, propertyRef).orElse(0);

                            innerLogger.logTodo("remove rawNode.getAttributeRequired(\"is\")");
                            var computedValue = switch (property.rawNode().getAttributeRequired("is")) {
                                case "lessThan": {
                                    innerLogger.log("lessThan");
                                    yield Math.min(classificationValue - 1, propertyValue);
                                }
                                case "lessThanOrEqual": {
                                    innerLogger.log("lessThanOrEqual");
                                    yield Math.min(classificationValue, propertyValue);
                                }
                                case "greaterThan": {
                                    innerLogger.log("greaterThan");
                                    yield Math.max(classificationValue + 1, propertyValue);
                                }
                                case "greaterThanOrEqual": {
                                    innerLogger.log("greaterThanOrEqual");
                                    yield Math.max(classificationValue, propertyValue);
                                }
                                case "equal": {
                                    innerLogger.log("equal");
                                    yield classificationValue;
                                }
                                default:
                                    throw new RuntimeException(
                                            "Unknown operation " + property.rawNode().getAttributeRequired("is")
                                    );
                            };
                            innerLogger.log("setting propertyRef", propertyRef, "to ", computedValue);
                            worldStepInstance.person.mutateProperty(person, propertyRef, (ignored) -> computedValue);
                        }
                    });
        }

    }

    private static Person createNewPerson(
        final WorldStepInstance worldStepInstance,
        final IType_personSelection<?> typePersonSelection) {
        var logger = logEnter();
        var person = new Person();

        person.setId(worldStepInstance.getNextId());

        logger.log("adding person with id", person.getId());
        logger.logTodo("remove people.addPerson(person)");
        return person;
    }
}
