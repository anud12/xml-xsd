package ro.anud.xml_xsd.specification.blackbox.classification.item.add.property_exists;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Add classification on item if property exists
## Given
  - classification rule for `property` value equal to 10
  - item with property `property` value 10
## Then
  Item gains classification `classification`.
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
