using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__create {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class location_graph__create  {

    public static string ClassTypeId = "/world_step/actions/location_graph.create";
    public static string TagName = "location_graph.create";

    public string Tag = "location_graph.create";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_rule_ref;
    public System.String _location_graph_rule_ref;

    //Children elements
    public location_graph__create()
    {
    }

    public location_graph__create(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph__create(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph.create");
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
        // Godot.GD.Print("Serializing location_graph.create");
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