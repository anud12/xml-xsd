package ro.anud.xml_xsd.specification.analyze_websocket.location_graph.add_classification.node_id;

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
# `location_graph.node.add_classificationt` action with node id selection
## Given
- `location_graph.node.add_classificationt` action with `<has__node_graph_id node_graph_id_ref="node_id"/>`
-
## Then
It should add classification to the node with the given node id.
 */

/*tags
- location_graph
- location_graph.node.add_classification
- type__node_graph__selection
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
