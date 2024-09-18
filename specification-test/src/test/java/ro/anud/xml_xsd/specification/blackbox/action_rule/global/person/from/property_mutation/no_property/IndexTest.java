package ro.anud.xml_xsd.specification.blackbox.action_rule.global.person.from.property_mutation.no_property;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Global Action
## Update property when target doesn't have one
## When
A global action is defined to add 1 to `property` on self

Using global action on different person without `property`

## It should
do nothing
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
