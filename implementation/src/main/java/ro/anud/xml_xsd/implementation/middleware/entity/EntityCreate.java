package ro.anud.xml_xsd.implementation.middleware.entity;

import ro.anud.xml_xsd.implementation.model.Type_entity.Type_entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions;
import ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Entity_create.Entity_create;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
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
    public Entity create(Entity_create action) {
        return Entity.builder()
                .entityRuleRef(Optional.ofNullable(action.getEntityRuleRef()))
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
