using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nname_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class name_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<group__name_token>? entry = new List<group__name_token>();
    public name_rule()
    {
    }

    public name_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public name_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing name_rule");
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
        // Godot.GD.Print("Serializing name_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<group__name_token>? Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<group__name_token>? value)
    {
      this.entry = value;
    }
  }
}