package ro.anud.xml_xsd.specification.analyze.event.person_select.property_mutation.modify;

import org.junit.jupiter.api.Disabled;
import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Person selection
## When
- selecting person with
  - `min` value of 1
- apply property_mutation to increase `property` value by 1

- already having item `0` with `property` value 1

## It should
modify person `1` property by adding 1 changing it to `2`
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
