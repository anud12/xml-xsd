package ro.anud.xml_xsd.specification.analyze.event.person_select.min.race;

import org.junit.jupiter.api.Disabled;
import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Person selection with min values and race
## When

selecting persons with
  - a `min` value of 2
  - race `race`

## It should
create 2 people with race `race`
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
