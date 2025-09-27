package ro.anud.xml_xsd.implementation.util.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LogScope implements AutoCloseable {

    private static final ThreadLocal<Integer> indentLevel = ThreadLocal.withInitial(() -> 0);
    private static final ThreadLocal<Map<Integer, LogScopeCloseable>> closeableMap = ThreadLocal.withInitial(HashMap::new);
    private String methodName = "";
    private final String tag = "";
    private Logger logger;
    private static LogScopeCloseable instance = new LogScopeCloseable();
    public static int PAD_TO = 80;


    private Object returnValue = null;

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

    public <T> T logReturn(T value) {
        this.returnValue = value;
        return value;
    }

    private LogScope() {
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



    static String getCallerSignature(int skip) {
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

    static String getIndent(int skip) {
        return "| ".repeat(getIndentLevel() - skip);
    }

    static String getIndent() {
        return getIndent(0);
    }

    static String padRight(String s) {
        return String.format("%-" + PAD_TO + "s", s);
    }

    public static LogScopeCloseable logScope() {
        var scope = closeableMap.get().getOrDefault(getIndentLevel(), new LogScopeCloseable());
        scope.newScope();
        scope.setTag("");
        return scope;
    }

    public static LogScopeCloseable logScope(Object... tag) {
//        return new LogScope(Arrays.stream(tag)
//                .map(Object::toString)
//                .collect(Collectors.joining(", ", "- ", " - ")));
        var scope = closeableMap.get().getOrDefault(getIndentLevel(), new LogScopeCloseable());
        scope.newScope();
        scope.setTag(Arrays.stream(tag)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "- ", " - ")));
        return scope;
    }



    static void increaseIndent() {
        indentLevel.set(getIndentLevel() + 1);
    }

    static void decreaseIndent() {
        indentLevel.set(Math.max(0, getIndentLevel() - 1));
    }
}
