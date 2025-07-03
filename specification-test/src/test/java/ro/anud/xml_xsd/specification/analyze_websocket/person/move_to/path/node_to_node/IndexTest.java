package ro.anud.xml_xsd.specification.analyze_websocket.person.move_to.path.node_to_node;

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
# `person.move_to` action with `path` and reaching destination

## Given
- 1 `person`
- 1 `location_graph` with 3 `node` linked from
    - `node_id` to `node_id_2`
        - with `person_progress_property` to 4
        - with `total_progress` to 1
    - `node_id_2` to `node_id_destination`
        - with `person_progress_property` to 4
        - with `total_progress` to 1
- 1 `actions` with `person.move_to` having `path` including only `node_id_destination`
## Then
It should move person_id to node_id_destination because it can reach it
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
