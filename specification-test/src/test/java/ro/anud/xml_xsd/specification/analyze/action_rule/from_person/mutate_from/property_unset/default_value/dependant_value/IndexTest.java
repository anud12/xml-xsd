package ro.anud.xml_xsd.specification.analyze.action_rule.from_person.mutate_from.property_unset.default_value.dependant_value;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `from_person` action with mutation on value and dependant value where both are unset and have default
## When
`from_person` action `action_id` is called


##It should
- it should compute the default value which is 1 for both
- compute operation by adding 1 from initial and 1 from dependant value
- set `property` value to 3
- set `dependant_property` value to 1
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
