using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion {
  public class entity_list : IEquatable<entity_list>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region.entity_list";
    public static string TagName = "entity_list";

    public string NodeName {get =>"entity_list";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<entity_list>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity> _entity = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity> entity
    {
      get => _entity;
      set
      {
        _entity = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _entity.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public entity_list()
    {
    }

    public entity_list(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entity_list(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity> entity)
      {
        this.entity = entity;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity>)
      {
        this.entity = null;
      }
    }

    public Action OnSelfChange(Action<entity_list> callback)
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
      // Godot.GD.Print("Deserializing entity_list");
      //Deserialize arguments

      //Deserialize children
      entity = rawNode.InitializeWithRawNode("entity", entity);
      entity.OnAdd = (value) =>
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
      rawNode.children["entity"] = entity.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entity_list");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.entity.ContainsKey(pathIndex))
        {
          this.entity[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity();
        this.entity[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity casted_entity) {
        return this._entity.KeyOf(casted_entity);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.entity
      || false;
    }

    public bool Equals(entity_list? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (entity_list)obj;
        return Equals(entity, other.entity);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, entity);
        return acc;
    }
  }
}