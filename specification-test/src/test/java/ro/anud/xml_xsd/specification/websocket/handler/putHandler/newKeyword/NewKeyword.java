package ro.anud.xml_xsd.specification.websocket.handler.putHandler.newKeyword;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.*;

import java.util.stream.Stream;

/*description
# websocket client updates property using "new" string as index
## Given
Loading a correct xml
## When

sending a update command which changes property name to "property_changed" at index "new"

## It should
update should specify that item at position 2 was updated (created)
download should reflect changed

 */

/*tags
  websocket, download
 */
@Execution(ExecutionMode.SAME_THREAD)
public class NewKeyword {
    @Disabled
    @TestFactory
    public Stream<DynamicNode> testWebSocketEndpoint() {
        var readUpdates = new ReadUpdates();
        return TestStrategy.group("run")
            .and(LoadStep.runValidated(this.getClass(),"1_load.xml"))
            .and(readUpdates.connect())
            .and(StartHandler.send())
            .and(PutHandler.runValidated(this.getClass(), "2_update.txt"))
            .and(readUpdates.assertResponse(this.getClass(), "3_expected.txt", "3_expected.txt"))
            .and(Download.run(this.getClass(), "4_download.txt"))
            .and(StopHandler.send())
            .build();

    }
}
