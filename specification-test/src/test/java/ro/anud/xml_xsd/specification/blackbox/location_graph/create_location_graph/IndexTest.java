package ro.anud.xml_xsd.specification.blackbox.location_graph.create_location_graph;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `create_location_graph` action
## Given
create_location_graph with attribute `location_graph_rule_ref` set to "location_graph_rule_id"
## Then
It should create a new location graph starting from `setup > starting node` rule
 */

/*tags
- location_graph
- location_graph.create
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClass(getClass());
    }
}
