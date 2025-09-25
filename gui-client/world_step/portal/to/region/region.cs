using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nportal.Nto.Nregion {}
namespace XSD {
}
namespace XSD.Nportal.Nto {
  public class region : IEquatable<region>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".portal.to.region";
    public static string TagName = "region";

    public string NodeName {get =>"region";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<region>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _region_rule_ref;
    public System.String region_rule_ref { get => _region_rule_ref; set => _region_rule_ref = value; }
    private System.String _side;
    public System.String side { get => _side; set => _side = value; }

    //Children elements
    private type__math_operations _start = new type__math_operations();
    public type__math_operations startOrCreate
    {
      get
      {
        if(_start == null)
        {
          _start = new();
          _start.ParentNode = this;
          NotifyChange();
        }
        return _start;
      }
      set
      {
        _start = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations start
    {
      get
      {
        return _start;
      }
      set
      {
        _start = value;
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
      if(name == "region_rule_ref")
      {
        Set_region_rule_ref(value);
      }
      if(name == "side")
      {
        Set_side(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations start)
      {
        this.start = start;
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
        this.start = new();
      }

      if(linkedNode is type__math_operations)
      {
        this.width = new();
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
      if(rawNode.attributes.ContainsKey("region_rule_ref"))
      {
        var attribute_region_rule_ref = rawNode.attributes["region_rule_ref"];
        this.region_rule_ref = rawNode.attributes["region_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("side"))
      {
        var attribute_side = rawNode.attributes["side"];
        this.side = rawNode.attributes["side"];
      }

      //Deserialize children
      start = rawNode.InitializeWithRawNode("start", start);

      width = rawNode.InitializeWithRawNode("width", width);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._region_rule_ref != null)
      {
        rawNode.attributes["region_rule_ref"] = this._region_rule_ref.ToString();
      }
      if(this._side != null)
      {
        rawNode.attributes["side"] = this._side.ToString();
      }

      //Serialize children
      if(start != null) {
        rawNode.children["start"] = new List<RawNode> { start.SerializeIntoRawNode() };
      }
      if(width != null) {
        rawNode.children["width"] = new List<RawNode> { width.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing region");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_region_rule_ref()
    {
      return this.region_rule_ref;
    }
    public void Set_region_rule_ref(System.String value)
    {
      this.region_rule_ref = value;
      this.NotifyChange();
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
        this.start.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__math_operations casted_start) {
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

    public bool Equals(region? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (region)obj;
        return Equals(region_rule_ref, other.region_rule_ref) && Equals(side, other.side) && Equals(start, other.start) && Equals(width, other.width);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, region_rule_ref);
        acc = HashCode.Combine(acc, side);
        acc = HashCode.Combine(acc, start);
        acc = HashCode.Combine(acc, width);
        return acc;
    }
  }
}