package ro.anud.xml_xsd.specification.blackbox.action_rule.from_person.mutate_from.participant_self.mutate_on.participant_self;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.TestBase;

import java.util.Collection;

/*description
# `from_person` action with mutation set on `from_person` depending on other property from `self`
# and `on_person` property mutation set
## When
`from_person` action `action_id` is called


##It should
- on person with id `1` it should add 1 and the value of `property_dependant` which is 1, finally totaling to 3
 */

/*tags
  - from_person
  - participant `self`
  - property_mutation
 */
@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
