using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nregion__append {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class region__append : IEquatable<region__append>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.region.append";
    public static string TagName = "region.append";

    public string NodeName {get =>"region.append";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<region__append>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _zone_id_ref;
    public System.String zone_id_ref { get => _zone_id_ref; set => _zone_id_ref = value; }
    private System.String _region_id_ref;
    public System.String region_id_ref { get => _region_id_ref; set => _region_id_ref = value; }

    //Children elements
    public region__append()
    {
    }

    public region__append(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public region__append(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "zone_id_ref")
      {
        Set_zone_id_ref(value);
      }
      if(name == "region_id_ref")
      {
        Set_region_id_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<region__append> callback)
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
      // Godot.GD.Print("Deserializing region.append");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("zone_id_ref"))
      {
        var attribute_zone_id_ref = rawNode.attributes["zone_id_ref"];
        this.zone_id_ref = rawNode.attributes["zone_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("region_id_ref"))
      {
        var attribute_region_id_ref = rawNode.attributes["region_id_ref"];
        this.region_id_ref = rawNode.attributes["region_id_ref"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._zone_id_ref != null)
      {
        rawNode.attributes["zone_id_ref"] = this._zone_id_ref.ToString();
      }
      if(this._region_id_ref != null)
      {
        rawNode.attributes["region_id_ref"] = this._region_id_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing region.append");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_zone_id_ref()
    {
      return this.zone_id_ref;
    }
    public void Set_zone_id_ref(System.String value)
    {
      this.zone_id_ref = value;
      this.NotifyChange();
    }
    public System.String Get_region_id_ref()
    {
      return this.region_id_ref;
    }
    public void Set_region_id_ref(System.String value)
    {
      this.region_id_ref = value;
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

    public bool Equals(region__append? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (region__append)obj;
        return Equals(zone_id_ref, other.zone_id_ref) && Equals(region_id_ref, other.region_id_ref);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, zone_id_ref);
        acc = HashCode.Combine(acc, region_id_ref);
        return acc;
    }
  }
}