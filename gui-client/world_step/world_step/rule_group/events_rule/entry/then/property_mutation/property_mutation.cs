using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.Nproperty_mutation {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen {
  public class property_mutation : Itype__math_operations {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;

    //Attributes of type__math_operations
    public System.Int32 initial;

    //Children elements

    //Children of type__math_operations

    public property_mutation()
    {
    }

    public property_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public property_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing property_mutation");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }

      // Deserialize arguments of type__math_operations
  if(rawNode.attributes.ContainsKey("initial"))
  {
    var attribute_initial = rawNode.attributes["initial"];
    this.initial = attribute_initial.ToInt();
  }

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
  if(this.initial != null)
  {
    rawNode.attributes["initial"] = this.initial.ToString();
  }

      //Serialize children

      // Serialize children of type__math_operations

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing property_mutation");
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
    public System.Int32 Get_initial()
    {
      return this.initial;
    }
    public void Set_initial(System.Int32 value)
    {
      this.initial = value;
    }
  }
}