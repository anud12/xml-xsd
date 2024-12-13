package ro.anud.xml_xsd.specification.blackbox.location_graph.create_adjacent.limit.batch;

import org.junit.jupiter.api.Disabled;
import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action with limit and angle
## Given
1 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to "location_graph_id"
and `node_id_ref` set to `node_id`.
the `link_group` has
  - `angle` attribute set
  - `limit` attribute set

## Then
When batched the validation executes on the input data and doesn't update when the first action is executed,
the side effect is that the limit is bypassed.

It should create
  -2 new nodes because at the time of execution there aren't any nodes adjacent to 'node_id'
  -2 links for node references by `node_id_ref` with different `x` and `y` positions
    - x: 100, y: 0
    - x: 100, y: 0
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
 */


@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    @Disabled
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
