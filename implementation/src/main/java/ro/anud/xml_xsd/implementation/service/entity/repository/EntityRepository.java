package ro.anud.xml_xsd.implementation.service.entity.repository;

import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Container;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers;
import ro.anud.xml_xsd.implementation.model.Type_entity.Type_entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_entity.IType_entity;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.container.ContainerRepository;
import ro.anud.xml_xsd.implementation.util.repository.NullableIndex;

import java.util.*;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.javascriptContext.api.entity.ContainerQueryJSApi.EMPTY;
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



    public Stream<Entity> queryInEntity(Optional<Entity> parentEntity, EntityQuery entityQuery) {
        try (var scope = logScope()) {
            if(parentEntity.isEmpty()) {
                return Stream.empty();
            }
            var baseStream = parentEntity.get().streamContainers()
                    .flatMap(Containers::streamContainer)
                    .filter(container -> entityQuery.getContainer().stream()
                            .filter(containerQuery -> !ContainerRepository.filterContainer(containerQuery.apply(EMPTY), container))
                            .findFirst()
                            .isEmpty()
                    )
                    .flatMap(Container::streamEntities)
                    .flatMap(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Entities.Entities::streamEntity)
                    .flatMap(entity -> byId.get(entity.getEntityIdRef()).stream());

            if (entityQuery == null || (entityQuery.getIdList().isEmpty()
                    && entityQuery.getRuleIdList().isEmpty()
                    && entityQuery.getContainer().isEmpty())
            ) {
                var all = baseStream.toList();
                scope.log("query returned {} entities", all.size());
                return baseStream;
            }

            return baseStream.filter(entity -> filterEntity(entityQuery, entity));
        }
    }

    public static boolean filterEntity(EntityQuery entityQuery, Entity entity) {
        try (var scope = logScope(entity.getId())){
            List<String> ids = entityQuery.getIdList();
            List<String> ruleIds = entityQuery.getRuleIdList();
            if (!ids.isEmpty()) {
                if (!ids.contains(entity.getId())) {
                    return false;
                }
            }
            if (!ruleIds.isEmpty()) {
                if (!entity.getEntityRuleRef().isEmpty()) {
                    if (!ruleIds.contains(entity.getEntityRuleRef().get())) {
                        return false;
                    }
                }
            }
            return true;

        }
    }

    public Entity getOrDefault(Type_entity entity) {
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
