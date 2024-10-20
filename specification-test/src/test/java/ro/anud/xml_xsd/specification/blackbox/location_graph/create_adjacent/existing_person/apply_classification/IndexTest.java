package ro.anud.xml_xsd.specification.blackbox.location_graph.create_adjacent.existing_person.apply_classification;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.TestBase;

import java.util.Collection;

/*description
# `location_graph.node.create_adjacent` action with `existing_person` containing classification selection
## Given

## Then
It should create persons with the given classification set
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
- classification
- existing_person
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
