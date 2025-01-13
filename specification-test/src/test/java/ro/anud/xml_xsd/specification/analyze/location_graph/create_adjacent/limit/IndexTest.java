package ro.anud.xml_xsd.specification.analyze.location_graph.create_adjacent.limit;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action with limit and angle
## Given
- 2 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to "location_graph_id"
and `node_id_ref` set to `node_id`.
the `link_group` has
  - `angle` attribute set
  - `limit` attribute set
- `link_group` rule with an angle of `0`
- 2 nodes that are at an angle of '0' degrees
## Then
It should do nothing because the `link_group` doesn't allow another node to be created.
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
