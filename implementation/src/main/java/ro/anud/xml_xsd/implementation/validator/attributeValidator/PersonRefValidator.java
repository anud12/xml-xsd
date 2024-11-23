package ro.anud.xml_xsd.implementation.validator.attributeValidator;

import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.validator.AttributeValidator;

import java.util.stream.Stream;

public class PersonRefValidator implements AttributeValidator {
    @Override
    public Stream<String> getAllowedValues(final WorldStep worldStep) {
        return worldStep.streamData()
            .flatMap(Data::streamPeople)
            .flatMap(People::streamPerson)
            .map(Person::getId);
    }

    @Override
    public String getAttributeKeyToBeTested() {
        return "person_ref";
    }
}
