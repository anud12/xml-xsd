package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PortalRule.PortalRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class PortalRepository {
    private final WorldStepInstance worldStepInstance;

    private HashMap<String, Entry> entryById = new HashMap<>();
    public PortalRepository(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
        }

    }

    public void index() {
        try (var scope = logScope()) {
            entryById.clear();
            worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamRuleGroup)
                .flatMap(RuleGroup::streamPortalRule)
                .flatMap(PortalRule::streamEntry)
                .forEach(entry -> entryById.put(entry.getId(), entry));
        }
    }

    public Optional<Entry> getById(final String id) {
        try (var scope = logScope(id)) {
            if (id == null || id.isBlank()) {
                return scope.logReturn(Optional.empty());
            }
            return scope.logReturn(Optional.ofNullable(entryById.get(id)));
        }
    }
}
