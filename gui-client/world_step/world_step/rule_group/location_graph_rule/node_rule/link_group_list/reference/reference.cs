using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.Nreference {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list {
  public class reference  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule/node_rule/link_group_list/reference";
    public static string TagName = "reference";

    public string Tag = "reference";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String link_group_rule_ref;
    public System.String _link_group_rule_ref;

    //Children elements
    public reference()
    {
    }

    public reference(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public reference(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing reference");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("link_group_rule_ref"))
      {
        var attribute_link_group_rule_ref = rawNode.attributes["link_group_rule_ref"];
        this.link_group_rule_ref = rawNode.attributes["link_group_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.link_group_rule_ref != null)
      {
        rawNode.attributes["link_group_rule_ref"] = this.link_group_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing reference");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_link_group_rule_ref()
    {
      return this.link_group_rule_ref;
    }
    public void Set_link_group_rule_ref(System.String value)
    {
      this.link_group_rule_ref = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}