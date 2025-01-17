package ro.anud.xml_xsd.specification.analyze.location_graph.create_adjacent.adjacentDepthLimit_2;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action with maxAngle
## Given
node graph with following links
```
D - C
    |
A - B
```
when calling `location_graph.node.create_adjacent` for 'A' with 'adjacent_depth_limit' of 2
and distance of `100`

## Then
It should create
  -1 new node
    - with id 0.0
    - with node_rule_ref=node
    - with position x=100 and y=100
  -2 links to 0.0 for
    - A
    - C
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
