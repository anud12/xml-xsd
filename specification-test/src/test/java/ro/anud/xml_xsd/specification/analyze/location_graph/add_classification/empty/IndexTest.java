package ro.anud.xml_xsd.specification.analyze.location_graph.add_classification.empty;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `location_graph.node.add_classification` action with empty selection
## Given
- `location_graph.node.add_classification` action with empty selection
-
## Then
It should add classification to all nodes.
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
