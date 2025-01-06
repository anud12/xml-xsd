package ro.anud.xml_xsd.implementation.middleware;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.PropertyRule.PropertyRule;
import ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.RuleGroup;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

public class DefaultPropertyInitializer {
    public static void apply(final WorldStepInstance worldStepInstance) {
        var personDefaultPropertyStream = worldStepInstance.getWorldStep()
            .streamRuleGroup()
            .flatMap(RuleGroup::streamPropertyRule)
            .flatMap(PropertyRule::streamEntry)
            .filter(entry -> entry.getPersonDefault().isPresent());

        personDefaultPropertyStream.forEach(entry -> {
            worldStepInstance.getWorldStep()
                .streamData()
                .flatMap(Data::streamPeople)
                .forEach(people -> {
                    var personDefault = entry.getPersonDefault().get();
                    worldStepInstance.computeOperation(personDefault);
                });
        });
    }
}
