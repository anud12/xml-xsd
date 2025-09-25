using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone {
  public class region : IEquatable<region>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region";
    public static string TagName = "region";

    public string NodeName {get =>"region";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<region>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule _rule = new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule();
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule ruleOrCreate
    {
      get
      {
        if(_rule == null)
        {
          _rule = new();
          _rule.ParentNode = this;
          NotifyChange();
        }
        return _rule;
      }
      set
      {
        _rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule rule
    {
      get
      {
        return _rule;
      }
      set
      {
        _rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position _position = new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position();
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position positionOrCreate
    {
      get
      {
        if(_position == null)
        {
          _position = new();
          _position.ParentNode = this;
          NotifyChange();
        }
        return _position;
      }
      set
      {
        _position = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position position
    {
      get
      {
        return _position;
      }
      set
      {
        _position = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit _limit = new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit();
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit limitOrCreate
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
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit limit
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

    private XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals? _available_portals = null;
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals available_portalsOrCreate
    {
      get
      {
        if(_available_portals == null)
        {
          _available_portals = new();
          _available_portals.ParentNode = this;
          NotifyChange();
        }
        return _available_portals;
      }
      set
      {
        _available_portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals? available_portals
    {
      get
      {
        return _available_portals;
      }
      set
      {
        _available_portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals? _portals = null;
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals portalsOrCreate
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
    public XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals? portals
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
    public region()
    {
    }

    public region(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public region(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "id")
      {
        Set_id(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule rule)
      {
        this.rule = rule;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position position)
      {
        this.position = position;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit limit)
      {
        this.limit = limit;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals available_portals)
      {
        this.available_portals = available_portals;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals portals)
      {
        this.portals = portals;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule)
      {
        this.rule = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position)
      {
        this.position = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit)
      {
        this.limit = new();
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals)
      {
        this.available_portals = null;
      }

      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals)
      {
        this.portals = null;
      }

    }

    public Action OnSelfChange(Action<region> callback)
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
      // Godot.GD.Print("Deserializing region");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      rule = rawNode.InitializeWithRawNode("rule", rule);

      position = rawNode.InitializeWithRawNode("position", position);

      limit = rawNode.InitializeWithRawNode("limit", limit);

      available_portals = rawNode.InitializeWithRawNode("available_portals", available_portals);

      portals = rawNode.InitializeWithRawNode("portals", portals);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }

      //Serialize children
      if(rule != null) {
        rawNode.children["rule"] = new List<RawNode> { rule.SerializeIntoRawNode() };
      }
      if(position != null) {
        rawNode.children["position"] = new List<RawNode> { position.SerializeIntoRawNode() };
      }
      if(limit != null) {
        rawNode.children["limit"] = new List<RawNode> { limit.SerializeIntoRawNode() };
      }
      if(available_portals != null) {
        rawNode.children["available_portals"] = new List<RawNode> { available_portals.SerializeIntoRawNode() };
      }
      if(portals != null) {
        rawNode.children["portals"] = new List<RawNode> { portals.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing region");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule.TagName.Length + 3);
        this.rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position.TagName.Length + 3);
        this.position.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit.TagName.Length + 3);
        this.limit.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals.TagName))
      {
        this.available_portals ??= new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals.TagName.Length + 3);
        this.available_portals.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals.TagName))
      {
        this.portals ??= new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals();
        var childXPath = xpath.Substring(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals.TagName.Length + 3);
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule casted_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position casted_position) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit casted_limit) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals casted_available_portals) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals casted_portals) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.rule
      || candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.position
      || candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.limit
      || candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.available_portals
      || candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.portals
      || false;
    }

    public bool Equals(region? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (region)obj;
        return Equals(id, other.id) && Equals(rule, other.rule) && Equals(position, other.position) && Equals(limit, other.limit) && Equals(available_portals, other.available_portals) && Equals(portals, other.portals);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, rule);
        acc = HashCode.Combine(acc, position);
        acc = HashCode.Combine(acc, limit);
        acc = HashCode.Combine(acc, available_portals);
        acc = HashCode.Combine(acc, portals);
        return acc;
    }
  }
}