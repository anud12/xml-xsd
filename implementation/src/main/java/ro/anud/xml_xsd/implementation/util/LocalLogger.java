package ro.anud.xml_xsd.implementation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.*;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.LogClass.IDENT;

public class LocalLogger {
    static Logger logger = LoggerFactory.getLogger(RawNode.class);

    private static boolean SKIP_STACK = false;
    private static boolean SKIP_PRINT = false;

    public static class LogClass {
        static String PARENT_DELIMITER = "|>";
        static String IDENT = "│ ";
        static String ARG_SEPARATOR = "  ";
        private StringBuilder parentArgs = new StringBuilder();

        public LogClass() {}

        public LogClass(StringBuilder parentArgs) {
            this.parentArgs = parentArgs;
        }

        public LogClass log(Object... args) {
            if(SKIP_PRINT) {
                return new LogClass();
            }
            var prefix = " [ log  ]";
            if(SKIP_STACK) {
                print(getStringBuilder(prefix, args , List.of()));
                return new LogClass(argumentsToString(args));
            }
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();
            var logLine = logLine(previousStackTrace);

            printWithStack(filterStacktrace, getStringBuilder(methodName + prefix, args , filterStacktrace));
//            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + logLine);
            return new LogClass(argumentsToString(args));
        }

        private StringBuilder getStringBuilder(
            final String methodName,
            final Object[] args,
            final List<StackTraceElement> filterStacktrace) {

            var line = new StringBuilder();
            line.append(methodName);
            line.append(argumentsToString(args));

            for (var i = 0; i < filterStacktrace.size(); i++) {
                line.insert(0, IDENT);
            }
            return line;
        }

        public LogClass logTodo(Object... args) {
            if(SKIP_PRINT) {
                return new LogClass();
            }
            var prefix = " [ TODO ]";
            if(SKIP_STACK) {
                print(getStringBuilder(prefix, args , List.of()));
                return new LogClass(argumentsToString(args));
            }
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var logLine = logLine(previousStackTrace);
            var methodName = previousStackTrace.getMethodName();

            printWithStack(filterStacktrace, getStringBuilder(methodName + prefix, args , filterStacktrace));
//            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + logLine);
            return new LogClass(argumentsToString(args));
        }

        public LogClass logEnter(Object... args) {
            if(SKIP_PRINT) {
                return new LogClass();
            }
            var prefix = " [enter ]";
            if(SKIP_STACK) {
                print(getStringBuilder(prefix, args , List.of()));
                return new LogClass(argumentsToString(args));
            }
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();

            printWithStack(filterStacktrace, getStringBuilder(methodName + prefix, args , filterStacktrace));
//            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + logLine);
            return new LogClass(argumentsToString(args));
        }

        public <T> T logReturn(T returnValue, Object... args) {
            if(SKIP_PRINT) {
                return returnValue;
            }
            var prefix = " [return]";
            if(SKIP_STACK) {
                print(getStringBuilder(prefix, args , List.of()));
                return returnValue;
            }
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var logLine = logLine(previousStackTrace);
            var methodName = previousStackTrace.getMethodName();
            var line = getStringBuilder(methodName + prefix, args , filterStacktrace);
            var returnValueString = Optional.ofNullable(returnValue).map(Objects::toString).orElse("null");
            line.append("value: [" + returnValueString + "]");

            printWithStack(filterStacktrace, line);

//            LoggerFactory.getLogger(previousStackTrace.getClassName()).info(String.valueOf(line) + ARG_SEPARATOR + "value: [" + returnValueString + "]" + logLine);
            return returnValue;
        }

        public void logReturnVoid(Object... args) {
            if(SKIP_PRINT) {
                return;
            }
            var prefix = " [return]";
            if(SKIP_STACK) {
                print(getStringBuilder(prefix, args , List.of()));
                return;
            }
            var stackTrace = Thread.currentThread().getStackTrace();
            var filterStacktrace = filterStacktrace(stackTrace);

            var previousStackTrace = filterStacktrace.get(0);
            var methodName = previousStackTrace.getMethodName();

            StringBuilder line = getStringBuilder(methodName +  prefix, args , filterStacktrace);
            line.append(ARG_SEPARATOR);
            line.append("value: [void]");
            printWithStack(filterStacktrace, line );
        }

        private StringBuilder argumentsToString(Object... args) {
            var builder = new StringBuilder()
                .append(parentArgs)
                .append(PARENT_DELIMITER);

            for (int i = 0; i < args.length; i++) {
                builder.append(args[i]);
                if(i < args.length -1) {
                    builder.append(ARG_SEPARATOR);
                }
            }
            return builder;
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

    private static void print(StringBuilder line) {
        LoggerFactory.getLogger(LocalLogger.class).info(line.toString());

    }

    private static void printWithStack(List<StackTraceElement> filterStacktrace, StringBuilder line) {
        for (var i = 0; i < filterStacktrace.size(); i++) {
            line.insert(0, IDENT);
        }

        var previousStackTrace = filterStacktrace.get(0);
        var logLine = logLine(previousStackTrace);
        line.append(logLine);
        LoggerFactory.getLogger(previousStackTrace.getClassName()).info(line.toString());

    }

    private static StringBuilder logLine(StackTraceElement previousStackTrace) {
        var className = previousStackTrace.getFileName();
        var lineNumber = previousStackTrace.getLineNumber();
        var logLine = new StringBuilder()
            .append(" ---  at ")
            .append(previousStackTrace.getClassName())
            .append("(")
            .append(className)
            .append(":")
            .append(lineNumber)
            .append(")");
//        var logLine = " ---  at " + previousStackTrace.getClassName() + "(" +className + ":" + lineNumber + ")";
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
