package ro.anud.xml_xsd.implementation.service;

import lombok.Setter;
import org.springframework.web.socket.TextMessage;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations;
import ro.anud.xml_xsd.implementation.repository.RuleRepository;
import ro.anud.xml_xsd.implementation.service.entity.EntityInstance;
import ro.anud.xml_xsd.implementation.service.location_graph.LocationGraphInstance;
import ro.anud.xml_xsd.implementation.service.name.NameInstance;
import ro.anud.xml_xsd.implementation.service.person.PersonInstance;
import ro.anud.xml_xsd.implementation.service.region.RegionInstance;
import ro.anud.xml_xsd.implementation.service.util.ComputeOperation;
import ro.anud.xml_xsd.implementation.service.zone.ZoneInstance;
import ro.anud.xml_xsd.implementation.util.LinkedNode;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;
import static ro.anud.xml_xsd.implementation.websocket.Client.ReturnCode.Update;

@Setter
public class WorldStepInstance {



    @FunctionalInterface
    public interface Mutation {
        void apply(WorldStepInstance outInstance);
    }

    public static WorldStepInstance createNewDoubleBuffered() {
        try (var logger = logScope()) {
            logger.log("create instance");
            var instance = new WorldStepInstance();
            logger.log("create out instance");
            var outInstance = new WorldStepInstance();
            instance.setOutInstance(outInstance);
            outInstance.setOutInstance(instance);
            return instance;
        }

    }

    public static WorldStepInstance createNewDoubleBuffered(WorldStep worldStep) {
        try (var logger = logScope("Creating new double buffered WorldStepInstance with WorldStep")) {
            var instance = createNewDoubleBuffered();
            instance.setWorldStep(worldStep);
            instance.getOutInstance().setWorldStep(WorldStep.fromRawNode(worldStep.rawNode()));
            return instance;
        }

    }

    public InstanceTypeEnum instance;
    private WorldStepInstance outInstance = this;
    private Optional<WorldStep> worldStep = Optional.empty();
    private Optional<WebSocketHandler> webSocketHandler = Optional.empty();
    public final RuleRepository ruleRepository = new RuleRepository(this);
    public final PersonInstance person = new PersonInstance(this);
    public final PropertyInstance property = new PropertyInstance(this);
    public final LocationGraphInstance locationGraph = new LocationGraphInstance(this);
    public final NameInstance name = new NameInstance(this);
    public final ZoneInstance zone = new ZoneInstance(this);
    public final RegionInstance region = new RegionInstance(this);
    public final EntityInstance entity = new EntityInstance(this);


    private int counter = 0;

    public WorldStepInstance() {
        System.out.print("");
    }

    public WorldStepInstance index() {
        try (var scope = logScope()) {
            ruleRepository.index();
            person.index();
            property.index();
            locationGraph.index();
            name.index();
            zone.index();
            region.index();
            return this;
        }
    }

    public Optional<WorldStep> getWorldStep() {
        return worldStep;
    }

    public WorldStepInstance setWorldStep(WorldStep worldStep) {
        this.worldStep = Optional.ofNullable(worldStep);
        index();
        addUpdateHandlers();
        return this;
    }

    public WorldStepInstance setWebSocketHandler(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = Optional.ofNullable(webSocketHandler);

        return this;
    }

    public void sendLinkNode(final LinkedNode linkedNode) {
        try (var scope = logScope("sendLinkNode", linkedNode.buildPath())) {
            if (webSocketHandler.isEmpty()) {
                scope.log("WebSocketHandler is not set");
//                throw new RuntimeException("WebSocketHandler is not set");
            }
            webSocketHandler.ifPresent(webSocketHandler1 -> {
                try {
                    var payload = Update.value
                        + linkedNode.buildPath()
                        + "\n" + linkedNode.serializeIntoRawNode().toDocumentString();
                    scope.log("sending message", payload);
                    webSocketHandler1.broadCastMessage(new TextMessage(payload));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }

    public Stream<WorldStep> streamWorldStep() {
        return worldStep.stream();
    }

    public WorldStepInstance getOutInstance() {
        return outInstance;
    }

    public <T extends IType_mathOperations<?>> Optional<Integer> computeOperation(
        T typeMathOperations,
        Person person) {
        try (var scope = logScope()) {
            return scope.logReturn(ComputeOperation.computeOperation(this, typeMathOperations, person));

        }
    }

    public <T extends IType_mathOperations<?>> Optional<Integer> computeOperation(
        T typeMathOperations) {
        try(var scope = logScope()){
            return scope.logReturn(ComputeOperation.computeOperation(this, typeMathOperations));
        }

    }

    public <T extends IType_mathOperations<?>> Optional<Integer> computeOperation(
        Optional<T> typeMathOperations,
        Person person) {
        try (var scope = logScope()) {
            if (typeMathOperations.isEmpty()) {
                return scope.logReturn(Optional.empty());
            }
            return scope.logReturn(ComputeOperation.computeOperation(this, typeMathOperations.get(), person));
        }

    }

    private void addUpdateHandlers() {
        this.worldStep.ifPresent(worldStep1 -> worldStep1.onChange((object, thisObject) -> {
            try (var logScope = logScope()){
                logScope.log("On change called for", object);
                sendLinkNode(object);
            }

        }));
    }

    public WorldStepInstance offsetRandomizationTable() {
        try (var scope = logScope()) {
            var randomizationTableOptional = worldStep
                .flatMap(WorldStep::getWorldMetadata)
                .map(WorldMetadata::getRandomizationTable)
                .map(RandomizationTable::getEntry);
            if (randomizationTableOptional.isEmpty()) {
                scope.log("empty randomizationTable");
                return this;
            }
            var randomizationTable = randomizationTableOptional.get();
            if (randomizationTable.size() == 1) {
                scope.log("ignoring offset for single entry");
                return this;
            }
            scope.log("applying offset");
            var entry = randomizationTable.removeFirst();
            randomizationTable.add(entry);
            return this;
        }
    }

    public float random() {
        try (var scope = logScope()) {
            var entryList = worldStep
                .flatMap(WorldStep::getWorldMetadata)
                .map(WorldMetadata::getRandomizationTable)
                .stream()
                .flatMap(RandomizationTable::streamEntry)
                .map(Entry::getValue)
                .toList();
            if (entryList.isEmpty()) {
                scope.log("empty randomization_table");
                return scope.logReturn(0);
            }
            var max = entryList.stream().max(Comparator.comparingInt(o -> o)).get();

            var index = counter % entryList.size();
            var value = entryList.get(index);
            var result = value / (float) (max);
            counter += 1;
            scope.log("max", max, "value", value, "index", index);
            return scope.logReturn(result);
        }

    }

    public <T> Optional<T> randomFrom(final Stream<T> locationList) {
        return randomFrom(locationList.toList());
    }

    public <T> Optional<T> randomFrom(final List<T> list) {
        try (var scope = logScope()) {
            if (list.isEmpty()) {
                scope.log("is empty");
                return scope.logReturn(Optional.empty());
            }
            int randomIndex = (int) Math.floor(this.random() * (list.size() - 1));
            scope.log("randomIndex:", randomIndex);
            return scope.logReturn(Optional.ofNullable(list.get(randomIndex)));

        }
    }

    public String getNextId() {
        try (var scope = logScope()) {
            var time = worldStep
                .flatMap(WorldStep::getWorldMetadata)
                .map(WorldMetadata::getElapsedTime)
                .map(ElapsedTime::getValue)
                .orElse(0);
            scope.log("time:", time);
            var counter = counterNext();
            scope.log("counter", counter);
            return scope.logReturn(time.toString() + "." + counter);
        }
    }

    public int counterNext() {
        try (var scope = logScope()) {
            var counter = worldStep
                .flatMap(WorldStep::getWorldMetadata)
                .map(WorldMetadata::getCounter)
                .map(Counter::getValue)
                .orElse(0);
            scope.log("counter", counter);
            worldStep
                .flatMap(WorldStep::getWorldMetadata)
                .ifPresent(outCounter -> outCounter.getCounter().setValue(counter + 1));
            return scope.logReturn(counter);
        }
    }

    public int randomBetweenInt(final Integer min, final Integer max) {
        try(var scope = logScope("min", min, "max", max)) {
            if (min > max) {
                scope.log("switching between");
                return randomBetweenInt(max, min);
            }
            var randomValue = this.random();
            int maxRange = max + 1 - min;
            if (maxRange == 0) {
                var isGreaterThan = randomValue >= 0.5;
                if (isGreaterThan) {
                    return scope.logReturn(max);
                }
                return scope.logReturn(min);
            }
            var delta = max - min;
            var result = randomValue * delta + min;
            return scope.logReturn((int) result);
        }

    }
}
