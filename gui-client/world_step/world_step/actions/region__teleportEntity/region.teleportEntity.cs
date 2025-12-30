using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nregion__teleportEntity {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class region__teleportEntity : IEquatable<region__teleportEntity>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.region.teleportEntity";
    public static string TagName = "region.teleportEntity";

    public string NodeName {get =>"region.teleportEntity";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<region__teleportEntity>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _zone_id_ref;
    public System.String zone_id_ref { get => _zone_id_ref; set => _zone_id_ref = value; }
    private System.String _region_id_ref;
    public System.String region_id_ref { get => _region_id_ref; set => _region_id_ref = value; }
    private System.String _entity_id_ref;
    public System.String entity_id_ref { get => _entity_id_ref; set => _entity_id_ref = value; }
    private System.Int32 _x;
    public System.Int32 x { get => _x; set => _x = value; }
    private System.Int32 _y;
    public System.Int32 y { get => _y; set => _y = value; }

    //Children elements
    public region__teleportEntity()
    {
    }

    public region__teleportEntity(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public region__teleportEntity(XmlElement xmlElement)
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
      if(name == "entity_id_ref")
      {
        Set_entity_id_ref(value);
      }
      if(name == "x")
      {
        Set_x(value?.ToInt() ?? 0);
      }
      if(name == "y")
      {
        Set_y(value?.ToInt() ?? 0);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<region__teleportEntity> callback)
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
      // Godot.GD.Print("Deserializing region.teleportEntity");
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
      if(rawNode.attributes.ContainsKey("entity_id_ref"))
      {
        var attribute_entity_id_ref = rawNode.attributes["entity_id_ref"];
        this.entity_id_ref = rawNode.attributes["entity_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("x"))
      {
        var attribute_x = rawNode.attributes["x"];
        this.x = attribute_x.ToInt();
      }
      if(rawNode.attributes.ContainsKey("y"))
      {
        var attribute_y = rawNode.attributes["y"];
        this.y = attribute_y.ToInt();
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
      if(this._entity_id_ref != null)
      {
        rawNode.attributes["entity_id_ref"] = this._entity_id_ref.ToString();
      }
      if(this._x != null)
      {
        rawNode.attributes["x"] = this._x.ToString();
      }
      if(this._y != null)
      {
        rawNode.attributes["y"] = this._y.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing region.teleportEntity");
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
    public System.String Get_entity_id_ref()
    {
      return this.entity_id_ref;
    }
    public void Set_entity_id_ref(System.String value)
    {
      this.entity_id_ref = value;
      this.NotifyChange();
    }
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
      this.NotifyChange();
    }
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
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

    public bool Equals(region__teleportEntity? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (region__teleportEntity)obj;
        return Equals(zone_id_ref, other.zone_id_ref) && Equals(region_id_ref, other.region_id_ref) && Equals(entity_id_ref, other.entity_id_ref) && Equals(x, other.x) && Equals(y, other.y);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, zone_id_ref);
        acc = HashCode.Combine(acc, region_id_ref);
        acc = HashCode.Combine(acc, entity_id_ref);
        acc = HashCode.Combine(acc, x);
        acc = HashCode.Combine(acc, y);
        return acc;
    }
  }
}