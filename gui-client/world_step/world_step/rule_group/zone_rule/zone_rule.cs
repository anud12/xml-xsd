using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nzone_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class zone_rule : IEquatable<zone_rule>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.zone_rule";
    public static string TagName = "zone_rule";

    public string NodeName {get =>"zone_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<zone_rule>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nzone_rule.entry? _entry = null;
    public XSD.Nworld_step.Nrule_group.Nzone_rule.entry entryOrCreate
    {
      get
      {
        if(_entry == null)
        {
          _entry = new();
          _entry.ParentNode = this;
          NotifyChange();
        }
        return _entry;
      }
      set
      {
        _entry = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.Nzone_rule.entry? entry
    {
      get
      {
        return _entry;
      }
      set
      {
        _entry = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public zone_rule()
    {
    }

    public zone_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public zone_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nzone_rule.entry entry)
      {
        this.entry = entry;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nzone_rule.entry)
      {
        this.entry = null;
      }

    }

    public Action OnSelfChange(Action<zone_rule> callback)
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
      // Godot.GD.Print("Deserializing zone_rule");
      //Deserialize arguments

      //Deserialize children
      entry = rawNode.InitializeWithRawNode("entry", entry);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(entry != null) {
        rawNode.children["entry"] = new List<RawNode> { entry.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing zone_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nzone_rule.entry.TagName))
      {
        this.entry ??= new XSD.Nworld_step.Nrule_group.Nzone_rule.entry();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nzone_rule.entry.TagName.Length + 3);
        this.entry.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nzone_rule.entry casted_entry) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nzone_rule.entry
      || false;
    }

    public bool Equals(zone_rule? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (zone_rule)obj;
        return Equals(entry, other.entry);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, entry);
        return acc;
    }
  }
}