using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation {
  public class location_graph  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String? id;

    //Children elements
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule rule = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule();
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> node = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node>();
    public location_graph()
    {
    }

    public location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.rule = rawNode.InitializeWithRawNode("rule", this.rule);
      this.node = rawNode.InitializeWithRawNode("node", this.node);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id?.ToString();
      }

      //Serialize children
      if(rule != null) {
        rawNode.children["rule"] = new List<RawNode> { rule.SerializeIntoRawNode() };
      }
      rawNode.children["node"] = node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String? Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String? value)
    {
      this.id = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule Get_rule()
    {
      return this.rule;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule GetOrInsertDefault_rule()
    {
      if(this.rule == null) {
        this.rule = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule();
      }
      return this.rule;
    }
    public void Set_rule(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule value)
    {
      this.rule = value;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> Get_node()
    {
      return this.node;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> GetOrInsertDefault_node()
    {
      if(this.node == null) {
        this.node = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node>();
      }
      return this.node;
    }
    public void Set_node(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> value)
    {
      this.node = value;
    }
  }
}

/*dependantType
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