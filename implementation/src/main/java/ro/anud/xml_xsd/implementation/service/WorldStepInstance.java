package ro.anud.xml_xsd.implementation.service;

import lombok.Setter;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations;
import ro.anud.xml_xsd.implementation.repository.RuleRepository;
import ro.anud.xml_xsd.implementation.service.person.PersonInstance;
import ro.anud.xml_xsd.implementation.service.util.ComputeOperation;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

@Setter
public class WorldStepInstance {


    private WorldStep worldStep;

    public final RuleRepository ruleRepository;
    public final PersonInstance person;
    public final PropertyInstance property;
    public final LocationGraphInstance locationGraph;
    private WorldStepInstance outInstance = this;

    public WorldStepInstance(WorldStep worldStep) {
        this.worldStep = worldStep;
        ruleRepository = new RuleRepository(this);
        person = new PersonInstance(this);
        property = new PropertyInstance(this);
        locationGraph = new LocationGraphInstance(this);
    }

    public WorldStep getWorldStep() {
        return worldStep;
    }

    public WorldStepInstance getOutInstance() {
        return outInstance;
    }


    public Optional<Integer> computeOperation(
        IType_mathOperations<?> typeMathOperations,
        PropertyInstance.PropertyInstanceGetter propertyInstanceGetter) {
        var logger = logEnter();
        logger.logTodo("Not implemented");
        return logger.logReturn(ComputeOperation.computeOperation(this, typeMathOperations, propertyInstanceGetter));
    }

    public Optional<Integer> computeOperation(
        IType_mathOperations<?> typeMathOperations,
        Person person) {
        var logger = logEnter();
        logger.logTodo("Not implemented");
        return logger.logReturn(ComputeOperation.computeOperation(this, typeMathOperations, person));
    }
}
