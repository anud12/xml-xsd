package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

public class PersonRepository {

    private final HashMap<String, Person> personById = new HashMap<>();

    public PersonRepository(WorldStepInstance worldStepInstance) {
        logEnter();
        Data data = worldStepInstance.getWorldStep()
            .getData();
        loadData(data);


    }

    private void loadData(Data data) {
        logEnter();
        logEnter("Extracting personById");
        data.streamPeople()
            .flatMap(People::streamPerson)
            .forEach(person -> {
                personById.put(person.getId(), person);
                person.onChange(person1 -> {
                    if (person1 == null) {
                        personById.remove(person.getId());
                    }
                }).unsubscribe();
            });
    }

    public Stream<Person> streamAll() {
        return logEnter().logReturn(personById.values().stream());
    }

    public Optional<Person> personById(String id) {
        logEnter("id:", id);
        return logReturn(Optional.ofNullable(personById.get(id)));
    }
}
