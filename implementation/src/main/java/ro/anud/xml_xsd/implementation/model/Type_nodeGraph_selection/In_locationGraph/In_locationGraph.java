package ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph;
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
  public class In_locationGraph  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    @Getter
    @Setter
    private RawNode rawNode = new RawNode();
    private List<Consumer<In_locationGraph>> onChangeList = new ArrayList<>();

    public static In_locationGraph fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new In_locationGraph();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
    public static Optional<In_locationGraph> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(In_locationGraph::fromRawNode));
    }
    public static List<In_locationGraph> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<In_locationGraph> returnList = rawNodeList.stream().map(In_locationGraph::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    public Runnable onChange(Consumer<In_locationGraph> onChange) {
      logEnter();
      onChangeList.add(onChange);
      return logReturn(() -> onChangeList.remove(onChange));
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId> has_locationGraphId = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing in__location_graph");
      //Deserialize arguments

      //Deserialize children
      this.has_locationGraphId = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId.fromRawNode(rawNode.getChildrenFirst("has__location_graph_id"));
    }

    public RawNode serializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("has__location_graph_id", has_locationGraphId);
      return rawNode;
    }

    public void serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing in__location_graph");
        var updatedRawNode = serializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
    }
    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId> getHas_locationGraphId()
    {
      return this.has_locationGraphId;
    }
    /*
    public Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId> GetOrInsertDefault_Has_locationGraphId()
    {
      if(this.has_locationGraphId == null) {
        this.has_locationGraphId = Optional.empty();
      }
      return this.has_locationGraphId;
    }
    */
    public In_locationGraph setHas_locationGraphId(Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.Has_locationGraphId.Has_locationGraphId> value)
    {
      this.has_locationGraphId = value;
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
  */