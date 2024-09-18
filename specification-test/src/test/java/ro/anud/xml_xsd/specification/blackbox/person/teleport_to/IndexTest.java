package ro.anud.xml_xsd.specification.blackbox.person.teleport_to;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `person.teleport` action on person

Having an empty person
It should teleport person `person_id` to node `node_id` under `location_graph_id`

## Given
- 1 `person`
- 1 `location_graph` with 1 `node`
- 1 `actions` with `person.teleport`
## Then
It should create a `person` with `person_id_ref` under the target node.
 */

/*tags
- person
- person.teleport
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
