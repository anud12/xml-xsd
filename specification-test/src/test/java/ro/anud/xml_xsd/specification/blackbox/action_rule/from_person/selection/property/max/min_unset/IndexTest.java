package ro.anud.xml_xsd.specification.blackbox.action_rule.from_person.selection.property.max.min_unset;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.TestBase;

import java.util.Collection;

/*description
# `from_person` action with selection set on `from_person` when only `max` is used
## When
- `from_person_rule` has selection that requires that property `property` is greater than 2
- `from_person` action `action_id` is called

##It should
- on person with id `1` it should add 2 to property setting to `2`
- ignore person with id `3`
 */

/*tags
  - from_person
  - type__person_selection
  - property
 */
@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
