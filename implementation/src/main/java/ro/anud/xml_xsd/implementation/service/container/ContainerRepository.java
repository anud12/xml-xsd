package ro.anud.xml_xsd.implementation.service.container;

import ro.anud.xml_xsd.implementation.javascriptContext.api.entity.ContainerQueryJSApi;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Container.Container;
import ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Data;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity.Entity;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.Repository;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;
import ro.anud.xml_xsd.implementation.service.entity.repository.ContainerQuery;
import ro.anud.xml_xsd.implementation.util.repository.NullableIndex;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ContainerRepository implements Repository<Container> {
    public final NullableIndex<String, Container, Container> byId = NullableIndex.ofNullable(Container.class, Container::getId);
    private final WorldStepInstance worldStepInstance;

    public ContainerRepository(WorldStepInstance worldStepInstance) {
        this.worldStepInstance = worldStepInstance;
    }

    @Override
    public void index() {
        try (var scope = logScope()){
            var list = worldStepInstance.streamWorldStep()
                    .flatMap(WorldStep::streamData)
                    .flatMap(Data::streamEntities)
                    .flatMap(Entities::streamEntity)
                    .flatMap(Entity::streamContainers)
                    .flatMap(Containers::streamContainer)
                    .toList();
            byId.reIndex(list);
        }
    }

    @Override
    public void loadData() {
        byId.addListeners(worldStepInstance);
    }
    public static boolean filterContainer(ContainerQuery containerQuery, Container container) {
        try (var scope = logScope(container.getId())) {
            if(containerQuery == null) {
                scope.log("Allow due null containerQuery");
                return true;
            }

            List<String> ids = containerQuery.getIdList();
            List<String> ruleIds = containerQuery.getRuleIdList();


            if(!ids.isEmpty()) {
                if(!ids.contains(container.getId())) {
                    scope.log("Reject id: " + container.getId());
                    return false;
                }
            }

            if(!ruleIds.isEmpty()) {
                if(!container.getContainerRuleRef().isEmpty()) {
                    if(!ruleIds.contains(container.getContainerRuleRef())) {
                        scope.log("Reject ruleRef: " + container.getContainerRuleRef());
                        return false;
                    }
                }

            }
            scope.log("Allow id:" + container.getId());
            return true;
        }
    }

    public Stream<Container> queryInEntity(Optional<Entity> parentEntity, ContainerQueryJSApi entityQuery) {
        try (var scope = logScope()) {
            if(parentEntity.isEmpty()) {
                return Stream.empty();
            }
            return parentEntity.get().streamContainers()
                    .flatMap(Containers::streamContainer)
                    .filter(container -> filterContainer(entityQuery, container));
        }
    }

    public Container getOrDefault(Container container) {
        return byId.get(container.getId()).orElseGet(() -> {
            var parentEntity = worldStepInstance.entity.repository.getOrDefault(container.parentAsContainers()
                            .flatMap(Containers::parentAsType_entity)
                            .stream().findFirst()
                            .get());
            var parent = parentEntity.streamContainersOrDefault().findFirst().get();
            var clonedContainer = Container.fromRawNode(container.rawNode());
            parent.addContainer(clonedContainer);
            return clonedContainer;
        });
    }
}
