using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id.Nor {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id {
  public class or  {

    public static string ClassTypeId = "/type__node_graph__selection/in__location_graph/has__location_graph_id/or";
    public static string TagName = "or";

    public string Tag = "or";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String? location_graph_id_ref;
    public System.String? _location_graph_id_ref;

    //Children elements
    public or()
    {
    }

    public or(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public or(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing or");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
      {
        var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_graph_id_ref != null)
      {
        rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref?.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing or");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String? Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String? value)
    {
      this.location_graph_id_ref = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}