package ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry;
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
  public class Entry implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "entry";
    public static Entry fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Entry();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Entry fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Entry> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Entry.fromRawNode(o, parent)));
        }

    }
    public static List<Entry> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Entry> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Entry.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.rule_group.container_rule.entry";
    }

    //Attributes

    private String name;

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity> allowedEntity = new ArrayList<>();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Entry>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Entry>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "entry";
    }
    public static Entry of() {
      return new Entry();
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule> parentAsContainerRule() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.ContainerRule casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity) {
          this.allowedEntity.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity) {
          return this.allowedEntity.indexOf(object);
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Entry> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Entry> callback) {
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
          innerLogger.log("name");
          var nameValue = rawNode.getAttributeRequired("name");
          if(Objects.equals(this.name, nameValue)) {
            isDirty = true;
          }
          this.name = nameValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.allowedEntity = ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity.fromRawNode(rawNode.getChildrenList("allowed_entity"), this);
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
        rawNode.setTag("entry");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("name");
          rawNode.setAttribute("name", this.name);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("allowed_entity");
          rawNode.setChildren("allowed_entity", allowedEntity.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getName()
    {
      return this.name;
    }
    public Entry setName(String value)
    {
      this.name = value;
      notifyChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity> getAllowedEntity()
    {
      return this.allowedEntity;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity> streamAllowedEntity()
    {
      return allowedEntity.stream();
    }
    public Entry addAllowedEntity(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity value)
    {
      this.allowedEntity.add(value);
      value.parentNode(this);
      return this;
    }
    public Entry addAllAllowedEntity(List<ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity> value)
    {
      this.allowedEntity.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Entry removeAllowedEntity(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity value)
    {
      this.allowedEntity.remove(value);
      value.clearParentNode();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.allowedEntity.size() > pathIndex) {
              return this.allowedEntity.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addAllowedEntity(newEntry);
          return linkedNode;
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.WorldStep.RuleGroup.ContainerRule.Entry.AllowedEntity.AllowedEntity.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.allowedEntity.size() > pathIndex) {
            return this.allowedEntity.get(pathIndex).getNodeAtPath(childXPath);
          }
          return Optional.empty();
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
            "name": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "allowed_entity": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "entity_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": false,
            "value": {
              "max": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": true
              },
              "min": {
                "metaType": "reference",
                "value": "type__math_operations",
                "isSingle": true,
                "isNullable": true
              }
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "entry"
    }
  */