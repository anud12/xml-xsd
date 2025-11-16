using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nnode_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class node_rule : IEquatable<node_rule>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.node_rule";
    public static string TagName = "node_rule";

    public string NodeName {get =>"node_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<node_rule>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nnode_rule.area _area = new XSD.Nworld_step.Nrule_group.Nnode_rule.area();
    public XSD.Nworld_step.Nrule_group.Nnode_rule.area areaOrCreate
    {
      get
      {
        if(_area == null)
        {
          _area = new();
          _area.ParentNode = this;
          NotifyChange();
        }
        return _area;
      }
      set
      {
        _area = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.Nnode_rule.area area
    {
      get
      {
        return _area;
      }
      set
      {
        _area = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.Nnode_rule.portals _portals = new XSD.Nworld_step.Nrule_group.Nnode_rule.portals();
    public XSD.Nworld_step.Nrule_group.Nnode_rule.portals portalsOrCreate
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
    public XSD.Nworld_step.Nrule_group.Nnode_rule.portals portals
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
    public node_rule()
    {
    }

    public node_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public node_rule(XmlElement xmlElement)
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.area area)
      {
        this.area = area;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.portals portals)
      {
        this.portals = portals;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.area)
      {
        this.area = new();
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.portals)
      {
        this.portals = new();
      }

    }

    public Action OnSelfChange(Action<node_rule> callback)
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
      // Godot.GD.Print("Deserializing node_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      area = rawNode.InitializeWithRawNode("area", area);

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
      if(area != null) {
        rawNode.children["area"] = new List<RawNode> { area.SerializeIntoRawNode() };
      }
      if(portals != null) {
        rawNode.children["portals"] = new List<RawNode> { portals.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing node_rule");
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
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nnode_rule.area.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nnode_rule.area.TagName.Length + 3);
        this.area.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nnode_rule.portals.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nnode_rule.portals.TagName.Length + 3);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.area casted_area) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.portals casted_portals) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nnode_rule.area
      || candidateChild is XSD.Nworld_step.Nrule_group.Nnode_rule.portals
      || false;
    }

    public bool Equals(node_rule? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (node_rule)obj;
        return Equals(id, other.id) && Equals(area, other.area) && Equals(portals, other.portals);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, area);
        acc = HashCode.Combine(acc, portals);
        return acc;
    }
  }
}