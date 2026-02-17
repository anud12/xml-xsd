package ro.anud.xml_xsd.specification.websocket.entity.setText;

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
# entity.setText
## When
entity.setText action is used on entity with an empty value

## It should
create that value
 */

/*tags
  action,entity,entity.setText,
 */




@Execution(ExecutionMode.SAME_THREAD)
public class SetTextTest {
    @TestFactory
    public Stream<DynamicNode> test() {var readUpdates = new ReadUpdates();
        var startStop = new StartStop();
        return TestStrategy.group("run")
                .and(LoadStep.runValidated(this.getClass(),"1_load.xml"))
                .and(readUpdates.connect())
                .and(startStop.send())
                .and(startStop.waitUntilFinished())
                .and(readUpdates.assertResponse(this.getClass(), "2_update.txt", "2_update.txt"))
                .and(Download.assertXml(this.getClass(), "3_download.xml"))
                .build();
    }
}
