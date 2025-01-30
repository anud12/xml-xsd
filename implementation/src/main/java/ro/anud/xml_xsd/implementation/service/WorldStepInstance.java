package ro.anud.xml_xsd.implementation.service;

import lombok.Setter;
import org.springframework.web.socket.TextMessage;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node;
import ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.Person.Person;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.Entry.Entry;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.WorldMetadata;
import ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep;
import ro.anud.xml_xsd.implementation.model.interfaces.IType_mathOperations.IType_mathOperations;
import ro.anud.xml_xsd.implementation.repository.RuleRepository;
import ro.anud.xml_xsd.implementation.service.location_graph.LocationGraphInstance;
import ro.anud.xml_xsd.implementation.service.name.NameInstance;
import ro.anud.xml_xsd.implementation.service.person.PersonInstance;
import ro.anud.xml_xsd.implementation.service.util.ComputeOperation;
import ro.anud.xml_xsd.implementation.util.LinkedNode;
import ro.anud.xml_xsd.implementation.websocket.WebSocketHandler;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.*;

@Setter
public class WorldStepInstance {


    @FunctionalInterface
    public interface Mutation {
        void apply(WorldStepInstance outInstance);
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

    private int counter = 0;

    public WorldStepInstance index() {
        ruleRepository.index();
        person.index();
        property.index();
        locationGraph.index();
        name.index();
        return this;
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
        var logger = logEnter("sendLinkNode");
        if (webSocketHandler.isEmpty()) {
            logger.log("webSocketHandler is empty");
            return;
        }
        webSocketHandler.ifPresent(webSocketHandler1 -> {
            try {
                logger.log("sending message", linkedNode.serializeIntoRawNode().toDocumentString());
                webSocketHandler1.broadCastMessage(new TextMessage("update\n"
                    + linkedNode.classTypeId()
                    + "\n" + linkedNode.serializeIntoRawNode().toDocumentString()
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
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
        var logger = logEnter();
        return logger.logReturn(ComputeOperation.computeOperation(this, typeMathOperations, person));
    }

    public <T extends IType_mathOperations<?>> Optional<Integer> computeOperation(
        T typeMathOperations) {
        var logger = logEnter();
        return logger.logReturn(ComputeOperation.computeOperation(this, typeMathOperations));
    }

    public <T extends IType_mathOperations<?>> Optional<Integer> computeOperation(
        Optional<T> typeMathOperations,
        Person person) {
        var logger = logEnter();
        if (typeMathOperations.isEmpty()) {
            return Optional.empty();
        }
        return logger.logReturn(ComputeOperation.computeOperation(this, typeMathOperations.get(), person));
    }

    private void addUpdateHandlers() {
        this.worldStep.ifPresent(worldStep1 -> worldStep1.onChange(objects -> {
                for (Object o : objects) {
                    if (o instanceof Person object) {
                        sendLinkNode(object);
                        return;
                    }
                    if(o instanceof Node object) {
                        sendLinkNode(object);
                        return;
                    }
                    if(o instanceof LocationGraph object) {
                        sendLinkNode(object);
                        return;
                    }
                }
            }
        ));
    }

    public WorldStepInstance offsetRandomizationTable() {
        var logger = logEnter();
        var randomizationTableOptional = worldStep
            .flatMap(WorldStep::getWorldMetadata)
            .map(WorldMetadata::getRandomizationTable)
            .map(RandomizationTable::getEntry);
        if (randomizationTableOptional.isEmpty()) {
            logger.log("empty randomizationTable");
            return this;
        }
        var randomizationTable = randomizationTableOptional.get();
        if (randomizationTable.size() == 1) {
            logger.log("ignoring offset for single entry");
            return this;
        }
        logger.log("applying offset");
        var entry = randomizationTable.removeFirst();
        randomizationTable.add(entry);

        return this;
    }

    public float random() {
        var logger = logEnter();
        var entryList = worldStep
            .flatMap(WorldStep::getWorldMetadata)
            .map(WorldMetadata::getRandomizationTable)
            .stream()
            .flatMap(RandomizationTable::streamEntry)
            .map(Entry::getValue)
            .toList();
        if (entryList.isEmpty()) {
            return logger.logReturn(0, "empty randomization_table");
        }
        var max = entryList.stream().max(Comparator.comparingInt(o -> o)).get();

        var index = counter % entryList.size();
        var value = entryList.get(index);
        var result = value / (float) (max);
        counter += 1;
        return logReturn(result, "max", max, "value", value, "index", index);
    }

    public <T> Optional<T> randomFrom(final Stream<T> locationList) {
        return randomFrom(locationList.toList());
    }

    public <T> Optional<T> randomFrom(final List<T> list) {
        var logger = logEnter();
        if (list.isEmpty()) {
            logger.log("is empty");
            return logger.logReturn(Optional.empty());
        }
        int randomIndex = (int) Math.floor(this.random() * (list.size() - 1));
        logger.log("randomIndex:", randomIndex);
        return Optional.ofNullable(list.get(randomIndex));
    }

    public String getNextId() {
        var logger = logEnter();
        var time = worldStep
            .flatMap(WorldStep::getWorldMetadata)
            .map(WorldMetadata::getElapsedTime)
            .map(ElapsedTime::getValue)
            .orElse(0);
        logger.log("time:", time);
        var counter = counterNext();
        logger.log("counter", counter);
        return logger.logReturn(time.toString() + "." + counter);
    }

    public int counterNext() {
        var logger = logEnter();
        var counter = worldStep
            .flatMap(WorldStep::getWorldMetadata)
            .map(WorldMetadata::getCounter)
            .map(Counter::getValue)
            .orElse(0);
        logger.log("counter", counter);
        worldStep
            .flatMap(WorldStep::getWorldMetadata)
            .ifPresent(outCounter -> outCounter.getCounter().setValue(counter + 1));
        return logger.logReturn(counter);
    }

    public int randomBetweenInt(final Integer min, final Integer max) {
        var logger = logEnter("min", min, "max", max);
        if (min > max) {
            logger.log("switching between");
            return randomBetweenInt(max, min);
        }
        var randomValue = this.random();
        int maxRange = max + 1 - min;
        if (maxRange == 0) {
            var isGreaterThan = randomValue >= 0.5;
            if (isGreaterThan) {
                return logger.logReturn(max);
            }
            return logger.logReturn(min);
        }
        var delta = max - min;
        var result = randomValue * delta + min;
        return logger.logReturn((int) result);
    }
}
