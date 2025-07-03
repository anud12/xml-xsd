package ro.anud.xml_xsd.specification.analyze_websocket.action_rule.from_person.mutate_from.property_unset.default_value;

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
# `from_person` action with mutation on unset value with default
## When
`from_person` action `action_id` is called


##It should
- it should compute the default value which is 1
- compute operation by adding 1
- set `property` value to 2
 */

/*tags
  - from_person
  - participant `self`
  - property_mutation
  - person_default
 */
@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
