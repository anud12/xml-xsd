package ro.anud.xml_xsd.implementation;

import org.junit.jupiter.api.Test;
import ro.anud.xml_xsd.implementation.util.repository.NonNullableIndex;
import ro.anud.xml_xsd.implementation.util.repository.NullableIndex;

import java.util.List;

public class NullableNonNullableIndexTest {


    @Test
    public void test() {
        record Job(String name) {
        }
        record Person(String name, List<Job> jobList) {
        }

        NonNullableIndex<String, Person, NullableIndex<String, Job, Job>> index = NullableIndex.ofNullable(Person.class, Person::name)
                        .compose(() -> NullableIndex.ofNullable(Job.class, Job::name), person -> person.jobList.stream());

        var result = index.get("person").get("first");

        System.out.println(result);
    }
}
