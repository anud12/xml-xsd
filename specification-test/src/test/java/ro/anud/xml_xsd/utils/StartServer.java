package ro.anud.xml_xsd.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ro.anud.xml_xsd.strategy.TestStrategy;
import ro.anud.xml_xsd.websocket.tests.ReadUpdates;
import ro.anud.xml_xsd.websocket.tests.StartHandler;

import java.util.stream.Stream;

@Execution(ExecutionMode.SAME_THREAD)
@Disabled
public class StartServer {
    @TestFactory
    public Stream<DynamicNode> test() {
        return TestStrategy.group("run")
//                .and(LoadStep.runValidated(this.getClass(),"1_load.xml"))
//                .and(readUpdates.connect())
                .and(StartHandler.send())
//                .and(AppendHandler.runValidated(this.getClass(), "2_payload.txt", "3_response.txt"))
//                .and(readUpdates.assertResponse(this.getClass(), "4_updates.txt", "4_updates.txt"))
//                .and(Download.run(this.getClass(), "5_download.txt"))
//                .and(StopHandler.send())
                .build();
    }
}
