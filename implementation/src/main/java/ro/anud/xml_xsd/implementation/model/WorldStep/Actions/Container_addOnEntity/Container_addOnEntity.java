package ro.anud.xml_xsd.implementation.model.WorldStep.Actions.Container_addOnEntity;
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
  public class Container_addOnEntity implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "container.addOnEntity";
    public static Container_addOnEntity fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Container_addOnEntity();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Container_addOnEntity fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Container_addOnEntity> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Container_addOnEntity.fromRawNode(o, parent)));
        }

    }
    public static List<Container_addOnEntity> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Container_addOnEntity> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Container_addOnEntity.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.actions.container.addOnEntity";
    }

    //Attributes

    private String containerRuleRef;

    private String entityId;

    //Children elements

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Container_addOnEntity>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Container_addOnEntity>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "container.addOnEntity";
    }
    public static Container_addOnEntity of() {
      return new Container_addOnEntity();
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
    }

    public int buildIndexForChild(Object object) {
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Container_addOnEntity> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Container_addOnEntity> callback) {
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
          innerLogger.log("container_rule_ref");
          var containerRuleRefValue = rawNode.getAttributeRequired("container_rule_ref");
          if(Objects.equals(this.containerRuleRef, containerRuleRefValue)) {
            isDirty = true;
          }
          this.containerRuleRef = containerRuleRefValue;
          innerLogger.log("entity_id");
          var entityIdValue = rawNode.getAttributeRequired("entity_id");
          if(Objects.equals(this.entityId, entityIdValue)) {
            isDirty = true;
          }
          this.entityId = entityIdValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
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
        rawNode.setTag("container.addOnEntity");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("container_rule_ref");
          rawNode.setAttribute("container_rule_ref", this.containerRuleRef);
          innerLogger.log("entity_id");
          rawNode.setAttribute("entity_id", this.entityId);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing container.addOnEntity");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getContainerRuleRef()
    {
      return this.containerRuleRef;
    }
    public Container_addOnEntity setContainerRuleRef(String value)
    {
      this.containerRuleRef = value;
      notifyChange();
      return this;
    }
    public String getEntityId()
    {
      return this.entityId;
    }
    public Container_addOnEntity setEntityId(String value)
    {
      this.entityId = value;
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
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
        "value": {},
        "isSingle": true,
        "isNullable": true,
        "attributes": {
          "metaType": "object",
          "value": {
            "container_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "entity_id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          }
        }
      },
      "name": "container.addOnEntity"
    }
  */