package ro.anud.xml_xsd.specification.blackbox.action_rule.from_person.selection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.TestBase;

import java.util.Collection;

/*description
# `from_person` action with selection set on `from_person`
## When
- `from_person_rule` has selection that requires that property `property` is less than 0
- `from_person` action `action_id` is called

##It should
- do nothing
 */

/*tags
  - from_person
  - type__person_selection
 */
@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
