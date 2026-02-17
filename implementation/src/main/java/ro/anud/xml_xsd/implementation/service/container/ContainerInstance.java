package ro.anud.xml_xsd.implementation.service.container;

import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

public class ContainerInstance {
    public final ContainerRepository repository;
    public ContainerInstance(WorldStepInstance worldStepInstance) {
        repository = new ContainerRepository(worldStepInstance);
    }
}
