package ro.anud.xml_xsd.implementation.javascriptContext.api.entity;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.PolyglotException;
import ro.anud.xml_xsd.implementation.javascriptContext.JavascriptRunner;
import ro.anud.xml_xsd.implementation.javascriptContext.api.CollectionJSApi;
import ro.anud.xml_xsd.implementation.javascriptContext.api.container.ContainerJSView;
import ro.anud.xml_xsd.implementation.javascriptContext.operations.mutation.TextMutation;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public record EntityJSView(JavascriptRunner javascriptRunner, String id) {

    public Optional<Entity> get() {
        return javascriptRunner
                .getWorldStepInstance()
                .entity
                .repository
                .byId.get(id);
    }

    @Override
    @HostAccess.Export
    public String toString() {
        return "EntityJSView{" +
                "id='" + id + '\'' +
                '}';
    }

    @HostAccess.Export
    public EntityJSView setText(String name, Function<String, String> mapper) {
        try (var scope = logScope()) {
            setText(name, mapper, (s, s2) -> s2);
            return this;
        }
    }

    @HostAccess.Export
    public EntityJSView setText(String name, Function<String, String> mapper, BiFunction<String, String, String> joiner) {
        try (var scope = logScope()) {
            PolyglotException e = Context.getCurrent().asValue(new RuntimeException()).as(PolyglotException.class);
            javascriptRunner.getWorldStepInstance().entity.textMutations.execute(new TextMutation(
                    e.getPolyglotStackTrace(),
                    id,
                    name,
                    mapper,
                    joiner
            ));
            return this;
        }
    }

    @HostAccess.Export
    public CollectionJSApi<List<ContainerJSView>> getAllContainersBy(Function<ContainerQueryJSApi, ContainerQueryJSApi> mapper) {
        var parentEntity = get();
        return new CollectionJSApi<>(
                javascriptRunner
                        .getWorldStepInstance()
                        .container
                        .repository.queryInEntity(parentEntity, mapper.apply(new ContainerQueryJSApi()))
                        .map(container -> new ContainerJSView(javascriptRunner, container.getId()))
                        .toList()
        );
    }


    @HostAccess.Export
    public CollectionJSApi<List<EntityJSView>> getAllEntitiesBy() {
        return getAllEntitiesBy(Function.identity());
    }

    @HostAccess.Export
    public CollectionJSApi<List<EntityJSView>> getAllEntitiesBy(Function<EntityQueryJSApi, EntityQueryJSApi> mapper) {
        try (var scope = logScope()) {
            var parentEntity = get();
            return new CollectionJSApi<>(javascriptRunner
                    .getWorldStepInstance()
                    .entity
                    .repository.queryInEntity(parentEntity, mapper.apply(new EntityQueryJSApi()))
                    .map(entity -> new EntityJSView(javascriptRunner, entity.getId()))
                    .toList()
            );
        }
    }
}
