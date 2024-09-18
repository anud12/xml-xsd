package ro.anud.xml_xsd.specification.blackbox.action_rule.global.person.not_eligible;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Global Action
## When
A global action is defined with from person selector

Using global action on target

Owner is not eligible to use the action

## It should
do nothing
 */

/*tags
- action_rule
- global_action
- type__person_selection
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
