package ro.anud.xml_xsd.implementation.repository;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.util.Subscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;

public class PersonRepository {

    private final HashMap<String, Person> personById = new HashMap<>();
    private final List<Person> personList = new ArrayList<>();
    private final WorldStepInstance worldStepInstance;
    private Optional<Subscription> subscription = Optional.empty();
    public PersonRepository(WorldStepInstance worldStepInstance) {
        var logger = logEnter();
        this.worldStepInstance = worldStepInstance;
    }

    public PersonRepository index() {
        var logger = logEnter();
        var data = worldStepInstance.streamWorldStep()
            .flatMap(WorldStep::streamData)
            .flatMap(Data::streamPeople);
        loadData(data);

        subscription.ifPresent(Subscription::unsubscribe);
        subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(classes -> {
            classes.forEach(o -> {
                    if (o instanceof People people) {
                        logger.log("worldStep onChange triggered is instance of", People.class);
                        loadData(Stream.of(people));
                    }
                });
        }));
        return this;
    }

    private void loadData(Stream<People> people) {
        logEnter("indexing by personId");
        personById.clear();
        personList.clear();
        people
            .flatMap(People::streamPerson)
            .forEach(person -> {
                personList.add(person);
                personById.put(person.getId(), person);
            });
    }

    public Stream<Person> streamAll() {
        return logEnter().logReturn(personById.values().stream());
    }

    public Optional<Person> personById(String id) {
        var logger = logEnter("id:", id);
        return logger.logReturn(Optional.ofNullable(personById.get(id)));
    }

    public Stream<Person> streamPerson() {
        return logEnter().logReturn(personList.stream());
    }

    public Person getOrCreate(final Person person) {
        var logger = logEnter("personId", person.getId());
        Optional<Person> personOptional = personById(person.getId());
        return personOptional.orElseGet(() -> {
            logger.log("creating new person");
            var newPerson = Person.fromRawNode(person.serializeIntoRawNode());
            worldStepInstance.getWorldStep()
                .flatMap(WorldStep::getData)
                .ifPresent(data -> data.getPeopleOrDefault().addPerson(newPerson));
            return newPerson;
        });
    }
}
