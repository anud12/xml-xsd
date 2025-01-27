package ro.anud.xml_xsd.cases;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public sealed class CaseBuilder permits CaseBuilder.Middle
{

    public static Start group(String name) {
        return new Start(name);
    }

    protected final Group currentCase;

    protected CaseBuilder(final Group currentCase) {this.currentCase = currentCase;}


    public Group getCurrentCase() {
        return currentCase;
    }

    public <U> Middle<U> and(String name, final Start.Supplier<U> function) {
        currentCase.caseStepList()
            .add(new Step<>(
                name,
                (object) -> Optional.ofNullable(function.call())
            ));
        return new Middle<>(
            currentCase
        );
    }

    public CaseBuilder and(final String name, final Start.Runnable consumer) {
        currentCase.caseStepList().add(new Step<>(
            name,
            object -> {
                consumer.call();
                return Optional.ofNullable(object);
            }
        ));
        return new CaseBuilder(currentCase);
    }


    public CaseBuilder and(final CaseBuilder caseBuilder) {
        var childrenCaseGroup = switch (caseBuilder) {
            case Middle<?> object -> object.getCurrentCase();
            case CaseBuilder object -> object.getCurrentCase();
        };
        this.currentCase.caseStepList().add(childrenCaseGroup);
        return new CaseBuilder(currentCase);
    }

    public Stream<DynamicNode> build() {
        var reference = new AtomicReference<>(Optional.empty());
        return Stream.of(currentCase.run(reference));
    }


    public static final class Start {
        private final String groupName;

        public Start(String groupName) {this.groupName = groupName;}

        public interface Supplier<T> {
            T call() throws Exception;
        }
        public interface Function<T, U> {
            U call(T t) throws Exception;
        }
        public interface Consumer<T> {
            void call(T t) throws Exception;
        }

        public interface Runnable {
            void call() throws Exception;
        }

        public  CaseBuilder start(final CaseBuilder run) {
            var currentCase = new Group(groupName, new ArrayList<>());
            currentCase.caseStepList().add(run.getCurrentCase());
            return new CaseBuilder(currentCase);
        }

        public <T> Middle<T> start(final String name, final Supplier<T> consumer) {

            var currentCase = new Group(groupName, new ArrayList<>());
            currentCase.caseStepList().add(new Step<>(
                name, object -> Optional.ofNullable(consumer.call())
            ));

            ArrayList<RunnableCase> caseList = new ArrayList<>();
            caseList.add(currentCase);
            //noinspection unchecked
            return new Middle<>(currentCase);
        }

        public CaseBuilder start(final String name, final Runnable consumer) {

            var currentCase = new Group(groupName, new ArrayList<>());

            currentCase.caseStepList().add(new Step<>(
                name, object -> {
                consumer.call();
                return Optional.empty();
            }));
            ArrayList<RunnableCase> caseList = new ArrayList<>();
            caseList.add(currentCase);
            //noinspection unchecked
            return new CaseBuilder(currentCase);
        }


    }

    public static final class Middle<T> extends CaseBuilder {

        public Middle(final Group currentCase) {
            super(currentCase);
        }

        public <Return> Middle<Return> and(final String endTest, final Start.Function<T, Return> lambda) {
            currentCase.caseStepList().add(new Step<>(
                endTest,
                arg -> Optional.of(lambda.call((T) arg))
            ));
            return new Middle<>(currentCase);
        }


        public CaseBuilder and(final String name, final Start.Consumer<T> consumer) {
            currentCase.caseStepList().add(new Step<>(
                name,
                object -> {
                    //noinspection unchecked
                    consumer.call((T) object);
                    return Optional.ofNullable(object);
                }
            ));
            return new CaseBuilder(currentCase);
        }

    }

//    public static final class End extends CaseBuilder implements Resettable, Buildable {
//
//        private final Group currentCase;
//
//        public RunnableCase getCurrentCase() {
//            return currentCase;
//        }
//
//
//        public End(
//            final Group currentCase
//        ) {
//            this.currentCase = currentCase;
//        }
//
//        public <T> Middle<T> and(String name, Start.Supplier<T> supplier) {
//            currentCase.caseStepList()
//                .add(
//                    new Step<>(
//                        name,
//                        object -> java.util.Optional.ofNullable(supplier.call())
//                    )
//                );
//            return new Middle<>(currentCase);
//        }
//
//        public Continue and(String name, Start.Runnable lambda) {
//            currentCase.caseStepList()
//                .add(new Step<>(
//                    name,
//                    object -> {
//                        lambda.call();
//                        return java.util.Optional.ofNullable(object);
//                    }));
//            return new Continue(currentCase);
//        }
//        @Override
//        public End and(final CaseBuilder caseBuilder) {
//            var childrenCaseGroup = switch (caseBuilder) {
//                case Middle<?> object -> object.getCurrentCase();
//                case End object -> object.getCurrentCase();
//            };
//            this.currentCase.caseStepList().add(childrenCaseGroup);
//            return new End(
//                this.currentCase
//            );
//        }
//
//
//        public Stream<DynamicNode> build() {
//            var reference = new AtomicReference<>(Optional.empty());
//            return Stream.of(currentCase.run(reference));
//        }
//    }

//    public static final class Continue extends CaseBuilder implements Buildable {
//
//    }
    public record Group(String name, List<RunnableCase> caseStepList) implements RunnableCase {

        @Override
        public DynamicNode run(final AtomicReference<Optional<Object>> ignored) {
            AtomicReference<Optional<Object>> atomicReference = new AtomicReference<>(Optional.empty());
            return DynamicContainer.dynamicContainer(
                name, () -> caseStepList
                    .stream()
                    .map(objectObjectCaseStep -> objectObjectCaseStep.run(atomicReference))
                    .toList()
                    .iterator());
        }
    }

    public interface Chainable<U> {
        <Return> Middle<Return> and(final String endTest, final Start.Function<U, Return> lambda);
        CaseBuilder and(final String name, final Start.Consumer<U> consumer);
        CaseBuilder and(final CaseBuilder caseBuilder);
    }

    public interface Resettable {
        CaseBuilder and(String name, Start.Runnable lambda);
        <T> Middle<T> and(String name, Start.Supplier<T> supplier);
        Resettable and(final CaseBuilder caseBuilder);
    }

    public interface RunnableCase {

        DynamicNode run(AtomicReference<Optional<Object>> reference);
    }
    public interface Buildable {
        public Stream<DynamicNode> build();
    }

    public record Step<T, U>(String name, Function<T, U> function) implements RunnableCase {


        @Override
        public DynamicTest run(AtomicReference<Optional<Object>> reference) {
            return DynamicTest.dynamicTest(
                name, () -> reference.getAndUpdate(o -> {
                    try {
                        //noinspection unchecked
                        var result = function.call((T) o.orElse(new Object()));

                        //noinspection unchecked
                        return (Optional<Object>) result;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }));
        }

        interface Function<T, U> {
            Optional<U> call(T object) throws Exception;
        }
    }

}
