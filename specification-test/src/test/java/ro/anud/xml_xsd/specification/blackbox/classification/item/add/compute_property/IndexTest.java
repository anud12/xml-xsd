package ro.anud.xml_xsd.specification.blackbox.classification.item.add.compute_property;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Add classification on item based on property with default item value
## Given
  - classification rule for `property` value equal to 10
  - property `property` with `item_default` value to 10
## Then
  Item gains
    - classification `classification`.
    - property `property` with value 10
 */

/*tags
- item
- classification
- property
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}