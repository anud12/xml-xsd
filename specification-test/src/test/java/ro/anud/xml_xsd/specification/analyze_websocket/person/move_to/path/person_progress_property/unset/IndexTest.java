package ro.anud.xml_xsd.specification.analyze_websocket.person.move_to.path.person_progress_property.unset;

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
# `person.move_to` action with `path` but `person_progress_property` unset

## Given
- 1 `person`
- 1 `location_graph` with 2 `node` linked from
    - `node_id` to `node_id_destination`
- 1 `actions` with `person.move_to` having `path` including only `node_id_destination`
## Then
It should do nothing because `link_to` doesn't have `person_progress_property` set.
Should remove `person.move_to` action from `actions`
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
