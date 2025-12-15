package ro.anud.xml_xsd.implementation.model.Type_entity;
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
  public class Type_entity implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "type__entity";
    public static Type_entity fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Type_entity();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Type_entity fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Type_entity> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Type_entity.fromRawNode(o, parent)));
        }

    }
    public static List<Type_entity> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Type_entity> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Type_entity.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".type__entity";
    }

    //Attributes

    private String id;
    @Builder.Default
    private Optional<String> entityRuleRef = Optional.empty();

    //Children elements
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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Type_entity>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Type_entity>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "type__entity";
    }
    public static Type_entity of() {
      return new Type_entity();
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

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap) {
          this.textMap = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers) {
          this.containers = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Type_entity> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Type_entity> callback) {
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
        rawNode.setTag("type__entity");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);
          innerLogger.log("entity_rule_ref");
          this.entityRuleRef.ifPresent(o -> rawNode.setAttribute("entity_rule_ref", o));
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
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
        // Godot.GD.Print("Serializing type__entity");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Type_entity setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public Optional<String> getEntityRuleRef()
    {
      return this.entityRuleRef;
    }
    public Type_entity setEntityRuleRef(Optional<String> value)
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
    public Type_entity setTextMap(ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap value)
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
    public Type_entity setContainers(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers value)
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
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap.nodeName))
        {
          if(this.textMap.isEmpty()) {
            this.textMap = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap.nodeName.length() + 3);
          return this.textMap.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers.nodeName))
        {
          if(this.containers.isEmpty()) {
            this.containers = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers.nodeName.length() + 3);
          return this.containers.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap.nodeName))
        {
          if(this.textMap.isEmpty()) {
            this.textMap = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_entity.TextMap.TextMap.nodeName.length() + 3);
          return this.textMap.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers.nodeName))
        {
          if(this.containers.isEmpty()) {
            this.containers = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_entity.Containers.Containers.nodeName.length() + 3);
          return this.containers.get().getNodeAtPath(childXPath);
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
            "id": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": false
            },
            "entity_rule_ref": {
              "metaType": "primitive",
              "value": "xs:string",
              "isNullable": true
            }
          }
        },
        "isSingle": true,
        "value": {
          "text_map": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "text": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "name": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "value": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                }
              }
            },
            "isNullable": true
          },
          "containers": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "container": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "container_rule_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  }
                },
                "isSingle": false,
                "value": {
                  "entities": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "entity": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "entity_id_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            }
                          },
                          "isNullable": false
                        }
                      }
                    },
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          }
        }
      },
      "name": "type__entity"
    }
  */