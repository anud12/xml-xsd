package ro.anud.xml_xsd.implementation.util.repository;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public final class NonNullableIndex<Key, Input, Stored> extends AbstractIndex<Key, Input, Stored> {


    protected final Function<Key, Stored> valueSupplier;

    public NonNullableIndex(Class<Input> inputClass, Function<Input, Optional<Key>> getKey, Function<Input, Stored> getValue, Function<Key, Stored> valueClass) {
        super(inputClass, getKey, getValue);
        valueSupplier = valueClass;
    }

    public NonNullableIndex(Class<Input> inputClass,
                            Function<Input, Optional<Key>> getKey,
                            BiFunction<AbstractIndex<Key, Input, Stored>, Input, Stored> getValue,
                            Function<Key, Stored> valueClass) {
        super(inputClass, getKey, getValue);
        valueSupplier = valueClass;
    }

    public Stored get(Key key) {
        return Optional.ofNullable(hashMap.get(key)).orElseGet(() -> valueSupplier.apply(key));
    }
}
