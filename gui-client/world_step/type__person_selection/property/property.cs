using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__person_selection.Nproperty {}
namespace XSD {
}
namespace XSD.Ntype__person_selection {
  public class property : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__person_selection.property";
    public static string TagName = "property";

    public string NodeName {get =>"property";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<property>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _property_rule_ref;
    public System.String property_rule_ref { get => _property_rule_ref; set => _property_rule_ref = value; }

    //Children elements
    private type__math_operations? _min = null;
    public type__math_operations min
    {
      get
      {
        if(_min == null)
        {
          _min = new();
          _min.ParentNode = this;
          NotifyChange();
        }
        return _min;
      }
      set
      {
        _min = value;
        _min.ParentNode = this;
      }
    }

    private type__math_operations? _max = null;
    public type__math_operations max
    {
      get
      {
        if(_max == null)
        {
          _max = new();
          _max.ParentNode = this;
          NotifyChange();
        }
        return _max;
      }
      set
      {
        _max = value;
        _max.ParentNode = this;
      }
    }
    public property()
    {
    }

    public property(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public property(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "property_rule_ref")
      {
        Set_property_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations min)
      {
        this.min = min;
      }

      if(linkedNode is type__math_operations max)
      {
        this.max = max;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations)
      {
        this.min = null;
      }

      if(linkedNode is type__math_operations)
      {
        this.max = null;
      }

    }

    public Action OnSelfChange(Action<property> callback)
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
      // Godot.GD.Print("Deserializing property");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }

      //Deserialize children
      min = rawNode.InitializeWithRawNode("min", min);

      max = rawNode.InitializeWithRawNode("max", max);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }

      //Serialize children
      if(min != null) {
        rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
      }
      if(max != null) {
        rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing property");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
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
        this.min ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.min.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.max ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.max.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__math_operations casted_min) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_max) {
        return 0;
      }
      return null;
    }
  }
}