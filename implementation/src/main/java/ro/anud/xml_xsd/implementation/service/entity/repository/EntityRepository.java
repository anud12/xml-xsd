package ro.anud.xml_xsd.implementation.service.entity.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Index;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class EntityRepository implements Repository<Entity> {
    final WorldStepInstance worldStepInstance;

    public final Index<String, Entity> byId = Index.of(Entity.class, Entity::getId);
    public final Index<String, Entity> byRuleRef = Index.ofOptional(Entity.class, Entity::getEntityRuleRef);

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
            byId.index(entityList);
            byRuleRef.index(entityList);
        }
    }

    @Override
    public void loadData() {
        byId.addListeners(worldStepInstance);
        byRuleRef.addListeners(worldStepInstance);
    }

    @Override
    public Entity getOrDefault(Entity entity) {
        return byId.get(entity.getId()).orElse(Entity.of());
    }

}
