package ro.anud.xml_xsd.implementation.service.person;

import ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection;
import ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Property.Property;
import ro.anud.xml_xsd.implementation.repository.PersonRepository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.person.util.ApplyPropertyMutation;
import ro.anud.xml_xsd.implementation.service.person.util.ClassifyPerson;
import ro.anud.xml_xsd.implementation.service.person.util.CreatePerson;
import ro.anud.xml_xsd.implementation.service.person.util.GetProperty;

import java.util.Optional;
import java.util.function.Function;
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

    public void applyPropertyMutationOnOut(
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

    public Person createPerson(final Type_personSelection personSelection) {
        return CreatePerson.createPerson(worldStepInstance, personSelection);
    }

    public void mutateProperty(
        final Person person,
        final String propertyRef,
        Function<Integer, Integer> computedValue) {
        var logger = logEnter("person", person.getId(), "propertyRef", propertyRef);
        logger.log("creating default");
        getProperty(person, propertyRef);
        var propertiesElement =person.getPropertiesOrDefault();
        var propertyResult = propertiesElement
            .streamProperty()
            .filter(property -> property.getPropertyRuleRef().equals(propertyRef))
            .findFirst();
        var propertyElement = propertyResult.orElseGet(() -> {
            logger.log("property is not present");
            var property = new Property().setPropertyRuleRef(propertyRef)
                .setValue(0);
            propertiesElement.addProperty(property);
            return property;
        });
        var currentValue = propertyElement.getValue();
        logger.log("currentValue", currentValue);
        var newValue = computedValue.apply(currentValue);
        logger.log("newValue", newValue);
        propertyElement.setValue(newValue);
        logger.logReturnVoid();
//
//        if (propertyResult.isPresent()) {
//            var innerLogger = logger.log("property is present");
//            var currentValue = propertyResult.get().getValue();
//
//            return;
//        }
//        var innerLogger = logger.log("property is not present");
//        var currentValue = getProperty(person, propertyRef).orElse(0);
//        innerLogger.log("currentValue", currentValue);
//        var newValue = computedValue.apply(currentValue);
//        innerLogger.log("newValue", newValue);
//        person.getPropertiesOrDefault().addProperty(new Property()
//            .setPropertyRuleRef(propertyRef)
//            .setValue(newValue)
//        );
//        innerLogger.logReturnVoid();
    }
}
