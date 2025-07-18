package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RegionRule.RegionRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RegionRuleRepository {
    private final WorldStepInstance worldStepInstance;

    private final HashMap<String, Entry> idEntry = new HashMap<>();
    public RegionRuleRepository(final WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public void index(final List<RuleGroup> ruleGroups) {
        idEntry.clear();
        ruleGroups.stream()
            .flatMap(RuleGroup::streamRegionRule)
            .flatMap(RegionRule::streamEntry)
            .forEach(entry -> idEntry.put(entry.getId(), entry));
    }

    public Optional<Entry> getById(final String regionRuleRef) {
        return Optional.ofNullable(idEntry.get(regionRuleRef));
    }
}
