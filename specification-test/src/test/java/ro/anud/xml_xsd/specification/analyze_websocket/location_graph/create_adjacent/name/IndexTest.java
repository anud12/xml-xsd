package ro.anud.xml_xsd.specification.analyze_websocket.location_graph.create_adjacent.name;

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
# `location_graph.node.create_adjacent` action with name rule
## Given
3 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to "location_graph_id"
and `node_id_ref` set to `node_id`
## Then
It should create 3 new nodes and links them to the node references by `node_id_ref` using same name `nodeFirst`
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
- name
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
