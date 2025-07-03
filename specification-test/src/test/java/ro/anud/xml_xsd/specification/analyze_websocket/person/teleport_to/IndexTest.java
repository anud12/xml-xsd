package ro.anud.xml_xsd.specification.analyze_websocket.person.teleport_to;

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
# `person.teleport` action on person

Having an empty person
It should teleport person `person_id` to node `node_id` under `location_graph_id`

## Given
- 1 `person`
- 1 `location_graph` with 1 `node`
- 1 `actions` with `person.teleport`
## Then
It should create a `person` with `person_id_ref` under the target node.
 */

/*tags
- person
- person.teleport
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
