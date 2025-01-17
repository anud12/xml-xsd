package ro.anud.xml_xsd.specification.analyze.action_rule.from_person.on_person.selection.from_person_same_location_graph_node.same_location;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `from_person` action with on_person selection
## When
`from_person` action `action_id` is called
- with `from_person_same_location_graph_node` element value set to `true`
- both persons are not in a graph node

##It should
- do nothing
 */

/*tags
  - from_person
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
