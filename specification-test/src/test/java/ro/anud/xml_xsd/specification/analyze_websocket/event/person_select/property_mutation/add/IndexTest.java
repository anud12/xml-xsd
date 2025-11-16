package ro.anud.xml_xsd.specification.analyze_websocket.event.person_select.property_mutation.add;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
#Person selection
##When
- selecting person with
  - `min` value of 1
- apply property_mutation to increase `property` value by 1

- already having item `0`

##It should
modify person `1` by adding property with value 1
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
