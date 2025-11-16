package ro.anud.xml_xsd.specification.analyze_websocket.location_graph.create_location_graph;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;
import ro.anud.xml_xsd.websocket.tests.AnalyzeTest;

import java.util.Collection;
import java.util.List;

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

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
