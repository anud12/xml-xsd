using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class actions  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nactions.by>? by = new List<XSD.Nworld_step.Nactions.by>();
    public List<XSD.Nworld_step.Nactions.location_graph__create>? location_graph__create = new List<XSD.Nworld_step.Nactions.location_graph__create>();
    public List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>? location_graph__node__create_adjacent = new List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>();
    public List<XSD.Nworld_step.Nactions.location_graph__node__add_classification>? location_graph__node__add_classification = new List<XSD.Nworld_step.Nactions.location_graph__node__add_classification>();
    public XSD.Nworld_step.Nactions.person__teleport? person__teleport = null;
    public List<XSD.Nworld_step.Nactions.person__on_person__property_mutation>? person__on_person__property_mutation = new List<XSD.Nworld_step.Nactions.person__on_person__property_mutation>();
    public List<XSD.Nworld_step.Nactions.person__create>? person__create = new List<XSD.Nworld_step.Nactions.person__create>();
    public List<XSD.Nworld_step.Nactions.person__move_to>? person__move_to = new List<XSD.Nworld_step.Nactions.person__move_to>();
    public List<XSD.Nworld_step.Nactions.from_person>? from_person = new List<XSD.Nworld_step.Nactions.from_person>();
    public actions()
    {
    }

    public actions(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public actions(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing actions");
      //Deserialize arguments

      //Deserialize children
      this.by = rawNode.InitializeWithRawNode("by", this.by);
      this.location_graph__create = rawNode.InitializeWithRawNode("location_graph.create", this.location_graph__create);
      this.location_graph__node__create_adjacent = rawNode.InitializeWithRawNode("location_graph.node.create_adjacent", this.location_graph__node__create_adjacent);
      this.location_graph__node__add_classification = rawNode.InitializeWithRawNode("location_graph.node.add_classification", this.location_graph__node__add_classification);
      this.person__teleport = rawNode.InitializeWithRawNode("person.teleport", this.person__teleport);
      this.person__on_person__property_mutation = rawNode.InitializeWithRawNode("person.on_person.property_mutation", this.person__on_person__property_mutation);
      this.person__create = rawNode.InitializeWithRawNode("person.create", this.person__create);
      this.person__move_to = rawNode.InitializeWithRawNode("person.move_to", this.person__move_to);
      this.from_person = rawNode.InitializeWithRawNode("from_person", this.from_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["by"] = by.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.create"] = location_graph__create.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.create_adjacent"] = location_graph__node__create_adjacent.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["location_graph.node.add_classification"] = location_graph__node__add_classification.Select(x => x.SerializeIntoRawNode()).ToList();
      if(person__teleport != null) {
        rawNode.children["person.teleport"] = new List<RawNode> { person__teleport.SerializeIntoRawNode() };
      }
      rawNode.children["person.on_person.property_mutation"] = person__on_person__property_mutation.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.create"] = person__create.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["person.move_to"] = person__move_to.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["from_person"] = from_person.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing actions");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nactions.by>? Get_by()
    {
      return this.by;
    }
    public void Set_by(List<XSD.Nworld_step.Nactions.by>? value)
    {
      this.by = value;
    }
    public List<XSD.Nworld_step.Nactions.location_graph__create>? Get_location_graph__create()
    {
      return this.location_graph__create;
    }
    public List<XSD.Nworld_step.Nactions.location_graph__create> GetOrInsertDefault_location_graph__create()
    {
      if(this.location_graph__create == null) {
        this.location_graph__create = new List<XSD.Nworld_step.Nactions.location_graph__create>();
      }
      return this.location_graph__create;
    }
    public void Set_location_graph__create(List<XSD.Nworld_step.Nactions.location_graph__create>? value)
    {
      this.location_graph__create = value;
    }
    public List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>? Get_location_graph__node__create_adjacent()
    {
      return this.location_graph__node__create_adjacent;
    }
    public List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent> GetOrInsertDefault_location_graph__node__create_adjacent()
    {
      if(this.location_graph__node__create_adjacent == null) {
        this.location_graph__node__create_adjacent = new List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>();
      }
      return this.location_graph__node__create_adjacent;
    }
    public void Set_location_graph__node__create_adjacent(List<XSD.Nworld_step.Nactions.location_graph__node__create_adjacent>? value)
    {
      this.location_graph__node__create_adjacent = value;
    }
    public List<XSD.Nworld_step.Nactions.location_graph__node__add_classification>? Get_location_graph__node__add_classification()
    {
      return this.location_graph__node__add_classification;
    }
    public List<XSD.Nworld_step.Nactions.location_graph__node__add_classification> GetOrInsertDefault_location_graph__node__add_classification()
    {
      if(this.location_graph__node__add_classification == null) {
        this.location_graph__node__add_classification = new List<XSD.Nworld_step.Nactions.location_graph__node__add_classification>();
      }
      return this.location_graph__node__add_classification;
    }
    public void Set_location_graph__node__add_classification(List<XSD.Nworld_step.Nactions.location_graph__node__add_classification>? value)
    {
      this.location_graph__node__add_classification = value;
    }
    public XSD.Nworld_step.Nactions.person__teleport? Get_person__teleport()
    {
      return this.person__teleport;
    }
    public void Set_person__teleport(XSD.Nworld_step.Nactions.person__teleport? value)
    {
      this.person__teleport = value;
    }
    public List<XSD.Nworld_step.Nactions.person__on_person__property_mutation>? Get_person__on_person__property_mutation()
    {
      return this.person__on_person__property_mutation;
    }
    public List<XSD.Nworld_step.Nactions.person__on_person__property_mutation> GetOrInsertDefault_person__on_person__property_mutation()
    {
      if(this.person__on_person__property_mutation == null) {
        this.person__on_person__property_mutation = new List<XSD.Nworld_step.Nactions.person__on_person__property_mutation>();
      }
      return this.person__on_person__property_mutation;
    }
    public void Set_person__on_person__property_mutation(List<XSD.Nworld_step.Nactions.person__on_person__property_mutation>? value)
    {
      this.person__on_person__property_mutation = value;
    }
    public List<XSD.Nworld_step.Nactions.person__create>? Get_person__create()
    {
      return this.person__create;
    }
    public List<XSD.Nworld_step.Nactions.person__create> GetOrInsertDefault_person__create()
    {
      if(this.person__create == null) {
        this.person__create = new List<XSD.Nworld_step.Nactions.person__create>();
      }
      return this.person__create;
    }
    public void Set_person__create(List<XSD.Nworld_step.Nactions.person__create>? value)
    {
      this.person__create = value;
    }
    public List<XSD.Nworld_step.Nactions.person__move_to>? Get_person__move_to()
    {
      return this.person__move_to;
    }
    public List<XSD.Nworld_step.Nactions.person__move_to> GetOrInsertDefault_person__move_to()
    {
      if(this.person__move_to == null) {
        this.person__move_to = new List<XSD.Nworld_step.Nactions.person__move_to>();
      }
      return this.person__move_to;
    }
    public void Set_person__move_to(List<XSD.Nworld_step.Nactions.person__move_to>? value)
    {
      this.person__move_to = value;
    }
    public List<XSD.Nworld_step.Nactions.from_person>? Get_from_person()
    {
      return this.from_person;
    }
    public List<XSD.Nworld_step.Nactions.from_person> GetOrInsertDefault_from_person()
    {
      if(this.from_person == null) {
        this.from_person = new List<XSD.Nworld_step.Nactions.from_person>();
      }
      return this.from_person;
    }
    public void Set_from_person(List<XSD.Nworld_step.Nactions.from_person>? value)
    {
      this.from_person = value;
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
        "by": {
          "metaType": "union",
          "value": [
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": false,
              "value": {
                "do": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "action_rule_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": true
                      },
                      "action_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": true
                      },
                      "person_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    }
                  }
                }
              }
            },
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": false,
              "value": {
                "move_towards": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "layer": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": true
                      },
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
                }
              }
            }
          ],
          "isSingle": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "person_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
          },
          "isNullable": true
        },
        "location_graph.create": {
          "metaType": "object",
          "value": {},
          "isSingle": false,
          "isNullable": true,
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
        "location_graph.node.create_adjacent": {
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
                "isNullable": false
              },
              "node_id_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            }
          }
        },
        "location_graph.node.add_classification": {
          "metaType": "object",
          "isSingle": false,
          "value": {
            "node_graph_selection": {
              "metaType": "reference",
              "value": "type__node_graph__selection",
              "isSingle": true,
              "isNullable": false
            },
            "to_be_added__classification": {
              "metaType": "object",
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
              },
              "isSingle": true,
              "value": {
                "and": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
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
              "isNullable": false
            }
          },
          "isNullable": true
        },
        "person.teleport": {
          "metaType": "union",
          "value": [
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": true,
              "value": {
                "location_graph": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "location_graph_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "node_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      }
                    }
                  }
                }
              }
            },
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": false,
              "value": {
                "link_to": {
                  "metaType": "object",
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "accumulated_progress": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  },
                  "isSingle": true,
                  "value": {
                    "selection": {
                      "metaType": "reference",
                      "value": "type__link_to__selection",
                      "isSingle": true,
                      "isNullable": false
                    }
                  },
                  "isNullable": false
                }
              }
            }
          ],
          "isSingle": true,
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
          },
          "isNullable": true
        },
        "person.on_person.property_mutation": {
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
              "target_person_id_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              },
              "action_property_mutation_rule_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            }
          }
        },
        "person.create": {
          "metaType": "object",
          "isSingle": false,
          "value": {
            "node_graph__selection": {
              "metaType": "reference",
              "value": "type__node_graph__selection",
              "isSingle": true,
              "isNullable": false
            },
            "person__selection": {
              "metaType": "reference",
              "value": "type__person_selection",
              "isSingle": true,
              "isNullable": false
            }
          },
          "isNullable": true
        },
        "person.move_to": {
          "metaType": "object",
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
          },
          "isSingle": false,
          "value": {
            "find_path_towards": {
              "metaType": "reference",
              "value": "type__node_graph__selection",
              "isSingle": true,
              "isNullable": true
            },
            "path": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "node": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": false,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "node_id_ref": {
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
          "isNullable": true
        },
        "from_person": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "person_id_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              },
              "from_person_rule_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            }
          },
          "isSingle": false,
          "value": {
            "on_person": {
              "metaType": "object",
              "value": {},
              "isSingle": true,
              "isNullable": false,
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
      "isNullable": true
    },
    "name": "actions"
  }
*/