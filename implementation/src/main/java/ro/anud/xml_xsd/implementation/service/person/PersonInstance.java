package ro.anud.xml_xsd.implementation.service.person;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Properties.Property.Property;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_personSelection.IType_personSelection;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_propertyMutation.IType_propertyMutation;
import ro.anud.xml_xsd.implementation.repository.PersonRepository;
import ro.anud.xml_xsd.implementation.service.Mutation;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.person.util.ApplyPropertyMutation;
import ro.anud.xml_xsd.implementation.service.person.util.ClassifyPerson;
import ro.anud.xml_xsd.implementation.service.person.util.CreatePerson;
import ro.anud.xml_xsd.implementation.service.person.util.GetProperty;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.service.person.util.GetProperty.computeBaseProperty;
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

    public Mutation<Person> applyPropertyMutation(
        final Person applicablePerson,
        final IType_propertyMutation<?> typePropertyMutation,
        final Person selfPerson,
        final Person targetPerson) {
        return ApplyPropertyMutation.applyPropertyMutation(
            worldStepInstance,
            applicablePerson,
            typePropertyMutation,
            selfPerson,
            targetPerson
        );
    }

    public Stream<String> classifyPerson(Person person) {
        var logger = logEnter("personId", person.getId());
        return logger.logReturn(ClassifyPerson.getPersonClassifications(this.worldStepInstance, person));
    }

    public Mutation<Person> createPerson(final IType_personSelection<?> personSelection) {
        return CreatePerson.createPerson(worldStepInstance, personSelection);
    }

    public Optional<Property> mutatePropertyIfPresent(
        final Person person,
        final String propertyRef,
        Function<Integer, Integer> computedValue) {
        var logger = logEnter("person", person.getId(), "propertyRef", propertyRef);
        var propertiesElement = person.getPropertiesOrDefault();
        var propertyValue = propertiesElement
            .streamProperty()
            .filter(property -> property.getPropertyRuleRef().equals(propertyRef))
            .findFirst()
            .map(property -> {
                var currentValue = property.getValue();
                var newValue = computedValue.apply(currentValue);
                logger.log("mutating currentValue", currentValue, "newValue", newValue);
                property.setValue(newValue);
                return property;
            });

        if(propertyValue.isPresent()) {
            return propertyValue;
        }
        logger.log("computing base property");
        return computeBaseProperty(worldStepInstance, person, propertyRef).map(integer -> {
            var property = new Property();
            var newValue = computedValue.apply(integer);
            logger.log("mutating currentValue", integer, "newValue", newValue);
            property.setValue(newValue);
            property.setPropertyRuleRef(propertyRef);
            propertiesElement.addProperty(property);
            return property;
        });

    }

    public Property mutateProperty(
        final Person person,
        final String propertyRef,
        Function<Optional<Integer>, Integer> computedValue) {
        var logger = logEnter("person", person.getId(), "propertyRef", propertyRef);
        return mutatePropertyIfPresent(person,propertyRef,integer -> computedValue.apply(Optional.of(integer)))
            .orElseGet(() -> {
                var newProperty = new Property()
                    .setValue(computedValue.apply(computeBaseProperty(worldStepInstance, person, propertyRef)))
                    .setPropertyRuleRef(propertyRef);
                var propertiesElement = person.getPropertiesOrDefault();
                propertiesElement.addProperty(newProperty);
                return newProperty;
            });
    }

    public Property setProperty(final Person person, final String propertyRef, final int newValue) {
        var logger = logEnter("person", person.getId(), "propertyRef", propertyRef);
        logger.log("creating default");
        return mutateProperty(person, propertyRef, (ignored) -> newValue);
    }

}
