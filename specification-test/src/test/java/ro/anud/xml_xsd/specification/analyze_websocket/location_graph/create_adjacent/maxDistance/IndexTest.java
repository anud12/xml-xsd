package ro.anud.xml_xsd.specification.analyze_websocket.location_graph.create_adjacent.maxDistance;

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
# `location_graph.node.create_adjacent` action with maxDistance
## Given
3 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to "location_graph_id"
and `node_id_ref` set to `node_id`.
the `link_group` has `angleMax` attribute set.

## Then
It should create
  -3 new nodes
  -3 links for node references by `node_id_ref` with different `x` positions
    - 10
    - 6 from 6.666666666666666
    - 3 from 3.333333333333333
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
