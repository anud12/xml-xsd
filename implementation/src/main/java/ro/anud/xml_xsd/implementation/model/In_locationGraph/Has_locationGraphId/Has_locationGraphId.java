package ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId;
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
  public class Has_locationGraphId implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "has__location_graph_id";
    public static Has_locationGraphId fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Has_locationGraphId();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Has_locationGraphId fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Has_locationGraphId> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Has_locationGraphId.fromRawNode(o, parent)));
        }

    }
    public static List<Has_locationGraphId> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Has_locationGraphId> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Has_locationGraphId.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".in__location_graph.has__location_graph_id";
    }

    //Attributes

    private String locationGraphIdRef;

    //Children elements
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or> or = new ArrayList<>();

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
      return "has__location_graph_id";
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

    public Optional<ro.anud.xml_xsd.implementation.model.In_locationGraph.In_locationGraph> parentAsIn_locationGraph() {
      return parentNode.flatMap(node -> {
        if (node instanceof ro.anud.xml_xsd.implementation.model.In_locationGraph.In_locationGraph casted){
          return Optional.of(casted);
        }
        return Optional.empty();
      });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or) {
          this.or.remove(object);
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or) {
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
        // Godot.GD.Print("Deserializing has__location_graph_id");

        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
          innerLogger.log("location_graph_id_ref");
          this.locationGraphIdRef = rawNode.getAttributeRequired("location_graph_id_ref");
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.or = ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or.fromRawNode(rawNode.getChildrenList("or"), this);
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("has__location_graph_id");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
          innerLogger.log("location_graph_id_ref");
          rawNode.setAttribute("location_graph_id_ref", this.locationGraphIdRef);
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("or");
          rawNode.setChildren("or", or.stream().map(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing has__location_graph_id");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getLocationGraphIdRef()
    {
      return this.locationGraphIdRef;
    }
    public Has_locationGraphId setLocationGraphIdRef(String value)
    {
      this.locationGraphIdRef = value;
      notifyChange();
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or> getOr()
    {
      return this.or;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or> streamOr()
    {
      return or.stream();
    }
    public Has_locationGraphId addOr(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or value)
    {
      this.or.add(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }
    public Has_locationGraphId addAllOr(List<ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or> value)
    {
      this.or.addAll(value);
      value.forEach(e -> e.parentNode(this));
      notifyChange();
      return this;
    }
    public Has_locationGraphId removeOr(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or value)
    {
      this.or.remove(value);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or.nodeName + "[" + indexString + "]", "");
          if(!"new".equals(indexString)) {
            var pathIndex = Integer.parseInt(indexString);
            if(this.or.size() > pathIndex) {
              return this.or.get(pathIndex).deserializeAtPath(childXPath,rawNode);
            }
          }
          var newEntry = new ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or();
          this.addOr(newEntry);
          return newEntry.deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or.nodeName + "["))
        {
          var startTokens = xpath.split(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or.nodeName + "\\[");
          var endToken = startTokens[1].split("]");
          var indexString = endToken[0];
          var childXPath = xpath.replace(ro.anud.xml_xsd.implementation.model.In_locationGraph.Has_locationGraphId.Or.Or.nodeName + "[" + indexString + "]", "");
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
      },
      "name": "has__location_graph_id"
    }
  */