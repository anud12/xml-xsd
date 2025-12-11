package ro.anud.xml_xsd.implementation.service.util;

import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Container;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers;
import ro.anud.xml_xsd.implementation.model.Type_mathOperations.Type_mathOperations;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ComputeOperation {


    public static Optional<Integer> computeOperation(WorldStepInstance worldStepInstance, IType_mathOperations<?> typeMathOperations, Person person) {
        return computeOperation(worldStepInstance,typeMathOperations.rawNode(), Optional.of(person), Optional.empty());
    }
    public static Optional<Integer> computeOperation(WorldStepInstance worldStepInstance, Type_mathOperations typeMathOperations, Person person) {
        return computeOperation(worldStepInstance,typeMathOperations.rawNode(), Optional.of(person), Optional.empty());
    }

    public static Optional<Integer> computeOperation(WorldStepInstance worldStepInstance, IType_mathOperations<?> typeMathOperations, Entity entity) {
        return computeOperation(worldStepInstance,typeMathOperations.rawNode(), Optional.empty(), Optional.of(entity));
    }

    public static Optional<Integer> computeOperation(WorldStepInstance worldStepInstance, Type_mathOperations typeMathOperations, Entity entity) {
        return computeOperation(worldStepInstance,typeMathOperations.rawNode(), Optional.empty(), Optional.of(entity));
    }

    public static Optional<Integer> computeOperation(WorldStepInstance worldStepInstance, Type_mathOperations typeMathOperations) {
        return computeOperation(worldStepInstance,typeMathOperations.rawNode(), Optional.empty(), Optional.empty());
    }

    public static Optional<Integer> computeOperation(WorldStepInstance worldStepInstance, IType_mathOperations<?> typeMathOperations) {
        return computeOperation(worldStepInstance,typeMathOperations.rawNode(), Optional.empty(), Optional.empty());
    }

    private static  Optional<Integer> computeOperation(WorldStepInstance worldStepInstance, RawNode rawNode, Optional<Person> person, Optional<Entity> entity) {

        try (var scope = logScope()) {
            var initial = rawNode.getAttributeInt("initial").orElse(0);
            scope.log("initial:", initial);


            var value = Stream.of(
                            rawNode.getChildrenList("add_property").stream(),
                            rawNode.getChildrenList("count_entity").stream(),
                            rawNode.getChildrenList("and").stream())
                    .flatMap(Function.identity())
                    .reduce(
                            initial,
                            (acc, rawNode1) -> createOperationFromQueryType(worldStepInstance, rawNode1, person, entity).apply(
                                    acc),
                            Integer::sum
                    );

            return scope.logReturn(Optional.of(value));
        }
    }

    record CountEntity(
            String entityRuleRef,
            Optional<InContainerElement> inContainer
    ){
        public static CountEntity of(RawNode rawNode) {
            return new CountEntity(
                    rawNode.getAttributeRequired("entity_rule_ref"),
                    rawNode.getChildrenFirst("in_container")
                            .map(InContainerElement::of)
            );
        }
    }

    record InContainerElement(
            String containerRuleRef
    ){
        public static InContainerElement of(RawNode rawNode) {
            return new InContainerElement(rawNode.getAttributeRequired("container_rule_ref"));
        }
    }
    private static Integer countEntities(WorldStepInstance worldStepInstance, Entity entity, CountEntity countEntity) {
        var containerRuleRefOptional = countEntity.inContainer.map(InContainerElement::containerRuleRef);
        if(containerRuleRefOptional.isEmpty()){
            return 0;
        }
        var containerRuleRef = containerRuleRefOptional.get();

        var count = entity.streamContainers()
                .flatMap(Containers::streamContainer)
                .filter(container -> container.getContainerRuleRef().equals(containerRuleRef))
                .flatMap(Container::streamEntities)
                .flatMap(Entities::streamEntity)
                .filter(childEntity -> worldStepInstance.entity.repository.byId.get(childEntity.getEntityIdRef())
                        .flatMap(Entity::getEntityRuleRef)
                        .map(entityRule -> entityRule.equals(countEntity.entityRuleRef))
                        .orElse(false)
                )
                .count();
        return Math.toIntExact(count);
    }

    private static Function<Integer, Integer> createOperationFromQueryType(
        WorldStepInstance worldStepInstance,
        RawNode rawNode,
        Optional<Person> person,
        Optional<Entity> entity) {
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
                case "count_entity": {
                    try (var innerScope = logScope("count_entity")) {
                        if (entity.isEmpty()) {
                            throw new RuntimeException("empty entity");
                        }
                        return integer -> innerScope.logReturn(integer + countEntities(worldStepInstance, entity.get(), CountEntity.of(rawNode)));
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
