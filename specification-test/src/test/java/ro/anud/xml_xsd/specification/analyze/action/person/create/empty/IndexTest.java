package ro.anud.xml_xsd.specification.analyze.action.person.create.empty;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# person.create
## When
person.create action is used with no parameters

## It should
create an empty person
 */

/*tags
  action,person,person.create,
 */


@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClass(getClass());
    }
}
