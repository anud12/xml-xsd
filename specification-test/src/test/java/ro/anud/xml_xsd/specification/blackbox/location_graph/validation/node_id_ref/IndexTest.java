package ro.anud.xml_xsd.specification.blackbox.location_graph.validation.node_id_ref;

import ro.anud.xml_xsd.specification.TestBase;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;

/*description
# `node_id_ref` validation
## Given
A property value of `node_id_ref` that isn't found in
  - `location_graph_rule/node_rule@id`
## Then
It should throw an error.
 */

/*tags
- validation
- node_id_ref
 */

@Execution(ExecutionMode.CONCURRENT)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return TestBase.runTestRelativeToClassWithValidationError(getClass());

    }
}
