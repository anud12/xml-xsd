package ro.anud.xml_xsd.implementation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class LocalLogger {
    static Logger logger = LoggerFactory.getLogger(RawNode.class);

    private static long depthLevel(StackTraceElement[] stackTraceElements) {
        var depthLevel = Arrays.stream(stackTraceElements)
                .toList()
                .reversed()
                .stream()
                .filter(stackTraceElement -> StringUtils.startsWithIgnoreCase(
                        stackTraceElement.getClassName(),
                        "ro.anud.xml_xsd.implementation")
                )
                .filter(stackTraceElement -> !StringUtils.startsWithIgnoreCase(
                        stackTraceElement.getClassName(),
                        LocalLogger.class.getName()))
                .count();

        return depthLevel;
    }

    public static void logEnter(Object... args) {
        var stackTrace = Thread.currentThread().getStackTrace();
        var depthLevel = depthLevel(stackTrace);

        var previousStackTrace = stackTrace[2];
        var methodName = previousStackTrace.getMethodName();
        StringBuilder line = new StringBuilder(Arrays.stream(args).reduce(
                methodName + "[enter ]:",
                (string, o) -> string + " " + o,
                (string, string2) -> string + string2
        ));
        for (var i = 0; i < depthLevel; i++) {
            line.insert(0, "\t");
        }

        LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line));
    }

    public static <T>T logReturn(T returnValue, Object... args) {
        var stackTrace = Thread.currentThread().getStackTrace();
        var depthLevel = depthLevel(stackTrace);

        var previousStackTrace = stackTrace[2];
        var methodName = previousStackTrace.getMethodName();
        StringBuilder line = new StringBuilder(Arrays.stream(args).reduce(
                methodName + "[return]:",
                (string, o) -> string + " " + o,
                (string, string2) -> string + string2
        ));
        for (var i = 0; i < depthLevel; i++) {
            line.insert(0, "\t");
        }
        LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + ", value: [" + returnValue.toString() + "]");
        return returnValue;
    }

    public static void logReturnVoid(Object... args) {

        var stackTrace = Thread.currentThread().getStackTrace();
        var depthLevel = depthLevel(stackTrace);

        var previousStackTrace = stackTrace[2];
        var methodName = previousStackTrace.getMethodName();
        StringBuilder line = new StringBuilder(Arrays.stream(args).reduce(
                methodName + "[return]:",
                (string, o) -> string + " " + o,
                (string, string2) -> string + string2
        ));
        for (var i = 0; i < depthLevel; i++) {
            line.insert(0, "\t");
        }
        LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + ", value: [void]");
    }

    public static void log(Object... args) {

        var stackTrace = Thread.currentThread().getStackTrace();
        var depthLevel = depthLevel(stackTrace);

        var previousStackTrace = stackTrace[2];
        var methodName = previousStackTrace.getMethodName();
        StringBuilder line = new StringBuilder(Arrays.stream(args).reduce(
                methodName + "[ log  ]: ",
                (string, o) -> string + " " + o,
                (string, string2) -> string + string2
        ));
        for (var i = 0; i < depthLevel; i++) {
            line.insert(0, "\t");
        }
        LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line));
    }
}
