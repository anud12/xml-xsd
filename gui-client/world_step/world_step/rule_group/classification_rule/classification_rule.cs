using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nclassification_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class classification_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>? entry = new List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>();
    public classification_rule()
    {
    }

    public classification_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public classification_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing classification_rule");
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
        // Godot.GD.Print("Serializing classification_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>? Get_entry()
    {
      return this.entry;
    }
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>? value)
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
    "name": "classification_rule"
  }
*/