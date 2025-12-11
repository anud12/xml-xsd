package ro.anud.xml_xsd.implementation.service.entity;

import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.entity.repository.EntityRepository;
import ro.anud.xml_xsd.implementation.service.entity.repository.EntityRuleRepository;

public class EntityInstance {
    final WorldStepInstance worldStepInstance;
    public final EntityRuleRepository ruleRepository;
    public final EntityRepository repository;

    public EntityInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        this.ruleRepository = new EntityRuleRepository(worldStepInstance);
        this.repository = new EntityRepository(worldStepInstance);
    }

}
