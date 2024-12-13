package ro.anud.xml_xsd.implementation.service.person;

import ro.anud.xml_xsd.implementation.model.Type_personSelection.Type_personSelection;
import ro.anud.xml_xsd.implementation.model.Type_propertyMutation.Type_propertyMutation;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Property.Property;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection.IType_personSelection;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutation.IType_propertyMutation;
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
        final IType_propertyMutation<?> typePropertyMutation,
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

    public Person createPerson(final IType_personSelection<?> personSelection) {
        return CreatePerson.createPerson(worldStepInstance, personSelection);
    }

    public Optional<Integer> mutateProperty(
        final Person person,
        final String propertyRef,
        Function<Integer, Integer> computedValue) {
        var logger = logEnter("person", person.getId(), "propertyRef", propertyRef);
        logger.log("creating default");
        getProperty(person, propertyRef);
        var propertiesElement = person.getPropertiesOrDefault();
        var propertyResult = propertiesElement
            .streamProperty()
            .filter(property -> property.getPropertyRuleRef().equals(propertyRef))
            .findFirst();

        return propertyResult.map(property -> {
            var currentValue = property.getValue();
            var newValue = computedValue.apply(currentValue);
            logger.log("mutating", "currentValue", currentValue, "computedValue", computedValue);
            property.setValue(newValue);
            return newValue;
        });

    }

    public void setProperty(final Person person, final String propertyRef, final int newValue) {
        var logger = logEnter("person", person.getId(), "propertyRef", propertyRef);
        logger.log("creating default");
        mutateProperty(person, propertyRef, (ignored) -> newValue)
            .orElseGet(() -> {
                logger.log("creating property");
                var property = new Property();
                property.setPropertyRuleRef(propertyRef);
                property.setValue(newValue);
                person.getPropertiesOrDefault().addProperty(property);
                return newValue;
            });
        logger.logReturnVoid();
    }
}
