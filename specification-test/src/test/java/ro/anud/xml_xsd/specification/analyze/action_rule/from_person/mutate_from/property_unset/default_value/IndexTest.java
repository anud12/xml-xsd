package ro.anud.xml_xsd.specification.analyze.action_rule.from_person.mutate_from.property_unset.default_value;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `from_person` action with mutation on unset value with default
## When
`from_person` action `action_id` is called


##It should
- it should compute the default value which is 1
- compute operation by adding 1
- set `property` value to 2
 */

/*tags
  - from_person
  - participant `self`
  - property_mutation
  - person_default
 */
@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
