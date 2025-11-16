package ro.anud.xml_xsd.implementation.service;


import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class PropertyInstance {

    public PropertyInstance index() {
        return this;
    }

    public interface PropertyInstanceGetter {
        Optional<Integer> getProperty(String propertyRef);
    }

    private WorldStepInstance worldStepInstance;

    public PropertyInstance(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
        }
    }

}
