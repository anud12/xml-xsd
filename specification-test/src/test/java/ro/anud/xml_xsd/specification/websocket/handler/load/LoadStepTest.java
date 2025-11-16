package ro.anud.xml_xsd.specification.websocket.handler.load;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.WebSocketTestClient;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.WebSocketTestBase;
import ro.anud.xml_xsd.websocket.tests.Download;
import ro.anud.xml_xsd.websocket.tests.LoadStep;
import ro.anud.xml_xsd.websocket.tests.ReadUpdates;
import ro.anud.xml_xsd.websocket.tests.Send;

import java.util.Collection;
import java.util.stream.Stream;

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
public class LoadStepTest {

    @TestFactory
    public Stream<DynamicNode> testWebSocketEndpoint() throws Exception {
//        return WebSocketTestBase.runTestRelativeToClass(getClass(), WebSocketTestClient.Command.Load);
        var readUpdates = new ReadUpdates();
        return TestStrategy.group(this.getClass().getSimpleName())
                .and(Send.run(this.getClass(), WebSocketTestClient.Command.Load, "2_send.txt", "3_main_expected.txt", "3_other_expected.txt"))
                .build();

    }
}
