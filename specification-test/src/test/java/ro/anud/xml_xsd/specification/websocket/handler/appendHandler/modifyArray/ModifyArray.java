package ro.anud.xml_xsd.specification.websocket.handler.appendHandler.modifyArray;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.*;

import java.util.stream.Stream;

/*description
# websocket client updates property
## Given
Loading a correct xml
## When

sending a update command which changes property name to "property_changed"

## It should
update message with changes
download should reflect changed

 */

/*tags
  websocket, download
 */
@Execution(ExecutionMode.SAME_THREAD)
public class ModifyArray {

    @TestFactory
    public Stream<DynamicNode> testWebSocketEndpoint() {
        var readUpdates = new ReadUpdates();
        var startStop = new StartStop();
        return TestStrategy.group("run")
            .and(LoadStep.runValidated(this.getClass(),"1_load.xml"))
            .and(readUpdates.connect())
            .and(PutHandler.runValidated(this.getClass(), "2_payload.txt"))
            .and(startStop.send())
            .and(startStop.waitUntilFinished())
            .and(readUpdates.assertResponse(this.getClass(), "3_updates.txt", "3_updates.txt"))
            .and(Download.run(this.getClass(), "4_download.txt"))
            .and(StopHandler.send())
            .build();

    }
}
