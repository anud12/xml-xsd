using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection {}
namespace XSD {
}
namespace XSD {
  public class type__node_graph__selection  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Ntype__node_graph__selection.in__location_graph? in__location_graph = null;
    public XSD.Ntype__node_graph__selection.has__node_graph_id? has__node_graph_id = null;
    public type__node_graph__selection()
    {
    }

    public type__node_graph__selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__node_graph__selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__node_graph__selection");
      //Deserialize arguments

      //Deserialize children
      this.in__location_graph = rawNode.InitializeWithRawNode("in__location_graph", this.in__location_graph);
      this.has__node_graph_id = rawNode.InitializeWithRawNode("has__node_graph_id", this.has__node_graph_id);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(in__location_graph != null) {
        rawNode.children["in__location_graph"] = new List<RawNode> { in__location_graph.SerializeIntoRawNode() };
      }
      if(has__node_graph_id != null) {
        rawNode.children["has__node_graph_id"] = new List<RawNode> { has__node_graph_id.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__node_graph__selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__node_graph__selection.in__location_graph? Get_in__location_graph()
    {
      return this.in__location_graph;
    }
    public XSD.Ntype__node_graph__selection.in__location_graph GetOrInsertDefault_in__location_graph()
    {
      if(this.in__location_graph == null) {
        this.in__location_graph = new XSD.Ntype__node_graph__selection.in__location_graph();
      }
      return this.in__location_graph;
    }
    public void Set_in__location_graph(XSD.Ntype__node_graph__selection.in__location_graph? value)
    {
      this.in__location_graph = value;
    }
    public XSD.Ntype__node_graph__selection.has__node_graph_id? Get_has__node_graph_id()
    {
      return this.has__node_graph_id;
    }
    public XSD.Ntype__node_graph__selection.has__node_graph_id GetOrInsertDefault_has__node_graph_id()
    {
      if(this.has__node_graph_id == null) {
        this.has__node_graph_id = new XSD.Ntype__node_graph__selection.has__node_graph_id();
      }
      return this.has__node_graph_id;
    }
    public void Set_has__node_graph_id(XSD.Ntype__node_graph__selection.has__node_graph_id? value)
    {
      this.has__node_graph_id = value;
    }
  }
}