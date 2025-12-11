package ro.anud.xml_xsd.implementation.middleware.container;

import lombok.Setter;
import ro.anud.xml_xsd.implementation.middleware.entity.EntityCreate;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Container;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.action.Action;
import ro.anud.xml_xsd.implementation.service.action.ActionCreate;
import ro.anud.xml_xsd.implementation.util.logging.LogScope;

import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@Setter
public class ContainerCreate implements ActionCreate<Container, Container_addOnEntity, Entity> {
    private EntityCreate entityCreate;


    @Override
    public void assignDependencies(Set<Action> middlewareSet) {
        middlewareSet.stream().filter(action -> action instanceof EntityCreate).findAny()
                .ifPresent(action -> entityCreate = (EntityCreate) action);
    }

    @Override
    public Stream<Container_addOnEntity> getAction(Stream<WorldStep> worldStep) {
        return worldStep.flatMap(WorldStep::streamActions)
                .flatMap(Actions::streamContainer_addOnEntity);
    }

    @Override
    public Container create(WorldStepInstance worldStepInstance, Container_addOnEntity action) {
        try (var scope = logScope()) {
            var rule = worldStepInstance.ruleRepository.containerRule.byName.get(action.getContainerRuleRef()).get();
            Optional<Entities> entities = Optional.of(
                    rule.streamAllowedEntity()
                            .flatMap(allowedEntity -> allowedEntity.getMin()
                                    .flatMap(typeMathOperations -> worldStepInstance.computeOperation(typeMathOperations))
                                    .stream()
                                    .flatMap(integer -> {
                                        try (var inner = logScope("creating "+ integer + "  child entities")) {
                                            return IntStream.range(0, integer)
                                                    .mapToObj(i -> entityCreate.applyAction(worldStepInstance, Entity_create.builder()
                                                                    .entityRuleRef(allowedEntity.getEntityRuleRef())
                                                                    .build())
                                                            .getId()
                                                    )
                                                    .map(id -> ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Entities.Entity.Entity.builder()
                                                            .entityIdRef(id)
                                                            .build()
                                                    );
                                        }
                                    })
                                )
                            .toList()
                )
                .flatMap(list -> switch (list.size()) {
                                            case 0 -> Optional.empty();
                                            default -> Optional.of(Entities.builder()
                                                    .entity(list)
                                                    .build());
                                        });
                                        return Container.builder()
                                                .containerRuleRef(action.getContainerRuleRef())
                                                .id(worldStepInstance.getNextId())
                                                .entities(entities)
                                                .build();
                                    }
        }

        @Override
        public Entity getParentNode (Stream < WorldStep > worldStep, Container_addOnEntity containerAddOnEntity){
            return worldStep.flatMap(WorldStep::streamData)
                    .flatMap(Data::streamEntities)
                    .flatMap(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities::streamEntity)
                    .filter(entity -> entity.getId().equals(containerAddOnEntity.getEntityId()))
                    .findFirst()
                    .get();
        }

        @Override
        public void append (Entity entity, Container container){
            entity.streamContainersOrDefault().findFirst().ifPresent(containers -> containers.addContainer(container));
        }
    }
