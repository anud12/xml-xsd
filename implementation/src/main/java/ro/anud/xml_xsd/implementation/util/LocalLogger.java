package ro.anud.xml_xsd.implementation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.LogClass.IDENT;

public class LocalLogger {
    static Logger logger = LoggerFactory.getLogger(RawNode.class);

    public static class LogClass {
        static String PARENT_DELIMITER = "|>";
        static String IDENT = "│ ";
        static String ARG_SEPARATOR = "  ";
        private List<Object> parentArgs = new ArrayList<>();

        public LogClass() {}

        public LogClass(List parentArgs) {
            this.parentArgs = parentArgs;
        }

        public LogClass log(Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();
            var logLine = logLine(previousStackTrace);

            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + " [ log  ]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }
            print(filterStacktrace, line);
//            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + logLine);
            return new LogClass(argumentsToString(args).toList());
        }

        public LogClass logTodo(Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var logLine = logLine(previousStackTrace);
            var methodName = previousStackTrace.getMethodName();

            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + " [ TODO ]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }
            print(filterStacktrace, line);
//            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + logLine);
            return new LogClass(argumentsToString(args).toList());
        }

        public LogClass logEnter(Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();
            var logLine = logLine(previousStackTrace);


            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + ":"  + " [enter ]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }
            print(filterStacktrace, line);
//            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + logLine);
            return new LogClass(argumentsToString(args).toList());
        }

        public <T> T logReturn(T returnValue, Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var logLine = logLine(previousStackTrace);
            var methodName = previousStackTrace.getMethodName();

            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + " [return]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }

            line.append(ARG_SEPARATOR);
            var returnValueString = Optional.ofNullable(returnValue).map(Objects::toString).orElse("null");
            line.append("value: [" + returnValueString + "]");
            print(filterStacktrace, line);

//            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + ARG_SEPARATOR + "value: [" + returnValueString + "]" + logLine);
            return returnValue;
        }

        public void logReturnVoid(Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();

            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName +  " [return]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            line.append(ARG_SEPARATOR);
            line.append("value: [void]");
            print(filterStacktrace, line );
        }

        private Stream<String> argumentsToString(Object... args) {
            var delimiter = Stream.of(PARENT_DELIMITER);
            if (parentArgs.isEmpty()) {
                delimiter = Stream.empty();
            }
            return Stream.concat(
                parentArgs.stream(),
                Stream.concat(delimiter, Arrays.stream(args))
            ).map(o -> {
                if(Objects.isNull(o)) {
                    return "null";
                }
                return o.toString();
            });
        }
    }


    private static List<StackTraceElement> filterStacktrace(StackTraceElement[] stackTraceElements) {
        return Arrays.stream(stackTraceElements)
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
            .filter(stackTraceElement -> !StringUtils.startsWithIgnoreCase(
                stackTraceElement.getClassName(),
                LogClass.class.getName()))
            .filter(stackTraceElement -> !stackTraceElement.getMethodName().startsWith("lambda$"))
            .toList()
            .reversed();
    }

    private static void print(List<StackTraceElement> filterStacktrace, StringBuilder line) {
        for (var i = 0; i < filterStacktrace.size(); i++) {
            line.insert(0, IDENT);
        }

        var previousStackTrace = filterStacktrace.get(0);
        var logLine = logLine(previousStackTrace);
        logLine = " ".repeat(Math.max(0,100 - line.toString().length())) + logLine;
        line.append(logLine);
        LoggerFactory.getLogger(previousStackTrace.getClassName()).info(line.toString());

    }

    private static String logLine(StackTraceElement previousStackTrace) {
        var className = previousStackTrace.getFileName();
        var lineNumber = previousStackTrace.getLineNumber();
        var logLine = " at " + previousStackTrace.getClassName() + "(" +className + ":" + lineNumber + ")";
        return logLine;
    }

    public static LogClass logEnter(Object... args) {
        return new LogClass().logEnter(args);
    }

    public static <T> T logReturn(T returnValue, Object... args) {
        return new LogClass().logReturn(returnValue, args);
    }

    public static void logReturnVoid(Object... args) {
        new LogClass().logReturnVoid(args);
    }

    public static LogClass log(Object... args) {
        return new LogClass().log(args);
    }
}
