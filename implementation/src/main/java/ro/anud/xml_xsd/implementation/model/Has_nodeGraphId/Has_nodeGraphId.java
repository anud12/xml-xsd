package ro.anud.xml_xsd.implementation.model.Has_nodeGraphId;
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
  public class Has_nodeGraphId implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "has__node_graph_id";
    public static Has_nodeGraphId fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Has_nodeGraphId();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Has_nodeGraphId fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Has_nodeGraphId> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Has_nodeGraphId.fromRawNode(o, parent)));
        }

    }
    public static List<Has_nodeGraphId> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Has_nodeGraphId> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Has_nodeGraphId.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".has__node_graph_id";
    }

    //Attributes

    private String nodeGraphIdRef;

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or> or = new ArrayList<>();

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
      return "has__node_graph_id";
    }

    public void notifyChange(List<Object> list) {
      try (var logger = logScope()) {
        list.addLast(this);
        logger.log("Notify change for", this.buildPath());
        onChangeList.forEach(consumer -> consumer.accept(list));
        parentNode.ifPresent(linkedNode -> linkedNode.notifyChange(list));
      }
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      notifyChange();
    }

    public void clearParentNode() {
      var parentNode = this.parentNode;
      this.parentNode = Optional.empty();
      parentNode.ifPresent(ro.anud.xml_xsd.implementation.util.LinkedNode::notifyChange);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or) {
          this.or.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or) {
          return this.or.indexOf(object);
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<List<Object>> onChange) {
      try (var logger = logScope()) {
        onChangeList.add(onChange);
        return logger.logReturn(() -> onChangeList.remove(onChange));
      }
    }

    public void deserialize (RawNode rawNode) {
      try (var logger = logScope()) {
        this.rawNode = rawNode;
        var isDirty = false;
        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("node_graph_id_ref");
          var nodeGraphIdRefValue = rawNode.getAttributeRequired("node_graph_id_ref");
          if(Objects.equals(this.nodeGraphIdRef, nodeGraphIdRefValue)) {
            isDirty = true;
          }
          this.nodeGraphIdRef = nodeGraphIdRefValue;
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.or = ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or.fromRawNode(rawNode.getChildrenList("or"), this);
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
        rawNode.setTag("has__node_graph_id");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("node_graph_id_ref");
          rawNode.setAttribute("node_graph_id_ref", this.nodeGraphIdRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("or");
          rawNode.setChildren("or", or.stream().map(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing has__node_graph_id");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getNodeGraphIdRef()
    {
      return this.nodeGraphIdRef;
    }
    public Has_nodeGraphId setNodeGraphIdRef(String value)
    {
      this.nodeGraphIdRef = value;
      notifyChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or> getOr()
    {
      return this.or;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or> streamOr()
    {
      return or.stream();
    }
    public Has_nodeGraphId addOr(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or value)
    {
      this.or.add(value);
      value.parentNode(this);
      return this;
    }
    public Has_nodeGraphId addAllOr(List<ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or> value)
    {
      this.or.addAll(value);
      value.forEach(e -> e.parentNode(this));
      return this;
    }
    public Has_nodeGraphId removeOr(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or value)
    {
      this.or.remove(value);
      value.clearParentNode();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.or.size() > pathIndex) {
              return this.or.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or();
          var linkedNode = newEntry.deserializeAtPath(childXPath, rawNode);
          this.addOr(newEntry);
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
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.Has_nodeGraphId.Or.Or.nodeName + "[" + indexString + "]", "");
          var pathIndex = Integer.parseInt(indexString);
          if(this.or.size() > pathIndex) {
            return this.or.get(pathIndex).getNodeAtPath(childXPath);
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
            "node_graph_id_ref": {
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
                "node_graph_id_ref": {
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
      },
      "name": "has__node_graph_id"
    }
  */