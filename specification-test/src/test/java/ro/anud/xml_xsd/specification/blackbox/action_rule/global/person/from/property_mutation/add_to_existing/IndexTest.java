package ro.anud.xml_xsd.specification.blackbox.action_rule.global.person.from.property_mutation.add_to_existing;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Global Action
## Update property when target has property based on that property
## When
A global action is defined to
  - set 10
  - then add current value
to `property` on self

Using global action on different person with `property`

## It should
set `property` value to 11
 */

/*tags
- global_action
- property
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
