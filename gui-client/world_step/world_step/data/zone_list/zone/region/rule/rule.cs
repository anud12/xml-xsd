using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nrule {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion {
  public class rule : IEquatable<rule>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region.rule";
    public static string TagName = "rule";

    public string NodeName {get =>"rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<rule>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _rule_id_ref;
    public System.String rule_id_ref { get => _rule_id_ref; set => _rule_id_ref = value; }

    //Children elements
    public rule()
    {
    }

    public rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "rule_id_ref")
      {
        Set_rule_id_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<rule> callback)
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
      // Godot.GD.Print("Deserializing rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("rule_id_ref"))
      {
        var attribute_rule_id_ref = rawNode.attributes["rule_id_ref"];
        this.rule_id_ref = rawNode.attributes["rule_id_ref"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._rule_id_ref != null)
      {
        rawNode.attributes["rule_id_ref"] = this._rule_id_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_rule_id_ref()
    {
      return this.rule_id_ref;
    }
    public void Set_rule_id_ref(System.String value)
    {
      this.rule_id_ref = value;
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

    public bool Equals(rule? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (rule)obj;
        return Equals(rule_id_ref, other.rule_id_ref);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, rule_id_ref);
        return acc;
    }
  }
}