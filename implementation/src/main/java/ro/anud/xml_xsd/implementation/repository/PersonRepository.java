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

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class PersonRepository {

    private final HashMap<String, Person> personById = new HashMap<>();
    private final List<Person> personList = new ArrayList<>();
    private final WorldStepInstance worldStepInstance;
    private Optional<Subscription> subscription = Optional.empty();

    public PersonRepository(WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
        }
    }

    public PersonRepository index() {
        try (var scope = logScope()) {
            var data = worldStepInstance.streamWorldStep()
                .flatMap(WorldStep::streamData)
                .flatMap(Data::streamPeople);
            loadData(data);

            subscription.ifPresent(Subscription::unsubscribe);
            subscription = worldStepInstance.getWorldStep().map(worldStep -> worldStep.onChange(classes -> {
                classes.forEach(o -> {
                    if (o instanceof People people) {
                        scope.log("worldStep onChange triggered is instance of", People.class);
                        loadData(Stream.of(people));
                    }
                });
            }));
            return this;
        }

    }

    private void loadData(Stream<People> people) {
        try (var scope = logScope()) {
            personById.clear();
            personList.clear();
            people
                .flatMap(People::streamPerson)
                .forEach(person -> {
                    personList.add(person);
                    personById.put(person.getId(), person);
                });
        }
    }

    public Stream<Person> streamAll() {
        try ( var scope = logScope()){
            return scope.logReturn(personById.values().stream());
        }

    }

    public Optional<Person> personById(String id) {
        try (var scope = logScope(id)) {
            return scope.logReturn(Optional.ofNullable(personById.get(id)));
        }

    }

    public Stream<Person> streamPerson() {
        try (var scope = logScope("streamPerson")) {
            return scope.logReturn(personList.stream());
        }
    }

    public Person getOrCreate(final Person person) {
        try (var scope = logScope("personId", person.getId())) {
            Optional<Person> personOptional = personById(person.getId());
            var result = personOptional.orElseGet(() -> {
                scope.log("creating new person");
                var newPerson = Person.fromRawNode(person.serializeIntoRawNode());
                worldStepInstance.getWorldStep()
                    .flatMap(WorldStep::getData)
                    .ifPresent(data -> data.getPeopleOrDefault().addPerson(newPerson));
                return newPerson;
            });
            return scope.logReturn(result);
        }

    }
}
