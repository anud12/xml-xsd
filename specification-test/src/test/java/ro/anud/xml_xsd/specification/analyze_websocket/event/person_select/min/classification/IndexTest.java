package ro.anud.xml_xsd.specification.analyze_websocket.event.person_select.min.classification;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# Person selection with min values and classification
## When

selecting persons with
  - a `min` value of 2
  - classification `classification` using a random value between 1 and 4
  - property_rule with default value 10

## It should
create 2 people
  - with property 2
  - with property 1
 */

/*tags
- person_select
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    @Disabled
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
