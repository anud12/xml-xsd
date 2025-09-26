using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__portal_rule.Nto {}
namespace XSD {
}
namespace XSD.Ntype__portal_rule {
  public class to : IEquatable<to>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__portal_rule.to";
    public static string TagName = "to";

    public string NodeName {get =>"to";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Ntype__portal_rule.Nto.region> _region = new();
    public LinkedNodeCollection<XSD.Ntype__portal_rule.Nto.region> region
    {
      get => _region;
      set
      {
        _region = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _region.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
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

      if(linkedNode is LinkedNodeCollection<XSD.Ntype__portal_rule.Nto.region> region)
      {
        this.region = region;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Ntype__portal_rule.Nto.region>)
      {
        this.region = null;
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
      region.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["region"] = region.Select(x => x.SerializeIntoRawNode()).ToList();
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
      if(xpath.StartsWith(XSD.Ntype__portal_rule.Nto.region.TagName + "["))
      {
        var startIndex = (XSD.Ntype__portal_rule.Nto.region.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Ntype__portal_rule.Nto.region.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Ntype__portal_rule.Nto.region.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.region.ContainsKey(pathIndex))
        {
          this.region[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Ntype__portal_rule.Nto.region();
        this.region[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Ntype__portal_rule.Nto.region casted_region) {
        return this._region.KeyOf(casted_region);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Ntype__portal_rule.Nto.region
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