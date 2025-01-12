package ro.anud.xml_xsd.specification.analyze.person.move_to.path.node_to_node.partial_over_node;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `person.move_to` action with `path` with not enough movement

## Given
- 1 `person`
- 1 `location_graph` with 3 `node` linked from
    - `node_id` to `node_id_2`
        - with `person_progress_property` to 4
        - with `total_progress` to 1

    - `node_id_2` to `node_id_destination`
        - with `person_progress_property` to 9
        - with `total_progress` to 10
- 1 `actions` with `person.move_to` having `path` including only `node_id_destination`
## Then
It should move person_id to `link_to` from `node_id_2` to `node_id_destination` because from node_id to node_id 2 it has `0.75`
 remaining progress, and multiplied by `person_progress_property` of `9` from `link_to` towards `node_id_destination` the result is
 6.75 converted to 6 but it's truncated to 6
 */

/*tags
- person
- person.move_to
- path
- person_progress_property
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
