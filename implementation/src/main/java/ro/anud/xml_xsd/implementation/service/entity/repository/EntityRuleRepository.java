package ro.anud.xml_xsd.implementation.service.entity.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.EntityRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.EntityRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Index;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class EntityRuleRepository implements Repository<Entry> {
    final WorldStepInstance worldStepInstance;

    public final Index<String, Entry> byName = Index.of(Entry.class, Entry::getName);

    public EntityRuleRepository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    @Override
    public void index() {
        try (var scope = logScope()) {
            var ruleList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamEntityRule)
                    .flatMap(EntityRule::streamEntry)
                    .toList();
            byName.index(ruleList);
        }
    }

    @Override
    public void loadData() {
        byName.addListeners(worldStepInstance);
    }

    @Override
    public Entry getOrDefault(Entry entry) {
        return entry.of();
    }
}
