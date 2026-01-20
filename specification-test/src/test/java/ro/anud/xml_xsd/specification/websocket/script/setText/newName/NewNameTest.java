package ro.anud.xml_xsd.specification.websocket.script.setText.newName;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.*;

import java.util.stream.Stream;

/*description
# script setText
## When
setting a text on server tick
and executing 2 times

## It should
set the name value to `first with second and third with second and third`
by appending 2 times ` with second and third`
 */

/*tags
  action,entity,entity.create,
 */




@Execution(ExecutionMode.SAME_THREAD)
public class NewNameTest {


    @TestFactory
    public Stream<DynamicNode> test() {
        var readDebug = new ReadDebug();
        var readUpdates = new ReadUpdates();
        var startStop = new StartStop();
        return TestStrategy.group("run")
                .and(LoadStep.runValidated(this.getClass(),"1_load.xml"))
                .and(readDebug.connect())
                .and(readUpdates.connect())
                .and(startStop.send())
                .and(startStop.waitUntilFinished())
                .and(startStop.send())
                .and(startStop.waitUntilFinished())
                .and(readDebug.assertResponse(this.getClass(), "2_debug.txt", "2_debug.txt"))
                .and(readUpdates.assertResponse(this.getClass(), "2_update.txt", "2_update.txt"))
                .and(Download.assertXml(this.getClass(), "3_download.xml"))
                .build();
    }
}
