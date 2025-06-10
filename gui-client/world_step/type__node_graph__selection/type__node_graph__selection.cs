using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection {}
namespace XSD {
}
namespace XSD {
  public class type__node_graph__selection : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__node_graph__selection";
    public static string TagName = "type__node_graph__selection";

    public string NodeName {get =>"type__node_graph__selection";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__node_graph__selection>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Ntype__node_graph__selection.in__location_graph? _in__location_graph = null;
    public XSD.Ntype__node_graph__selection.in__location_graph in__location_graph
    {
      get
      {
        if(_in__location_graph == null)
        {
          _in__location_graph = new();
          _in__location_graph.ParentNode = this;
          NotifyChange();
        }
        return _in__location_graph;
      }
      set
      {
        _in__location_graph = value;
        _in__location_graph.ParentNode = this;
      }
    }

    private XSD.Ntype__node_graph__selection.has__node_graph_id? _has__node_graph_id = null;
    public XSD.Ntype__node_graph__selection.has__node_graph_id has__node_graph_id
    {
      get
      {
        if(_has__node_graph_id == null)
        {
          _has__node_graph_id = new();
          _has__node_graph_id.ParentNode = this;
          NotifyChange();
        }
        return _has__node_graph_id;
      }
      set
      {
        _has__node_graph_id = value;
        _has__node_graph_id.ParentNode = this;
      }
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

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__node_graph__selection.in__location_graph in__location_graph)
      {
        this.in__location_graph = in__location_graph;
      }

      if(linkedNode is XSD.Ntype__node_graph__selection.has__node_graph_id has__node_graph_id)
      {
        this.has__node_graph_id = has__node_graph_id;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__node_graph__selection.in__location_graph)
      {
        this.in__location_graph = null;
      }

      if(linkedNode is XSD.Ntype__node_graph__selection.has__node_graph_id)
      {
        this.has__node_graph_id = null;
      }

    }

    public Action OnSelfChange(Action<type__node_graph__selection> callback)
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
      // Godot.GD.Print("Deserializing type__node_graph__selection");
      //Deserialize arguments

      //Deserialize children
      in__location_graph = rawNode.InitializeWithRawNode("in__location_graph", in__location_graph);

      has__node_graph_id = rawNode.InitializeWithRawNode("has__node_graph_id", has__node_graph_id);
      NotifyChange();
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


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__node_graph__selection.in__location_graph.TagName))
      {
        this.in__location_graph ??= new XSD.Ntype__node_graph__selection.in__location_graph();
        var childXPath = xpath.Substring(XSD.Ntype__node_graph__selection.in__location_graph.TagName.Length + 3);
        this.in__location_graph.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__node_graph__selection.has__node_graph_id.TagName))
      {
        this.has__node_graph_id ??= new XSD.Ntype__node_graph__selection.has__node_graph_id();
        var childXPath = xpath.Substring(XSD.Ntype__node_graph__selection.has__node_graph_id.TagName.Length + 3);
        this.has__node_graph_id.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__node_graph__selection.in__location_graph casted_in__location_graph) {
        return 0;
      }
      if(linkedNode is XSD.Ntype__node_graph__selection.has__node_graph_id casted_has__node_graph_id) {
        return 0;
      }
      return null;
    }
  }
}