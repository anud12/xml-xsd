package ro.anud.xml_xsd.specification.analyze_websocket.zone_rule.append_region.different_rotation.from_rotation_inverted.from_left_portal.to_left_portal.wider_even_portal;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
#Append region from left portal to target left portal with even portal width
##When
- origin region is rotated inverted
- an append region rule is applied to a zone
- width is increased from 1 to 2
##It should
it should append a region to the zone at the position (y - 1) more

```
 */

/*tags
- zone
- region
- creation
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
