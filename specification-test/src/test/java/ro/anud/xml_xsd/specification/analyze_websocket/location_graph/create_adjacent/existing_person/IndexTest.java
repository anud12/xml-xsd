package ro.anud.xml_xsd.specification.analyze_websocket.location_graph.create_adjacent.existing_person;

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
# `location_graph.node.create_adjacent` action with existing_person
## Given
1 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to "location_graph_id"
and `node_id_ref` set to `node_id`.
the `link_group` has `angleMax` attribute set.

'node_rule' with 'existing_people' set

## Then
It should create
  -1 new node
  -1 links for node references by `node_id_ref`
    - with different `x` and `y` positions x: 1, y: 0
    - with 3 people reference in the node
  - 3 people
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
- existing_person
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
