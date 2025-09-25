package ro.anud.xml_xsd.implementation.service.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ComputeOperation {


    public static Optional<Integer> computeOperation(
        WorldStepInstance worldStepInstance,
        IType_mathOperations<?> typeMathOperations,
        Person person) {
        try (var scope = logScope()){
            var rawNode = typeMathOperations.rawNode();
            var initial = rawNode.getAttributeInt("initial").orElse(0);
            scope.log("initial:", initial);


            var value = Stream.concat(
                            rawNode.getChildrenList("add_property").stream(),
                            rawNode.getChildrenList("and").stream())
                    .reduce(
                            initial,
                            (acc, rawNode1) -> createOperationFromQueryType(worldStepInstance, rawNode1, Optional.of(person)).apply(
                                    acc),
                            Integer::sum
                    );
            return scope.logReturn(Optional.of(value));
        }

    }

    public static Optional<Integer> computeOperation(
        WorldStepInstance worldStepInstance,
        IType_mathOperations<?> typeMathOperations
    ) {
        try (var scope = logScope()){
            var rawNode = typeMathOperations.rawNode();
            var initial = rawNode.getAttributeInt("initial").orElse(0);
            scope.log("initial:", initial);


            var value = Stream.concat(
                            rawNode.getChildrenList("add_property").stream(),
                            rawNode.getChildrenList("and").stream())
                    .reduce(
                            initial,
                            (acc, rawNode1) -> createOperationFromQueryType(worldStepInstance, rawNode1, Optional.empty()).apply(
                                    acc),
                            Integer::sum
                    );

            return scope.logReturn(Optional.of(value));
        }
    }

    private static Function<Integer, Integer> createOperationFromQueryType(
        WorldStepInstance worldStepInstance,
        RawNode rawNode,
        Optional<Person> person) {
        try (var scope = logScope()){
            switch (rawNode.getTag()) {
                case "add_property": {
                    try (var innerScope = logScope("add_property")){
                        if (person.isEmpty()) {
                            throw new RuntimeException("empty person");
                        }
                        var propertyRef = rawNode.getAttribute("property_rule_ref")
                                .orElseThrow(() -> new RuntimeException("property_rule_ref is undefined"));
                        var newValue = worldStepInstance.person.getProperty(person.get(), propertyRef).orElseThrow();
                        innerScope.log("propertyRef:", propertyRef, "newValue:", newValue);
                        return integer -> innerScope.logReturn(integer + newValue);
                    }
                }
                case "and": {
                    switch (rawNode.getAttribute("do").get()) {
                        case "add": {
                            try (var innerScope = logScope("add")){
                                var value = rawNode.getAttributeIntRequired("value");
                                innerScope.log("value:", value);
                                return integer -> innerScope.logReturn(integer + value);
                            }

                        }
                        case "add_dice": {
                            try (var innerScope = logScope("add_dice")){
                                int value = (int) (worldStepInstance.random() * rawNode.getAttributeIntRequired("value"));
                                innerScope.log("value:", value);
                                return integer -> innerScope.logReturn(integer + value);
                            }
                        }
                        case "multiply": {
                            try (var innerScope = logScope("multiply")){
                                var value = rawNode.getAttributeIntRequired("value");
                                innerScope.log("value:", value);
                                return integer -> innerScope.logReturn(integer * value);
                            }
                        }
                        case "multiply_dice": {
                            try (var innerScope = logScope("multiply_dice")){
                                int value = (int) (worldStepInstance.random() * rawNode.getAttributeIntRequired("value"));
                                innerScope.log("value:", value);
                                return integer -> innerScope.logReturn(integer * value);

                            }
                        }
                        case "divide": {
                            try (var innerScope = logScope("divide")){
                                var value = rawNode.getAttributeIntRequired("value");
                                innerScope.log("value:", value);
                                if (value == 0) {
                                    return integer -> 0;
                                }
                                return integer -> innerScope.logReturn(integer / value);
                            }
                        }
                        case "divide_dice": {
                            try (var innerScope = logScope("divide_dice")){
                                int value = (int) (worldStepInstance.random() * rawNode.getAttributeIntRequired("value"));
                                innerScope.log("value:", value);
                                if (value == 0) {
                                    return integer -> 0;
                                }
                                return integer -> innerScope.logReturn(integer / value);
                            }
                        }

                        case "modulo": {
                            try (var innerScope = logScope("modulo")){
                                var value = rawNode.getAttributeIntRequired("value");
                                innerScope.log("value:", value);
                                return integer -> innerScope.logReturn(integer % value);
                            }
                        }
                        case "modulo_dice": {
                            try (var innerScope = logScope("modulo_dice")){
                                int value = (int) (worldStepInstance.random() * rawNode.getAttributeIntRequired("value"));
                                innerScope.log("value:", value);
                                return integer -> innerScope.logReturn(integer % value);
                            }
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
}
