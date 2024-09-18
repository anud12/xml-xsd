package ro.anud.xml_xsd.specification.blackbox.action_rule.person_to_person;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Person to person action
## When
A action is defined

Using global action on from Billy to Bob
Distance between them is 0

##It should
compute billy strength to 10
compute bob health to 15
  -base 10
  -add billy's strength divided by 2 (5)
 */

/*tags
  - person_to_person
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
