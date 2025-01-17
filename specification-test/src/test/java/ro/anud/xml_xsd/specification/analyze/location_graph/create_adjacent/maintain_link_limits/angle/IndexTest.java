package ro.anud.xml_xsd.specification.analyze.location_graph.create_adjacent.maintain_link_limits.angle;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action should maintain link limits when adding adjacent links based on angle
## Given

## Then
- The adjacent link limits should be maintained by creating
```xml
<node node_rule_ref="plains" id="0.0">
  <position x="2" y="0"/>
</node>
```
from
```xml
<link_group id="0" angle="0" limit="1">
  <to_option node_rule_ref="plains" adjacent_depth_limit="100" distance="1" maxDistance="1" adjacent_distance_max="1"/>
</link_group>
```
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
