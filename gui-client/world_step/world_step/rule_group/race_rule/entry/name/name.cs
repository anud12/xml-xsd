using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry.Nname {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nrace_rule.Nentry {
  public class name  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String name_rule_ref;

    //Children elements
    public name()
    {
    }

    public name(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public name(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing name");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("name_rule_ref"))
      {
        var attribute_name_rule_ref = rawNode.attributes["name_rule_ref"];
        this.name_rule_ref = rawNode.attributes["name_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.name_rule_ref != null)
      {
        rawNode.attributes["name_rule_ref"] = this.name_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing name");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_name_rule_ref()
    {
      return this.name_rule_ref;
    }
    public void Set_name_rule_ref(System.String value)
    {
      this.name_rule_ref = value;
    }
  }
}