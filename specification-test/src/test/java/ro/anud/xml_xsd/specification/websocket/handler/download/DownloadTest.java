package ro.anud.xml_xsd.specification.websocket.handler.download;

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

import java.util.Collection;
import java.util.stream.Stream;

/*description
# websocket download
## Given
Loading a correct xml
## When

sending a download command

## It should
send xml with current world state
 */

/*tags
  websocket, download
 */
@Execution(ExecutionMode.SAME_THREAD)
public class DownloadTest {

    @TestFactory
    public Stream<DynamicNode> testWebSocketEndpoint() throws Exception {
        var readUpdates = new ReadUpdates();
        return TestStrategy.group(this.getClass().getSimpleName())
                .and(LoadStep.runValidated(this.getClass(), "1_load.xml"))
                .and(readUpdates.connect())
                .and(Download.run(this.getClass(), "3_main_expected.txt"))
                .and(readUpdates.assertResponse(this.getClass(), "3_other_expected.txt", "3_other_expected.txt"))
                .build();

//        return WebSocketTestBase.runTestRelativeToClass(getClass(), WebSocketTestClient.Command.Download);

    }
}
