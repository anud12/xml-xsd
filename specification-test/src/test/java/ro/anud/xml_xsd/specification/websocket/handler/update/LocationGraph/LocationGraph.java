package ro.anud.xml_xsd.specification.websocket.handler.update.LocationGraph;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.Download;
import ro.anud.xml_xsd.websocket.tests.LoadStep;
import ro.anud.xml_xsd.websocket.tests.ReadUpdates;
import ro.anud.xml_xsd.websocket.tests.StartStop;

import java.util.stream.Stream;

/*description
# websocket update person
## Given
Loading a correct xml
## When

sending a  startStop command

## It should
send xml with updated person

 */

/*tags
  websocket, download
 */
@Execution(ExecutionMode.SAME_THREAD)
public class LocationGraph {

    @TestFactory
    public Stream<DynamicNode> testWebSocketEndpoint() {
        var readUpdates = new ReadUpdates();
        var startStop = new StartStop();
        return TestStrategy.group("run")
            .and(LoadStep.runValidated(this.getClass(),"1_load.xml"))
            .and(readUpdates.connect())
            .and(startStop.send())
            .and(startStop.waitUntilFinished())
            .and(readUpdates.assertResponse(this.getClass(), "2_expected.txt", "2_expected.txt"))
            .and(Download.run(this.getClass(), "3_download.txt"))
            .build();

    }
}
