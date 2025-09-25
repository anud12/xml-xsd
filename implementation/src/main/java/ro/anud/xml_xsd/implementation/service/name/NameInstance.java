package ro.anud.xml_xsd.implementation.service.name;

import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

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
        try (var scope = logScope()){
            return scope.logReturn(CalculateName.calculateNameFromRefString(worldStepInstance, nameRuleRef));
        }
    }

    public Optional<String> calculateNameFromRefString(Optional<String> nameRuleRef) {
        try (var scope = logScope("nameRuleRef", nameRuleRef)){
            if (nameRuleRef.isEmpty()) {
                scope.log("empty");
                return scope.logReturn(Optional.empty());
            }
            return scope.logReturn(calculateNameFromRefString(nameRuleRef.get()));
        }

    }

}
