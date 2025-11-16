using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__on_person__property_mutation {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__on_person__property_mutation : IEquatable<person__on_person__property_mutation>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.person.on_person.property_mutation";
    public static string TagName = "person.on_person.property_mutation";

    public string NodeName {get =>"person.on_person.property_mutation";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person__on_person__property_mutation>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _person_id_ref;
    public System.String person_id_ref { get => _person_id_ref; set => _person_id_ref = value; }
    private System.String _target_person_id_ref;
    public System.String target_person_id_ref { get => _target_person_id_ref; set => _target_person_id_ref = value; }
    private System.String _action_property_mutation_rule_ref;
    public System.String action_property_mutation_rule_ref { get => _action_property_mutation_rule_ref; set => _action_property_mutation_rule_ref = value; }

    //Children elements
    public person__on_person__property_mutation()
    {
    }

    public person__on_person__property_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__on_person__property_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "person_id_ref")
      {
        Set_person_id_ref(value);
      }
      if(name == "target_person_id_ref")
      {
        Set_target_person_id_ref(value);
      }
      if(name == "action_property_mutation_rule_ref")
      {
        Set_action_property_mutation_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<person__on_person__property_mutation> callback)
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
      // Godot.GD.Print("Deserializing person.on_person.property_mutation");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("target_person_id_ref"))
      {
        var attribute_target_person_id_ref = rawNode.attributes["target_person_id_ref"];
        this.target_person_id_ref = rawNode.attributes["target_person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("action_property_mutation_rule_ref"))
      {
        var attribute_action_property_mutation_rule_ref = rawNode.attributes["action_property_mutation_rule_ref"];
        this.action_property_mutation_rule_ref = rawNode.attributes["action_property_mutation_rule_ref"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this._person_id_ref.ToString();
      }
      if(this._target_person_id_ref != null)
      {
        rawNode.attributes["target_person_id_ref"] = this._target_person_id_ref.ToString();
      }
      if(this._action_property_mutation_rule_ref != null)
      {
        rawNode.attributes["action_property_mutation_rule_ref"] = this._action_property_mutation_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person.on_person.property_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
      this.NotifyChange();
    }
    public System.String Get_target_person_id_ref()
    {
      return this.target_person_id_ref;
    }
    public void Set_target_person_id_ref(System.String value)
    {
      this.target_person_id_ref = value;
      this.NotifyChange();
    }
    public System.String Get_action_property_mutation_rule_ref()
    {
      return this.action_property_mutation_rule_ref;
    }
    public void Set_action_property_mutation_rule_ref(System.String value)
    {
      this.action_property_mutation_rule_ref = value;
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

    public bool Equals(person__on_person__property_mutation? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (person__on_person__property_mutation)obj;
        return Equals(person_id_ref, other.person_id_ref) && Equals(target_person_id_ref, other.target_person_id_ref) && Equals(action_property_mutation_rule_ref, other.action_property_mutation_rule_ref);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, person_id_ref);
        acc = HashCode.Combine(acc, target_person_id_ref);
        acc = HashCode.Combine(acc, action_property_mutation_rule_ref);
        return acc;
    }
  }
}