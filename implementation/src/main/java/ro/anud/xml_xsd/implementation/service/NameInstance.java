package ro.anud.xml_xsd.implementation.service;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class NameInstance {

    private WorldStepInstance worldStepInstance;

    public NameInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    public Optional<String> calculateNameFromRefString(String nameRuleRef) {
        var logger = logEnter("nameRuleRef", nameRuleRef);
        logger.logTodo("implement");
        return Optional.of("name");
    }

    public Optional<String> calculateNameFromRefString(Optional<String> nameRuleRef) {
        var logger = logEnter("nameRuleRef", nameRuleRef);
        if (nameRuleRef.isEmpty()) {
            logger.log("empty");
            return logger.logReturn(Optional.empty());
        }
        return logger.logReturn(calculateNameFromRefString(nameRuleRef.get()));
    }
}
