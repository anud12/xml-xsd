using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class location_graph_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup setup = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup();
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>? node_rule = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>();
    public location_graph_rule()
    {
    }

    public location_graph_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.setup = rawNode.InitializeWithRawNode("setup", this.setup);
      this.node_rule = rawNode.InitializeWithRawNode("node_rule", this.node_rule);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(setup != null) {
        rawNode.children["setup"] = new List<RawNode> { setup.SerializeIntoRawNode() };
      }
      rawNode.children["node_rule"] = node_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup Get_setup()
    {
      return this.setup;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup GetOrInsertDefault_setup()
    {
      if(this.setup == null) {
        this.setup = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup();
      }
      return this.setup;
    }
    public void Set_setup(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup value)
    {
      this.setup = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>? Get_node_rule()
    {
      return this.node_rule;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule> GetOrInsertDefault_node_rule()
    {
      if(this.node_rule == null) {
        this.node_rule = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>();
      }
      return this.node_rule;
    }
    public void Set_node_rule(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>? value)
    {
      this.node_rule = value;
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
            "isNullable": false
          }
        },
        "isNullable": false
      },
      "isSingle": true,
      "value": {
        "setup": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "starting_node": {
              "metaType": "object",
              "value": {},
              "isSingle": true,
              "isNullable": false,
              "attributes": {
                "metaType": "object",
                "value": {
                  "node_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  }
                },
                "isNullable": false
              }
            },
            "necessary_node": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "node_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  },
                  "min": {
                    "metaType": "primitive",
                    "value": "xs:int",
                    "isNullable": false
                  },
                  "max": {
                    "metaType": "primitive",
                    "value": "xs:int",
                    "isNullable": true
                  }
                }
              },
              "isSingle": false,
              "value": {
                "or": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": false,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "node_rule_ref": {
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
        },
        "node_rule": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "id": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
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
                  "name_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
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
            "link_group_list": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "reference": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": false,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "link_group_rule_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  }
                },
                "link_group": {
                  "metaType": "object",
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "id": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "angle": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": false
                      },
                      "angleMax": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": true
                      },
                      "limit": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": true
                      }
                    }
                  },
                  "isSingle": false,
                  "value": {
                    "to_option": {
                      "metaType": "object",
                      "attributes": {
                        "metaType": "object",
                        "value": {
                          "node_rule_ref": {
                            "metaType": "primitive",
                            "value": "xs:string",
                            "isNullable": false
                          },
                          "distance": {
                            "metaType": "primitive",
                            "value": "xs:int",
                            "isNullable": false
                          },
                          "maxDistance": {
                            "metaType": "primitive",
                            "value": "xs:int",
                            "isNullable": true
                          },
                          "adjacent_depth_limit": {
                            "metaType": "primitive",
                            "value": "xs:int",
                            "isNullable": false
                          }
                        }
                      },
                      "isSingle": false,
                      "value": {
                        "distance_to_progress_multiplier": {
                          "metaType": "reference",
                          "value": "type__math_operations",
                          "isSingle": true,
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
                }
              },
              "isNullable": true
            },
            "existing_person": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "min": {
                    "metaType": "primitive",
                    "value": "xs:int",
                    "isNullable": false
                  },
                  "max": {
                    "metaType": "primitive",
                    "value": "xs:int",
                    "isNullable": true
                  }
                }
              },
              "isSingle": true,
              "value": {
                "person_selection": {
                  "metaType": "reference",
                  "value": "type__person_selection",
                  "isSingle": true,
                  "isNullable": false
                }
              },
              "isNullable": true
            }
          },
          "isNullable": true
        }
      },
      "isNullable": true
    },
    "name": "location_graph_rule"
  }
*/