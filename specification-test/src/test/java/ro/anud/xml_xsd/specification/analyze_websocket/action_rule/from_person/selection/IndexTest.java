package ro.anud.xml_xsd.specification.analyze_websocket.action_rule.from_person.selection;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;
import ro.anud.xml_xsd.websocket.tests.AnalyzeTest;

import java.util.Collection;
import java.util.List;

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
@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
