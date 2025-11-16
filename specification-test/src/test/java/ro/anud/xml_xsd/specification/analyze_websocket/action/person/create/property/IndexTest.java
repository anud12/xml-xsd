package ro.anud.xml_xsd.specification.analyze_websocket.action.person.create.property;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.websocket.tests.AnalyzeTest;

import java.util.List;

/*description
# person.create
## When
- person.create action is used with property
- property_ref has default person value

## It should
create person with property set
 */

/*tags
- action
- person
- person.create,
- property
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
