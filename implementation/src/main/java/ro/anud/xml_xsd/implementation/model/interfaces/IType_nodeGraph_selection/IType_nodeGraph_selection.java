package ro.anud.xml_xsd.implementation.model.interfaces.IType_nodeGraph_selection;

public interface IType_nodeGraph_selection<T> extends ro.anud.xml_xsd.implementation.util.LinkedNode {

  //Children elements
  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph> getIn_locationGraph();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph> streamIn_locationGraph();
  T setIn_locationGraph(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.In_locationGraph.In_locationGraph value);

  java.util.Optional<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId> getHas_nodeGraphId();
  java.util.stream.Stream<ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId> streamHas_nodeGraphId();
  T setHas_nodeGraphId(ro.anud.xml_xsd.implementation.model.Type_nodeGraph_selection.Has_nodeGraphId.Has_nodeGraphId value);
  void deserialize (ro.anud.xml_xsd.implementation.util.RawNode rawNode);

  ro.anud.xml_xsd.implementation.util.RawNode serializeIntoRawNode();

  void serialize(org.w3c.dom.Document document, org.w3c.dom.Element element);
}

/*
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