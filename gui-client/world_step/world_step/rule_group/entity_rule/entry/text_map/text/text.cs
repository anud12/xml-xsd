using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ntext_map.Ntext {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ntext_map {
  public class text : IEquatable<text>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.entity_rule.entry.text_map.text";
    public static string TagName = "text";

    public string NodeName {get =>"text";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<text>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _name;
    public System.String name { get => _name; set => _name = value; }
    private System.String _value;
    public System.String value { get => _value; set => _value = value; }

    //Children elements
    public text()
    {
    }

    public text(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public text(XmlElement xmlElement)
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
      if(name == "value")
      {
        Set_value(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<text> callback)
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
      // Godot.GD.Print("Deserializing text");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = rawNode.attributes["value"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._name != null)
      {
        rawNode.attributes["name"] = this._name.ToString();
      }
      if(this._value != null)
      {
        rawNode.attributes["value"] = this._value.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing text");
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
    public System.String Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String value)
    {
      this.value = value;
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

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return false;
    }

    public bool Equals(text? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (text)obj;
        return Equals(name, other.name) && Equals(value, other.value);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, name);
        acc = HashCode.Combine(acc, value);
        return acc;
    }
  }
}