package ro.anud.xml_xsd.websocket;

import org.junit.jupiter.api.DynamicNode;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public interface WebSocketStep<T> {
    Stream<DynamicNode> build(Class<?> runningClass, CompletableFuture<T> future);
}
