package ro.anud.xml_xsd.implementation.service;

import lombok.Getter;
import lombok.Setter;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.repository.PersonRepository;
import ro.anud.xml_xsd.implementation.repository.RuleRepository;
import ro.anud.xml_xsd.implementation.service.person.PersonInstance;

@Getter
@Setter
public class WorldStepInstance {


    private WorldStep worldStep;

    private final PersonRepository personRepository;
    private final RuleRepository ruleRepository;
    private final PersonInstance personInstance;
    private final PropertyInstance propertyInstance;
    private final LocationGraphInstance locationGraphInstance;
    public WorldStepInstance(WorldStep worldStep) {
        this.worldStep = worldStep;
        personRepository = new PersonRepository(this);
        ruleRepository = new RuleRepository(this);
        personInstance = new PersonInstance(this);
        propertyInstance = new PropertyInstance(this);
        locationGraphInstance = new LocationGraphInstance(this);
    }

}
