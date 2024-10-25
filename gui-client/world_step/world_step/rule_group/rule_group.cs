using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class rule_group  {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public XSD.Nworld_step.Nrule_group.property_rule? property_rule = null;
    public XSD.Nworld_step.Nrule_group.classification_rule? classification_rule = null;
    public XSD.Nworld_step.Nrule_group.name_rule? name_rule = null;
    public XSD.Nworld_step.Nrule_group.race_rule? race_rule = null;
    public XSD.Nworld_step.Nrule_group.action_rule? action_rule = null;
    public XSD.Nworld_step.Nrule_group.events_rule? events_rule = null;
    public XSD.Nworld_step.Nrule_group.link_group_rule_list? link_group_rule_list = null;
    public XSD.Nworld_step.Nrule_group.location_graph_rule? location_graph_rule = null;
    public XSD.Nworld_step.Nrule_group.location_classification_rule? location_classification_rule = null;
    public rule_group()
    {
    }

    public rule_group(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public rule_group(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing rule_group");
      //Deserialize arguments

      //Deserialize children
      this.property_rule = rawNode.InitializeWithRawNode("property_rule", this.property_rule);
      this.classification_rule = rawNode.InitializeWithRawNode("classification_rule", this.classification_rule);
      this.name_rule = rawNode.InitializeWithRawNode("name_rule", this.name_rule);
      this.race_rule = rawNode.InitializeWithRawNode("race_rule", this.race_rule);
      this.action_rule = rawNode.InitializeWithRawNode("action_rule", this.action_rule);
      this.events_rule = rawNode.InitializeWithRawNode("events_rule", this.events_rule);
      this.link_group_rule_list = rawNode.InitializeWithRawNode("link_group_rule_list", this.link_group_rule_list);
      this.location_graph_rule = rawNode.InitializeWithRawNode("location_graph_rule", this.location_graph_rule);
      this.location_classification_rule = rawNode.InitializeWithRawNode("location_classification_rule", this.location_classification_rule);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(property_rule != null) {
        rawNode.children["property_rule"] = new List<RawNode> { property_rule.SerializeIntoRawNode() };
      }
      if(classification_rule != null) {
        rawNode.children["classification_rule"] = new List<RawNode> { classification_rule.SerializeIntoRawNode() };
      }
      if(name_rule != null) {
        rawNode.children["name_rule"] = new List<RawNode> { name_rule.SerializeIntoRawNode() };
      }
      if(race_rule != null) {
        rawNode.children["race_rule"] = new List<RawNode> { race_rule.SerializeIntoRawNode() };
      }
      if(action_rule != null) {
        rawNode.children["action_rule"] = new List<RawNode> { action_rule.SerializeIntoRawNode() };
      }
      if(events_rule != null) {
        rawNode.children["events_rule"] = new List<RawNode> { events_rule.SerializeIntoRawNode() };
      }
      if(link_group_rule_list != null) {
        rawNode.children["link_group_rule_list"] = new List<RawNode> { link_group_rule_list.SerializeIntoRawNode() };
      }
      if(location_graph_rule != null) {
        rawNode.children["location_graph_rule"] = new List<RawNode> { location_graph_rule.SerializeIntoRawNode() };
      }
      if(location_classification_rule != null) {
        rawNode.children["location_classification_rule"] = new List<RawNode> { location_classification_rule.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing rule_group");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    /* ignored attribute key={key} of type=System.Object*/
    public XSD.Nworld_step.Nrule_group.property_rule? Get_property_rule()
    {
      return this.property_rule;
    }
    public XSD.Nworld_step.Nrule_group.property_rule GetOrInsertDefault_property_rule()
    {
      if(this.property_rule == null) {
        this.property_rule = new XSD.Nworld_step.Nrule_group.property_rule();
      }
      return this.property_rule;
    }
    public void Set_property_rule(XSD.Nworld_step.Nrule_group.property_rule? value)
    {
      this.property_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.classification_rule? Get_classification_rule()
    {
      return this.classification_rule;
    }
    public XSD.Nworld_step.Nrule_group.classification_rule GetOrInsertDefault_classification_rule()
    {
      if(this.classification_rule == null) {
        this.classification_rule = new XSD.Nworld_step.Nrule_group.classification_rule();
      }
      return this.classification_rule;
    }
    public void Set_classification_rule(XSD.Nworld_step.Nrule_group.classification_rule? value)
    {
      this.classification_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.name_rule? Get_name_rule()
    {
      return this.name_rule;
    }
    public XSD.Nworld_step.Nrule_group.name_rule GetOrInsertDefault_name_rule()
    {
      if(this.name_rule == null) {
        this.name_rule = new XSD.Nworld_step.Nrule_group.name_rule();
      }
      return this.name_rule;
    }
    public void Set_name_rule(XSD.Nworld_step.Nrule_group.name_rule? value)
    {
      this.name_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.race_rule? Get_race_rule()
    {
      return this.race_rule;
    }
    public XSD.Nworld_step.Nrule_group.race_rule GetOrInsertDefault_race_rule()
    {
      if(this.race_rule == null) {
        this.race_rule = new XSD.Nworld_step.Nrule_group.race_rule();
      }
      return this.race_rule;
    }
    public void Set_race_rule(XSD.Nworld_step.Nrule_group.race_rule? value)
    {
      this.race_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.action_rule? Get_action_rule()
    {
      return this.action_rule;
    }
    public XSD.Nworld_step.Nrule_group.action_rule GetOrInsertDefault_action_rule()
    {
      if(this.action_rule == null) {
        this.action_rule = new XSD.Nworld_step.Nrule_group.action_rule();
      }
      return this.action_rule;
    }
    public void Set_action_rule(XSD.Nworld_step.Nrule_group.action_rule? value)
    {
      this.action_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.events_rule? Get_events_rule()
    {
      return this.events_rule;
    }
    public XSD.Nworld_step.Nrule_group.events_rule GetOrInsertDefault_events_rule()
    {
      if(this.events_rule == null) {
        this.events_rule = new XSD.Nworld_step.Nrule_group.events_rule();
      }
      return this.events_rule;
    }
    public void Set_events_rule(XSD.Nworld_step.Nrule_group.events_rule? value)
    {
      this.events_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.link_group_rule_list? Get_link_group_rule_list()
    {
      return this.link_group_rule_list;
    }
    public XSD.Nworld_step.Nrule_group.link_group_rule_list GetOrInsertDefault_link_group_rule_list()
    {
      if(this.link_group_rule_list == null) {
        this.link_group_rule_list = new XSD.Nworld_step.Nrule_group.link_group_rule_list();
      }
      return this.link_group_rule_list;
    }
    public void Set_link_group_rule_list(XSD.Nworld_step.Nrule_group.link_group_rule_list? value)
    {
      this.link_group_rule_list = value;
    }
    public XSD.Nworld_step.Nrule_group.location_graph_rule? Get_location_graph_rule()
    {
      return this.location_graph_rule;
    }
    public XSD.Nworld_step.Nrule_group.location_graph_rule GetOrInsertDefault_location_graph_rule()
    {
      if(this.location_graph_rule == null) {
        this.location_graph_rule = new XSD.Nworld_step.Nrule_group.location_graph_rule();
      }
      return this.location_graph_rule;
    }
    public void Set_location_graph_rule(XSD.Nworld_step.Nrule_group.location_graph_rule? value)
    {
      this.location_graph_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.location_classification_rule? Get_location_classification_rule()
    {
      return this.location_classification_rule;
    }
    public XSD.Nworld_step.Nrule_group.location_classification_rule GetOrInsertDefault_location_classification_rule()
    {
      if(this.location_classification_rule == null) {
        this.location_classification_rule = new XSD.Nworld_step.Nrule_group.location_classification_rule();
      }
      return this.location_classification_rule;
    }
    public void Set_location_classification_rule(XSD.Nworld_step.Nrule_group.location_classification_rule? value)
    {
      this.location_classification_rule = value;
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
            "metaType": "unknown",
            "isNullable": false
          }
        },
        "isNullable": false
      },
      "isSingle": false,
      "value": {
        "property_rule": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "entry": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "id": {
                    "metaType": "unknown",
                    "isNullable": false
                  },
                  "units": {
                    "metaType": "unknown",
                    "isNullable": false
                  }
                }
              },
              "isSingle": false,
              "value": {
                "person_default": {
                  "metaType": "composition",
                  "value": [
                    {
                      "metaType": "object",
                      "value": {},
                      "isSingle": true,
                      "isNullable": false
                    },
                    {
                      "metaType": "primitive",
                      "value": "type__math_operations"
                    }
                  ],
                  "isSingle": true,
                  "isNullable": true
                },
                "item_default": {
                  "metaType": "composition",
                  "value": [
                    {
                      "metaType": "object",
                      "value": {},
                      "isSingle": true,
                      "isNullable": false
                    },
                    {
                      "metaType": "primitive",
                      "value": "type__math_operations"
                    }
                  ],
                  "isSingle": true,
                  "isNullable": true
                },
                "property-threshold": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": false,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "name": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "min-value-inclusive": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": true
                      },
                      "max-value-inclusive": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": true
                      }
                    }
                  }
                }
              },
              "isNullable": true
            }
          },
          "isNullable": true
        },
        "classification_rule": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "entry": {
              "metaType": "object",
              "attributes": {
                "metaType": "object",
                "value": {
                  "id": {
                    "metaType": "unknown",
                    "isNullable": false
                  }
                },
                "isNullable": false
              },
              "isSingle": false,
              "value": {
                "property": {
                  "metaType": "reference",
                  "value": "group__math_operations",
                  "isSingle": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "property_rule_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "is": {
                        "metaType": "union",
                        "value": [
                          {
                            "metaType": "primitive",
                            "value": "\"lessThan\""
                          },
                          {
                            "metaType": "primitive",
                            "value": "\"lessThanOrEqual\""
                          },
                          {
                            "metaType": "primitive",
                            "value": "\"greaterThan\""
                          },
                          {
                            "metaType": "primitive",
                            "value": "\"greaterThanOrEqual\""
                          },
                          {
                            "metaType": "primitive",
                            "value": "\"equal\""
                          }
                        ]
                      }
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
        "name_rule": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "entry": {
              "metaType": "reference",
              "value": "group__name_token",
              "isSingle": false,
              "attributes": {
                "metaType": "object",
                "value": {
                  "id": {
                    "metaType": "unknown",
                    "isNullable": false
                  }
                },
                "isNullable": false
              },
              "isNullable": true
            }
          },
          "isNullable": true
        },
        "race_rule": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "entry": {
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
                "vision": {
                  "metaType": "reference",
                  "value": "type_range",
                  "isSingle": true,
                  "isNullable": true
                },
                "movement": {
                  "metaType": "reference",
                  "value": "type_range",
                  "isSingle": true,
                  "isNullable": true
                },
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
                "property_bonus": {
                  "metaType": "reference",
                  "value": "group__math_operations",
                  "isSingle": false,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "property_rule_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": true
                      }
                    },
                    "isNullable": true
                  },
                  "isNullable": true
                },
                "icon": {
                  "metaType": "reference",
                  "value": "type_icon",
                  "isSingle": true,
                  "isNullable": true
                }
              },
              "isNullable": true
            }
          },
          "isNullable": true
        },
        "action_rule": {
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
        "events_rule": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "entry": {
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
                "when": {
                  "metaType": "reference",
                  "value": "type__trigger",
                  "isSingle": false,
                  "isNullable": false
                },
                "then": {
                  "metaType": "object",
                  "isSingle": false,
                  "value": {
                    "select_person": {
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
                              "origin": {
                                "metaType": "union",
                                "value": [
                                  {
                                    "metaType": "primitive",
                                    "value": "\"target\""
                                  },
                                  {
                                    "metaType": "primitive",
                                    "value": "\"self\""
                                  }
                                ]
                              }
                            }
                          }
                        },
                        {
                          "metaType": "primitive",
                          "value": "type__person_selection"
                        }
                      ],
                      "isSingle": false,
                      "isNullable": true
                    },
                    "property_mutation": {
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
                              "property_rule_ref": {
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
                          "value": "type__math_operations"
                        }
                      ],
                      "isSingle": true,
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
        "link_group_rule_list": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "link_group_rule": {
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
        "location_graph_rule": {
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
        "location_classification_rule": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "entry": {
              "metaType": "object",
              "value": {},
              "isSingle": false,
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
            }
          },
          "isNullable": true
        }
      },
      "isNullable": false
    },
    "name": "rule_group"
  }
*/