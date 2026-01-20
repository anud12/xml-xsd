package ro.anud.xml_xsd.specification.websocket.script.replaceFile;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.*;

import java.util.stream.Stream;

/*description
# script ReplaceFileTest
## When
- loading a script
- and executing it
- load a new version of a script with the same filename
- and executing it on server tick
## It should
first execute the first version
and on second execution it should execute the second version
 */

/*tags
 script, modules
 */



@Execution(ExecutionMode.SAME_THREAD)
public class ReplaceFileTest {


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
                .and(LoadStep.runValidated(this.getClass(),"2_load.xml"))
                .and(startStop.send())
                .and(startStop.waitUntilFinished())
                .and(readDebug.assertResponse(this.getClass(), "3_debug.txt", "3_debug.txt"))
                .build();
    }
}
