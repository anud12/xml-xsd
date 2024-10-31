package ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public class Has_locationGraphId  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<Has_locationGraphId>> onChangeList = new ArrayList<>();

    public static Has_locationGraphId fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Has_locationGraphId();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<Has_locationGraphId> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Has_locationGraphId::fromRawNode));
    }
    public static List<Has_locationGraphId> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Has_locationGraphId> returnList = rawNodeList.stream().map(Has_locationGraphId::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<Has_locationGraphId> onChange) {
      onChangeList.add(onChange);
      return () -> onChangeList.remove(onChange);
    }

    //Attributes
    private String locationGraphIdRef;

    //Children elements
    private List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or> or = new ArrayList<>();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing has__location_graph_id");
      //Deserialize arguments
      this.locationGraphIdRef = rawNode.getAttributeRequired("location_graph_id_ref");

      //Deserialize children
      this.or = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or.fromRawNode(rawNode.getChildrenList("or"));
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("location_graph_id_ref", this.locationGraphIdRef);

      //Serialize children
      rawNode.addChildren("or", or);
      return rawNode;
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
      onChangeList.forEach(consumer -> consumer.accept(this));
      return this;
    }
    public List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or> getOr()
    {
      return this.or;
    }
    /*
    public List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or> GetOrInsertDefault_Or()
    {
      if(this.or == null) {
        this.or = new ArrayList<>();
      }
      return this.or;
    }
    */
    public Has_locationGraphId setOr(List<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Or.Or> value)
    {
      this.or = value;
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
      "name": "has__location_graph_id",
      "parentType": {
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
        "name": "in__location_graph",
        "parentType": {
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
          "name": "type__node_graph__selection"
        }
      }
    }
  */