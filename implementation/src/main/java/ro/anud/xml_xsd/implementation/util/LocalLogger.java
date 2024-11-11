package ro.anud.xml_xsd.implementation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Stream;

public class LocalLogger {
    static Logger logger = LoggerFactory.getLogger(RawNode.class);

    public static class LogClass {
        static String PARENT_DELIMITER = "|>";
        static String IDENT = "│ ";
        static String ARG_SEPARATOR = "\t";
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
            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + " [ log  ]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }
            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line));
            return new LogClass(argumentsToString(args).toList());
        }

        public LogClass logTodo(Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();

            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + " [ TODO ]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }
            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line));
            return new LogClass(argumentsToString(args).toList());
        }

        public LogClass logEnter(Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();
            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + " [enter ]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }

            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line));
            return new LogClass(argumentsToString(args).toList());
        }

        public <T> T logReturn(T returnValue, Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();
            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + " [return]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }
            var returnValueString = Optional.ofNullable(returnValue).map(Objects::toString).orElse("null");
            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + ARG_SEPARATOR + "value: [" + returnValueString + "]");
            return returnValue;
        }

        public void logReturnVoid(Object... args) {
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();
            StringBuilder line = new StringBuilder(argumentsToString(args).reduce(
                methodName + " [return]",
                (string, o) -> string + ARG_SEPARATOR + o,
                (string, string2) -> string + string2
            ));
            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }
            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + ARG_SEPARATOR + "value: [void]");
        }

        private Stream<String> argumentsToString(Object... args) {
            var delimiter = Stream.of(PARENT_DELIMITER);
            if (parentArgs.isEmpty()) {
                delimiter = Stream.empty();
            }
            return Stream.concat(
                parentArgs.stream(),
                Stream.concat(delimiter, Arrays.stream(args))
            ).map(Object::toString);
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
