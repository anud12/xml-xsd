package ro.anud.xml_xsd.specification.websocket.handler.echo;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.WebSocketTestClient;
import ro.anud.xml_xsd.websocket.WebSocketTestBase;

import java.util.Collection;

/*description
# websocket echo
## When

sending an echo command

## It should
resend on main client and other client
 */

/*tags
  websocket, echo
 */

@Execution(ExecutionMode.SAME_THREAD)
public class EchoTest {

    @TestFactory
    public Collection<DynamicTest> testWebSocketEndpoint() throws Exception {
        return WebSocketTestBase.runTestRelativeToClass(getClass(), WebSocketTestClient.Command.Echo);

    }
}
