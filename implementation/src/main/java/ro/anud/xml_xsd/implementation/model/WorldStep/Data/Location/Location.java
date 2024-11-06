package ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location;
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
  public class Location implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Location fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Location();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Location fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Location> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Location.fromRawNode(o, parent)));
    }
    public static List<Location> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Location> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Location.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph> locationGraph = new ArrayList<>();

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
    private List<Consumer<Location>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "location";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph) {
          this.locationGraph.remove(object);
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Location> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location");
      //Deserialize arguments

      //Deserialize children
      this.locationGraph = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph.fromRawNode(rawNode.getChildrenList("location_graph"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("location_graph", locationGraph.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing location");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph> getLocationGraph()
    {
      return this.locationGraph;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph> streamLocationGraph()
    {
      return locationGraph.stream();
    }
    public Location addLocationGraph(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph value)
    {
      this.locationGraph.add(value);
      value.setParentNode(this);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Location addAllLocationGraph(List<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph> value)
    {
      this.locationGraph.addAll(value);
      value.forEach(e -> e.setParentNode(this));
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public Location removeLocationGraph(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.LocationGraph.LocationGraph value)
    {
      this.locationGraph.remove(value);
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
        "isSingle": true,
        "value": {
          "location_graph": {
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
          }
        },
        "isNullable": true
      },
      "name": "location"
    }
  */