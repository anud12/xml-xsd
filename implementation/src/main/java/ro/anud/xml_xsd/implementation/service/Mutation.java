package ro.anud.xml_xsd.implementation.service;

import java.util.function.Function;

public class Mutation<T>{
    public static <T> Mutation<T> of(Function<WorldStepInstance, T> function) {
        return new Mutation<T>(function);
    }

    private final Function<WorldStepInstance, T> function;

    private Mutation(Function<WorldStepInstance, T> function) {
        this.function = function;
    }

    public T apply(WorldStepInstance worldStepInstance) {
        return function.apply(worldStepInstance);
    }
}
