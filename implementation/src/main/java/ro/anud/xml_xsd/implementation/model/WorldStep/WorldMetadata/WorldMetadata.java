package ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class WorldMetadata implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "world_metadata";
    public static WorldMetadata fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new WorldMetadata();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static WorldMetadata fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
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

    public String classTypeId() {
      return ".world_step.world_metadata";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep> previousWorldStep = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep> nextWorldStep = Optional.empty();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime elapsedTime = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration stepDuration = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter counter = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter();
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable randomizationTable = new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private RawNode rawNode = new RawNode();

    public RawNode rawNode() {
      return rawNode;
    }
    public void rawNode(RawNode rawNode) {
      this.rawNode = rawNode;
    }

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode() {
      return parentNode;
    }

    @Builder.Default
    private List<Consumer<List<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "world_metadata";
    }

    public void childChanged(List<Object> list) {
      list.addLast(this);
      onChangeList.forEach(consumer -> consumer.accept(list));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(list));
    }

    private void triggerOnChange() {
      childChanged(new ArrayList<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep> parentAsWorldStep() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldStep casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
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

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_metadata");

      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger = logger.log("children");
      //Deserialize children
      this.previousWorldStep = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep.fromRawNode(rawNode.getChildrenFirst("previous_world_step"), this);
      this.nextWorldStep = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep.fromRawNode(rawNode.getChildrenFirst("next_world_step"), this);
      this.elapsedTime = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime.fromRawNode(rawNode.getChildrenFirst("elapsed_time").get(), this);
      this.stepDuration = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration.fromRawNode(rawNode.getChildrenFirst("stepDuration").get(), this);
      this.counter = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter.fromRawNode(rawNode.getChildrenFirst("counter").get(), this);
      this.randomizationTable = ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable.fromRawNode(rawNode.getChildrenFirst("randomization_table").get(), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      rawNode.setTag("world_metadata");
      var innerLogger = logger.log("attributes");
      //Serialize attributes

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("previous_world_step");
      rawNode.setChildren("previous_world_step", previousWorldStep.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep::serializeIntoRawNode).toList());
      innerLogger.log("next_world_step");
      rawNode.setChildren("next_world_step", nextWorldStep.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep::serializeIntoRawNode).toList());
      innerLogger.log("elapsed_time");
      rawNode.setChildren("elapsed_time", Optional.ofNullable(elapsedTime).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime::serializeIntoRawNode).toList());
      innerLogger.log("stepDuration");
      rawNode.setChildren("stepDuration", Optional.ofNullable(stepDuration).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration::serializeIntoRawNode).toList());
      innerLogger.log("counter");
      rawNode.setChildren("counter", Optional.ofNullable(counter).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter::serializeIntoRawNode).toList());
      innerLogger.log("randomization_table");
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
        this.previousWorldStep = Optional.of(instance);
        instance.parentNode(this);
        return this.previousWorldStep.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep> streamPreviousWorldStepOrDefault()
    {
      return java.util.stream.Stream.of(getPreviousWorldStepOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep> streamPreviousWorldStep()
    {
      return previousWorldStep.stream();
    }
    public WorldMetadata setPreviousWorldStep(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep value)
    {
      this.previousWorldStep = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
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
        this.nextWorldStep = Optional.of(instance);
        instance.parentNode(this);
        return this.nextWorldStep.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep> streamNextWorldStepOrDefault()
    {
      return java.util.stream.Stream.of(getNextWorldStepOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep> streamNextWorldStep()
    {
      return nextWorldStep.stream();
    }
    public WorldMetadata setNextWorldStep(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep value)
    {
      this.nextWorldStep = Optional.ofNullable(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime getElapsedTime()
    {
      return this.elapsedTime;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime> streamElapsedTime()
    {
      return Optional.ofNullable(elapsedTime).stream();
    }
    public WorldMetadata setElapsedTime(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime value)
    {
      this.elapsedTime = value;
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration getStepDuration()
    {
      return this.stepDuration;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration> streamStepDuration()
    {
      return Optional.ofNullable(stepDuration).stream();
    }
    public WorldMetadata setStepDuration(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration value)
    {
      this.stepDuration = value;
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter getCounter()
    {
      return this.counter;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter> streamCounter()
    {
      return Optional.ofNullable(counter).stream();
    }
    public WorldMetadata setCounter(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter value)
    {
      this.counter = value;
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable getRandomizationTable()
    {
      return this.randomizationTable;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable> streamRandomizationTable()
    {
      return Optional.ofNullable(randomizationTable).stream();
    }
    public WorldMetadata setRandomizationTable(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable value)
    {
      this.randomizationTable = value;
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep.nodeName))
        {
          if(this.previousWorldStep.isEmpty()) {
            this.previousWorldStep = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.PreviousWorldStep.PreviousWorldStep.nodeName.length() + 3);
          return this.previousWorldStep.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep.nodeName))
        {
          if(this.nextWorldStep.isEmpty()) {
            this.nextWorldStep = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.NextWorldStep.NextWorldStep.nodeName.length() + 3);
          return this.nextWorldStep.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.ElapsedTime.ElapsedTime.nodeName.length() + 3);
          return this.elapsedTime.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.StepDuration.StepDuration.nodeName.length() + 3);
          return this.stepDuration.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.Counter.Counter.nodeName.length() + 3);
          return this.counter.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.WorldMetadata.RandomizationTable.RandomizationTable.nodeName.length() + 3);
          return this.randomizationTable.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
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
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              }
            },
            "isNullable": false
          }
        },
        "isNullable": true
      },
      "name": "world_metadata"
    }
  */