using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nregion_rule.Nentry {}
namespace XSD {
  public interface Itype__region_rule {

    //Children elements
    public XSD.Ntype__region_rule.limit limit { get; set; }
    public XSD.Ntype__region_rule.portals portals { get; set; }
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);

  }
}
namespace XSD.Nworld_step.Nrule_group.Nregion_rule {
  public class entry : IEquatable<entry>, XSD.ILinkedNode , Itype__region_rule {

    public static string ClassTypeId = ".world_step.rule_group.region_rule.entry";
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

    //Attributes of type__region_rule

    //Children elements

    //Children of type__region_rule
    private XSD.Ntype__region_rule.limit _limit = new XSD.Ntype__region_rule.limit();
    public XSD.Ntype__region_rule.limit limitOrCreate
    {
      get
      {
        if(_limit == null)
        {
          _limit = new();
          _limit.ParentNode = this;
          NotifyChange();
        }
        return _limit;
      }
      set
      {
        _limit = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__region_rule.limit limit
    {
      get
      {
        return _limit;
      }
      set
      {
        _limit = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Ntype__region_rule.portals? _portals = null;
    public XSD.Ntype__region_rule.portals portalsOrCreate
    {
      get
      {
        if(_portals == null)
        {
          _portals = new();
          _portals.ParentNode = this;
          NotifyChange();
        }
        return _portals;
      }
      set
      {
        _portals = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__region_rule.portals? portals
    {
      get
      {
        return _portals;
      }
      set
      {
        _portals = value;
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
    }

    public void ClearChild(dynamic linkedNode)
    {
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

      // Deserialize arguments of type__region_rule


      //Deserialize children

      // Deserialize children of type__region_rule
  limit = rawNode.InitializeWithRawNode("limit", limit);

  portals = rawNode.InitializeWithRawNode("portals", portals);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }

      // Serialize arguments of type__region_rule


      //Serialize children

      // Serialize children of type__region_rule
  if(limit != null) {
    rawNode.children["limit"] = new List<RawNode> { limit.SerializeIntoRawNode() };
  }
  if(portals != null) {
    rawNode.children["portals"] = new List<RawNode> { portals.SerializeIntoRawNode() };
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

    public bool Equals(entry? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (entry)obj;
        return Equals(id, other.id);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        return acc;
    }
  }
}