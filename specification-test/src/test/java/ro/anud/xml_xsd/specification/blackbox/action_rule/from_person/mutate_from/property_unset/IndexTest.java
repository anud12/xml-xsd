package ro.anud.xml_xsd.specification.blackbox.action_rule.from_person.mutate_from.property_unset;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.TestBase;

import java.util.Collection;

/*description
# `from_person` action with mutation set on `from_person` when property is unset
## When
`from_person` action `action_id` is called


##It should
- it should do nothing
 */

/*tags
  - from_person
  - participant `self`
 */
@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
