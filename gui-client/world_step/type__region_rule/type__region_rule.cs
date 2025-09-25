using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__region_rule {}
namespace XSD {
}
namespace XSD {
  public class type__region_rule : IEquatable<type__region_rule>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__region_rule";
    public static string TagName = "type__region_rule";

    public string NodeName {get =>"type__region_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__region_rule>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Ntype__region_rule.limit _limit = new XSD.Ntype__region_rule.limit();
    public XSD.Ntype__region_rule.limit limitOrCreate
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
    public XSD.Ntype__region_rule.limit limit
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

    private XSD.Ntype__region_rule.portals? _portals = null;
    public XSD.Ntype__region_rule.portals portalsOrCreate
    {
      get
      {
        if(_portals == null)
        {
          _portals = new();
          _portals.ParentNode = this;
          NotifyChange();
        }
        return _portals;
      }
      set
      {
        _portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__region_rule.portals? portals
    {
      get
      {
        return _portals;
      }
      set
      {
        _portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public type__region_rule()
    {
    }

    public type__region_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__region_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__region_rule.limit limit)
      {
        this.limit = limit;
      }

      if(linkedNode is XSD.Ntype__region_rule.portals portals)
      {
        this.portals = portals;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__region_rule.limit)
      {
        this.limit = new();
      }

      if(linkedNode is XSD.Ntype__region_rule.portals)
      {
        this.portals = null;
      }

    }

    public Action OnSelfChange(Action<type__region_rule> callback)
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
      // Godot.GD.Print("Deserializing type__region_rule");
      //Deserialize arguments

      //Deserialize children
      limit = rawNode.InitializeWithRawNode("limit", limit);

      portals = rawNode.InitializeWithRawNode("portals", portals);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(limit != null) {
        rawNode.children["limit"] = new List<RawNode> { limit.SerializeIntoRawNode() };
      }
      if(portals != null) {
        rawNode.children["portals"] = new List<RawNode> { portals.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__region_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__region_rule.limit.TagName))
      {
        var childXPath = xpath.Substring(XSD.Ntype__region_rule.limit.TagName.Length + 3);
        this.limit.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__region_rule.portals.TagName))
      {
        this.portals ??= new XSD.Ntype__region_rule.portals();
        var childXPath = xpath.Substring(XSD.Ntype__region_rule.portals.TagName.Length + 3);
        this.portals.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__region_rule.limit casted_limit) {
        return 0;
      }
      if(linkedNode is XSD.Ntype__region_rule.portals casted_portals) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Ntype__region_rule.limit
      || candidateChild is XSD.Ntype__region_rule.portals
      || false;
    }

    public bool Equals(type__region_rule? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (type__region_rule)obj;
        return Equals(limit, other.limit) && Equals(portals, other.portals);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, limit);
        acc = HashCode.Combine(acc, portals);
        return acc;
    }
  }
}