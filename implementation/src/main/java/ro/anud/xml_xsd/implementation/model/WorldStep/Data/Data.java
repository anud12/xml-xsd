package ro.anud.xml_xsd.implementation.model.WorldStep.Data;
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
  public class Data implements  ro.anud.xml_xsd.implementation.util.LinkedNode {

    public static Data fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Data();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Data fromRawNode(RawNode rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      var instance = fromRawNode(rawNode);
      instance.setParentNode(parent);
      return logReturn(instance);
    }
    public static Optional<Data> fromRawNode(Optional<RawNode> rawNode, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
        logEnter();
        return logReturn(rawNode.map(o -> Data.fromRawNode(o, parent)));
    }
    public static List<Data> fromRawNode(List<RawNode> rawNodeList, ro.anud.xml_xsd.implementation.util.LinkedNode parent) {
      logEnter();
      List<Data> returnList = Optional.ofNullable(rawNodeList)
          .orElse(List.of())
          .stream()
          .map(o -> Data.fromRawNode(o, parent))
          .collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People> people = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location> location = Optional.empty();

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
    private List<Consumer<Data>> onChangeList = new ArrayList<>();

    public String nodeName() {
      return "data";
    }

    public void setParentNode(ro.anud.xml_xsd.implementation.util.LinkedNode linkedNode) {
      this.parentNode = Optional.of(linkedNode);
    }

    public void removeChild(Object object) {
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People) {
          this.people = Optional.empty();
        }
        if(object instanceof ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location) {
          this.location = Optional.empty();
        }
    }

    public void removeFromParent() {
      parentNode.ifPresent(node -> node.removeChild(this));
    }

    public Subscription onChange(Consumer<Data> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing data");
      //Deserialize arguments

      //Deserialize children
      this.people = ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People.fromRawNode(rawNode.getChildrenFirst("people"), this);
      this.location = ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location.fromRawNode(rawNode.getChildrenFirst("location"), this);
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.setChildren("people", people.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People::serializeIntoRawNode).toList());
      rawNode.setChildren("location", location.stream().map(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location::serializeIntoRawNode).toList());
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing data");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People> getPeople()
    {
      return this.people;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People> streamPeople()
    {
      return people.stream();
    }
    public Data setPeople(ro.anud.xml_xsd.implementation.model.WorldStep.Data.People.People value)
    {
      this.people = Optional.ofNullable(value);
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }

    public Optional<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location> getLocation()
    {
      return this.location;
    }
    public Stream<ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location> streamLocation()
    {
      return location.stream();
    }
    public Data setLocation(ro.anud.xml_xsd.implementation.model.WorldStep.Data.Location.Location value)
    {
      this.location = Optional.ofNullable(value);
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
          "people": {
            "metaType": "object",
            "isSingle": true,
            "value": {
              "person": {
                "metaType": "object",
                "attributes": {
                  "metaType": "object",
                  "value": {
                    "id": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": false
                    },
                    "name": {
                      "metaType": "primitive",
                      "value": "xs:string",
                      "isNullable": true
                    }
                  }
                },
                "isSingle": false,
                "value": {
                  "race": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": true,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "race_rule_ref": {
                          "metaType": "primitive",
                          "value": "xs:string",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
                    }
                  },
                  "properties": {
                    "metaType": "object",
                    "isSingle": true,
                    "value": {
                      "property": {
                        "metaType": "object",
                        "value": {},
                        "isSingle": false,
                        "isNullable": true,
                        "attributes": {
                          "metaType": "object",
                          "value": {
                            "property_rule_ref": {
                              "metaType": "primitive",
                              "value": "xs:string",
                              "isNullable": false
                            },
                            "value": {
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
                  "relations": {
                    "metaType": "object",
                    "value": {},
                    "isSingle": false,
                    "isNullable": true,
                    "attributes": {
                      "metaType": "object",
                      "value": {
                        "with": {
                          "metaType": "unknown",
                          "isNullable": false
                        }
                      },
                      "isNullable": false
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
                            "classification_rule_ref": {
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
                  "icon": {
                    "metaType": "reference",
                    "value": "type_icon",
                    "isSingle": true,
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            },
            "isNullable": true
          },
          "location": {
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
          }
        },
        "isNullable": false
      },
      "name": "data"
    }
  */