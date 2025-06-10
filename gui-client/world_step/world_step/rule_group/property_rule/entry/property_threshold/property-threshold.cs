using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.Nproperty_threshold {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry {
  public class property_threshold : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.property_rule.entry.property-threshold";
    public static string TagName = "property-threshold";

    public string NodeName {get =>"property-threshold";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<property_threshold>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _name;
    public System.String name { get => _name; set => _name = value; }
    private System.Int32? _min_value_inclusive;
    public System.Int32? min_value_inclusive { get => _min_value_inclusive; set => _min_value_inclusive = value; }
    private System.Int32? _max_value_inclusive;
    public System.Int32? max_value_inclusive { get => _max_value_inclusive; set => _max_value_inclusive = value; }

    //Children elements
    public property_threshold()
    {
    }

    public property_threshold(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public property_threshold(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "name")
      {
        Set_name(value);
      }
      if(name == "min_value_inclusive")
      {
        Set_min_value_inclusive(value?.ToInt() ?? 0);
      }
      if(name == "max_value_inclusive")
      {
        Set_max_value_inclusive(value?.ToInt() ?? 0);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<property_threshold> callback)
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
      // Godot.GD.Print("Deserializing property-threshold");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }
      if(rawNode.attributes.ContainsKey("min-value-inclusive"))
      {
        var attribute_min_value_inclusive = rawNode.attributes["min-value-inclusive"];
        this.min_value_inclusive = attribute_min_value_inclusive?.ToInt();
      }
      if(rawNode.attributes.ContainsKey("max-value-inclusive"))
      {
        var attribute_max_value_inclusive = rawNode.attributes["max-value-inclusive"];
        this.max_value_inclusive = attribute_max_value_inclusive?.ToInt();
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.name != null)
      {
        rawNode.attributes["name"] = this.name.ToString();
      }
      if(this.min_value_inclusive != null)
      {
        rawNode.attributes["min-value-inclusive"] = this.min_value_inclusive?.ToString();
      }
      if(this.max_value_inclusive != null)
      {
        rawNode.attributes["max-value-inclusive"] = this.max_value_inclusive?.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing property-threshold");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String value)
    {
      this.name = value;
      this.NotifyChange();
    }
    public System.Int32? Get_min_value_inclusive()
    {
      return this.min_value_inclusive;
    }
    public void Set_min_value_inclusive(System.Int32? value)
    {
      this.min_value_inclusive = value;
      this.NotifyChange();
    }
    public System.Int32? Get_max_value_inclusive()
    {
      return this.max_value_inclusive;
    }
    public void Set_max_value_inclusive(System.Int32? value)
    {
      this.max_value_inclusive = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
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
      return null;
    }
  }
}