package ro.anud.xml_xsd.specification.analyze.classification.person.empty__property_rule;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Classify person without any properties and property_rule doesn't have a default value for people
## Given
  - declare property rule `attribute`
  - person without properties
  - classification rule requiring that attribute is equal to 10
## Then
  Person doesn't change.
 */

/*tags
- person
- classification
- property
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
