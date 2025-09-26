using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__portal_rule {}
namespace XSD {
}
namespace XSD {
  public class type__portal_rule : IEquatable<type__portal_rule>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__portal_rule";
    public static string TagName = "type__portal_rule";

    public string NodeName {get =>"type__portal_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__portal_rule>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Ntype__portal_rule.limit _limit = new XSD.Ntype__portal_rule.limit();
    public XSD.Ntype__portal_rule.limit limitOrCreate
    {
      get
      {
        if(_limit == null)
        {
          _limit = new();
          _limit.ParentNode = this;
          NotifyChange();
        }
        return _limit;
      }
      set
      {
        _limit = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__portal_rule.limit limit
    {
      get
      {
        return _limit;
      }
      set
      {
        _limit = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Ntype__portal_rule.to _to = new XSD.Ntype__portal_rule.to();
    public XSD.Ntype__portal_rule.to toOrCreate
    {
      get
      {
        if(_to == null)
        {
          _to = new();
          _to.ParentNode = this;
          NotifyChange();
        }
        return _to;
      }
      set
      {
        _to = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__portal_rule.to to
    {
      get
      {
        return _to;
      }
      set
      {
        _to = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public type__portal_rule()
    {
    }

    public type__portal_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__portal_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__portal_rule.limit limit)
      {
        this.limit = limit;
      }

      if(linkedNode is XSD.Ntype__portal_rule.to to)
      {
        this.to = to;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__portal_rule.limit)
      {
        this.limit = new();
      }

      if(linkedNode is XSD.Ntype__portal_rule.to)
      {
        this.to = new();
      }

    }

    public Action OnSelfChange(Action<type__portal_rule> callback)
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
      // Godot.GD.Print("Deserializing type__portal_rule");
      //Deserialize arguments

      //Deserialize children
      limit = rawNode.InitializeWithRawNode("limit", limit);

      to = rawNode.InitializeWithRawNode("to", to);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(limit != null) {
        rawNode.children["limit"] = new List<RawNode> { limit.SerializeIntoRawNode() };
      }
      if(to != null) {
        rawNode.children["to"] = new List<RawNode> { to.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__portal_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__portal_rule.limit.TagName))
      {
        var childXPath = xpath.Substring(XSD.Ntype__portal_rule.limit.TagName.Length + 3);
        this.limit.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__portal_rule.to.TagName))
      {
        var childXPath = xpath.Substring(XSD.Ntype__portal_rule.to.TagName.Length + 3);
        this.to.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__portal_rule.limit casted_limit) {
        return 0;
      }
      if(linkedNode is XSD.Ntype__portal_rule.to casted_to) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Ntype__portal_rule.limit
      || candidateChild is XSD.Ntype__portal_rule.to
      || false;
    }

    public bool Equals(type__portal_rule? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (type__portal_rule)obj;
        return Equals(limit, other.limit) && Equals(to, other.to);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, limit);
        acc = HashCode.Combine(acc, to);
        return acc;
    }
  }
}