package ro.anud.xml_xsd.implementation.util.repository;

import java.util.Optional;
import java.util.function.Function;

public final class NullableIndex<Key, Input, Stored> extends AbstractIndex<Key, Input, Stored>{


    public NullableIndex(Class<Input> inputClass, Function<Input, Optional<Key>> getKey, Function<Input, Stored> getValue) {
        super(inputClass, getKey, getValue);
    }

    public Optional<Stored> get(Key key) {
        return Optional.ofNullable(hashMap.get(key));
    }
}
