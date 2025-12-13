package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entity;
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
  public class Entity implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_entity.IType_entity<Entity>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "entity";
    public static Entity fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Entity();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Entity fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Entity> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Entity.fromRawNode(o, parent)));
        }

    }
    public static List<Entity> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Entity> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Entity.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".world_step.data.entities.entity";
    }

    //Attributes

    //Attributes of type__entity

    private String id;
    @Builder.Default
    private Optional<String> entityRuleRef = Optional.empty();

    //Children elements

    //Children of type__entity
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap> textMap = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers> containers = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Entity>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Entity>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "entity";
    }
    public static Entity of() {
      return new Entity();
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

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities> parentAsEntities() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Entities.Entities casted){
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

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Entity> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Entity> callback) {
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

          // Deserialize arguments of type__entity
          innerLogger.log("id");
          var idValue = rawNode.getAttributeRequired("id");
          if(Objects.equals(this.id, idValue)) {
            isDirty = true;
          }
          this.id = idValue;
          innerLogger.log("entity_rule_ref");
          var entityRuleRefValue = rawNode.getAttribute("entity_rule_ref");
          if(Objects.equals(this.entityRuleRef, entityRuleRefValue)) {
            isDirty = true;
          }
          this.entityRuleRef = entityRuleRefValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children

          // Deserialize children of type__entity
          this.textMap = ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap.fromRawNode(rawNode.getChildrenFirst("text_map"), this);
          this.containers = ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers.fromRawNode(rawNode.getChildrenFirst("containers"), this);
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
        rawNode.setTag("entity");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes

          // Serialize arguments of type__entity
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);
          innerLogger.log("entity_rule_ref");
          this.entityRuleRef.ifPresent(o -> rawNode.setAttribute("entity_rule_ref", o));
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children

          // Serialize children of type__entity
          innerLogger.log("text_map");
          rawNode.setChildren("text_map", textMap.stream().map(ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap::serializeIntoRawNode).toList());
          innerLogger.log("containers");
          rawNode.setChildren("containers", containers.stream().map(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing entity");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public String getId()
    {
      return this.id;
    }
    public Entity setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public Optional<String> getEntityRuleRef()
    {
      return this.entityRuleRef;
    }
    public Entity setEntityRuleRef(Optional<String> value)
    {
      this.entityRuleRef = value;
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap> getTextMap()
    {
      return this.textMap;
    }
    public ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap getTextMapOrDefault()
    {
      return this.textMap.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap();
        this.textMap = Optional.of(instance);
        instance.parentNode(this);
        return this.textMap.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap> streamTextMapOrDefault()
    {
      return java.util.stream.Stream.of(getTextMapOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap> streamTextMap()
    {
      return textMap.stream();
    }
    public Entity setTextMap(ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap value)
    {
      this.textMap = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers> getContainers()
    {
      return this.containers;
    }
    public ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers getContainersOrDefault()
    {
      return this.containers.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers();
        this.containers = Optional.of(instance);
        instance.parentNode(this);
        return this.containers.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers> streamContainersOrDefault()
    {
      return java.util.stream.Stream.of(getContainersOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers> streamContainers()
    {
      return containers.stream();
    }
    public Entity setContainers(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers value)
    {
      this.containers = Optional.ofNullable(value);
      value.parentNode(this);
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
        "attributes": {
          "metaType": "object",
          "value": {}
        },
        "value": {}
      },
      "name": "entity"
    }
  */