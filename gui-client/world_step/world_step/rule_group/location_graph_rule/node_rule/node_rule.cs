using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {
  public class node_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name? name = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications? classifications = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list? link_group_list = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person? existing_person = null;
    public node_rule()
    {
    }

    public node_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public node_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing node_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.name = rawNode.InitializeWithRawNode("name", this.name);
      this.classifications = rawNode.InitializeWithRawNode("classifications", this.classifications);
      this.link_group_list = rawNode.InitializeWithRawNode("link_group_list", this.link_group_list);
      this.existing_person = rawNode.InitializeWithRawNode("existing_person", this.existing_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(name != null) {
        rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
      }
      if(classifications != null) {
        rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
      }
      if(link_group_list != null) {
        rawNode.children["link_group_list"] = new List<RawNode> { link_group_list.SerializeIntoRawNode() };
      }
      if(existing_person != null) {
        rawNode.children["existing_person"] = new List<RawNode> { existing_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing node_rule");
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
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name? Get_name()
    {
      return this.name;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name GetOrInsertDefault_name()
    {
      if(this.name == null) {
        this.name = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name();
      }
      return this.name;
    }
    public void Set_name(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name? value)
    {
      this.name = value;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications? Get_classifications()
    {
      return this.classifications;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications GetOrInsertDefault_classifications()
    {
      if(this.classifications == null) {
        this.classifications = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications();
      }
      return this.classifications;
    }
    public void Set_classifications(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications? value)
    {
      this.classifications = value;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list? Get_link_group_list()
    {
      return this.link_group_list;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list GetOrInsertDefault_link_group_list()
    {
      if(this.link_group_list == null) {
        this.link_group_list = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list();
      }
      return this.link_group_list;
    }
    public void Set_link_group_list(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list? value)
    {
      this.link_group_list = value;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person? Get_existing_person()
    {
      return this.existing_person;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person GetOrInsertDefault_existing_person()
    {
      if(this.existing_person == null) {
        this.existing_person = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person();
      }
      return this.existing_person;
    }
    public void Set_existing_person(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person? value)
    {
      this.existing_person = value;
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
    },
    "name": "node_rule"
  }
*/