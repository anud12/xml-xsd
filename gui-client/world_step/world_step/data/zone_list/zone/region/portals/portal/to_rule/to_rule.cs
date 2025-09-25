using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal {
  public class to_rule : IEquatable<to_rule>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region.portals.portal.to_rule";
    public static string TagName = "to_rule";

    public string NodeName {get =>"to_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to_rule>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region> _region = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region> region
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
    public to_rule()
    {
    }

    public to_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public to_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region> region)
      {
        this.region = region;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region>)
      {
        this.region = new();
      }
    }

    public Action OnSelfChange(Action<to_rule> callback)
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
      // Godot.GD.Print("Deserializing to_rule");
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
        // Godot.GD.Print("Serializing to_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.region.ContainsKey(pathIndex))
        {
          this.region[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region();
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region casted_region) {
        return this._region.KeyOf(casted_region);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto_rule.region
      || false;
    }

    public bool Equals(to_rule? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (to_rule)obj;
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