package ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection;
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
  public class Type_nodeGraph_selection implements  ro.anud.xml_xsd.implementation.model.interfaces.IType_nodeGraph_selection.IType_nodeGraph_selection<Type_nodeGraph_selection>,  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static String nodeName = "type__node_graph__selection";
    public static Type_nodeGraph_selection fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        var instance = new Type_nodeGraph_selection();
        if(Objects.nonNull(parent)) {
          instance.parentNode(parent);
        }
        instance.rawNode(rawNode);
        instance.deserialize(rawNode);
        return logger.logReturn(instance);
      }

    }
    public static Type_nodeGraph_selection fromRawNode(RawNode rawNode) {
      try (var logger = logScope()) {
        var instance = fromRawNode(rawNode, null);
        return logger.logReturn(instance);
      }
    }
    public static Optional<Type_nodeGraph_selection> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        try(var logger = logScope()) {
          return logger.logReturn(rawNode.map(o -> Type_nodeGraph_selection.fromRawNode(o, parent)));
        }

    }
    public static List<Type_nodeGraph_selection> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      try (var logger = logScope()) {
        List<Type_nodeGraph_selection> returnList = Optional.ofNullable(rawNodeList)
            .orElse(List.of())
            .stream()
            .map(o -> Type_nodeGraph_selection.fromRawNode(o, parent))
            .collect(Collectors.toList());
        return logger.logReturn(returnList);
      }
    }

    public String classTypeId() {
      return ".type__node_graph__selection";
    }

    //Attributes

    //Children elements
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph> in_locationGraph = Optional.empty();
    @Builder.Default
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId> has_nodeGraphId = Optional.empty();

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
      return "type__node_graph__selection";
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

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph) {
          this.in_locationGraph = Optional.empty();
          notifyChange();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId) {
          this.has_nodeGraphId = Optional.empty();
          notifyChange();
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId) {
          return 0;
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
        // Godot.GD.Print("Deserializing type__node_graph__selection");

        try (var innerLogger = logScope("attributes")) {
          //Deserialize attributes
        }
        try (var innerLogger = logScope("children")) {
          //Deserialize children
          this.in_locationGraph = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph.fromRawNode(rawNode.getChildrenFirst("in__location_graph"), this);
          this.has_nodeGraphId = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId.fromRawNode(rawNode.getChildrenFirst("has__node_graph_id"), this);
        }
      } catch (Exception e) {
        throw new RuntimeException("Deserialization failed for: " + this.buildPath(), e);
      }

    }

    public RawNode serializeIntoRawNode()
    {
      try (var logger = logScope()) {
        rawNode.setTag("type__node_graph__selection");
        try (var innerLogger = logScope("attributes")) {
          //Serialize attributes
        }
        try (var innerLogger = logScope("children")) {

          //Serialize children
          innerLogger.log("in__location_graph");
          rawNode.setChildren("in__location_graph", in_locationGraph.stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph::serializeIntoRawNode).toList());
          innerLogger.log("has__node_graph_id");
          rawNode.setChildren("has__node_graph_id", has_nodeGraphId.stream().map(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId::serializeIntoRawNode).toList());
          return rawNode;
        }
      }
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__node_graph__selection");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph> getIn_locationGraph()
    {
      return this.in_locationGraph;
    }
    public ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph getIn_locationGraphOrDefault()
    {
      return this.in_locationGraph.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph();
        this.in_locationGraph = Optional.of(instance);
        instance.parentNode(this);
        return this.in_locationGraph.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph> streamIn_locationGraphOrDefault()
    {
      return java.util.stream.Stream.of(getIn_locationGraphOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph> streamIn_locationGraph()
    {
      return in_locationGraph.stream();
    }
    public Type_nodeGraph_selection setIn_locationGraph(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph value)
    {
      this.in_locationGraph = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId> getHas_nodeGraphId()
    {
      return this.has_nodeGraphId;
    }
    public ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId getHas_nodeGraphIdOrDefault()
    {
      return this.has_nodeGraphId.orElseGet(() -> {
        var instance = new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId();
        this.has_nodeGraphId = Optional.of(instance);
        instance.parentNode(this);
        return this.has_nodeGraphId.get();
      });
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId> streamHas_nodeGraphIdOrDefault()
    {
      return java.util.stream.Stream.of(getHas_nodeGraphIdOrDefault());
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId> streamHas_nodeGraphId()
    {
      return has_nodeGraphId.stream();
    }
    public Type_nodeGraph_selection setHas_nodeGraphId(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId value)
    {
      this.has_nodeGraphId = Optional.ofNullable(value);
      value.parentNode(this);
      notifyChange();
      return this;
    }

    public ro.anud.xml_xsd.implementation.util.LinkedNode deserializeAtPath(String xpath, RawNode rawNode) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph.nodeName))
        {
          if(this.in_locationGraph.isEmpty()) {
            this.in_locationGraph = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph.nodeName.length() + 3);
          return this.in_locationGraph.get().deserializeAtPath(childXPath, rawNode);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId.nodeName))
        {
          if(this.has_nodeGraphId.isEmpty()) {
            this.has_nodeGraphId = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId.nodeName.length() + 3);
          return this.has_nodeGraphId.get().deserializeAtPath(childXPath, rawNode);
        }

        deserialize(rawNode);
        return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> getNodeAtPath(String xpath) {
       if(xpath.startsWith("."))
        {
          xpath = xpath.substring(1);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph.nodeName))
        {
          if(this.in_locationGraph.isEmpty()) {
            this.in_locationGraph = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph.nodeName.length() + 3);
          return this.in_locationGraph.get().getNodeAtPath(childXPath);
        }
        if(xpath.startsWith(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId.nodeName))
        {
          if(this.has_nodeGraphId.isEmpty()) {
            this.has_nodeGraphId = Optional.of(new ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId());
          }
          var childXPath = xpath.substring(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId.nodeName.length() + 3);
          return this.has_nodeGraphId.get().getNodeAtPath(childXPath);
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
          "in__location_graph": {
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
          "has__node_graph_id": {
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
          }
        }
      },
      "typeDeclaration": {
        "name": "type__node_graph__selection",
        "type": "complex",
        "isSingle": true,
        "value": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "in__location_graph": {
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
            "has__node_graph_id": {
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
            }
          }
        }
      },
      "name": "type__node_graph__selection"
    }
  */