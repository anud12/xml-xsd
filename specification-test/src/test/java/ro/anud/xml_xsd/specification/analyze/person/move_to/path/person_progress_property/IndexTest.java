package ro.anud.xml_xsd.specification.analyze.person.move_to.path.person_progress_property;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `person.move_to` action with `path` and `person_progress_property` set

## Given
- 1 `person`
- 1 `location_graph` with 2 `node` linked from
    - `node_id` to `node_id_destination` without `person_progress_property`
- 1 `actions` with `person.move_to` having `path` including only `node_id_destination`
## Then
It should do nothing because `link_to` doesn't have `person_progress_property` set.
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
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
