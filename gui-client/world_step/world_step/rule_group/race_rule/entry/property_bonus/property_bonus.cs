using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry.Nproperty_bonus {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry {
  public class property_bonus : Itype__math_operations {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;

    //Attributes of type__math_operations

    //Children elements

    //Children of type__math_operations

    public property_bonus()
    {
    }

    public property_bonus(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public property_bonus(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing property_bonus");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }

      // Deserialize arguments of type__math_operations

      //Deserialize children

      // Deserialize children of type__math_operations

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }

      // Serialize arguments of type__math_operations


      //Serialize children

      // Serialize children of type__math_operations

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing property_bonus");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
  }
}