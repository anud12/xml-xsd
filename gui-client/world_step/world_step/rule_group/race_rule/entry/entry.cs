using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nrace_rule {
  public class entry  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public type_range? vision = null;
    public type_range? movement = null;
    public XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry.name? name = null;
    public List<group__math_operations>? property_bonus = new List<group__math_operations>();
    public type_icon? icon = null;
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
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.vision = rawNode.InitializeWithRawNode("vision", this.vision);
      this.movement = rawNode.InitializeWithRawNode("movement", this.movement);
      this.name = rawNode.InitializeWithRawNode("name", this.name);
      this.property_bonus = rawNode.InitializeWithRawNode("property_bonus", this.property_bonus);
      this.icon = rawNode.InitializeWithRawNode("icon", this.icon);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(vision != null) {
        rawNode.children["vision"] = new List<RawNode> { vision.SerializeIntoRawNode() };
      }
      if(movement != null) {
        rawNode.children["movement"] = new List<RawNode> { movement.SerializeIntoRawNode() };
      }
      if(name != null) {
        rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
      }
      rawNode.children["property_bonus"] = property_bonus.Select(x => x.SerializeIntoRawNode()).ToList();
      if(icon != null) {
        rawNode.children["icon"] = new List<RawNode> { icon.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
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
    public type_range? Get_vision()
    {
      return this.vision;
    }
    public void Set_vision(type_range? value)
    {
      this.vision = value;
    }
    public type_range? Get_movement()
    {
      return this.movement;
    }
    public void Set_movement(type_range? value)
    {
      this.movement = value;
    }
    public XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry.name? Get_name()
    {
      return this.name;
    }
    public XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry.name GetOrInsertDefault_name()
    {
      if(this.name == null) {
        this.name = new XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry.name();
      }
      return this.name;
    }
    public void Set_name(XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry.name? value)
    {
      this.name = value;
    }
    public List<group__math_operations>? Get_property_bonus()
    {
      return this.property_bonus;
    }
    public void Set_property_bonus(List<group__math_operations>? value)
    {
      this.property_bonus = value;
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
    },
    "name": "entry"
  }
*/