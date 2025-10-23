package ro.anud.xml_xsd.implementation.util.logging;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.*;

@Getter
@Setter
public class LogScopeCloseable implements AutoCloseable {

    private String methodName = "";
    private String tag = "";
    private Logger logger;
    private Object returnValue = null;

    @Override
    public void close() {
        decreaseIndent();

        String prefix = getIndent() + "┻ " + "[" + methodName + "]: " + " exit: "+ tag;
        if (returnValue != null) {
            prefix += " return: " + returnValue + "";
        }
        absoluteLog(padRight(prefix) + " --- " + getCallerSignature(1));
    }

    void newScope() {
        getCaller();

        String prefix = getIndent() + "┳ " + "[" + methodName + "]: " +  " enter: " + tag ;
        absoluteLog(padRight(prefix) + " --- " + getCallerSignature(2));

        increaseIndent();
    }


    public void log(Object... message) {
        String prefix = getIndent(1) + "┣ " + "[" + methodName + "]: " + tag;

        prefix += Arrays.stream(message)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        absoluteLog(padRight(prefix) + " --- " + getCallerSignature(1));
    }

    private void absoluteLog(String message) {
        if (message == null) {
            logger.info("null");
            return;
        }
        String escaped = message
                .replace("\r\n", "\\n")
                .replace("\r", "\\n")
                .replace("\n", "\\n");
        logger.info(escaped);
    }

    public <T> T logReturn(T value) {
        this.returnValue = value;
        return value;
    }

    public void logTodo(Object... message) {
        String prefix = getIndent(1) + "┣ " + "[" + methodName + "]: " + tag;

        prefix += Arrays.stream(message)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        absoluteLog(padRight(prefix) + " --- " + getCallerSignature(1));
    }

    private void getCaller() {
        var stackSkip = 4;
        StackTraceElement stack = Thread.currentThread().getStackTrace()[stackSkip];
        methodName = stack.getMethodName();
        logger = LoggerFactory.getLogger(stack.getClassName());
    }
}
