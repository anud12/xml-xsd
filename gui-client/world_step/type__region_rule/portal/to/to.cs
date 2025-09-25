using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__region_rule.Nportal.Nto {}
namespace XSD {
}
namespace XSD.Ntype__region_rule.Nportal {
  public class to : IEquatable<to>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__region_rule.portal.to";
    public static string TagName = "to";

    public string NodeName {get =>"to";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Ntype__region_rule.Nportal.Nto.region _region = new XSD.Ntype__region_rule.Nportal.Nto.region();
    public XSD.Ntype__region_rule.Nportal.Nto.region regionOrCreate
    {
      get
      {
        if(_region == null)
        {
          _region = new();
          _region.ParentNode = this;
          NotifyChange();
        }
        return _region;
      }
      set
      {
        _region = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__region_rule.Nportal.Nto.region region
    {
      get
      {
        return _region;
      }
      set
      {
        _region = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public to()
    {
    }

    public to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__region_rule.Nportal.Nto.region region)
      {
        this.region = region;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__region_rule.Nportal.Nto.region)
      {
        this.region = new();
      }

    }

    public Action OnSelfChange(Action<to> callback)
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
      // Godot.GD.Print("Deserializing to");
      //Deserialize arguments

      //Deserialize children
      region = rawNode.InitializeWithRawNode("region", region);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(region != null) {
        rawNode.children["region"] = new List<RawNode> { region.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__region_rule.Nportal.Nto.region.TagName))
      {
        var childXPath = xpath.Substring(XSD.Ntype__region_rule.Nportal.Nto.region.TagName.Length + 3);
        this.region.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__region_rule.Nportal.Nto.region casted_region) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Ntype__region_rule.Nportal.Nto.region
      || false;
    }

    public bool Equals(to? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (to)obj;
        return Equals(region, other.region);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, region);
        return acc;
    }
  }
}