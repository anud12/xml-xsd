using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class location_graph__node__add_classification : XSD.ILinkedNode  {

    public static string ClassTypeId = "/world_step/actions/location_graph.node.add_classification";
    public static string TagName = "location_graph.node.add_classification";

    public string NodeName {get =>"location_graph.node.add_classification";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<location_graph__node__add_classification>> _callbackList = new();

    //Attributes

    //Children elements
    private type__node_graph__selection _node_graph_selection = new type__node_graph__selection();
    public type__node_graph__selection node_graph_selection
    {
      get
      {
        if(_node_graph_selection == null)
        {
          _node_graph_selection = new();
          _node_graph_selection.ParentNode = this;
          OnChange();
        }
        return _node_graph_selection;
      }
      set
      {
        _node_graph_selection = value;
        _node_graph_selection.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification _to_be_added__classification = new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification();
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification to_be_added__classification
    {
      get
      {
        if(_to_be_added__classification == null)
        {
          _to_be_added__classification = new();
          _to_be_added__classification.ParentNode = this;
          OnChange();
        }
        return _to_be_added__classification;
      }
      set
      {
        _to_be_added__classification = value;
        _to_be_added__classification.ParentNode = this;
      }
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

    public Action OnChange(Action<location_graph__node__add_classification> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph.node.add_classification");
      //Deserialize arguments

      //Deserialize children
      node_graph_selection = rawNode.InitializeWithRawNode("node_graph_selection", node_graph_selection);

      to_be_added__classification = rawNode.InitializeWithRawNode("to_be_added__classification", to_be_added__classification);
      OnChange();
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

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("/"))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__node_graph__selection.TagName))
      {
        var childXPath = xpath.Substring(type__node_graph__selection.TagName.Length + 3);
        this.node_graph_selection.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification.TagName.Length + 3);
        this.to_be_added__classification.SetXPath(childXPath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }

    public void ChildChanged(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _callbackList.ForEach(action => action(this));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is type__node_graph__selection casted_node_graph_selection) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification casted_to_be_added__classification) {
        return 0;
      }
      return null;
    }
  }
}