package ro.anud.xml_xsd.specification.analyze.action_rule.from_person.mutate_from.participant_self.mutate_on.participant_target;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `from_person` action with mutation set on `from_person` depending on other property from `self`
# and `on_person` property mutation set `from` participant attribute set to `target`
## When
`from_person` action `action_id` is called


##It should
- on person with id `1`
    - should change strength from `10` to `9`
- on person with id `2`
    - should change health from `1` to `-4`
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
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
