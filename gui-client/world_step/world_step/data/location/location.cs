using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata {
  public class location  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph>? location_graph = new List<XSD.Nworld_step.Ndata.Nlocation.location_graph>();
    public location()
    {
    }

    public location(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location");
      //Deserialize arguments

      //Deserialize children
      this.location_graph = rawNode.InitializeWithRawNode("location_graph", this.location_graph);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["location_graph"] = location_graph.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph>? Get_location_graph()
    {
      return this.location_graph;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph> GetOrInsertDefault_location_graph()
    {
      if(this.location_graph == null) {
        this.location_graph = new List<XSD.Nworld_step.Ndata.Nlocation.location_graph>();
      }
      return this.location_graph;
    }
    public void Set_location_graph(List<XSD.Nworld_step.Ndata.Nlocation.location_graph>? value)
    {
      this.location_graph = value;
    }
  }
}

/*dependantType
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