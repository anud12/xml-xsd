package ro.anud.xml_xsd.specification.blackbox.event.item_select.property_mutation.modify;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Item selection
## When
- selecting items with
  - `min` value of 1
- apply property_mutation to increase `property` value by 1

- already having item `0` with `property` value 1

## It should
modify item `0` property by adding 1 changing it to `2`
 */

/*tags
- item
- property_mutation
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}