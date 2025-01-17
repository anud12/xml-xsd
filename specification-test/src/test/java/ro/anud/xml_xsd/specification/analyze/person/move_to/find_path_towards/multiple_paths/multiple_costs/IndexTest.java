package ro.anud.xml_xsd.specification.analyze.person.move_to.find_path_towards.multiple_paths.multiple_costs;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `person.move_to` action with `find_path_towards` multiple paths and costs

## Given
- 1 `person`
- 1 `location_graph` with 4 `node` linked from
    - `node_id` to `node_id_2`
    - `node_id` to `node_id_4`
    - `node_id_2` to `node_id_3`
    - `node_id_3` to `node_id_4`
    - `node_id_4` to `node_id_5`
- 1 `actions` with `person.move_to` having `find_path_towards` child element

cost between `node_id` and `node_id_4` is increased so that it is the worse path.
## Then
It should replace `find_path_towards with `path` element containing in order
ignoring the link between `node_id` to `node_id_4`
    - `node_id_2`
    - `node_id_3`
    - `node_id_4`
    - `node_id_destination`
 */

/*tags
- person
- person.move_to
- find_path_towards
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
