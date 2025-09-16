package ro.anud.xml_xsd.specification.analyze_websocket.zone_rule.append_region.different_rotation.from_rotation_counterclockwise.from_bottom_portal.to_bottom_portal;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
#Append region from bottom portal to target bottom portal
##When
- origin region is rotated counterclockwise
- an append region rule is applied to a zone
##It should
it should append a region to the zone at the position
 */

/*tags
- zone
- region
- creation
 */

@Execution(ExecutionMode.SAME_THREAD)
public class      IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
