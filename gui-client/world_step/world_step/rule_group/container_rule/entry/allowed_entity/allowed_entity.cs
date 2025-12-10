using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.Nallowed_entity {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry {
  public class allowed_entity : IEquatable<allowed_entity>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.container_rule.entry.allowed_entity";
    public static string TagName = "allowed_entity";

    public string NodeName {get =>"allowed_entity";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<allowed_entity>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _entity_rule_ref;
    public System.String entity_rule_ref { get => _entity_rule_ref; set => _entity_rule_ref = value; }

    //Children elements
    private type__math_operations? _max = null;
    public type__math_operations maxOrCreate
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
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations? max
    {
      get
      {
        return _max;
      }
      set
      {
        _max = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private type__math_operations? _min = null;
    public type__math_operations minOrCreate
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
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations? min
    {
      get
      {
        return _min;
      }
      set
      {
        _min = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public allowed_entity()
    {
    }

    public allowed_entity(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public allowed_entity(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "entity_rule_ref")
      {
        Set_entity_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations max)
      {
        this.max = max;
      }

      if(linkedNode is type__math_operations min)
      {
        this.min = min;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations)
      {
        this.max = null;
      }

      if(linkedNode is type__math_operations)
      {
        this.min = null;
      }

    }

    public Action OnSelfChange(Action<allowed_entity> callback)
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
      // Godot.GD.Print("Deserializing allowed_entity");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("entity_rule_ref"))
      {
        var attribute_entity_rule_ref = rawNode.attributes["entity_rule_ref"];
        this.entity_rule_ref = rawNode.attributes["entity_rule_ref"];
      }

      //Deserialize children
      max = rawNode.InitializeWithRawNode("max", max);

      min = rawNode.InitializeWithRawNode("min", min);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._entity_rule_ref != null)
      {
        rawNode.attributes["entity_rule_ref"] = this._entity_rule_ref.ToString();
      }

      //Serialize children
      if(max != null) {
        rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
      }
      if(min != null) {
        rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing allowed_entity");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_entity_rule_ref()
    {
      return this.entity_rule_ref;
    }
    public void Set_entity_rule_ref(System.String value)
    {
      this.entity_rule_ref = value;
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
        this.max ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.max.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.min ??= new type__math_operations();
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.min.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__math_operations casted_max) {
        return 0;
      }
      if(linkedNode is type__math_operations casted_min) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is type__math_operations
      || candidateChild is type__math_operations
      || false;
    }

    public bool Equals(allowed_entity? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (allowed_entity)obj;
        return Equals(entity_rule_ref, other.entity_rule_ref) && Equals(max, other.max) && Equals(min, other.min);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, entity_rule_ref);
        acc = HashCode.Combine(acc, max);
        acc = HashCode.Combine(acc, min);
        return acc;
    }
  }
}