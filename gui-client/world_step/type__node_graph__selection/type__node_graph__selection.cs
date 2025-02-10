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

    public static string ClassTypeId = "/type__node_graph__selection";
    public static string TagName = "type__node_graph__selection";

    public string Tag = "type__node_graph__selection";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Ntype__node_graph__selection.in__location_graph? _in__location_graph = null;
    public XSD.Ntype__node_graph__selection.in__location_graph? in__location_graph {
      get { return _in__location_graph; }
      set { _in__location_graph = value; }
    }

    private XSD.Ntype__node_graph__selection.has__node_graph_id? _has__node_graph_id = null;
    public XSD.Ntype__node_graph__selection.has__node_graph_id? has__node_graph_id {
      get { return _has__node_graph_id; }
      set { _has__node_graph_id = value; }
    }
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
      this._in__location_graph = rawNode.InitializeWithRawNode("in__location_graph", this._in__location_graph);
      this._has__node_graph_id = rawNode.InitializeWithRawNode("has__node_graph_id", this._has__node_graph_id);
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
      return this._in__location_graph;
    }
    public XSD.Ntype__node_graph__selection.in__location_graph GetOrInsertDefault_in__location_graph()
    {
      if(this._in__location_graph == null) {

        // true2
        this._in__location_graph = new XSD.Ntype__node_graph__selection.in__location_graph();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_in__location_graph();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_in__location_graph(XSD.Ntype__node_graph__selection.in__location_graph? value)
    {
        this._in__location_graph = value;
    }
    public XSD.Ntype__node_graph__selection.has__node_graph_id? Get_has__node_graph_id()
    {
      return this._has__node_graph_id;
    }
    public XSD.Ntype__node_graph__selection.has__node_graph_id GetOrInsertDefault_has__node_graph_id()
    {
      if(this._has__node_graph_id == null) {

        // true2
        this._has__node_graph_id = new XSD.Ntype__node_graph__selection.has__node_graph_id();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_has__node_graph_id();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_has__node_graph_id(XSD.Ntype__node_graph__selection.has__node_graph_id? value)
    {
        this._has__node_graph_id = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__node_graph__selection.in__location_graph.TagName))
      {
        this.in__location_graph ??= new XSD.Ntype__node_graph__selection.in__location_graph();
        xpath = xpath.Substring(XSD.Ntype__node_graph__selection.in__location_graph.TagName.Length + 3);
        this.in__location_graph.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__node_graph__selection.has__node_graph_id.TagName))
      {
        this.has__node_graph_id ??= new XSD.Ntype__node_graph__selection.has__node_graph_id();
        xpath = xpath.Substring(XSD.Ntype__node_graph__selection.has__node_graph_id.TagName.Length + 3);
        this.has__node_graph_id.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}