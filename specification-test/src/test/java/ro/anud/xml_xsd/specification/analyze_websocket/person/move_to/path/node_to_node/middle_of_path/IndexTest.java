package ro.anud.xml_xsd.specification.analyze_websocket.person.move_to.path.node_to_node.middle_of_path;

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
# `person.move_to` action with `path` starting from `node` with path containing that `node`

## Given
## Then
- It should move person
- It should remove in `path` the `node` with property `node_id` because the person is on that node
 */

/*tags
- person
- person.move_to
- path
- person_progress_property
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
