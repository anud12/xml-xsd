package ro.anud.xml_xsd.implementation.service.util;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations;
import ro.anud.xml_xsd.implementation.service.PropertyInstance;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class ComputeOperation {
    public static Optional<Integer> computeOperation(
        WorldStepInstance worldStepInstance,
        IType_mathOperations<?> typeMathOperations,
        PropertyInstance.PropertyInstanceGetter propertyInstanceGetter) {
        var logger = logEnter();
        logger.logTodo("Not implemented");
        return logger.logReturn(Optional.empty());
    }

    public static Optional<Integer> computeOperation(
        WorldStepInstance worldStepInstance,
        IType_mathOperations<?> typeMathOperations,
        Person person) {
        var logger = logEnter();
        logger.logTodo("Not implemented");
        return logger.logReturn(Optional.empty());
    }
}
