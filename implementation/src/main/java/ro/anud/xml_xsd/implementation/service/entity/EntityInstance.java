package ro.anud.xml_xsd.implementation.service.entity;

import ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.entity.repository.EntityRepository;
import ro.anud.xml_xsd.implementation.service.entity.repository.EntityRuleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class EntityInstance {
    final WorldStepInstance worldStepInstance;
    public final EntityRuleRepository ruleRepository;
    public final EntityRepository repository;

    private List<String> modifiedEntitiesById = new ArrayList<>();

    public EntityInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        this.ruleRepository = new EntityRuleRepository(worldStepInstance);
        this.repository = new EntityRepository(worldStepInstance);
    }
}
