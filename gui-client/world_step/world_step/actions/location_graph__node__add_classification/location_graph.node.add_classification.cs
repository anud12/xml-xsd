using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class location_graph__node__add_classification  {

    public static string ClassTypeId = "/world_step/actions/location_graph.node.add_classification";
    public static string TagName = "location_graph.node.add_classification";

    public string Tag = "location_graph.node.add_classification";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private type__node_graph__selection _node_graph_selection = new type__node_graph__selection();
    public type__node_graph__selection node_graph_selection {
      get { return _node_graph_selection; }
      set { _node_graph_selection = value; }
    }

    private XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification _to_be_added__classification = new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification();
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification to_be_added__classification {
      get { return _to_be_added__classification; }
      set { _to_be_added__classification = value; }
    }
    public location_graph__node__add_classification()
    {
    }

    public location_graph__node__add_classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph__node__add_classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph.node.add_classification");
      //Deserialize arguments

      //Deserialize children
      this._node_graph_selection = rawNode.InitializeWithRawNode("node_graph_selection", this._node_graph_selection);
      this._to_be_added__classification = rawNode.InitializeWithRawNode("to_be_added__classification", this._to_be_added__classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(node_graph_selection != null) {
        rawNode.children["node_graph_selection"] = new List<RawNode> { node_graph_selection.SerializeIntoRawNode() };
      }
      if(to_be_added__classification != null) {
        rawNode.children["to_be_added__classification"] = new List<RawNode> { to_be_added__classification.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph.node.add_classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public type__node_graph__selection Get_node_graph_selection()
    {
      return this.node_graph_selection;
    }
    public void Set_node_graph_selection(type__node_graph__selection value)
    {
      this.node_graph_selection = value;
    }
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification Get_to_be_added__classification()
    {
      return this._to_be_added__classification;
    }
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification GetOrInsertDefault_to_be_added__classification()
    {
      if(this._to_be_added__classification == null) {

        // true2
        this._to_be_added__classification = new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_to_be_added__classification();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_to_be_added__classification(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification value)
    {
        this._to_be_added__classification = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__node_graph__selection.TagName))
      {
        xpath = xpath.Substring(type__node_graph__selection.TagName.Length + 3);
        this.node_graph_selection.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification.TagName.Length + 3);
        this.to_be_added__classification.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}