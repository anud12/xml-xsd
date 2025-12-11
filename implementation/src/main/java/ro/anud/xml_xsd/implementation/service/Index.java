package ro.anud.xml_xsd.implementation.service;

import ro.anud.xml_xsd.implementation.util.LinkedNode;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class Index<T, U extends LinkedNode> {

    protected Index(Class<U> clazz) {
        this.clazz = clazz;
    }

    public static <T,U extends LinkedNode> Index<T,U> of(Class<U> clazz, Function<U, T> function) {
        return new Index<>(clazz) {
            @Override
            protected Optional<T> getKey(U u) {
                return Optional.of(function.apply(u));
            }
        };
    }

    public static <T,U extends LinkedNode> Index<T,U> ofOptional(Class<U> clazz, Function<U, Optional<T>> function) {
        return new Index<>(clazz) {
            @Override
            protected Optional<T> getKey(U u) {
                return function.apply(u);
            }
        };
    }

    protected abstract Optional<T> getKey(U u);

    private final HashMap<T, U> hashMap = new HashMap<>();
    private final Class<U> clazz;

    public void addListeners(WorldStepInstance worldStepInstance) {
        worldStepInstance.getWorldStep().get().onChange((origin, worldStep) -> {
            if(clazz.isAssignableFrom(origin.getClass())) {
                getKey((U) origin).ifPresent(key -> hashMap.put(key, (U) origin));
            }
        });
        worldStepInstance.getWorldStep().get().onRemove((origin, worldStep) -> {
            if(clazz.isAssignableFrom(origin.getClass())) {
                getKey((U) origin).ifPresent(hashMap::remove);
            }
        });
    }

    public void index(List<U> uList) {
        hashMap.clear();
        uList.forEach(u -> {
            getKey(u).ifPresent(key -> hashMap.put(key, u));
        });
    }

    public Optional<U> get(T t) {
        return Optional.ofNullable(hashMap.get(t));
    }
    public void set(U u) {
        getKey(u).ifPresent(key -> hashMap.put(key, u));
    }

}
