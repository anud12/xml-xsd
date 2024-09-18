package ro.anud.xml_xsd.specification.blackbox.action_rule.global.person.on.selection.apply;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Global Action
## Update property when selecting a target and has property
## When
A global action is defined selecting a person with classification `classification`
to set 10 to `property` on target

Using global action on different person with `property`

Target person doesn't have classification

## It should
do nothing
 */

/*tags
- global_action
- property
- type__person_selection
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
