using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople {
  public class person  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String? name;

    //Children elements
    public XSD.Nworld_step.Ndata.Npeople.Nperson.race? race = null;
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties? properties = null;
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations>? relations = new List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations>();
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? classifications = null;
    public type_icon? icon = null;
    public person()
    {
    }

    public person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }

      //Deserialize children
      this.race = rawNode.InitializeWithRawNode("race", this.race);
      this.properties = rawNode.InitializeWithRawNode("properties", this.properties);
      this.relations = rawNode.InitializeWithRawNode("relations", this.relations);
      this.classifications = rawNode.InitializeWithRawNode("classifications", this.classifications);
      this.icon = rawNode.InitializeWithRawNode("icon", this.icon);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.name != null)
      {
        rawNode.attributes["name"] = this.name?.ToString();
      }

      //Serialize children
      if(race != null) {
        rawNode.children["race"] = new List<RawNode> { race.SerializeIntoRawNode() };
      }
      if(properties != null) {
        rawNode.children["properties"] = new List<RawNode> { properties.SerializeIntoRawNode() };
      }
      rawNode.children["relations"] = relations.Select(x => x.SerializeIntoRawNode()).ToList();
      if(classifications != null) {
        rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
      }
      if(icon != null) {
        rawNode.children["icon"] = new List<RawNode> { icon.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person");
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
    public System.String? Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String? value)
    {
      this.name = value;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.race? Get_race()
    {
      return this.race;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.race GetOrInsertDefault_race()
    {
      if(this.race == null) {
        this.race = new XSD.Nworld_step.Ndata.Npeople.Nperson.race();
      }
      return this.race;
    }
    public void Set_race(XSD.Nworld_step.Ndata.Npeople.Nperson.race? value)
    {
      this.race = value;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties? Get_properties()
    {
      return this.properties;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties GetOrInsertDefault_properties()
    {
      if(this.properties == null) {
        this.properties = new XSD.Nworld_step.Ndata.Npeople.Nperson.properties();
      }
      return this.properties;
    }
    public void Set_properties(XSD.Nworld_step.Ndata.Npeople.Nperson.properties? value)
    {
      this.properties = value;
    }
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations>? Get_relations()
    {
      return this.relations;
    }
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations> GetOrInsertDefault_relations()
    {
      if(this.relations == null) {
        this.relations = new List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations>();
      }
      return this.relations;
    }
    public void Set_relations(List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations>? value)
    {
      this.relations = value;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? Get_classifications()
    {
      return this.classifications;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications GetOrInsertDefault_classifications()
    {
      if(this.classifications == null) {
        this.classifications = new XSD.Nworld_step.Ndata.Npeople.Nperson.classifications();
      }
      return this.classifications;
    }
    public void Set_classifications(XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? value)
    {
      this.classifications = value;
    }
    public type_icon? Get_icon()
    {
      return this.icon;
    }
    public void Set_icon(type_icon? value)
    {
      this.icon = value;
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
          },
          "name": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": true
          }
        }
      },
      "isSingle": false,
      "value": {
        "race": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": true,
          "attributes": {
            "metaType": "object",
            "value": {
              "race_rule_ref": {
                "metaType": "unknown",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        "properties": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "property": {
              "metaType": "object",
              "value": {},
              "isSingle": false,
              "isNullable": true,
              "attributes": {
                "metaType": "object",
                "value": {
                  "property_rule_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  },
                  "value": {
                    "metaType": "unknown",
                    "isNullable": false
                  }
                }
              }
            }
          },
          "isNullable": true
        },
        "relations": {
          "metaType": "object",
          "value": {},
          "isSingle": false,
          "isNullable": true,
          "attributes": {
            "metaType": "object",
            "value": {
              "with": {
                "metaType": "unknown",
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
                  "classification_rule_ref": {
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
        "icon": {
          "metaType": "reference",
          "value": "type_icon",
          "isSingle": true,
          "isNullable": true
        }
      },
      "isNullable": true
    },
    "name": "person"
  }
*/