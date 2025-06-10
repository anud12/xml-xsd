using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nin__location_graph {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection {
  public class in__location_graph : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__node_graph__selection.in__location_graph";
    public static string TagName = "in__location_graph";

    public string NodeName {get =>"in__location_graph";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<in__location_graph>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id? _has__location_graph_id = null;
    public XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id has__location_graph_id
    {
      get
      {
        if(_has__location_graph_id == null)
        {
          _has__location_graph_id = new();
          _has__location_graph_id.ParentNode = this;
          NotifyChange();
        }
        return _has__location_graph_id;
      }
      set
      {
        _has__location_graph_id = value;
        _has__location_graph_id.ParentNode = this;
      }
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

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id has__location_graph_id)
      {
        this.has__location_graph_id = has__location_graph_id;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id)
      {
        this.has__location_graph_id = null;
      }

    }

    public Action OnSelfChange(Action<in__location_graph> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }

    public Action OnSelfChangeNode(Action<ILinkedNode> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }


    public Action OnChange(Action<List<ILinkedNode>> callback)
    {
      _onChangeCallbackList.Add(callback);
      return () => _onChangeCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing in__location_graph");
      //Deserialize arguments

      //Deserialize children
      has__location_graph_id = rawNode.InitializeWithRawNode("has__location_graph_id", has__location_graph_id);
      NotifyChange();
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


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id.TagName))
      {
        this.has__location_graph_id ??= new XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id();
        var childXPath = xpath.Substring(XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id.TagName.Length + 3);
        this.has__location_graph_id.DeserializeAtPath(childXPath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }

    public void NotifyChange(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _onSelfChangeCallbackList.ForEach(action => action(this));
      _onChangeCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.NotifyChange(linkedNodes);
    }

    public void NotifyChange()
    {
      NotifyChange(new ());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id casted_has__location_graph_id) {
        return 0;
      }
      return null;
    }
  }
}