using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nin__location_graph {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection {
  public class in__location_graph  {

    public static string ClassTypeId = "/type__node_graph__selection/in__location_graph";
    public static string TagName = "in__location_graph";

    public string Tag = "in__location_graph";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id? _has__location_graph_id = null;
    public XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id? has__location_graph_id {
      get { return _has__location_graph_id; }
      set { _has__location_graph_id = value; }
    }
    public in__location_graph()
    {
    }

    public in__location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public in__location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing in__location_graph");
      //Deserialize arguments

      //Deserialize children
      this._has__location_graph_id = rawNode.InitializeWithRawNode("has__location_graph_id", this._has__location_graph_id);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(has__location_graph_id != null) {
        rawNode.children["has__location_graph_id"] = new List<RawNode> { has__location_graph_id.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing in__location_graph");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id? Get_has__location_graph_id()
    {
      return this._has__location_graph_id;
    }
    public XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id GetOrInsertDefault_has__location_graph_id()
    {
      if(this._has__location_graph_id == null) {

        // true2
        this._has__location_graph_id = new XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_has__location_graph_id();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_has__location_graph_id(XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id? value)
    {
        this._has__location_graph_id = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id.TagName))
      {
        this.has__location_graph_id ??= new XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id();
        xpath = xpath.Substring(XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id.TagName.Length + 3);
        this.has__location_graph_id.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}