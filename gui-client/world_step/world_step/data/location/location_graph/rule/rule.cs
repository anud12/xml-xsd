using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nrule {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {
  public class rule  {

    public static string ClassTypeId = "/world_step/data/location/location_graph/rule";
    public static string TagName = "rule";

    public string Tag = "rule";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_rule_ref;
    public System.String _location_graph_rule_ref;

    //Children elements
    public rule()
    {
    }

    public rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_rule_ref"))
      {
        var attribute_location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
        this.location_graph_rule_ref = rawNode.attributes["location_graph_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_graph_rule_ref != null)
      {
        rawNode.attributes["location_graph_rule_ref"] = this.location_graph_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_location_graph_rule_ref()
    {
      return this.location_graph_rule_ref;
    }
    public void Set_location_graph_rule_ref(System.String value)
    {
      this.location_graph_rule_ref = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}