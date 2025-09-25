using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nnode_rule.Narea {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nnode_rule {
  public class area : IEquatable<area>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.node_rule.area";
    public static string TagName = "area";

    public string NodeName {get =>"area";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<area>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
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
    public area()
    {
    }

    public area(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public area(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations height)
      {
        this.height = height;
      }

      if(linkedNode is type__math_operations width)
      {
        this.width = width;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations)
      {
        this.height = new();
      }

      if(linkedNode is type__math_operations)
      {
        this.width = new();
      }

    }

    public Action OnSelfChange(Action<area> callback)
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
      // Godot.GD.Print("Deserializing area");
      //Deserialize arguments

      //Deserialize children
      height = rawNode.InitializeWithRawNode("height", height);

      width = rawNode.InitializeWithRawNode("width", width);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(height != null) {
        rawNode.children["height"] = new List<RawNode> { height.SerializeIntoRawNode() };
      }
      if(width != null) {
        rawNode.children["width"] = new List<RawNode> { width.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing area");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
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
        this.height.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.width.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__math_operations casted_height) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_width) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is type__math_operations
      || candidateChild is type__math_operations
      || false;
    }

    public bool Equals(area? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (area)obj;
        return Equals(height, other.height) && Equals(width, other.width);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, height);
        acc = HashCode.Combine(acc, width);
        return acc;
    }
  }
}