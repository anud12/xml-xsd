package ro.anud.xml_xsd.implementation.model.In_locationGraph;
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
  public class In_locationGraph implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "in__location_graph";
    public static In_locationGraph fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new In_locationGraph();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static In_locationGraph fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<In_locationGraph> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> In_locationGraph.fromRawNode(o, parent)));
        }

    }
    public static List<In_locationGraph> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<In_locationGraph> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> In_locationGraph.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".in__location_graph";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId> has_locationGraphId = Optional.empty();

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
    private List<ro.anud.xml_xsd.implementation.util.ChangeCallback<In_locationGraph>> onChangeList = new ArrayList<>();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.util.RemoveCallback<In_locationGraph>> onRemoveList = new ArrayList<>();

    public String nodeName() {
      return "in__location_graph";
    }
    public static In_locationGraph of() {
      return new In_locationGraph();
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
        if(object instanceof ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId) {
          this.has_locationGraphId = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId) {
          return 0;
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(ro.anud.xml_xsd.implementation.util.ChangeCallback<In_locationGraph> callback) {
      try (var logger = logScope()) {
        onChangeList.add(callback);
        return logger.logReturn(() -> onChangeList.remove(callback));
      }
    }
    public Subscription onRemove(ro.anud.xml_xsd.implementation.util.RemoveCallback<In_locationGraph> callback) {
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
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.has_locationGraphId = ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId.fromRawNode(rawNode.getChildrenFirst("has__location_graph_id"), this);
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
        rawNode.setTag("in__location_graph");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("has__location_graph_id");
          rawNode.setChildren("has__location_graph_id", has_locationGraphId.stream().map(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing in__location_graph");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId> getHas_locationGraphId()
    {
      return this.has_locationGraphId;
    }
    public ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId getHas_locationGraphIdOrDefault()
    {
      return this.has_locationGraphId.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId();
        this.has_locationGraphId = Optional.of(instance);
        instance.parentNode(this);
        return this.has_locationGraphId.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId> streamHas_locationGraphIdOrDefault()
    {
      return java.util.stream.Stream.of(getHas_locationGraphIdOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId> streamHas_locationGraphId()
    {
      return has_locationGraphId.stream();
    }
    public In_locationGraph setHas_locationGraphId(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId value)
    {
      this.has_locationGraphId = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId.nodeName))
        {
          if(this.has_locationGraphId.isEmpty()) {
            this.has_locationGraphId = Optional.of(new ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId.nodeName.length() + 3);
          return this.has_locationGraphId.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId.nodeName))
        {
          if(this.has_locationGraphId.isEmpty()) {
            this.has_locationGraphId = Optional.of(new ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Has_locationGraphId.nodeName.length() + 3);
          return this.has_locationGraphId.get().getNodeAtPath(childXPath);
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
        "isSingle": true,
        "value": {
          "has__location_graph_id": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "location_graph_id_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "isSingle": true,
            "value": {
              "or": {
                "metaType": "object",
                "value": {},
                "isSingle": false,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "location_graph_id_ref": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": true
                    }
                  },
                  "isNullable": true
                }
              }
            },
            "isNullable": true
          }
        },
        "isNullable": true
      },
      "name": "in__location_graph"
    }
  */