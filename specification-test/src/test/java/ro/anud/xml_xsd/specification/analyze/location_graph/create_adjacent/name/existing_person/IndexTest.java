package ro.anud.xml_xsd.specification.analyze.location_graph.create_adjacent.name.existing_person;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action with name rule and existing person
## Given
- 3 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to "location_graph_id"
and `node_id_ref` set to `node_id`
- node rule that has `people` with empty `selection`
## Then
- It should create 3 new nodes and links them to the node references by `node_id_ref` using same name `nodeFirst`
- people created should not have any values
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
- name
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
