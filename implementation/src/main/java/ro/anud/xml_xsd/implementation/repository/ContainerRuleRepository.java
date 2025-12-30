package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.util.repository.NonNullableIndex;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.repository.NullableIndex;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ContainerRuleRepository implements Repository<Entry>  {
    final WorldStepInstance worldStepInstance;

    public final NullableIndex<String, Entry, Entry> byName = NullableIndex.ofNullable(Entry.class, Entry::getName);

    public ContainerRuleRepository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    @Override
    public void index() {

        try (var scope = logScope()) {
            var ruleList = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamContainerRule)
                    .flatMap(ContainerRule::streamEntry)
                    .toList();
            byName.reIndex(ruleList);
        }
    }

    @Override
    public void loadData() {
        byName.addListeners(worldStepInstance);
    }
}
