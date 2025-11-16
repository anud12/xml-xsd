package ro.anud.xml_xsd.specification.analyze_websocket.location_graph.create_adjacent.existing_person.apply_classification.property.person_default;

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
# `location_graph.node.create_adjacent` action with `existing_person` containing classification selection
## Given

- classification includes property `property_rule_id`
    - with `greaterThan` set to 1
- property `property_rule_id` includes `default_person`


## Then
It should create persons with the given classification set
- have `property_rule_id` set to 10
 */

/*tags
- location_graph
- location_graph.node.create_adjacent
- classification
- existing_person
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public List<DynamicNode> test() {
        return AnalyzeTest.runTestRelativeToClass(getClass()).build().toList();
    }
}
