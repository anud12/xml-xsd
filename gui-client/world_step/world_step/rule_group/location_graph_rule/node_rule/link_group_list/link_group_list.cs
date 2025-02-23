using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {
  public class link_group_list  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>? reference = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>();
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group>? link_group = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group>();
    public link_group_list()
    {
    }

    public link_group_list(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_group_list(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group_list");
      //Deserialize arguments

      //Deserialize children
      this.reference = rawNode.InitializeWithRawNode("reference", this.reference);
      this.link_group = rawNode.InitializeWithRawNode("link_group", this.link_group);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["reference"] = reference.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["link_group"] = link_group.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_group_list");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>? Get_reference()
    {
      return this.reference;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference> GetOrInsertDefault_reference()
    {
      if(this.reference == null) {
        this.reference = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>();
      }
      return this.reference;
    }
    public void Set_reference(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>? value)
    {
      this.reference = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group>? Get_link_group()
    {
      return this.link_group;
    }
    public void Set_link_group(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group>? value)
    {
      this.link_group = value;
    }
  }
}