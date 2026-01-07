package ro.anud.xml_xsd.specification.websocket.script;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.*;

import java.util.stream.Stream;

/*description
# operation.echo
## When
counting entities in an entity container

## It should
return 1
 */

/*tags
  action,entity,entity.create,
 */




@Execution(ExecutionMode.SAME_THREAD)
public class ScriptTest {


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
