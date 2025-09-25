package ro.anud.xml_xsd.implementation.service.name;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.NameRule.NameRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class Repository {

    private final HashMap<String, Entry> stringNameRuleHashMap = new HashMap<>();
    private final WorldStepInstance worldStepInstance;
    public Repository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public void index() {
        try (var scope = logScope()){
            worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamRuleGroup)
                    .flatMap(RuleGroup::streamNameRule)
                    .flatMap(NameRule::streamEntry)
                    .forEach(nameRule -> stringNameRuleHashMap.put(nameRule.getId(), nameRule));
        }
    }

    public Optional<Entry> getNameTokenById(String id) {
        return Optional.ofNullable(stringNameRuleHashMap.get(id));
    }
}
