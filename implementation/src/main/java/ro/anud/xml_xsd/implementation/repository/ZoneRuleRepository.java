package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ZoneRule.ZoneRule;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ZoneRuleRepository {
    private final WorldStepInstance worldStepInstance;
    public ZoneRuleRepository(final WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    private final HashMap<String, Entry> idHashMap = new HashMap<>();
    public void index(final List<RuleGroup> ruleGroups) {
        ruleGroups.stream()
            .flatMap(RuleGroup::streamZoneRule)
            .flatMap(ZoneRule::streamEntry)
            .forEach(entry -> {
                idHashMap.put(entry.getId(),entry);
            });
    }
    public Optional<Entry> getById(String id) {
        return Optional.ofNullable(idHashMap.get(id));
    }
}
