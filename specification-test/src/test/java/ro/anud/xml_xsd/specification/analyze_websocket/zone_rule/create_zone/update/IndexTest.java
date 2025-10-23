package ro.anud.xml_xsd.specification.analyze_websocket.zone_rule.create_zone.update;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.LoadStep;
import ro.anud.xml_xsd.websocket.tests.ReadUpdates;
import ro.anud.xml_xsd.websocket.tests.StartStop;

import java.util.stream.Stream;

/*description
#Zone
##When
- world_step contains only rule_group for zone
- a `create zone` action to create a zone

##It should
- create the given zone and all of its parent nodes.
- send the modified nodes including the new zone to clients
 */

/*tags
- zone
- region
- creation
 */

@Execution(ExecutionMode.SAME_THREAD)
public class IndexTest {

    @TestFactory
    public Stream<DynamicNode> test() {
        var readUpdates = new ReadUpdates();
        var startStop = new StartStop();
        return TestStrategy.group("run")
                .and(LoadStep.runValidated(this.getClass(),"1_load.xml"))
                .and(readUpdates.connect())
                .and(startStop.send())
                .and(startStop.waitUntilFinished())
                .and(readUpdates.assertResponse(this.getClass(), "4_updates.txt", "4_updates.txt"))
//                .and(Download.run(this.getClass(), "5_download.txt"))
//                .and(StopHandler.send())
                .build();
    }
}
