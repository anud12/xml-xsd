package ro.anud.xml_xsd.specification.analyze_websocket.person.move_to.path.node_to_node.from_link;

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
# `person.move_to` action with `path` starting from `link_to` with not enough movement

## Given
- 1 `person` located on a `link_to` from `node_id` to node_id_2` with `accumulated_progress` `1`
- 1 `location_graph` with 3 `node` linked from
    - `node_id` to `node_id_2`
        - with `person_progress_property` to 4
        - with `total_progress` to 1

    - `node_id_2` to `node_id_destination`
        - with `person_progress_property` to `10`
        - with `total_progress` to 10
- 1 `actions` with `person.move_to` having `path` including only `node_id_destination`
## Then
It should move `person_id` to `link_to` from `node_id_2` to `node_id_destination` because from node_id to node_id 2 it has `0.8`
because `0.8 = (progressValue(5) - total_progress (1)) / (progressValue(5))` where `progressValue(5) = initial (4) + accumulated_progress (1)`
(`((initial (4) + accumulated_progress (1)) - total_progress (1) )/ (initial (4) + accumulated_progress (1))`)
 remaining progress, and multiplied by `person_progress_property` of `9` from `link_to` towards `node_id_destination` the result is
 7.5 but it's truncated to 7
 */

/*tags
- person
- person.move_to
- path
- person_progress_property
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
