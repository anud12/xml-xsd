using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {
  public class node  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.String id;

    //Children elements
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? name = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? position = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? classifications = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? links = null;
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people? people = null;
    public node()
    {
    }

    public node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public node(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing node");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.name = rawNode.InitializeWithRawNode("name", this.name);
      this.position = rawNode.InitializeWithRawNode("position", this.position);
      this.classifications = rawNode.InitializeWithRawNode("classifications", this.classifications);
      this.links = rawNode.InitializeWithRawNode("links", this.links);
      this.people = rawNode.InitializeWithRawNode("people", this.people);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
      }
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(name != null) {
        rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
      }
      if(position != null) {
        rawNode.children["position"] = new List<RawNode> { position.SerializeIntoRawNode() };
      }
      if(classifications != null) {
        rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
      }
      if(links != null) {
        rawNode.children["links"] = new List<RawNode> { links.SerializeIntoRawNode() };
      }
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? Get_name()
    {
      return this.name;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name GetOrInsertDefault_name()
    {
      if(this.name == null) {
        this.name = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name();
      }
      return this.name;
    }
    public void Set_name(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.name? value)
    {
      this.name = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? Get_position()
    {
      return this.position;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position GetOrInsertDefault_position()
    {
      if(this.position == null) {
        this.position = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position();
      }
      return this.position;
    }
    public void Set_position(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.position? value)
    {
      this.position = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? Get_classifications()
    {
      return this.classifications;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications GetOrInsertDefault_classifications()
    {
      if(this.classifications == null) {
        this.classifications = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications();
      }
      return this.classifications;
    }
    public void Set_classifications(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.classifications? value)
    {
      this.classifications = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? Get_links()
    {
      return this.links;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links GetOrInsertDefault_links()
    {
      if(this.links == null) {
        this.links = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links();
      }
      return this.links;
    }
    public void Set_links(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.links? value)
    {
      this.links = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people? Get_people()
    {
      return this.people;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people GetOrInsertDefault_people()
    {
      if(this.people == null) {
        this.people = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people();
      }
      return this.people;
    }
    public void Set_people(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.people? value)
    {
      this.people = value;
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
    },
    "name": "node"
  }
*/