package ro.anud.xml_xsd.specification.analyze_websocket.action_rule.from_person.mutate_from.participant_self;

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
# `from_person` action with mutation set on `from_person` depending on other property from `self`
## When
`from_person` action `action_id` is called


##It should
- on person with id `1` it should add 1 and the value of `property_dependant` which is 1, finally totaling to 3
 */

/*tags
  - from_person
  - participant `self`
  - property_mutation
 */
@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
