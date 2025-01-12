package ro.anud.xml_xsd.specification.analyze.event.person_select.min.reuse_person;

import org.junit.jupiter.api.Disabled;
import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
#Person selection with min values and no peoples
##When

selecting persons with
  - a `min` value of 2

##It should
create 1 people at location x: 0, y: 0
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
