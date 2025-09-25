using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal.Nto {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nnode_rule.Nportals.Nportal {
  public class to : IEquatable<to>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.node_rule.portals.portal.to";
    public static string TagName = "to";

    public string NodeName {get =>"to";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _node_rule_ref;
    public System.String node_rule_ref { get => _node_rule_ref; set => _node_rule_ref = value; }

    //Children elements
    private type__rectangle_side _side = new type__rectangle_side();
    public type__rectangle_side sideOrCreate
    {
      get
      {
        if(_side == null)
        {
          _side = new();
          _side.ParentNode = this;
          NotifyChange();
        }
        return _side;
      }
      set
      {
        _side = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__rectangle_side side
    {
      get
      {
        return _side;
      }
      set
      {
        _side = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

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
    public to()
    {
    }

    public to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "node_rule_ref")
      {
        Set_node_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__rectangle_side side)
      {
        this.side = side;
      }

      if(linkedNode is type__math_operations width)
      {
        this.width = width;
      }

      if(linkedNode is type__math_operations height)
      {
        this.height = height;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__rectangle_side)
      {
        this.side = new();
      }

      if(linkedNode is type__math_operations)
      {
        this.width = new();
      }

      if(linkedNode is type__math_operations)
      {
        this.height = new();
      }

    }

    public Action OnSelfChange(Action<to> callback)
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
      // Godot.GD.Print("Deserializing to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }

      //Deserialize children
      side = rawNode.InitializeWithRawNode("side", side);

      width = rawNode.InitializeWithRawNode("width", width);

      height = rawNode.InitializeWithRawNode("height", height);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this._node_rule_ref.ToString();
      }

      //Serialize children
      if(side != null) {
        rawNode.children["side"] = new List<RawNode> { side.SerializeIntoRawNode() };
      }
      if(width != null) {
        rawNode.children["width"] = new List<RawNode> { width.SerializeIntoRawNode() };
      }
      if(height != null) {
        rawNode.children["height"] = new List<RawNode> { height.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__rectangle_side.TagName))
      {
        var childXPath = xpath.Substring(type__rectangle_side.TagName.Length + 3);
        this.side.DeserializeAtPath(childXPath, rawNode);
        return;
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
      if(linkedNode is type__rectangle_side casted_side) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_width) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_height) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is type__rectangle_side
      || candidateChild is type__math_operations
      || candidateChild is type__math_operations
      || false;
    }

    public bool Equals(to? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (to)obj;
        return Equals(node_rule_ref, other.node_rule_ref) && Equals(side, other.side) && Equals(width, other.width) && Equals(height, other.height);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, node_rule_ref);
        acc = HashCode.Combine(acc, side);
        acc = HashCode.Combine(acc, width);
        acc = HashCode.Combine(acc, height);
        return acc;
    }
  }
}