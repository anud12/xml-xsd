using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.Nitem_default {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry {
  public class item_default : IEquatable<item_default>, XSD.ILinkedNode , Itype__math_operations {

    public static string ClassTypeId = ".world_step.rule_group.property_rule.entry.item_default";
    public static string TagName = "item_default";

    public string NodeName {get =>"item_default";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<item_default>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Attributes of type__math_operations

    //Children elements

    //Children of type__math_operations

    public item_default()
    {
    }

    public item_default(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public item_default(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }


    public Action OnSelfChange(Action<item_default> callback)
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
      // Godot.GD.Print("Deserializing item_default");
      //Deserialize arguments

      // Deserialize arguments of type__math_operations


      //Deserialize children

      // Deserialize children of type__math_operations

      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__math_operations


      //Serialize children

      // Serialize children of type__math_operations

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing item_default");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
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

        public bool Equals(item_default? obj)
        {
            if (obj == null || GetType() != obj.GetType())
                return false;

            var other = (item_default)obj;
            return object.Equals(this, other);
        }

    public int GetHashCode()
    {
        return base.GetHashCode();
    }
  }
}