package ro.anud.xml_xsd.implementation.service.entity;

import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.entity.repository.EntityRuleRepository;

public class EntityInstance {
    final WorldStepInstance worldStepInstance;
    public final EntityRuleRepository repository;

    public EntityInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        this.repository = new EntityRuleRepository(worldStepInstance);
    }

}
