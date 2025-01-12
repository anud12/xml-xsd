package ro.anud.xml_xsd.specification.websocket.echo;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ro.anud.xml_xsd.specification.WebSocketTestBase;

import java.util.Collection;

/*description
# websocket echo
## When

sending an echo command

## It should
resend on main client and other client
 */

/*tags
  echo
 */

public class EchoTest {

    @TestFactory
    public Collection<DynamicTest> testWebSocketEndpoint() throws Exception {
        return WebSocketTestBase.runTestRelativeToClass(getClass(), WebSocketTestBase.Command.Echo);

    }
}
