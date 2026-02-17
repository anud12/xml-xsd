package ro.anud.xml_xsd.implementation.service.entity;

import ro.anud.xml_xsd.implementation.javascriptContext.operations.mutation.TextMutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.entity.repository.EntityRepository;
import ro.anud.xml_xsd.implementation.service.entity.repository.EntityRuleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityInstance {
    final WorldStepInstance worldStepInstance;
    public final EntityRuleRepository ruleRepository;
    public final EntityRepository repository;
    public final EntityTextMutations textMutations;

    private final Map<String, Map<String, List<TextMutation>>> entityIdToPropertyNameToTextMutationMap = new HashMap<>();

    public EntityInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        this.ruleRepository = new EntityRuleRepository(worldStepInstance);
        this.repository = new EntityRepository(worldStepInstance);
        textMutations = new EntityTextMutations(worldStepInstance);
    }

}
