using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection.Nin__location_graph {
  public class has__location_graph_id  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_id_ref;

    //Children elements
    public List<XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id.or>? or = new List<XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id.or>();
    public has__location_graph_id()
    {
    }

    public has__location_graph_id(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public has__location_graph_id(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing has__location_graph_id");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
      {
        var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      }

      //Deserialize children
      this.or = rawNode.InitializeWithRawNode("or", this.or);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_graph_id_ref != null)
      {
        rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref.ToString();
      }

      //Serialize children
      rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing has__location_graph_id");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }
    public List<XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id.or>? Get_or()
    {
      return this.or;
    }
    public List<XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id.or> GetOrInsertDefault_or()
    {
      if(this.or == null) {
        this.or = new List<XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id.or>();
      }
      return this.or;
    }
    public void Set_or(List<XSD.Ntype__node_graph__selection.Nin__location_graph.Nhas__location_graph_id.or>? value)
    {
      this.or = value;
    }
  }
}