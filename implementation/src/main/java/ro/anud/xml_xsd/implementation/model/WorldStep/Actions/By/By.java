package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class By implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "by";
    public static By fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new By();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static By fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<By> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> By.fromRawNode(o, parent)));
        }

    }
    public static List<By> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<By> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> By.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.actions.by";
    }

    //Attributes

    private String personRef;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement doElement = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards> moveTowards = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<By>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<By>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "by";
    }
    public static By of() {
      return new By();
    }

    public void notifyChange(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.onChange(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(object));
      }
    }

    public void notifyRemove(ro.anud.xml_xsd.implementation.util.LinkedNode object) {
      try (var logger = logScope()) {
        logger.log("Notify remove for", this.buildPath());
        onRemoveList.forEach(consumer -> consumer.onRemove(object, this));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyRemove(object));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode.ifPresent(parent -> notifyRemove());
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions> parentAsActions() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Actions casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement) {
          throw new RuntimeException("trying to delete doElement which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards) {
          this.moveTowards = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<By> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<By> callback) {
      try (var logger = logScope()) {
        onRemoveList.add(callback);
        return logger.logReturn(() -> onRemoveList.remove(callback));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("person_ref");
          var personRefValue = rawNode.getAttributeRequired("person_ref");
          if(Objects.equals(this.personRef, personRefValue)) {
            isDirty = true;
          }
          this.personRef = personRefValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.doElement = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement.fromRawNode(rawNode.getChildrenFirst("do").get(), this);
          this.moveTowards = ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards.fromRawNode(rawNode.getChildrenFirst("move_towards"), this);
        }

        if(isDirty) {
          notifyChange();
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("by");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("person_ref");
          rawNode.setAttribute("person_ref", this.personRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("do");
          rawNode.setChildren("do", Optional.ofNullable(doElement).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement::serializeIntoRawNode).toList());
          innerLogger.log("move_towards");
          rawNode.setChildren("move_towards", moveTowards.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing by");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getPersonRef()
    {
      return this.personRef;
    }
    public By setPersonRef(String value)
    {
      this.personRef = value;
      notifyChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement getDoElement()
    {
      return this.doElement;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement> streamDoElement()
    {
      return Optional.ofNullable(doElement).stream();
    }
    public By setDoElement(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement value)
    {
      this.doElement = value;
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards> getMoveTowards()
    {
      return this.moveTowards;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards getMoveTowardsOrDefault()
    {
      return this.moveTowards.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards();
        this.moveTowards = Optional.of(instance);
        instance.parentNode(this);
        return this.moveTowards.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards> streamMoveTowardsOrDefault()
    {
      return java.util.stream.Stream.of(getMoveTowardsOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards> streamMoveTowards()
    {
      return moveTowards.stream();
    }
    public By setMoveTowards(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards value)
    {
      this.moveTowards = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement.nodeName.length() + 3);
          return this.doElement.deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards.nodeName))
        {
          if(this.moveTowards.isEmpty()) {
            this.moveTowards = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards.nodeName.length() + 3);
          return this.moveTowards.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement.nodeName))
        {
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.DoElement.DoElement.nodeName.length() + 3);
          return this.doElement.getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards.nodeName))
        {
          if(this.moveTowards.isEmpty()) {
            this.moveTowards = Optional.of(new ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.WorldStep.Actions.By.MoveTowards.MoveTowards.nodeName.length() + 3);
          return this.moveTowards.get().getNodeAtPath(childXPath);
        }
        return Optional.of(this);
    }
  }


  /*
    dependant type:
    {
      "type": "element",
      "value": {
        "metaType": "object",
        "attributes": {
          "metaType": "object",
          "value": {
            "person_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "value": {
          "do": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "action_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                },
                "action_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                },
                "person_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            }
          },
          "move_towards": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": true,
            "attributes": {
              "metaType": "object",
              "value": {
                "layer": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": true
                },
                "x": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                },
                "y": {
                  "metaType": "primitive",
                  "value": "xs:int",
                  "isNullable": false
                }
              }
            }
          }
        }
      },
      "name": "by"
    }
  */