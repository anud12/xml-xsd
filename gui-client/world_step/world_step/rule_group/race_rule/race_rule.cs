using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nrace_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class race_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nrace_rule.entry>? entry = new List<XSD.Nworld_step.Nrule_group.Nrace_rule.entry>();
    public race_rule()
    {
    }

    public race_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public race_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing race_rule");
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
        // Godot.GD.Print("Serializing race_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nrace_rule.entry>? Get_entry()
    {
      return this.entry;
    }
    public List<XSD.Nworld_step.Nrule_group.Nrace_rule.entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<XSD.Nworld_step.Nrule_group.Nrace_rule.entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<XSD.Nworld_step.Nrule_group.Nrace_rule.entry>? value)
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
    "name": "race_rule"
  }
*/