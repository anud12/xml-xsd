using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ngroup__operation__and {}
namespace XSD {
}
namespace XSD {
  public class group__operation__and  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Ngroup__operation__and.add_property? add_property = null;
    public List<group__operation__and>? and = new List<group__operation__and>();
    public group__operation__and()
    {
    }

    public group__operation__and(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__operation__and(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing group__operation__and");
      //Deserialize arguments

      //Deserialize children
      this.add_property = rawNode.InitializeWithRawNode("add_property", this.add_property);
      this.and = rawNode.InitializeWithRawNode("and", this.and);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(add_property != null) {
        rawNode.children["add_property"] = new List<RawNode> { add_property.SerializeIntoRawNode() };
      }
      rawNode.children["and"] = and.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing group__operation__and");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ngroup__operation__and.add_property? Get_add_property()
    {
      return this.add_property;
    }
    public XSD.Ngroup__operation__and.add_property GetOrInsertDefault_add_property()
    {
      if(this.add_property == null) {
        this.add_property = new XSD.Ngroup__operation__and.add_property();
      }
      return this.add_property;
    }
    public void Set_add_property(XSD.Ngroup__operation__and.add_property? value)
    {
      this.add_property = value;
    }
    public List<group__operation__and>? Get_and()
    {
      return this.and;
    }
    public void Set_and(List<group__operation__and>? value)
    {
      this.and = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": false,
      "value": {
        "add_property": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": true,
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
        "and": {
          "metaType": "reference",
          "value": "group__operation__and",
          "isSingle": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "do": {
                "metaType": "primitive",
                "value": "type__group__operation__and",
                "isNullable": false
              },
              "value": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            }
          },
          "isNullable": true
        }
      }
    },
    "name": "group__operation__and"
  }
*/