using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata {
  public class location  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph>? location_graph = new List<XSD.Nworld_step.Ndata.Nlocation.location_graph>();
    public location()
    {
    }

    public location(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location");
      //Deserialize arguments

      //Deserialize children
      this.location_graph = rawNode.InitializeWithRawNode("location_graph", this.location_graph);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["location_graph"] = location_graph.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph>? Get_location_graph()
    {
      return this.location_graph;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.location_graph> GetOrInsertDefault_location_graph()
    {
      if(this.location_graph == null) {
        this.location_graph = new List<XSD.Nworld_step.Ndata.Nlocation.location_graph>();
      }
      return this.location_graph;
    }
    public void Set_location_graph(List<XSD.Nworld_step.Ndata.Nlocation.location_graph>? value)
    {
      this.location_graph = value;
    }
  }
}