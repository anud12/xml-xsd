using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nzone_rule {
  public class entry : IEquatable<entry>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.zone_rule.entry";
    public static string TagName = "entry";

    public string NodeName {get =>"entry";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<entry>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region _starting_region = new XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region();
    public XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region starting_regionOrCreate
    {
      get
      {
        if(_starting_region == null)
        {
          _starting_region = new();
          _starting_region.ParentNode = this;
          NotifyChange();
        }
        return _starting_region;
      }
      set
      {
        _starting_region = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region starting_region
    {
      get
      {
        return _starting_region;
      }
      set
      {
        _starting_region = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "id")
      {
        Set_id(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region starting_region)
      {
        this.starting_region = starting_region;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region)
      {
        this.starting_region = new();
      }

    }

    public Action OnSelfChange(Action<entry> callback)
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
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      starting_region = rawNode.InitializeWithRawNode("starting_region", starting_region);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }

      //Serialize children
      if(starting_region != null) {
        rawNode.children["starting_region"] = new List<RawNode> { starting_region.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region.TagName.Length + 3);
        this.starting_region.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region casted_starting_region) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nzone_rule.Nentry.starting_region
      || false;
    }

    public bool Equals(entry? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (entry)obj;
        return Equals(id, other.id) && Equals(starting_region, other.starting_region);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, starting_region);
        return acc;
    }
  }
}