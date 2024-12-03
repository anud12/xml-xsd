package ro.anud.xml_xsd.implementation.service.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class ComputeOperation {


    public static Optional<Integer> computeOperation(
        WorldStepInstance worldStepInstance,
        IType_mathOperations<?> typeMathOperations,
        Person person) {
        var logger = logEnter();
        var rawNode = typeMathOperations.getRawNode();
        var initial = rawNode.getAttributeInt("initial").orElse(0);
        logger.log("initial:", initial);


        var value = Stream.concat(
                rawNode.getChildrenList("add_property").stream(),
                rawNode.getChildrenList("and").stream())
            .reduce(
                initial,
                (acc, rawNode1) -> createOperationFromQueryType(worldStepInstance, rawNode1, Optional.of(person)).apply(
                    acc),
                Integer::sum
            );
        return logger.logReturn(Optional.of(value));
    }

    public static Optional<Integer> computeOperation(
        WorldStepInstance worldStepInstance,
        IType_mathOperations<?> typeMathOperations
    ) {
        var logger = logEnter();
        var rawNode = typeMathOperations.getRawNode();
        var initial = rawNode.getAttributeInt("initial").orElse(0);
        logger.log("initial:", initial);


        var value = Stream.concat(
                rawNode.getChildrenList("add_property").stream(),
                rawNode.getChildrenList("and").stream())
            .reduce(
                initial,
                (acc, rawNode1) -> createOperationFromQueryType(worldStepInstance, rawNode1, Optional.empty()).apply(
                    acc),
                Integer::sum
            );

        return logger.logReturn(Optional.of(value));
    }

    private static Function<Integer, Integer> createOperationFromQueryType(
        WorldStepInstance worldStepInstance,
        RawNode rawNode,
        Optional<Person> person) {
        var logger = logEnter();
        switch (rawNode.getTag()) {
            case "add_property": {
                if (person.isEmpty()) {
                    throw new RuntimeException("empty person");
                }
                var innerLogger = logger.log("add_property");
                var propertyRef = rawNode.getAttribute("property_rule_ref")
                    .orElseThrow(() -> new RuntimeException("property_rule_ref is undefined"));
                var newValue = worldStepInstance.person.getProperty(person.get(), propertyRef).orElseThrow();
                innerLogger.log("propertyRef:", propertyRef, "newValue:", newValue);
                return integer -> innerLogger.logReturn(integer + newValue);
            }
            case "and": {
                switch (rawNode.getAttribute("do").get()) {
                    case "add": {
                        var innerLogger = logger.log("add");
                        var value = rawNode.getAttributeIntRequired("value");
                        innerLogger.log("value:", value);
                        return integer -> innerLogger.logReturn(integer + value);
                    }
                    case "add_dice": {
                        var innerLogger = logger.log("add_dice");
                        int value = (int) (worldStepInstance.random() * rawNode.getAttributeIntRequired("value"));
                        innerLogger.log("value:", value);
                        return integer -> innerLogger.logReturn(integer + value);
                    }
                    case "multiply": {
                        var innerLogger = logger.log("multiply");
                        var value = rawNode.getAttributeIntRequired("value");
                        innerLogger.log("value:", value);
                        return integer -> innerLogger.logReturn(integer * value);
                    }
                    case "multiply_dice": {
                        var innerLogger = logger.log("multiply_dice");
                        int value = (int) (worldStepInstance.random() * rawNode.getAttributeIntRequired("value"));
                        innerLogger.log("value:", value);
                        return integer -> innerLogger.logReturn(integer * value);
                    }
                    case "divide": {
                        var innerLogger = logger.log("divide");
                        var value = rawNode.getAttributeIntRequired("value");
                        innerLogger.log("value:", value);
                        if (value == 0) {
                            return integer -> 0;
                        }
                        return integer -> innerLogger.logReturn(integer / value);
                    }
                    case "divide_dice": {
                        var innerLogger = logger.log("multiply_dice");
                        int value = (int) (worldStepInstance.random() * rawNode.getAttributeIntRequired("value"));
                        innerLogger.log("value:", value);
                        if (value == 0) {
                            return integer -> 0;
                        }
                        return integer -> innerLogger.logReturn(integer / value);
                    }

                    case "modulo": {
                        var innerLogger = logger.log("multiply");
                        var value = rawNode.getAttributeIntRequired("value");
                        innerLogger.log("value:", value);
                        return integer -> innerLogger.logReturn(integer % value);
                    }
                    case "modulo_dice": {
                        var innerLogger = logger.log("multiply_dice");
                        int value = (int) (worldStepInstance.random() * rawNode.getAttributeIntRequired("value"));
                        innerLogger.log("value:", value);
                        return integer -> innerLogger.logReturn(integer % value);
                    }
                    default:
                        throw new RuntimeException("unknown operation :" + rawNode.getAttribute("do"));
                }
            }
            default:
                throw new RuntimeException("unknown tag:" + rawNode.getTag());
        }
    }
}
