package ro.anud.xml_xsd.implementation.javascriptContext.api;

import lombok.ToString;
import org.graalvm.polyglot.HostAccess;

import java.util.Collection;
import java.util.function.Consumer;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@ToString
public class CollectionJSApi<T> {
    private final T value;

    public CollectionJSApi(T value) {
        this.value = value;
    }

    @HostAccess.Export
    public void forEach(Consumer<T> consumer) {
        try (var scope = logScope()){
            if (value instanceof Collection<?> coll) {
                for (Object element : coll) {
                    @SuppressWarnings("unchecked")
                    T e = (T) element;
                    consumer.accept(e);
                }
            } else {
                @SuppressWarnings("unchecked")
                T single = (T) value;
                consumer.accept(single);
            }
        }
    }
    @HostAccess.Export
    public long count() {
        try (var scope = logScope()){
            if(value == null) {
                return 0;
            }
            if (value instanceof Collection<?> coll) {
                return coll.size();
            } else {
                return 1;
            }
        }
    }
}
