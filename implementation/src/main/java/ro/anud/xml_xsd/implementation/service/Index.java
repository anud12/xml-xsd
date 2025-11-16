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
            protected T getKey(U u) {
                return function.apply(u);
            }
        };
    }
    protected abstract T getKey(U u);

    private final HashMap<T, U> hashMap = new HashMap<>();
    private final Class<U> clazz;

    public void addListeners(WorldStepInstance worldStepInstance) {
        worldStepInstance.getWorldStep().get().onChange((origin, worldStep) -> {
            if(clazz.isAssignableFrom(origin.getClass())) {
                hashMap.put(getKey((U) origin), (U) origin);
            }
        });
        worldStepInstance.getWorldStep().get().onRemove((origin, worldStep) -> {
            if(clazz.isAssignableFrom(origin.getClass())) {
                hashMap.remove(getKey((U) origin));
            }
        });
    }

    public void index(List<U> uList) {
        hashMap.clear();
        uList.forEach(u -> {
            hashMap.put(getKey(u), u);
        });
    }

    public Optional<U> get(T t) {
        return Optional.ofNullable(hashMap.get(t));
    }
    public void set(U u) {
        hashMap.put(getKey(u), u);
    }

}
