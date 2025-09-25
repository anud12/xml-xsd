package ro.anud.xml_xsd.implementation.util.logging;

import java.util.concurrent.Callable;

public class ContextAwareTask {
    public static Runnable wrap(Runnable task) {
        int callerIndent = LogScope.getIndentLevel();
        return () -> {
            int original = LogScope.getIndentLevel();
            try {
                LogScope.setIndent(callerIndent);
                task.run();
            } finally {
                LogScope.setIndent(original);
            }
        };
    }

    public static <V> Callable<V> wrap(Callable<V> task) {
        int callerIndent = LogScope.getIndentLevel();
        return () -> {
            int original = LogScope.getIndentLevel();
            try {
                LogScope.setIndent(callerIndent);
                return task.call();
            } finally {
                LogScope.setIndent(original);
            }
        };
    }
}
