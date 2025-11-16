package ro.anud.xml_xsd.implementation.service.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

public class ZoneInstance {
    private final WorldStepInstance worldStepInstance;

    public final ZoneRepository repository = new ZoneRepository();

    public ZoneInstance(final WorldStepInstance worldStepInstance) {
        try (var scope = logScope()) {
            this.worldStepInstance = worldStepInstance;
        }
    }

    public void index() {
        try (var scope = logScope()) {
            repository.index(worldStepInstance.streamWorldStep().flatMap(WorldStep::streamData).toList());
        }
    }

}
