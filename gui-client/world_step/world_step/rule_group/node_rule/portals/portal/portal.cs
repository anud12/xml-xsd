using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals {
  public class portal : IEquatable<portal>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.node_rule.portals.portal";
    public static string TagName = "portal";

    public string NodeName {get =>"portal";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<portal>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _side;
    public System.String side { get => _side; set => _side = value; }

    //Children elements
    private type__math_operations _width = new type__math_operations();
    public type__math_operations widthOrCreate
    {
      get
      {
        if(_width == null)
        {
          _width = new();
          _width.ParentNode = this;
          NotifyChange();
        }
        return _width;
      }
      set
      {
        _width = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations width
    {
      get
      {
        return _width;
      }
      set
      {
        _width = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private type__math_operations _height = new type__math_operations();
    public type__math_operations heightOrCreate
    {
      get
      {
        if(_height == null)
        {
          _height = new();
          _height.ParentNode = this;
          NotifyChange();
        }
        return _height;
      }
      set
      {
        _height = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations height
    {
      get
      {
        return _height;
      }
      set
      {
        _height = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to _to = new XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to();
    public XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to toOrCreate
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
    public XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to to
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
    public portal()
    {
    }

    public portal(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public portal(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "side")
      {
        Set_side(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations width)
      {
        this.width = width;
      }

      if(linkedNode is type__math_operations height)
      {
        this.height = height;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to to)
      {
        this.to = to;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations)
      {
        this.width = new();
      }

      if(linkedNode is type__math_operations)
      {
        this.height = new();
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to)
      {
        this.to = new();
      }

    }

    public Action OnSelfChange(Action<portal> callback)
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
      // Godot.GD.Print("Deserializing portal");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("side"))
      {
        var attribute_side = rawNode.attributes["side"];
        this.side = rawNode.attributes["side"];
      }

      //Deserialize children
      width = rawNode.InitializeWithRawNode("width", width);

      height = rawNode.InitializeWithRawNode("height", height);

      to = rawNode.InitializeWithRawNode("to", to);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._side != null)
      {
        rawNode.attributes["side"] = this._side.ToString();
      }

      //Serialize children
      if(width != null) {
        rawNode.children["width"] = new List<RawNode> { width.SerializeIntoRawNode() };
      }
      if(height != null) {
        rawNode.children["height"] = new List<RawNode> { height.SerializeIntoRawNode() };
      }
      if(to != null) {
        rawNode.children["to"] = new List<RawNode> { to.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing portal");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_side()
    {
      return this.side;
    }
    public void Set_side(System.String value)
    {
      this.side = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.width.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.height.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to.TagName.Length + 3);
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
      if(linkedNode is type__math_operations casted_width) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_height) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to casted_to) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is type__math_operations
      || candidateChild is type__math_operations
      || candidateChild is XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.to
      || false;
    }

    public bool Equals(portal? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (portal)obj;
        return Equals(side, other.side) && Equals(width, other.width) && Equals(height, other.height) && Equals(to, other.to);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, side);
        acc = HashCode.Combine(acc, width);
        acc = HashCode.Combine(acc, height);
        acc = HashCode.Combine(acc, to);
        return acc;
    }
  }
}