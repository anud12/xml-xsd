package ro.anud.xml_xsd.implementation.service.person;

import ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.repository.PersonRepository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.person.util.ApplyPropertyMutation;
import ro.anud.xml_xsd.implementation.service.person.util.ClassifyPerson;
import ro.anud.xml_xsd.implementation.service.person.util.GetProperty;

import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class PersonInstance {

    private final WorldStepInstance worldStepInstance;
    public final SelectionInstance selection;
    public final PersonRepository repository;

    public PersonInstance(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
        selection = new SelectionInstance(worldStepInstance);
        this.repository = new PersonRepository(worldStepInstance);

    }

    public Optional<Integer> getProperty(final Person person, final String propertyRef) {
        var logger = logEnter("personId:", person.getId(), "propertyRef:", propertyRef);
        return logger.logReturn(GetProperty.getProperty(this.worldStepInstance, person, propertyRef));
    }

    public void applyPropertyMutation(
        final Person selfPerson,
        final Type_propertyMutation typePropertyMutation,
        final Person originPerson,
        final Person targetPerson) {
        ApplyPropertyMutation.applyPropertyMutation(
            worldStepInstance,
            selfPerson,
            typePropertyMutation,
            originPerson,
            targetPerson
        );
    }

    public Stream<String> classifyPerson(Person person) {
        var logger = logEnter("personId", person.getId());
        return logger.logReturn(ClassifyPerson.getPersonClassifications(this.worldStepInstance, person));
    }
}
