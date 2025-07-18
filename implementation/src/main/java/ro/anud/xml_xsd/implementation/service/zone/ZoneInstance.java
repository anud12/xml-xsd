package ro.anud.xml_xsd.implementation.service.zone;

import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.service.WorldStepInstance;

public class ZoneInstance {
    private final WorldStepInstance worldStepInstance;

    public final ZoneRepository repository = new ZoneRepository();

    public ZoneInstance(final WorldStepInstance worldStepInstance) {this.worldStepInstance = worldStepInstance;}

    public void index() {
        repository.index(worldStepInstance.streamWorldStep().flatMap(WorldStep::streamData).toList());
    }
}
