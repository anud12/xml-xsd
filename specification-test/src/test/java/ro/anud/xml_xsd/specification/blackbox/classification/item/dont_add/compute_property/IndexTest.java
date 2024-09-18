package ro.anud.xml_xsd.specification.blackbox.classification.item.dont_add.compute_property;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Don't classification on item based on property without item default value
## Given
  - classification rule for `property` value equal to 10
  - property `property` with `item_default` value to 10
## Then
  Item doesn't change
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
