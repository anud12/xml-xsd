using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class action_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>? from_person = new List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>();
    public XSD.Nworld_step.Nrule_group.Naction_rule.global? global = null;
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.person_to_person>? person_to_person = new List<XSD.Nworld_step.Nrule_group.Naction_rule.person_to_person>();
    public action_rule()
    {
    }

    public action_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public action_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing action_rule");
      //Deserialize arguments

      //Deserialize children
      this.from_person = rawNode.InitializeWithRawNode("from_person", this.from_person);
      this.global = rawNode.InitializeWithRawNode("global", this.global);
      this.person_to_person = rawNode.InitializeWithRawNode("person_to_person", this.person_to_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["from_person"] = from_person.Select(x => x.SerializeIntoRawNode()).ToList();
      if(global != null) {
        rawNode.children["global"] = new List<RawNode> { global.SerializeIntoRawNode() };
      }
      rawNode.children["person_to_person"] = person_to_person.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing action_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>? Get_from_person()
    {
      return this.from_person;
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person> GetOrInsertDefault_from_person()
    {
      if(this.from_person == null) {
        this.from_person = new List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>();
      }
      return this.from_person;
    }
    public void Set_from_person(List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>? value)
    {
      this.from_person = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.global? Get_global()
    {
      return this.global;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.global GetOrInsertDefault_global()
    {
      if(this.global == null) {
        this.global = new XSD.Nworld_step.Nrule_group.Naction_rule.global();
      }
      return this.global;
    }
    public void Set_global(XSD.Nworld_step.Nrule_group.Naction_rule.global? value)
    {
      this.global = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.person_to_person>? Get_person_to_person()
    {
      return this.person_to_person;
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.person_to_person> GetOrInsertDefault_person_to_person()
    {
      if(this.person_to_person == null) {
        this.person_to_person = new List<XSD.Nworld_step.Nrule_group.Naction_rule.person_to_person>();
      }
      return this.person_to_person;
    }
    public void Set_person_to_person(List<XSD.Nworld_step.Nrule_group.Naction_rule.person_to_person>? value)
    {
      this.person_to_person = value;
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
        "from_person": {
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
            "selection": {
              "metaType": "reference",
              "value": "type__person_selection",
              "isSingle": true,
              "isNullable": true
            },
            "mutations": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "property_mutation": {
                  "metaType": "reference",
                  "value": "type__property_mutation",
                  "isSingle": false,
                  "isNullable": true
                }
              },
              "isNullable": true
            },
            "on_person": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "selection": {
                  "metaType": "composition",
                  "value": [
                    {
                      "metaType": "object",
                      "isSingle": true,
                      "value": {
                        "from_person_same_location_graph_node": {
                          "metaType": "object",
                          "value": {},
                          "isSingle": true,
                          "isNullable": true,
                          "attributes": {
                            "metaType": "object",
                            "value": {
                              "value": {
                                "metaType": "primitive",
                                "value": "xs:boolean",
                                "isNullable": false
                              }
                            },
                            "isNullable": false
                          }
                        }
                      }
                    },
                    {
                      "metaType": "primitive",
                      "value": "type__person_selection"
                    }
                  ],
                  "isSingle": true,
                  "isNullable": true
                },
                "mutations": {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "property_mutation": {
                      "metaType": "reference",
                      "value": "type__property_mutation",
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
        "global": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "entry": {
              "metaType": "composition",
              "value": [
                {
                  "metaType": "object",
                  "value": {},
                  "isSingle": true,
                  "isNullable": false,
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
                  }
                },
                {
                  "metaType": "primitive",
                  "value": "type__action"
                }
              ],
              "isSingle": false,
              "isNullable": true
            }
          },
          "isNullable": true
        },
        "person_to_person": {
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
            "test": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "value": {
                  "metaType": "reference",
                  "value": "group__math_operations",
                  "isSingle": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "target": {
                        "metaType": "primitive",
                        "value": "type_person_select",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  },
                  "isNullable": false
                },
                "expected": {
                  "metaType": "reference",
                  "value": "group__math_operations",
                  "isSingle": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "target": {
                        "metaType": "primitive",
                        "value": "type_person_select",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
                  },
                  "isNullable": false
                }
              },
              "isNullable": false
            },
            "property_mutation": {
              "metaType": "reference",
              "value": "type__property_mutation_on",
              "isSingle": true,
              "isNullable": true
            },
            "location_mutation": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "name": {
                    "metaType": "unknown",
                    "isNullable": true
                  },
                  "on": {
                    "metaType": "primitive",
                    "value": "type_person_select",
                    "isNullable": false
                  }
                }
              },
              "isSingle": true,
              "value": {
                "from": {
                  "metaType": "reference",
                  "value": "group__math_operations",
                  "isSingle": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "participant": {
                        "metaType": "primitive",
                        "value": "type_person_select",
                        "isNullable": false
                      }
                    },
                    "isNullable": false
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
      "isNullable": true
    },
    "name": "action_rule"
  }
*/