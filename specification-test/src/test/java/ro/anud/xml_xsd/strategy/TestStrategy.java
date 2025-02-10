package ro.anud.xml_xsd.strategy;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public abstract sealed class TestStrategy permits TestStrategy.Unit, TestStrategy.Value {

    private sealed interface AbstractConsumer permits AndLambda, ValueAndLambda {
    }

    public non-sealed interface AndLambda<T extends TestStrategy> extends AbstractConsumer {
        T accept(TestStrategy testStrategy) throws Exception;
    }

    public non-sealed interface ValueAndLambda<U, T> extends AbstractConsumer {
        T accept(TestStrategy.Value<U> caseBuilder) throws Exception;
    }

    public static Unit group(String groupName) {
        var currentCase = new Value.StepGroup(groupName, new ArrayList<>());
        return new Unit(currentCase);
    }

    public static Unit list() {
        var currentCase = new Value.StepCollection(new ArrayList<>());
        return new Unit(currentCase);
    }

    protected final Value.CaseStepContainer currentContainer;

    protected TestStrategy(final Value.CaseStepContainer currentContainer) {this.currentContainer = currentContainer;}

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

    public TestStrategy and(final TestStrategy testStrategy) {
        this.currentContainer.caseStepList().add(testStrategy.currentContainer);
        return new Unit(currentContainer);
    }

    public Stream<DynamicNode> build() {
        var reference = new AtomicReference<>(Optional.empty());
        return currentContainer.run(reference);
    }

    public <T extends TestStrategy> T and(AndLambda<T> lambda) {
        try {
            return lambda.accept(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final class Unit extends TestStrategy {

        public Unit(final Value.CaseStepContainer currentContainer) {
            super(currentContainer);
        }
    }

    public static final class Value<T> extends TestStrategy {

        public Value(final CaseStepContainer currentCase) {
            super(currentCase);
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

        public <U> U and(final ValueAndLambda<T, U> lambda) {
            try {
                return lambda.accept(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
