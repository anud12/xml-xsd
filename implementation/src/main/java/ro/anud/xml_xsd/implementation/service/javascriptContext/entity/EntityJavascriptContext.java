package ro.anud.xml_xsd.implementation.service.javascriptContext.entity;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.PolyglotException;
import ro.anud.xml_xsd.implementation.service.javascriptContext.JavascriptRunner;
import ro.anud.xml_xsd.implementation.service.javascriptContext.mutation.TextMutation;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EntityJavascriptContext {

    private final JavascriptRunner javascriptRunner;

    public EntityJavascriptContext(JavascriptRunner javascriptRunner) {
        this.javascriptRunner = javascriptRunner;
    }

    @HostAccess.Export
    public View getById(String id) {
        return new View(this, id);
    }

    public record View(EntityJavascriptContext entityJavascriptContext, String id) {


        @HostAccess.Export
        public View setText(String name, Function<String, String> mapper) {
            setText(name, mapper, (s, s2) -> s2);
            return this;
        }

        @HostAccess.Export
        public View setText(String name, Function<String, String> mapper, BiFunction<String, String, String> joiner) {
            PolyglotException e = Context.getCurrent().asValue(new RuntimeException()).as(PolyglotException.class);
            entityJavascriptContext.javascriptRunner.executor.add(new TextMutation(
                    e.getPolyglotStackTrace(),
                    id,
                    name,
                    mapper,
                    joiner
            ));
            return this;
        }
    }


}
