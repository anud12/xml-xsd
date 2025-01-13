package ro.anud.xml_xsd.specification.analyze.event.person_select.min.property.min;

import org.junit.jupiter.api.Disabled;
import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Person selection with min values and property minimum
## When
selecting persons with
  - property has default person value of 10
  - a `min` value of 3
  - property `property` with max value of random from 0 and 5

## It should
- compute `property` value for person `0` using default value 10
- create 3 people (because person `0` value is greater than 5) with `property` value between 0 and 5
  - 2
  - 3
  - 1
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
