using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__link_to__selection {}
namespace XSD {
}
namespace XSD {
  public class type__link_to__selection : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__link_to__selection";
    public static string TagName = "type__link_to__selection";

    public string NodeName {get =>"type__link_to__selection";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__link_to__selection>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private type__node_graph__selection? _origin__node_graph__selection = null;
    public type__node_graph__selection origin__node_graph__selection
    {
      get
      {
        if(_origin__node_graph__selection == null)
        {
          _origin__node_graph__selection = new();
          _origin__node_graph__selection.ParentNode = this;
          NotifyChange();
        }
        return _origin__node_graph__selection;
      }
      set
      {
        _origin__node_graph__selection = value;
        _origin__node_graph__selection.ParentNode = this;
      }
    }

    private type__node_graph__selection? _destination__node_graph__selection = null;
    public type__node_graph__selection destination__node_graph__selection
    {
      get
      {
        if(_destination__node_graph__selection == null)
        {
          _destination__node_graph__selection = new();
          _destination__node_graph__selection.ParentNode = this;
          NotifyChange();
        }
        return _destination__node_graph__selection;
      }
      set
      {
        _destination__node_graph__selection = value;
        _destination__node_graph__selection.ParentNode = this;
      }
    }
    public type__link_to__selection()
    {
    }

    public type__link_to__selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__link_to__selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__node_graph__selection origin__node_graph__selection)
      {
        this.origin__node_graph__selection = origin__node_graph__selection;
      }

      if(linkedNode is type__node_graph__selection destination__node_graph__selection)
      {
        this.destination__node_graph__selection = destination__node_graph__selection;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__node_graph__selection)
      {
        this.origin__node_graph__selection = null;
      }

      if(linkedNode is type__node_graph__selection)
      {
        this.destination__node_graph__selection = null;
      }

    }

    public Action OnSelfChange(Action<type__link_to__selection> callback)
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
      // Godot.GD.Print("Deserializing type__link_to__selection");
      //Deserialize arguments

      //Deserialize children
      origin__node_graph__selection = rawNode.InitializeWithRawNode("origin__node_graph__selection", origin__node_graph__selection);

      destination__node_graph__selection = rawNode.InitializeWithRawNode("destination__node_graph__selection", destination__node_graph__selection);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(origin__node_graph__selection != null) {
        rawNode.children["origin__node_graph__selection"] = new List<RawNode> { origin__node_graph__selection.SerializeIntoRawNode() };
      }
      if(destination__node_graph__selection != null) {
        rawNode.children["destination__node_graph__selection"] = new List<RawNode> { destination__node_graph__selection.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__link_to__selection");
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
        this.origin__node_graph__selection ??= new type__node_graph__selection();
        var childXPath = xpath.Substring(type__node_graph__selection.TagName.Length + 3);
        this.origin__node_graph__selection.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__node_graph__selection.TagName))
      {
        this.destination__node_graph__selection ??= new type__node_graph__selection();
        var childXPath = xpath.Substring(type__node_graph__selection.TagName.Length + 3);
        this.destination__node_graph__selection.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__node_graph__selection casted_origin__node_graph__selection) {
        return 0;
      }
      if(linkedNode is type__node_graph__selection casted_destination__node_graph__selection) {
        return 0;
      }
      return null;
    }
  }
}