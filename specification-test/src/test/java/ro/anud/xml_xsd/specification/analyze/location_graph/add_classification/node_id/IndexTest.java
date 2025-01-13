package ro.anud.xml_xsd.specification.analyze.location_graph.add_classification.node_id;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

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

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
