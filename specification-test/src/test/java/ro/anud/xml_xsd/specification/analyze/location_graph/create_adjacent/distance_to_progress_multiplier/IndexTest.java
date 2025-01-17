package ro.anud.xml_xsd.specification.analyze.location_graph.create_adjacent.distance_to_progress_multiplier;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action with `total_progress`
## Given
2 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to "location_graph_id"
and `node_id_ref` set to `node_id`.


## Then
It should create
  -2 new nodes
  -2 links for node references with total_progress set to double of distance
    - `node_id` to `0.0` should be `12`
    - `node_id` to `0.1` should be `6`
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
