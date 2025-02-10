package ro.anud.xml_xsd.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Execution(ExecutionMode.SAME_THREAD)
class Test {


    @TestFactory
    public Stream<DynamicNode> startWithSingleCase() {
        return TestStrategy.group("groupName")
            .and(
                "firstTest", () -> {
                    System.out.println("first test");
                    System.out.println("sleep");
                    Thread.sleep(500);
                })
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> startWith2Steps() {
        return TestStrategy.group("groupName")
            .and(
                "firstTest", () -> {
                    System.out.println("first test");
                    System.out.println("sleep");
                    Thread.sleep(500);
                    return 2;
                })

            .and(
                "secondTest", integer -> {
                    Thread.sleep(500);
                    System.out.println("got" + integer);
                })
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> startWithMiddleSteps() {
        return TestStrategy.group("groupName")
            .and("firstTest", () -> 2)
            .and(
                "middleTest", integer -> {
                    Assertions.assertThat(integer).isEqualTo(2);
                    return integer + 2;
                })
            .and(
                "conversionToOptional", integer -> {
                    Assertions.assertThat(integer).isEqualTo(4);
                    return Optional.of(integer);
                })
            .and(
                "endTest", integer -> {
                    Assertions.assertThat(integer).isEqualTo(Optional.of(4));
                })
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> startWithMiddleStepsAndContinuation() {
        return TestStrategy.group("groupName")
            .and(
                "firstTest", () -> 2)
            .and(
                "secondTest", integer -> {
                    Assertions.assertThat(integer).isEqualTo(2);
                    return integer + 2;
                })
            .and(
                "conversionToOptional", integer -> {
                    Assertions.assertThat(integer).isEqualTo(4);
                    return Optional.of(integer);
                })
            .and(
                "endTest", optional -> {
                    Assertions.assertThat(optional).isEqualTo(Optional.of(4));
                })
            .and("continuation test", () -> "ending")
            .and(
                "final test", () -> {
                    Assertions.assertThat(true)
                        .isEqualTo(true);
                })
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> valueAfterList() {
        return TestStrategy.group("groupName")
            .and(TestStrategy.list()
                .and("firstTest", () -> 2)
            )
            .and(
                "assert", integer -> {
                    Assertions.assertThat(integer).isEqualTo(2);
                })
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> valueAfterGroup() {
        return TestStrategy.group("groupName")
            .and(TestStrategy.group("innerGroup")
                .and("firstTest", () -> 2)
            )
            .and(
                "assert", integer -> {
                    Assertions.assertThat(integer).isEqualTo(2);
                })
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> andWithLambdaForUnit() {
        return TestStrategy.group("groupName")
            .and("middleReturn", () -> {})
            .and(value -> value.and(
                "assert in lambda", () -> {
                    Assertions.assertThat(true).isEqualTo(true);
                }))
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> andWithLambdaThatReturnsForUnit() {
        return TestStrategy.group("groupName")
            .and("middleReturn", () -> {})
            .and(value -> value.and(
                "lambda return", () -> 2))
            .and(
                "assert", integer -> {
                    Assertions.assertThat(integer).isEqualTo(2);
                })
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> andWithLambdaForValue() {
        return TestStrategy.group("groupName")
            .and("middleReturn", () -> 1)
            .and((TestStrategy.ValueAndLambda<Integer, TestStrategy>) value -> value.and(
                "assert in lambda", integer -> {
                    Assertions.assertThat(integer).isEqualTo(1);
                }))
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> andWithLambdaThatReturnsForValue() {
        return TestStrategy.group("groupName")
            .and("middleReturn", () -> 1)
            .and((TestStrategy.ValueAndLambda<Integer, TestStrategy.Value<Integer>>) value -> value.and(
                "assert in lambda", integer -> {
                    Assertions.assertThat(integer).isEqualTo(1);
                    return 2;
                }))
            .and(
                "assert", integer -> {
                    Assertions.assertThat(integer).isEqualTo(2);
                })
            .build();
    }


    @TestFactory
    public Stream<DynamicNode> startWithMultiLevelGroups() {
        return TestStrategy.group("groupName")
            .and("firstTest", () -> 2)
            .and(
                "secondTest", integer -> {
                    Assertions.assertThat(integer).isEqualTo(2);
                    return integer + 2;
                })
            .and(
                "conversionToOptional", integer -> {
                    Assertions.assertThat(integer).isEqualTo(4);
                    return Optional.of(integer);
                })
            .and(
                "first no return", optional -> {
                    Assertions.assertThat(optional).isEqualTo(Optional.of(4));
                })
            .and(
                "second no return", () -> {
                    Assertions.assertThat(true).isEqualTo(true);
                })
            .and("continuation test", () -> "ending")
            .and(
                TestStrategy.group("2ndGroup")
                    .and("2ndGroup firstTest", () -> 2)
                    .and(
                        "2ndGroup secondTest", integer -> {
                            Assertions.assertThat(integer).isEqualTo(2);
                            return integer + 2;
                        })
                    .and(
                        "2ndGroup conversionToOptional", integer -> {
                            Assertions.assertThat(integer).isEqualTo(4);
                            return Optional.of(integer);
                        })
                    .and(
                        "2ndGroup first no return", optional -> {
                            Assertions.assertThat(optional).isEqualTo(Optional.of(4));
                        })
                    .and(
                        "2ndGroup second no return", () -> {
                            Assertions.assertThat(true).isEqualTo(true);
                        })
                    .and("2ndGroup continuation test", () -> "ending")
                    .and(TestStrategy.group("3rdGroups")
                        .and("3rdGroup firstTest", () -> 2)
                        .and(
                            "3rdGroup secondTest", integer -> {
                                Assertions.assertThat(integer).isEqualTo(2);
                                return integer + 2;
                            })
                        .and(
                            "3rdGroup conversionToOptional", integer -> {
                                Assertions.assertThat(integer).isEqualTo(4);
                                return Optional.of(integer);
                            })
                        .and(
                            "3rdGroup first no return", optional -> {
                                Assertions.assertThat(optional).isEqualTo(Optional.of(4));
                            })
                        .and(
                            "3rdGroup second no return", () -> {
                                Assertions.assertThat(true).isEqualTo(true);
                            })
                        .and("3rdGroup continuation test", () -> "ending")
                        .and(
                            "3rdGroup final test", () -> {
                                Assertions.assertThat(true)
                                    .isEqualTo(true);
                            }))
                    .and(
                        "2ndGroup final test", () -> {
                            Assertions.assertThat(true)
                                .isEqualTo(true);
                        })
            )
            .and("supplier for intermittent", () -> 1)
            .and(TestStrategy.list().and(
                "intermittent list list", () -> {
                    Assertions.assertThat(true).isEqualTo(true);
                }).and(
                "intermittent list second returns", () -> 2)
            )
            .and(
                "final test", () -> {
                    Assertions.assertThat(true)
                        .isEqualTo(true);
                })
            .build();
    }

    @TestFactory
    public Stream<DynamicNode> startDemo() {

        interface Fn<T, U> {
            U fn(T t) throws Exception;
        }

        record Step<T, U>(String name, Fn<T, U> function) {}
        ;

        var stepList = List.of(
            new Step<>(
                "first", value -> {
                System.out.println(value);
                Thread.sleep(500);
                return value + " first";
            }),
            new Step<>(
                "second", value -> {
                System.out.println(value);
                Thread.sleep(500);
                return value + " second";
            }),
            new Step<>(
                "third", value -> {
                System.out.println(value);
                Thread.sleep(500);
                return value + " third";
            }));

        AtomicReference<Object> future = new AtomicReference<>("startValue");

        return stepList.stream().map(objectStringStep -> DynamicTest.dynamicTest(
            objectStringStep.name, () -> {
                var returnValue = objectStringStep.function.fn(future.get());
                future.set(returnValue);
            }));
    }
}
