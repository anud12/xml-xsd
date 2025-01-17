package ro.anud.xml_xsd.specification.analyze.location_graph.validation.node_rule_ref;

import ro.anud.xml_xsd.specification.HttpTestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `node_rule_ref` validation
## Given
A property value of `node_rule_ref` that isn't found in
  - `location_graph_rule/node_rule@id`
## Then
It should throw an error.
 */

/*tags
- validation
- node_rule_ref
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClassWithValidationError(getClass());

    }
}
