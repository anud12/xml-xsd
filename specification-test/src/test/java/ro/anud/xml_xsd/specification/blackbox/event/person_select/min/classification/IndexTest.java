package ro.anud.xml_xsd.specification.blackbox.event.person_select.min.classification;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

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

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
