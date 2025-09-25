package ro.anud.xml_xsd.implementation.util.logging;

import java.util.List;
import java.util.concurrent.*;

public class ContextAwareExecutorService extends AbstractExecutorService {
    private final ExecutorService delegate;

    public ContextAwareExecutorService(ExecutorService delegate) {
        this.delegate = delegate;
    }

    @Override
    public void execute(Runnable command) {
        delegate.execute(ContextAwareTask.wrap(command));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return delegate.submit(ContextAwareTask.wrap(task));
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return delegate.submit(ContextAwareTask.wrap(task), result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return delegate.submit(ContextAwareTask.wrap(task));
    }

    // Delegate shutdown methods
    @Override public void shutdown() { delegate.shutdown(); }
    @Override public List<Runnable> shutdownNow() { return delegate.shutdownNow(); }
    @Override public boolean isShutdown() { return delegate.isShutdown(); }
    @Override public boolean isTerminated() { return delegate.isTerminated(); }
    @Override public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate.awaitTermination(timeout, unit);
    }
}