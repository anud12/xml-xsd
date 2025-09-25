using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata {
  public class zone_list : IEquatable<zone_list>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list";
    public static string TagName = "zone_list";

    public string NodeName {get =>"zone_list";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<zone_list>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.zone> _zone = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.zone> zone
    {
      get => _zone;
      set
      {
        _zone = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _zone.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public zone_list()
    {
    }

    public zone_list(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public zone_list(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.zone> zone)
      {
        this.zone = zone;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.zone>)
      {
        this.zone = null;
      }
    }

    public Action OnSelfChange(Action<zone_list> callback)
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
      // Godot.GD.Print("Deserializing zone_list");
      //Deserialize arguments

      //Deserialize children
      zone = rawNode.InitializeWithRawNode("zone", zone);
      zone.OnAdd = (value) =>
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
      rawNode.children["zone"] = zone.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing zone_list");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.zone.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nzone_list.zone.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Nzone_list.zone.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Nzone_list.zone.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.zone.ContainsKey(pathIndex))
        {
          this.zone[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nzone_list.zone();
        this.zone[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.zone casted_zone) {
        return this._zone.KeyOf(casted_zone);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nzone_list.zone
      || false;
    }

    public bool Equals(zone_list? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (zone_list)obj;
        return Equals(zone, other.zone);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, zone);
        return acc;
    }
  }
}