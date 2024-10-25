using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class link_group_rule_list  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>? link_group_rule = new List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>();
    public link_group_rule_list()
    {
    }

    public link_group_rule_list(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_group_rule_list(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group_rule_list");
      //Deserialize arguments

      //Deserialize children
      this.link_group_rule = rawNode.InitializeWithRawNode("link_group_rule", this.link_group_rule);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["link_group_rule"] = link_group_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_group_rule_list");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>? Get_link_group_rule()
    {
      return this.link_group_rule;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule> GetOrInsertDefault_link_group_rule()
    {
      if(this.link_group_rule == null) {
        this.link_group_rule = new List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>();
      }
      return this.link_group_rule;
    }
    public void Set_link_group_rule(List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>? value)
    {
      this.link_group_rule = value;
    }
  }
}