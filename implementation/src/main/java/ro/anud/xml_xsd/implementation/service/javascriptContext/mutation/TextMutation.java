package ro.anud.xml_xsd.implementation.service.javascriptContext.mutation;

import java.util.function.BiFunction;
import java.util.function.Function;

public record TextMutation(
        Iterable<org.graalvm.polyglot.PolyglotException.StackFrame> stackFrame,
        String entityId,
        String name,
        Function<String, String> mapper,
        BiFunction<String, String, String> joiner
) implements Mutation {
}
