package ro.anud.xml_xsd.specification.websocket.download;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.specification.WebSocketTestBase;

import java.util.Collection;

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
    public Collection<DynamicTest> testWebSocketEndpoint() throws Exception {
        return WebSocketTestBase.runTestRelativeToClass(getClass(), WebSocketTestBase.Command.Download);

    }
}
