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