using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion {
  public class available_portals : IEquatable<available_portals>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region.available_portals";
    public static string TagName = "available_portals";

    public string NodeName {get =>"available_portals";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<available_portals>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal> _portal = new();
    public LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal> portal
    {
      get => _portal;
      set
      {
        _portal = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _portal.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public available_portals()
    {
    }

    public available_portals(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public available_portals(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal> portal)
      {
        this.portal = portal;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal>)
      {
        this.portal = null;
      }
    }

    public Action OnSelfChange(Action<available_portals> callback)
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
      // Godot.GD.Print("Deserializing available_portals");
      //Deserialize arguments

      //Deserialize children
      portal = rawNode.InitializeWithRawNode("portal", portal);
      portal.OnAdd = (value) =>
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
      rawNode.children["portal"] = portal.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing available_portals");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.portal.ContainsKey(pathIndex))
        {
          this.portal[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal();
        this.portal[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal casted_portal) {
        return this._portal.KeyOf(casted_portal);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Navailable_portals.portal
      || false;
    }

    public bool Equals(available_portals? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (available_portals)obj;
        return Equals(portal, other.portal);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, portal);
        return acc;
    }
  }
}