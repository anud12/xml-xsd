package ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ro.anud.xml_xsd.implementation.util.RawNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import static ro.anud.xml_xsd.implementation.util.LocalLogger.logEnter;
import static ro.anud.xml_xsd.implementation.util.LocalLogger.logReturn;

  @Getter
  @Setter
  @EqualsAndHashCode
  @ToString
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public class Type_nodeGraph_selection  {

    @ToString.Exclude()
    @EqualsAndHashCode.Exclude()
    @JsonIgnore
    private RawNode rawNode = new RawNode();

    public static Type_nodeGraph_selection fromRawNode(RawNode rawNode) {
      logEnter();
      var instance = new Type_nodeGraph_selection();
      instance.setRawNode(rawNode);
      instance.deserialize(rawNode);
      return logReturn(instance);
    }
      public static Optional<Type_nodeGraph_selection> fromRawNode(Optional<RawNode> rawNode) {
        logEnter();
        return logReturn(rawNode.map(Type_nodeGraph_selection::fromRawNode));
    }
    public static List<Type_nodeGraph_selection> fromRawNode(List<RawNode> rawNodeList) {
      logEnter();
      List<Type_nodeGraph_selection> returnList = rawNodeList.stream().map(Type_nodeGraph_selection::fromRawNode).collect(Collectors.toList());
      return logReturn(returnList);
    }

    //Attributes

    //Children elements
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph> in_locationGraph = Optional.empty();
    private Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId> has_nodeGraphId = Optional.empty();

    public void deserialize (RawNode rawNode) {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__node_graph__selection");
      //Deserialize arguments

      //Deserialize children
      this.in_locationGraph = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph.fromRawNode(rawNode.getChildrenFirst("in__location_graph"));
      this.has_nodeGraphId = ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId.fromRawNode(rawNode.getChildrenFirst("has__node_graph_id"));
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.addChildren("in__location_graph", in_locationGraph);
      rawNode.addChildren("has__node_graph_id", has_nodeGraphId);
      return rawNode;
    }

    public void Serialize(Document document, Element element)
    {
        // Godot.GD.Print("Serializing type__node_graph__selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.populateNode(document, element);
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
      "name": "type__node_graph__selection"
    }
  */