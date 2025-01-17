package ro.anud.xml_xsd.specification.websocket.load;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.WebSocketTestBase;

import java.util.Collection;

/*description
# websocket load
## When

sending an load command with correct xml

## It should
return ok
 */

/*tags
  websocket, load
 */

@Execution(ExecutionMode.SAME_THREAD)
public class LoadTest {

    @TestFactory
    public Collection<DynamicTest> testWebSocketEndpoint() throws Exception {
        return WebSocketTestBase.runTestRelativeToClass(getClass(), WebSocketTestBase.Command.Load);

    }
}
