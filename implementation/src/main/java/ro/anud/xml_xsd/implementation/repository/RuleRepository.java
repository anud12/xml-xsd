package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.service.PropertyInstance;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.LocalLogger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

public class RuleRepository {


    private HashMap<String, FromPerson> fromPersonHashMapById = new HashMap<>();
    private HashMap<String, Entry> propertyRuleHashMap = new HashMap<>();
    private PropertyInstance propertyInstance;

    public RuleRepository(WorldStepInstance worldStepInstance) {
        logEnter();
        this.propertyInstance = new PropertyInstance(worldStepInstance);
        var worldStep = worldStepInstance.getWorldStep();
        var ruleGroups = worldStep.getRuleGroup();

        var actionRule = ruleGroups.stream()
                .map(RuleGroup::getActionRule)
                .flatMap(Optional::stream)
                .toList();

        logEnter("Extracting fromPerson");
        actionRule
                .stream()
                .map(ActionRule::getFromPerson)
                .flatMap(Collection::stream)
                .forEach(fromPeople -> fromPersonHashMapById.put(fromPeople.getId(), fromPeople));

        logEnter("Extracting propertyRule");
        ruleGroups.stream()
                .map(RuleGroup::getPropertyRule)
                .flatMap(Optional::stream)
                .map(PropertyRule::getEntry)
                .flatMap(Collection::stream)
                .forEach(entry -> propertyRuleHashMap.put(entry.getId(), entry));
    }

    public Optional<FromPerson> fromPersonById(String id) {
        logEnter("id:", id);
        return LocalLogger.logReturn(Optional.ofNullable(fromPersonHashMapById.get(id)), "id:", id);
    }

    public Optional<Entry> getPropertyById(String id) {
        logEnter("id:", id);
        return logReturn(Optional.of(propertyRuleHashMap.get(id)), "id:", id);
    }
}
