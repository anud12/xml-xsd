using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class property_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.entry>? entry = new List<XSD.Nworld_step.Nrule_group.Nproperty_rule.entry>();
    public property_rule()
    {
    }

    public property_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public property_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing property_rule");
      //Deserialize arguments

      //Deserialize children
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing property_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.entry>? Get_entry()
    {
      return this.entry;
    }
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<XSD.Nworld_step.Nrule_group.Nproperty_rule.entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<XSD.Nworld_step.Nrule_group.Nproperty_rule.entry>? value)
    {
      this.entry = value;
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
    "name": "property_rule"
  }
*/