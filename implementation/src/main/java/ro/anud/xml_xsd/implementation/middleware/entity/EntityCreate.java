package ro.anud.xml_xsd.implementation.middleware.entity;

import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Container;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.action.ActionCreate;

import java.util.Optional;
import java.util.stream.Stream;

public class EntityCreate implements ActionCreate<Entity, Entity_create, Entities> {
    @Override
    public Stream<Entity_create> getAction(Stream<WorldStep> worldStep) {
        return worldStep.flatMap(WorldStep::streamActions)
                .flatMap(Actions::streamEntity_create);
    }

    @Override
    public Entity create(WorldStepInstance worldStepInstance, Entity_create action) {
        var rule = worldStepInstance.ruleRepository.entityRule.byName.get(action.getEntityRuleRef()).get();
        return Entity.builder()
                .entityRuleRef(Optional.ofNullable(rule.getName()))
                .containers(rule.getContainers()
                        .map(containers -> Containers.builder()
                                .container(containers.streamContainer()
                                        .map(container -> Container.builder()
                                                .containerRuleRef(container.getContainerRuleRef())
                                                .build()
                                        )
                                        .toList())
                                .build())
                )
                .build();
    }

    @Override
    public Entities getParentNode(Stream<WorldStep> worldStep) {
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
