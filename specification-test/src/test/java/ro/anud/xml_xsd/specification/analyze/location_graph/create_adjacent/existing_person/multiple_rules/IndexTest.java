package ro.anud.xml_xsd.specification.analyze.location_graph.create_adjacent.existing_person.multiple_rules;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action with `existing_person` and origin node using `other_rule`
## Given
- 1 entries with `location_graph.node.create_adjacent` with attribute `location_graph_id_ref` set to `location_graph_id`
and `node_id_ref` set to `node_id`.
- the `link_group` has `angleMax` attribute set.

- target node uses `other_node` rule
- `node_rule` with `existing_people` set
- `other_rule` without `existing people` set

## Then
It should use `existing_person` rule for the one that is being created, rather than the one than the target one, by creating
  -1 new node
  -1 links for node references by `node_id_ref`
    - with different `x` and `y` positions x: 1, y: 0
    - with 3 people reference in the node
  - 3 people
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
- existing_person
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
