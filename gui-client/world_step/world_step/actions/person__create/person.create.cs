using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__create {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__create : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.person.create";
    public static string TagName = "person.create";

    public string NodeName {get =>"person.create";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person__create>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements
    private type__node_graph__selection _node_graph__selection = new type__node_graph__selection();
    public type__node_graph__selection node_graph__selection
    {
      get
      {
        if(_node_graph__selection == null)
        {
          _node_graph__selection = new();
          _node_graph__selection.ParentNode = this;
          OnChange();
        }
        return _node_graph__selection;
      }
      set
      {
        _node_graph__selection = value;
        _node_graph__selection.ParentNode = this;
      }
    }

    private type__person_selection _person__selection = new type__person_selection();
    public type__person_selection person__selection
    {
      get
      {
        if(_person__selection == null)
        {
          _person__selection = new();
          _person__selection.ParentNode = this;
          OnChange();
        }
        return _person__selection;
      }
      set
      {
        _person__selection = value;
        _person__selection.ParentNode = this;
      }
    }
    public person__create()
    {
    }

    public person__create(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__create(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<person__create> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public Action OnChangeBubble(Action<List<ILinkedNode>> callback)
    {
      _bubbleCallbackList.Add(callback);
      return () => _bubbleCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person.create");
      //Deserialize arguments

      //Deserialize children
      node_graph__selection = rawNode.InitializeWithRawNode("node_graph__selection", node_graph__selection);

      person__selection = rawNode.InitializeWithRawNode("person__selection", person__selection);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(node_graph__selection != null) {
        rawNode.children["node_graph__selection"] = new List<RawNode> { node_graph__selection.SerializeIntoRawNode() };
      }
      if(person__selection != null) {
        rawNode.children["person__selection"] = new List<RawNode> { person__selection.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person.create");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__node_graph__selection.TagName))
      {
        var childXPath = xpath.Substring(type__node_graph__selection.TagName.Length + 3);
        this.node_graph__selection.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__person_selection.TagName))
      {
        var childXPath = xpath.Substring(type__person_selection.TagName.Length + 3);
        this.person__selection.DeserializeAtPath(childXPath, rawNode);
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
      _bubbleCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is type__node_graph__selection casted_node_graph__selection) {
        return 0;
      }
      if(linkedNode is type__person_selection casted_person__selection) {
        return 0;
      }
      return null;
    }
  }
}