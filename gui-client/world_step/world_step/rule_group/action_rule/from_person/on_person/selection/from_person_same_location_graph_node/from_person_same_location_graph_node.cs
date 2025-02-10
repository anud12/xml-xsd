using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.Nfrom_person_same_location_graph_node {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection {
  public class from_person_same_location_graph_node  {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/from_person/on_person/selection/from_person_same_location_graph_node";
    public static string TagName = "from_person_same_location_graph_node";

    public string Tag = "from_person_same_location_graph_node";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String value;
    public System.String _value;

    //Children elements
    public from_person_same_location_graph_node()
    {
    }

    public from_person_same_location_graph_node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from_person_same_location_graph_node(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person_same_location_graph_node");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = rawNode.attributes["value"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from_person_same_location_graph_node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String value)
    {
      this.value = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}