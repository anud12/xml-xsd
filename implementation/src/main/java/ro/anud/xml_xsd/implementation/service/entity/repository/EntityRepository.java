package ro.anud.xml_xsd.implementation.service.entity.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.util.repository.NonNullableIndex;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.repository.NullableIndex;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class EntityRepository implements Repository<Entity> {
    final WorldStepInstance worldStepInstance;

    public final NullableIndex<String, Entity, Entity> byId = NullableIndex.ofNullable(Entity.class, Entity::getId);
    public final NullableIndex<String, Entity, Entity> byRuleRef = NullableIndex.ofNullableOptional(Entity.class, Entity::getEntityRuleRef);

    public EntityRepository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    @Override
    public void index() {
        try (var scope = logScope()) {
            var entityList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamData)
                    .flatMap(Data::streamEntities)
                    .flatMap(Entities::streamEntity)
                    .toList();
            byId.reIndex(entityList);
            byRuleRef.reIndex(entityList);
        }
    }

    @Override
    public void loadData() {
        byId.addListeners(worldStepInstance);
        byRuleRef.addListeners(worldStepInstance);
    }

    public Entity getOrDefault(Entity entity) {
        return byId.get(entity.getId()).orElseGet(() -> {
            var entityList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamDataOrDefault)
                    .flatMap(Data::streamEntitiesOrDefault)
                    .findFirst();
            var clonedEntity = Entity.fromRawNode(entity.serializeIntoRawNode());
            entityList.get().addEntity(clonedEntity);
            return clonedEntity;
        });
    }
}
