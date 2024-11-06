package ro.anud.xml_xsd.implementation.service;


import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class PropertyInstance {

    public interface PropertyInstanceGetter {
        Optional<Integer> getProperty(String propertyRef);
    }

    private WorldStepInstance worldStepInstance;

    public PropertyInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

}
