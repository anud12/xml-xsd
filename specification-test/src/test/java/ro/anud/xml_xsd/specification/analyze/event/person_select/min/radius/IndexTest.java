package ro.anud.xml_xsd.specification.analyze.event.person_select.min.radius;

import org.junit.jupiter.api.Disabled;
import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Person selection with min values and classification
## When

selecting persons with
  - a `min` value of 3
  - radius of 100
  - property_rule with default value 10

## It should
create 2 people because `0` is within the radius
  - with location x: -16, y: 0
  - with location x: 33, y: 50
 */

/*tags
- person_select
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    @Disabled
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
