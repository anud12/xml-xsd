package ro.anud.xml_xsd.implementation.middleware.entity;

import lombok.Setter;
import ro.anud.xml_xsd.implementation.middleware.container.ContainerCreate;
import ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.Text.Text;
import ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity.Container_addOnEntity;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.Entry.Containers.Containers;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.action.Action;
import ro.anud.xml_xsd.implementation.service.action.ActionCreate;
import ro.anud.xml_xsd.implementation.util.logging.LogScope;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@Setter
public class EntityCreate implements ActionCreate<Entity, Entity_create, Entities> {

    private ContainerCreate containerCreate;

    @Override
    public void assignDependencies(Set<Action> middlewareSet) {
        middlewareSet.stream().filter(action -> action instanceof ContainerCreate).findAny()
                .ifPresent(action -> containerCreate = (ContainerCreate) action);
    }

    @Override
    public Stream<Entity_create> getAction(Stream<WorldStep> worldStep) {
        return worldStep.flatMap(WorldStep::streamActions)
                .flatMap(Actions::streamEntity_create);
    }

    @Override
    public Entity create(WorldStepInstance worldStepInstance, Entity_create action) {
        try (var scope = LogScope.logScope()) {
            var rule = worldStepInstance.ruleRepository.entityRule.byName.get(action.getEntityRuleRef()).get();
            var id = worldStepInstance.getNextId();

            var containers = Optional.of(
                    rule.streamContainers()
                            .flatMap(Containers::streamContainer)
                            .map(container -> containerCreate.create(worldStepInstance, Container_addOnEntity.builder()
                                    .entityId(id)
                                    .containerRuleRef(container.getContainerRuleRef())
                                    .build()))
                            .toList()
            ).flatMap(list -> switch (list.size()) {
                case 0 -> Optional.empty();
                default -> Optional.of(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers.builder()
                        .container(list)
                        .build());
            });
            var textMap = rule.getTextMap()
                    .map(strings1 -> TextMap.builder()
                            .text(strings1.streamText().map(string -> Text.builder()
                                            .name(string.getName())
                                            .value(string.getValue())
                                            .build()
                                    )
                                    .toList())
                            .build()
                    );
            return Entity.builder()
                    .id(id)
                    .entityRuleRef(Optional.ofNullable(rule.getName()))
                    .textMap(textMap)
                    .containers(containers)
                    .build();
        }

    }

    @Override
    public Entities getParentNode(Stream<WorldStep> worldStep, Entity_create entityCreate) {
        return worldStep.flatMap(WorldStep::streamDataOrDefault)
                .flatMap(Data::streamEntitiesOrDefault)
                .findFirst()
                .get();
    }

    @Override
    public void append(Entities entities, Entity typeEntity) {
        entities.addEntity(typeEntity);
    }

}
