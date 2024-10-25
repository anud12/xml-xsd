using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nhas__node_graph_id.Nor {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection.Nhas__node_graph_id {
  public class or  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String? node_graph_id_ref;

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
      if(rawNode.attributes.ContainsKey("node_graph_id_ref"))
      {
        var attribute_node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
        this.node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_graph_id_ref != null)
      {
        rawNode.attributes["node_graph_id_ref"] = this.node_graph_id_ref?.ToString();
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
    public System.String? Get_node_graph_id_ref()
    {
      return this.node_graph_id_ref;
    }
    public void Set_node_graph_id_ref(System.String? value)
    {
      this.node_graph_id_ref = value;
    }
  }
}