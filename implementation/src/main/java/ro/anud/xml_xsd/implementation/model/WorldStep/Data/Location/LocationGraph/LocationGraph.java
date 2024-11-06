package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.*;
import java.util.stream.Stream;
import ro.anud.xml_xsd.implementation.util.Subscription;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  public class LocationGraph implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static LocationGraph fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new LocationGraph();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static LocationGraph fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
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
    private Optional<String> id;

    //Children elements
    private ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule rule = new ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule();
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> node = new ArrayList<>();

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();

    @Getter
    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private Optional<ro.anud.xml_xsd.implementation.util.LinkedNode> parentNode = Optional.empty();
    private List<Consumer<LocationGraph>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "location_graph";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule) {
          throw new RuntimeException("trying to delete rule which is required");
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node) {
          throw new RuntimeException("trying to delete node which is required");
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<LocationGraph> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph");
      //Deserialize arguments
      this.id = rawNode.getAttribute("id");

      //Deserialize children
      this.rule = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule.fromRawNode(rawNode.getChildrenFirst("rule").get(), this);
      this.node = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node.fromRawNode(rawNode.getChildrenList("node"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      this.id.ifPresent(o -> rawNode.setAttribute("id", o));

      //Serialize children
      rawNode.setChildren("rule", Optional.ofNullable(rule).stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule::serializeIntoRawNode).toList());
      rawNode.setChildren("node", node.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing location_graph");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public Optional<String> getId()
    {
      return this.id;
    }
    public LocationGraph setId(Optional<String> value)
    {
      this.id = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule getRule()
    {
      return this.rule;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule> streamRule()
    {
      return Optional.ofNullable(rule).stream();
    }
    public LocationGraph setRule(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Rule.Rule value)
    {
      this.rule = value;
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> getNode()
    {
      return this.node;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> streamNode()
    {
      return node.stream();
    }
    public LocationGraph addNode(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node value)
    {
      this.node.add(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public LocationGraph addAllNode(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node> value)
    {
      this.node.addAll(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public LocationGraph removeNode(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.Node.Node value)
    {
      this.node.remove(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
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
              "isNullable": true
            }
          },
          "isNullable": true
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