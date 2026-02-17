package ro.anud.xml_xsd.implementation.javascriptContext.api.container;

import org.graalvm.polyglot.HostAccess;
import ro.anud.xml_xsd.implementation.javascriptContext.JavascriptRunner;
import ro.anud.xml_xsd.implementation.javascriptContext.api.entity.EntityJSView;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Container;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Entities.Entity.Entity;

import java.util.Optional;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public record ContainerJSView(JavascriptRunner javascriptRunner, String id) {

    @Override
    @HostAccess.Export
    public String toString() {
        return "ContainerJSView{" +
                "id='" + id + '\'' +
                '}';
    }

    public Optional<Container> get() {
        return javascriptRunner
                .getWorldStepInstance()
                .container
                .repository
                .byId.get(id);
    }
    public Optional<Container> getOut() {
        return get().map(container -> javascriptRunner
                .getWorldStepInstance()
                .getOutInstance()
                .container
                .repository
                .getOrDefault(container));
    }

    @HostAccess.Export
    public ContainerJSView addEntity(EntityJSView entityJSView) {
        try (var scope = logScope()){
            var container = getOut().get();
            container.getEntitiesOrDefault()
                    .addEntity(Entity.builder()
                            .entityIdRef(entityJSView.id())
                            .build());
            return this;
        }
    }
}
