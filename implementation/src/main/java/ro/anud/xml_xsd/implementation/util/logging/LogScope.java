package ro.anud.xml_xsd.implementation.util.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LogScope implements AutoCloseable {

    private static final ThreadLocal<Integer> indentLevel = ThreadLocal.withInitial(() -> 0);
    private String methodName = "";
    private final String tag = "";
    private Logger logger;
    public static int PAD_TO = 80;


    private Object returnValue = null;

    private static String getCallerSignature(int skip) {
//         [0] is getStackTrace, [1] is this method, [2] is caller, etc.
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int index = 2 + skip;
        StackTraceElement elem = stack[index];
        return "at " + elem.getClassName() + "." + elem.getMethodName() +
                "(" + elem.getFileName() + ":" + elem.getLineNumber() + ")";
    }

    public static int getIndentLevel() {
        return indentLevel.get();
    }

    public static void setIndent(final int callerIndent) {
        indentLevel.set(callerIndent);
    }

    private static String getIndent(int skip) {
        return "| ".repeat(getIndentLevel() - skip);
    }

    private static String getIndent() {
        return getIndent(0);
    }

    private static String padRight(String s) {
        return String.format("%-" + PAD_TO + "s", s);
    }

    public static LogScope logScope() {
        return new LogScope("");
    }

    public static LogScope logScope(Object... tag) {
        return new LogScope(Arrays.stream(tag)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "- ", " - ")));
    }

    public void log(Object... message) {
        String prefix = getIndent(1) + "┣ " + "[" + methodName + "]: " + tag;

        prefix += Arrays.stream(message)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        absoluteLog(padRight(prefix) + " --- " + getCallerSignature(1));
    }

    private void absoluteLog(String message) {
        logger.info(message);
    }

    static void increaseIndent() {
        indentLevel.set(getIndentLevel() + 1);
    }

    static void decreaseIndent() {
        indentLevel.set(Math.max(0, getIndentLevel() - 1));
    }

    public <T> T logReturn(T value) {
        this.returnValue = value;
        return value;
    }

    private LogScope(final String tag) {
        getCaller();

        String prefix = getIndent() + "┳ " + "[" + methodName + "]: " + tag + "enter";
        absoluteLog(padRight(prefix) + " --- " + getCallerSignature(2));

        increaseIndent();
    }

    @Override
    public void close() {
        decreaseIndent();

        String prefix = getIndent() + "┻ " + "[" + methodName + "]: "+ tag +  "exit";
        if (returnValue != null) {
            prefix += " return: " + returnValue + "";
        }
        absoluteLog(padRight(prefix) + " --- " + getCallerSignature(1));
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
