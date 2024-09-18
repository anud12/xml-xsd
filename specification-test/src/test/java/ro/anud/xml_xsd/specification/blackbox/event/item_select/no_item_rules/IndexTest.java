package ro.anud.xml_xsd.specification.blackbox.event.item_select.no_item_rules;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Item selection
## When
selecting items with a `min` value of 1 and no item rules

## It should
throw error
 */

/*tags
- item
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClassWithError(getClass());

    }
}
