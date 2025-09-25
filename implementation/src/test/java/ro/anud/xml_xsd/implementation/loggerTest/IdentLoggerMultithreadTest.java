package ro.anud.xml_xsd.implementation.loggerTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ro.anud.xml_xsd.implementation.util.logging.LogScope;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@SpringBootTest(classes = IdentLoggerMultithreadTest.class)
public class IdentLoggerMultithreadTest {

    @Test
    void testIdentLoggerWithMixedStackSizes() throws InterruptedException {
        Runnable deepStack = () -> {
            try (LogScope scope = LogScope.logScope()) {
                level1();
            }
        };

        Runnable shallowStack = () -> {
            try (LogScope scope = logScope()) {
                scope.log("Shallow stack thread");
            }
        };

        Thread thread1 = new Thread(deepStack, "DeepStackThread");
        Thread thread2 = new Thread(shallowStack, "ShallowStackThread");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        // Optionally, assert log output if capturing System.out
    }

    private static void level1() {
        try (LogScope scope = logScope()) {
            level2();
        }
    }

    private static void level2() {
        try (LogScope scope = logScope()) {
            level3();
        }
    }

    private static void level3() {
        try (LogScope scope = logScope()) {
            scope.log("Deep stack thread at level 3");
        }
    }
}
