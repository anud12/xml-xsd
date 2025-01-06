package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturnVoid;

  @EqualsAndHashCode
  @ToString
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class LocationGraph implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LocationGraph fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LocationGraph();
      instance.rawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LocationGraph fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.parentNode(parent);
      return logReturn(instance);
    }
    public static Optional<LocationGraph> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> LocationGraph.fromRawNode(o, parent)));
    }
    public static List<LocationGraph> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<LocationGraph> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> LocationGraph.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    private String id;

    //Children elements
    @Builder.Default
    private ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule rule = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule();
    @Builder.Default
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> node = new ArrayList<>();

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
    private List<Consumer<Set<Object>>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "location_graph";
    }

    public void childChanged(Set<Object> set) {
      set.add(this);
      onChangeList.forEach(consumer -> consumer.accept(set));
      parentNode.ifPresent(linkedNode -> linkedNode.childChanged(set));
    }

    private void triggerOnChange() {
      childChanged(new HashSet<>());
    }

    public void parentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
      triggerOnChange();
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location> parentAsLocation() {
      return parentNode.flatMap(node -> {
       if (node instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location casted){
         return Optional.of(casted);
       }
       return Optional.empty();
     });
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule) {
          throw new RuntimeException("trying to delete rule which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node) {
          throw new RuntimeException("trying to delete node which is required");
        }
    }

    public int buildIndexForChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule) {
          return 0;
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node) {
          return this.node.indexOf(object);
        }
        return 0;
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Set<Object>> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      var logger = logEnter();
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph");
      var innerLogger = logger.log("attributes");
      //Deserialize attributes
      innerLogger.log("id");
      this.id = rawNode.getAttributeRequired("id");
      innerLogger = logger.log("children");
      //Deserialize children
      this.rule = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule.fromRawNode(rawNode.getChildrenFirst("rule").get(), this);
      this.node = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node.fromRawNode(rawNode.getChildrenList("node"), this);
      logReturnVoid();
    }

    public RawNode serializeIntoRawNode()
    {
      var logger = logEnter();
      var innerLogger = logger.log("attributes");
      //Serialize attributes
      innerLogger.log("id");
      rawNode.setAttribute("id", this.id);

      innerLogger = logger.log("children");
      //Serialize children
      innerLogger.log("rule");
      rawNode.setChildren("rule", Optional.ofNullable(rule).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule::serializeIntoRawNode).toList());
      innerLogger.log("node");
      rawNode.setChildren("node", node.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing location_graph");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public String getId()
    {
      return this.id;
    }
    public LocationGraph setId(String value)
    {
      this.id = value;
      triggerOnChange();
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule getRule()
    {
      return this.rule;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule> streamRule()
    {
      return Optional.ofNullable(rule).stream();
    }
    public LocationGraph setRule(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule value)
    {
      this.rule = value;
      value.parentNode(this);
      triggerOnChange();
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> getNode()
    {
      return this.node;
    }
    public java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> streamNode()
    {
      return node.stream();
    }
    public LocationGraph addNode(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node value)
    {
      this.node.add(value);
      value.parentNode(this);
      triggerOnChange();
      return this;
    }
    public LocationGraph addAllNode(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> value)
    {
      this.node.addAll(value);
      value.forEach(e -> e.parentNode(this));
      triggerOnChange();
      return this;
    }
    public LocationGraph removeNode(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node value)
    {
      this.node.remove(value);
      triggerOnChange();
      return this;
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
            }
          },
          "isNullable": false
        },
        "isSingle": false,
        "value": {
          "rule": {
            "metaType": "object",
            "value": {},
            "isSingle": true,
            "isNullable": false,
            "attributes": {
              "metaType": "object",
              "value": {
                "location_graph_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              },
              "isNullable": false
            }
          },
          "node": {
            "metaType": "object",
            "attributes": {
              "metaType": "object",
              "value": {
                "node_rule_ref": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                },
                "id": {
                  "metaType": "primitive",
                  "value": "xs:string",
                  "isNullable": false
                }
              }
            },
            "isSingle": false,
            "value": {
              "name": {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "value": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              },
              "position": {
                "metaType": "object",
                "value": {},
                "isSingle": true,
                "isNullable": true,
                "attributes": {
                  "metaType": "object",
                  "value": {
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
              },
              "classifications": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "classification": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": false,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "location_classification_rule_ref": {
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
              },
              "links": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "link_to": {
                    "metaType": "object",
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "node_id_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        },
                        "total_progress": {
                          "metaType": "primitive",
                          "value": "xs:int",
                          "isNullable": false
                        }
                      }
                    },
                    "isSingle": false,
                    "value": {
                      "people": {
                        "metaType": "object",
                        "isSingle": true,
                        "value": {
                          "person": {
                            "metaType": "object",
                            "value": {},
                            "isSingle": false,
                            "isNullable": true,
                            "attributes": {
                              "metaType": "object",
                              "value": {
                                "person_id_ref": {
                                  "metaType": "primitive",
                                  "value": "xs:string",
                                  "isNullable": false
                                },
                                "accumulated_progress": {
                                  "metaType": "primitive",
                                  "value": "xs:int",
                                  "isNullable": false
                                }
                              }
                            }
                          }
                        },
                        "isNullable": true
                      },
                      "person_progress_property": {
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
              "people": {
                "metaType": "object",
                "isSingle": true,
                "value": {
                  "person": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": false,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "person_id_ref": {
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
            "isNullable": false
          }
        },
        "isNullable": true
      },
      "name": "location_graph"
    }
  */