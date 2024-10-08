package ro.anud.xml_xsd.specification.blackbox.event.person_select.min.no_people;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# Person selection with min values and no peoples
## When

selecting persons with
  - a `min` value of 2

## It should
create 2 people with races chosen at random
  - race
  - second_race
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
