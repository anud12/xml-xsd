package ro.anud.xml_xsd.specification.analyze_websocket.location_graph.validation.node_graph_id_ref;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.HttpTestBase;

import java.util.Collection;

/*description
# `location_graph_id_ref` validation
## Given
A property value of `location_graph_id_ref` that isn't found in
  - 'location_graph@id'
## Then
It should throw an error.
 */

/*tags
- validation
- location_graph_id_ref
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Collection<DynamicTest> test() {
        return HttpTestBase.runTestRelativeToClassWithValidationError(getClass());

    }
}
