package ro.anud.xml_xsd.specification.blackbox.location_graph.create_adjacent.existing_person.property_selection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.TestBase;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action with `existing_person` containing `property` selection
## Given

- property selection with `min` and `max` value

## Then
It should create persons with a random property value between `min` and `max`
    - 0.1 has `2`
    - 0.2 has `1`
    - 0.3 has `1`
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
- classification
- property
- existing_person
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
