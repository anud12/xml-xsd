package ro.anud.xml_xsd.specification.analyze_websocket.zone_rule.create_zone.with_portal;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
#Zone
##When
- a zone is created using `zone_rule` with portal
##It should
create a new zone and create its starting region according to the rule
also create `to_rule` element into `region` copying the `to` element from rule
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
