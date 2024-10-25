using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {
  public class setup  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node starting_node = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node();
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>? necessary_node = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>();
    public setup()
    {
    }

    public setup(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public setup(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing setup");
      //Deserialize arguments

      //Deserialize children
      this.starting_node = rawNode.InitializeWithRawNode("starting_node", this.starting_node);
      this.necessary_node = rawNode.InitializeWithRawNode("necessary_node", this.necessary_node);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(starting_node != null) {
        rawNode.children["starting_node"] = new List<RawNode> { starting_node.SerializeIntoRawNode() };
      }
      rawNode.children["necessary_node"] = necessary_node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing setup");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node Get_starting_node()
    {
      return this.starting_node;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node GetOrInsertDefault_starting_node()
    {
      if(this.starting_node == null) {
        this.starting_node = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node();
      }
      return this.starting_node;
    }
    public void Set_starting_node(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node value)
    {
      this.starting_node = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>? Get_necessary_node()
    {
      return this.necessary_node;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node> GetOrInsertDefault_necessary_node()
    {
      if(this.necessary_node == null) {
        this.necessary_node = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>();
      }
      return this.necessary_node;
    }
    public void Set_necessary_node(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>? value)
    {
      this.necessary_node = value;
    }
  }
}