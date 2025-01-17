package ro.anud.xml_xsd.implementation.service.name;

import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class NameInstance {

    public Repository repository;
    private WorldStepInstance worldStepInstance;

    public NameInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        this.repository = new Repository(worldStepInstance);
    }
    public NameInstance index() {
        repository.index();
        return this;
    }

    public Optional<String> calculateNameFromRefString(String nameRuleRef) {
        var logger = logEnter("nameRuleRef", nameRuleRef);
        return logger.logReturn(CalculateName.calculateNameFromRefString(worldStepInstance, nameRuleRef));
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
