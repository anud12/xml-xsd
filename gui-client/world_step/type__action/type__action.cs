using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__action {}
namespace XSD {
}
namespace XSD {
  public class type__action : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__action";
    public static string TagName = "type__action";

    public string NodeName {get =>"type__action";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__action>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Ntype__action.from _from = new XSD.Ntype__action.from();
    public XSD.Ntype__action.from from
    {
      get
      {
        if(_from == null)
        {
          _from = new();
          _from.ParentNode = this;
          NotifyChange();
        }
        return _from;
      }
      set
      {
        _from = value;
        _from.ParentNode = this;
      }
    }

    private XSD.Ntype__action.on _on = new XSD.Ntype__action.on();
    public XSD.Ntype__action.on on
    {
      get
      {
        if(_on == null)
        {
          _on = new();
          _on.ParentNode = this;
          NotifyChange();
        }
        return _on;
      }
      set
      {
        _on = value;
        _on.ParentNode = this;
      }
    }
    public type__action()
    {
    }

    public type__action(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__action(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__action.from from)
      {
        this.from = from;
      }

      if(linkedNode is XSD.Ntype__action.on on)
      {
        this.on = on;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__action.from)
      {
        this.from = new();
      }

      if(linkedNode is XSD.Ntype__action.on)
      {
        this.on = new();
      }

    }

    public Action OnSelfChange(Action<type__action> callback)
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
      // Godot.GD.Print("Deserializing type__action");
      //Deserialize arguments

      //Deserialize children
      from = rawNode.InitializeWithRawNode("from", from);

      on = rawNode.InitializeWithRawNode("on", on);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(from != null) {
        rawNode.children["from"] = new List<RawNode> { from.SerializeIntoRawNode() };
      }
      if(on != null) {
        rawNode.children["on"] = new List<RawNode> { on.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__action");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__action.from.TagName))
      {
        var childXPath = xpath.Substring(XSD.Ntype__action.from.TagName.Length + 3);
        this.from.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__action.on.TagName))
      {
        var childXPath = xpath.Substring(XSD.Ntype__action.on.TagName.Length + 3);
        this.on.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__action.from casted_from) {
        return 0;
      }
      if(linkedNode is XSD.Ntype__action.on casted_on) {
        return 0;
      }
      return null;
    }
  }
}