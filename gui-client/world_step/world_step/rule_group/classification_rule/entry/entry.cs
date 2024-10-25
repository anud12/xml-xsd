using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nclassification_rule {
  public class entry  {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public List<group__math_operations>? property = new List<group__math_operations>();
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments

      //Deserialize children
      this.property = rawNode.InitializeWithRawNode("property", this.property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    /* ignored attribute key={key} of type=System.Object*/
    public List<group__math_operations>? Get_property()
    {
      return this.property;
    }
    public void Set_property(List<group__math_operations>? value)
    {
      this.property = value;
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
    },
    "name": "entry"
  }
*/