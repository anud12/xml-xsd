package ro.anud.xml_xsd.specification.websocket.load.invalid;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.LoadStep;
import ro.anud.xml_xsd.websocket.tests.ReadFromFileStep;

import java.util.stream.Stream;

/*description
# websocket load
## When

sending an load command with correct xml

## It should
return ok
 */

/*tags
  websocket, load
 */

@Execution(ExecutionMode.SAME_THREAD)
public class LoadStepTest {

    @TestFactory
    public Stream<DynamicNode> testWebSocketEndpoint() throws Exception {

        return TestStrategy.list()
            .and(LoadStep.run(this.getClass(), "1_send.xml"))
            .and(ReadFromFileStep.wrap(this.getClass(),"2_main_expected.txt"))
            .and(
                "assert", response -> {
                    Assertions.assertThat(response.parent()).isEqualTo(response.fileString());
                })
            .build();

    }
}
