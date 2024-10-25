using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata {
  public class people  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Ndata.Npeople.person>? person = new List<XSD.Nworld_step.Ndata.Npeople.person>();
    public people()
    {
    }

    public people(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public people(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing people");
      //Deserialize arguments

      //Deserialize children
      this.person = rawNode.InitializeWithRawNode("person", this.person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["person"] = person.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing people");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Npeople.person>? Get_person()
    {
      return this.person;
    }
    public List<XSD.Nworld_step.Ndata.Npeople.person> GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new List<XSD.Nworld_step.Ndata.Npeople.person>();
      }
      return this.person;
    }
    public void Set_person(List<XSD.Nworld_step.Ndata.Npeople.person>? value)
    {
      this.person = value;
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
        "person": {
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
        }
      },
      "isNullable": true
    },
    "name": "people"
  }
*/