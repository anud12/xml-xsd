package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.ActionRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ActionRule.FromPerson.FromPerson;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.ClassificationRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.PropertyInstance;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class RuleRepository {


    private final HashMap<String, FromPerson> fromPersonHashMapById = new HashMap<>();
    private final HashMap<String, Entry> propertyRuleHashMap = new HashMap<>();
    private final HashMap<String, ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Entry> classificationRulesNoPropertiesMap = new HashMap<>();
    private final HashMap<String, ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Entry> classificationRules = new HashMap<>();
    private final WorldStepInstance worldStepInstance;
    public final NodeRuleRepository nodeRule;
    public final LinkGroupRuleRepository linkGroupRule;
    public final ZoneRuleRepository zoneRule;
    public final RegionRuleRepository regionRule;
    public final PortalRepository portalRule;
    private PropertyInstance propertyInstance;


    public RuleRepository(WorldStepInstance worldStepInstance) {
        logEnter();
        this.propertyInstance = new PropertyInstance(worldStepInstance);
        this.worldStepInstance = worldStepInstance;
        this.linkGroupRule = new LinkGroupRuleRepository(worldStepInstance);
        this.nodeRule = new NodeRuleRepository(worldStepInstance);
        this.zoneRule = new ZoneRuleRepository(worldStepInstance);
        this.regionRule = new RegionRuleRepository(worldStepInstance);
        this.portalRule = new PortalRepository(worldStepInstance);
    }
    public RuleRepository index() {
        var ruleGroups = worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamRuleGroup)
            .toList();

        nodeRule.index(ruleGroups);
        linkGroupRule.index();
        zoneRule.index(ruleGroups);
        regionRule.index(ruleGroups);
        portalRule.index();

        var actionRule = ruleGroups
            .stream()
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
        ruleGroups.stream()
            .flatMap(RuleGroup::streamClassificationRule)
            .flatMap(ClassificationRule::streamEntry)
            .forEach(entry -> {
                if (entry.getProperty().isEmpty()) {
                    classificationRulesNoPropertiesMap.put(entry.getId(), entry);
                }
                classificationRules.put(entry.getId(), entry);
            });
        return this;
    }

    public Optional<FromPerson> getPersonById(String id) {
        var logger = logEnter("id:", id);
        return logger.logReturn(Optional.ofNullable(fromPersonHashMapById.get(id)));
    }

    public Optional<Entry> getPropertyById(String id) {
        var logger = logEnter("id:", id);
        return logger.logReturn(Optional.of(propertyRuleHashMap.get(id)));
    }

    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Entry> streamClassificationRuleEntryByNoProperties() {
        var logger = logEnter();
        return logger.logReturn(classificationRulesNoPropertiesMap.values().stream());
    }

    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ClassificationRule.Entry.Entry> streamAllClassificationRuleEntry() {
        var logger = logEnter();
        return logger.logReturn(classificationRules.values().stream());
    }
}
