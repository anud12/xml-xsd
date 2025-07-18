package ro.anud.xml_xsd.specification.analyze_websocket.zone_rule.append_region.from_position.from_top;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
#Append region from right side
##When
- an append region rule is applied to a zone
- without offset
- from bottom side portal
- with left side portal
##It should
it should append a region to the zone at the position y:10 and x:9
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
