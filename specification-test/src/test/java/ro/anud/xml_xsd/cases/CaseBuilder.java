package ro.anud.xml_xsd.cases;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Stream;

public abstract sealed class CaseBuilder<CaseLambdaReturnType> permits CaseBuilder.Unit, CaseBuilder.Value {

    public static Unit group(String groupName) {
        var currentCase = new Value.StepGroup(groupName, new ArrayList<>());
        return new Unit(currentCase);
    }

    public static Unit list() {
        var currentCase = new Value.StepCollection(new ArrayList<>());
        return new Unit(currentCase);
    }

    protected final Value.CaseStepContainer currentContainer;

    protected CaseBuilder(final Value.CaseStepContainer currentContainer) {this.currentContainer = currentContainer;}

    public <U> Value<U> and(String name, final Value.Supplier<U> function) {
        currentContainer.caseStepList()
            .add(new Value.Step<>(
                name,
                (object) -> Optional.ofNullable(function.call())
            ));
        return new Value<>(
            currentContainer
        );
    }


    public Unit and(final String name, final Value.Runnable consumer) {
        currentContainer.caseStepList().add(new Value.Step<>(
            name,
            object -> {
                consumer.call();
                return Optional.ofNullable(object);
            }
        ));
        return new Unit(currentContainer);
    }


    public <T> Value<T> and(final Value<T> value) {
        this.currentContainer.caseStepList().add(value.currentContainer);
        return new Value<>(currentContainer);
    }

    public Unit and(final Unit caseBuilder) {
        this.currentContainer.caseStepList().add(caseBuilder.currentContainer);
        return new Unit(currentContainer);
    }
    public CaseBuilder<Unit> and(final CaseBuilder<Unit> caseBuilder) {
        this.currentContainer.caseStepList().add(caseBuilder.currentContainer);
        return new Unit(currentContainer);
    }

    public Stream<DynamicNode> build() {
        var reference = new AtomicReference<>(Optional.empty());
        return currentContainer.run(reference);
    }

    public abstract CaseLambdaReturnType and(java.util.function.Consumer<CaseLambdaReturnType> lambda);

    public static final class Unit extends CaseBuilder<Unit> {

        public Unit(final Value.CaseStepContainer currentContainer) {
            super(currentContainer);
        }

        @Override
        public Unit and(final Consumer<Unit> lambda) {
            try {
                lambda.accept(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return this;
        }

    }

    public static final class Value<T> extends CaseBuilder<Value<T>> {

        public Value(final CaseStepContainer currentCase) {
            super(currentCase);
        }

        @Override
        public Value<T> and(final java.util.function.Consumer<Value<T>> lambda) {
            try {
                lambda.accept(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return this;
        }

        public <Return> Value<Return> and(final String endTest, final Function<T, Return> lambda) {
            currentContainer.caseStepList().add(new Step<>(
                endTest,
                arg -> Optional.of(lambda.call((T) arg))
            ));
            return new Value<>(currentContainer);
        }


        public Unit and(final String name, final Consumer<T> consumer) {
            currentContainer.caseStepList().add(new Step<>(
                name,
                object -> {
                    //noinspection unchecked
                    consumer.call((T) object);
                    return Optional.ofNullable(object);
                }
            ));
            return new Unit(currentContainer);
        }

        public interface Runnable {
            void call() throws Exception;
        }

        public interface Consumer<T> {
            void call(T t) throws Exception;
        }

        public interface Function<T, U> {
            U call(T t) throws Exception;
        }

        public interface Supplier<T> {
            T call() throws Exception;
        }

        public interface RunnableCase {

            Stream<DynamicNode> run(AtomicReference<Optional<Object>> reference);
        }

        public interface CaseStepContainer extends RunnableCase {
            List<RunnableCase> caseStepList();
        }

        public record StepCollection(List<RunnableCase> caseStepList) implements CaseStepContainer {

            @Override
            public Stream<DynamicNode> run(final AtomicReference<Optional<Object>> ignored) {
                AtomicReference<Optional<Object>> atomicReference = new AtomicReference<>(Optional.empty());
                return caseStepList
                    .stream()
                    .flatMap(objectObjectCaseStep -> objectObjectCaseStep.run(ignored));
            }
        }

        public record StepGroup(String name, List<RunnableCase> caseStepList) implements CaseStepContainer {

            @Override
            public Stream<DynamicNode> run(final AtomicReference<Optional<Object>> ignored) {
                return Stream.of(DynamicContainer.dynamicContainer(
                    name, () -> caseStepList
                        .stream()
                        .flatMap(objectObjectCaseStep -> objectObjectCaseStep.run(ignored))
                        .toList()
                        .iterator())
                );
            }
        }

        public record Step<T, U>(String name, Function<T, U> function) implements RunnableCase {
            @Override
            public Stream<DynamicNode> run(AtomicReference<Optional<Object>> reference) {
                return Stream.of(DynamicTest.dynamicTest(
                    name, () -> reference.getAndUpdate(o -> {
                        try {
                            //noinspection unchecked
                            var result = function.call((T) o.orElse(new Object()));

                            //noinspection unchecked
                            return (Optional<Object>) result;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }))
                );
            }

            interface Function<T, U> {
                Optional<U> call(T object) throws Exception;
            }
        }
    }

}
