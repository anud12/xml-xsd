package ro.anud.xml_xsd.specification.analyze_websocket.action_rule.from_person.selection.property.max.min_unset;

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
@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
