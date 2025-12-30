package ro.anud.xml_xsd.implementation.service.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ZoneInstance {
    private final WorldStepInstance worldStepInstance;

    public final ZoneRepository repository;
    public final ZoneEntityRepository entities;
    public final ZoneRegionRepository region;

    public ZoneInstance(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
            this.entities = new ZoneEntityRepository(worldStepInstance);
            this.region = new ZoneRegionRepository(worldStepInstance);
            this.repository = new ZoneRepository(worldStepInstance);
        }
    }

    public void index() {
        try (var scope = logScope()) {
            repository.index(worldStepInstance.streamWorldStep().flatMap(WorldStep::streamData).toList());
            entities.index();
            region.index();
        }
    }

}
