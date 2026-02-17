package ro.anud.xml_xsd.implementation.util.repository;

import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public sealed class AbstractIndex <Key, Input, Stored> permits NonNullableIndex, NullableIndex {
    protected final Function<Input, Optional<Key>> getKey;
    protected final BiFunction<AbstractIndex<Key, Input, Stored>, Input, Stored> getValue;
    protected final Class<Input> inputClass;

    protected final HashMap<Key, Stored> hashMap = new HashMap<>();

    public AbstractIndex(Class<Input> inputClass, Function<Input, Optional<Key>> getKey, Function<Input, Stored> getValue) {
        this.getKey = getKey;
        this.getValue = (keyInputStoredIndexMapped, input) -> getValue.apply(input);
        this.inputClass = inputClass;
    }
    public AbstractIndex(Class<Input> inputClass, Function<Input, Optional<Key>> getKey, BiFunction<AbstractIndex<Key, Input, Stored>, Input, Stored> getValue) {
        this.getKey = getKey;
        this.getValue = getValue;
        this.inputClass = inputClass;
    }

    public void set(Input input) {
        getKey.apply(input).ifPresent(key -> hashMap.put(key, getValue.apply(this, input)));
    }

    public void clear() {
        hashMap.clear();
    }

    public <ChildKey, ChildInput, ChildStored, ChildIndex extends AbstractIndex<ChildKey, ChildInput, ChildStored>> NonNullableIndex<Key, Input, ChildIndex> compose(
            Supplier<ChildIndex> indexMapped,
            Function<Input, Stream<ChildInput>> inputInputValueFunction
    ) {

        return new NonNullableIndex<Key, Input, ChildIndex>(inputClass, getKey, (index, input) -> {
            ChildIndex childIndex = indexMapped.get();
            inputInputValueFunction.apply(input).forEach(childIndex::set);
            return childIndex;
        }, key -> indexMapped.get());
    }

    public static <Key, Value> NonNullableIndex<Key, Value, Value> of(Class<Value> inputClass,Function<Value, Key> function, Function<Key, Value> valueSupplier) {
        return new NonNullableIndex<Key, Value, Value>(
                inputClass,
                value -> Optional.of(function.apply(value)),
                Function.identity(),
                valueSupplier
        );
    }

    public static <Key, Value> NonNullableIndex<Key, Value, Value> ofOptional(Class<Value> inputClass, Function<Value, Optional<Key>> function, Function<Key, Value> valueSupplier) {
        return new NonNullableIndex<Key, Value, Value>(
                inputClass,
                function,
                Function.identity(),
                valueSupplier
        );
    }

    public static <Key, Value> NullableIndex<Key, Value, Value> ofNullable(Class<Value> clazz, Function<Value, Key> function) {
        return new NullableIndex<>(clazz, value -> Optional.of(function.apply(value)), Function.identity());
    }

    public static <Key, Value> NullableIndex<Key, Value, Value> ofNullableOptional(Class<Value> clazz, Function<Value, Optional<Key>> function) {
        return new NullableIndex<>(clazz, function, Function.identity());
    }


    public void reIndex(List<Input> valueList) {
        clear();
        valueList.forEach(value -> {
            getKey.apply(value).ifPresent(key -> hashMap.put(key, getValue.apply(this, value)));
        });
    }


    public void addListeners(WorldStepInstance worldStepInstance) {
        worldStepInstance.getWorldStep().get().onChange((origin, worldStep) -> {
            if(inputClass.isAssignableFrom(origin.getClass())) {
                this.set((Input) origin);
            }
        });
        worldStepInstance.getWorldStep().get().onRemove((origin, worldStep) -> {
            if(inputClass.isAssignableFrom(origin.getClass())) {
                this.set((Input) origin);
            }
        });
    }
}
