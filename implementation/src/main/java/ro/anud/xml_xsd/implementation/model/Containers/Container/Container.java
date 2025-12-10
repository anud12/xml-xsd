package ro.anud.xml_xsd.implementation.model.Containers.Container;
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
  public class Container implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "container";
    public static Container fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Container();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Container fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Container> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Container.fromRawNode(o, parent)));
        }

    }
    public static List<Container> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Container> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Container.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".containers.container";
    }

    //Attributes

    private String id;

    private String containerRuleRef;

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities> entities = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<Container>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<Container>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "container";
    }
    public static Container of() {
      return new Container();
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

    public Optional<ro.anud.xml_xsd.implementation.model.Containers.Containers> parentAsContainers() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.Containers.Containers casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities) {
          this.entities = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<Container> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<Container> callback) {
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
          innerLogger.log("container_rule_ref");
          var containerRuleRefValue = rawNode.getAttributeRequired("container_rule_ref");
          if(Objects.equals(this.containerRuleRef, containerRuleRefValue)) {
            isDirty = true;
          }
          this.containerRuleRef = containerRuleRefValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.entities = ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities.fromRawNode(rawNode.getChildrenFirst("entities"), this);
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
        rawNode.setTag("container");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("id");
          rawNode.setAttribute("id", this.id);
          innerLogger.log("container_rule_ref");
          rawNode.setAttribute("container_rule_ref", this.containerRuleRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("entities");
          rawNode.setChildren("entities", entities.stream().map(ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing container");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public Container setId(String value)
    {
      this.id = value;
      notifyChange();
      return this;
    }
    public String getContainerRuleRef()
    {
      return this.containerRuleRef;
    }
    public Container setContainerRuleRef(String value)
    {
      this.containerRuleRef = value;
      notifyChange();
      return this;
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities> getEntities()
    {
      return this.entities;
    }
    public ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities getEntitiesOrDefault()
    {
      return this.entities.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities();
        this.entities = Optional.of(instance);
        instance.parentNode(this);
        return this.entities.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities> streamEntitiesOrDefault()
    {
      return java.util.stream.Stream.of(getEntitiesOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities> streamEntities()
    {
      return entities.stream();
    }
    public Container setEntities(ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities value)
    {
      this.entities = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities.nodeName))
        {
          if(this.entities.isEmpty()) {
            this.entities = Optional.of(new ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities.nodeName.length() + 3);
          return this.entities.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities.nodeName))
        {
          if(this.entities.isEmpty()) {
            this.entities = Optional.of(new ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Containers.Container.Entities.Entities.nodeName.length() + 3);
          return this.entities.get().getNodeAtPath(childXPath);
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
      },
      "name": "container"
    }
  */