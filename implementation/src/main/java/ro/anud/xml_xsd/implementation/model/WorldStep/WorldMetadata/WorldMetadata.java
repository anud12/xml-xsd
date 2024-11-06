package ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import java.util.stream.Stream;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class WorldMetadata implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static WorldMetadata fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new WorldMetadata();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static WorldMetadata fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<WorldMetadata> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> WorldMetadata.fromRawNode(o, parent)));
    }
    public static List<WorldMetadata> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<WorldMetadata> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> WorldMetadata.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep> previousWorldStep = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep> nextWorldStep = Optional.empty();
    private ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime elapsedTime = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime();
    private ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration stepDuration = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration();
    private ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter counter = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter();
    private ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable randomizationTable = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<WorldMetadata>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "world_metadata";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep) {
          this.previousWorldStep = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep) {
          this.nextWorldStep = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime) {
          throw new RuntimeException("trying to delete elapsedTime which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration) {
          throw new RuntimeException("trying to delete stepDuration which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter) {
          throw new RuntimeException("trying to delete counter which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable) {
          throw new RuntimeException("trying to delete randomizationTable which is required");
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<WorldMetadata> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_metadata");
      //Deserialize arguments

      //Deserialize children
      this.previousWorldStep = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep.fromRawNode(rawNode.getChildrenFirst("previous_world_step"), this);
      this.nextWorldStep = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep.fromRawNode(rawNode.getChildrenFirst("next_world_step"), this);
      this.elapsedTime = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime.fromRawNode(rawNode.getChildrenFirst("elapsed_time").get(), this);
      this.stepDuration = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration.fromRawNode(rawNode.getChildrenFirst("stepDuration").get(), this);
      this.counter = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter.fromRawNode(rawNode.getChildrenFirst("counter").get(), this);
      this.randomizationTable = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable.fromRawNode(rawNode.getChildrenFirst("randomization_table").get(), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("previous_world_step", previousWorldStep.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep::serializeIntoRawNode).toList());
      rawNode.setChildren("next_world_step", nextWorldStep.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep::serializeIntoRawNode).toList());
      rawNode.setChildren("elapsed_time", Optional.ofNullable(elapsedTime).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime::serializeIntoRawNode).toList());
      rawNode.setChildren("stepDuration", Optional.ofNullable(stepDuration).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration::serializeIntoRawNode).toList());
      rawNode.setChildren("counter", Optional.ofNullable(counter).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter::serializeIntoRawNode).toList());
      rawNode.setChildren("randomization_table", Optional.ofNullable(randomizationTable).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing world_metadata");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep> getPreviousWorldStep()
    {
      return this.previousWorldStep;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep getPreviousWorldStepOrDefault()
    {
      return this.previousWorldStep.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep();
        instance.setParentNode(this);
        this.previousWorldStep = Optional.of(instance);
        return this.previousWorldStep.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep> streamPreviousWorldStep()
    {
      return previousWorldStep.stream();
    }
    public WorldMetadata setPreviousWorldStep(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep value)
    {
      this.previousWorldStep = Optional.ofNullable(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep> getNextWorldStep()
    {
      return this.nextWorldStep;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep getNextWorldStepOrDefault()
    {
      return this.nextWorldStep.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep();
        instance.setParentNode(this);
        this.nextWorldStep = Optional.of(instance);
        return this.nextWorldStep.get();
      });
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep> streamNextWorldStep()
    {
      return nextWorldStep.stream();
    }
    public WorldMetadata setNextWorldStep(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep value)
    {
      this.nextWorldStep = Optional.ofNullable(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime getElapsedTime()
    {
      return this.elapsedTime;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime> streamElapsedTime()
    {
      return Optional.ofNullable(elapsedTime).stream();
    }
    public WorldMetadata setElapsedTime(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime value)
    {
      this.elapsedTime = value;
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration getStepDuration()
    {
      return this.stepDuration;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration> streamStepDuration()
    {
      return Optional.ofNullable(stepDuration).stream();
    }
    public WorldMetadata setStepDuration(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration value)
    {
      this.stepDuration = value;
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter getCounter()
    {
      return this.counter;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter> streamCounter()
    {
      return Optional.ofNullable(counter).stream();
    }
    public WorldMetadata setCounter(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter value)
    {
      this.counter = value;
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable getRandomizationTable()
    {
      return this.randomizationTable;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable> streamRandomizationTable()
    {
      return Optional.ofNullable(randomizationTable).stream();
    }
    public WorldMetadata setRandomizationTable(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable value)
    {
      this.randomizationTable = value;
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

  }


  /*
    dependant type:
    {
      "type": "element",
      "value": {
        "metaType": "object",
        "isSingle": true,
        "value": {
          "previous_world_step": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "value": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                }
              },
              "isNullable": true
            }
          },
          "next_world_step": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "value": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                }
              },
              "isNullable": true
            }
          },
          "elapsed_time": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "value": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "stepDuration": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "value": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "counter": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "value": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "randomization_table": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "entry": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": false,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "value": {
                      "metaType": "primitive",
                      "value": "xs:int",
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                }
              }
            },
            "isNullable": false
          }
        },
        "isNullable": false
      },
      "name": "world_metadata"
    }
  */