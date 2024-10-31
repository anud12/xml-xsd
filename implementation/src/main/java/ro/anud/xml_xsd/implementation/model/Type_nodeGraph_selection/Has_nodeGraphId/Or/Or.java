package ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Or;
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
  public class Or  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<Or>> onChangeList = new ArrayList<>();

    public static Or fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Or();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<Or> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Or::fromRawNode));
    }
    public static List<Or> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Or> returnList = rawNodeList.stream().map(Or::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<Or> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    //Attributes
    private Optional<String> nodeGraphIdRef;

    //Children elements

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing or");
      //Deserialize arguments
      this.nodeGraphIdRef = rawNode.getAttribute("node_graph_id_ref");

      //Deserialize children
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments
      rawNode.setAttribute("node_graph_id_ref", this.nodeGraphIdRef);

      //Serialize children
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing or");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }

    public Optional<String> getNodeGraphIdRef()
    {
      return this.nodeGraphIdRef;
    }
    public Or setNodeGraphIdRef(Optional<String> value)
    {
      this.nodeGraphIdRef = value;
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
      },
      "name": "or",
      "parentType": {
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
        "name": "has__node_graph_id",
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