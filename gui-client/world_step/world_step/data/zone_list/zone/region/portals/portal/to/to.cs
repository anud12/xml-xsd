using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal.Nto {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nportals.Nportal {
  public class to : IEquatable<to>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region.portals.portal.to";
    public static string TagName = "to";

    public string NodeName {get =>"to";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<to>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _zone_ref;
    public System.String zone_ref { get => _zone_ref; set => _zone_ref = value; }
    private System.String _region_ref;
    public System.String region_ref { get => _region_ref; set => _region_ref = value; }
    private System.String _side;
    public System.String side { get => _side; set => _side = value; }
    private System.Int32 _start;
    public System.Int32 start { get => _start; set => _start = value; }
    private System.Int32 _end;
    public System.Int32 end { get => _end; set => _end = value; }

    //Children elements
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
      if(name == "zone_ref")
      {
        Set_zone_ref(value);
      }
      if(name == "region_ref")
      {
        Set_region_ref(value);
      }
      if(name == "side")
      {
        Set_side(value);
      }
      if(name == "start")
      {
        Set_start(value?.ToInt() ?? 0);
      }
      if(name == "end")
      {
        Set_end(value?.ToInt() ?? 0);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
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
      if(rawNode.attributes.ContainsKey("zone_ref"))
      {
        var attribute_zone_ref = rawNode.attributes["zone_ref"];
        this.zone_ref = rawNode.attributes["zone_ref"];
      }
      if(rawNode.attributes.ContainsKey("region_ref"))
      {
        var attribute_region_ref = rawNode.attributes["region_ref"];
        this.region_ref = rawNode.attributes["region_ref"];
      }
      if(rawNode.attributes.ContainsKey("side"))
      {
        var attribute_side = rawNode.attributes["side"];
        this.side = rawNode.attributes["side"];
      }
      if(rawNode.attributes.ContainsKey("start"))
      {
        var attribute_start = rawNode.attributes["start"];
        this.start = rawNode.attributes["start"];
      }
      if(rawNode.attributes.ContainsKey("end"))
      {
        var attribute_end = rawNode.attributes["end"];
        this.end = rawNode.attributes["end"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._zone_ref != null)
      {
        rawNode.attributes["zone_ref"] = this._zone_ref.ToString();
      }
      if(this._region_ref != null)
      {
        rawNode.attributes["region_ref"] = this._region_ref.ToString();
      }
      if(this._side != null)
      {
        rawNode.attributes["side"] = this._side.ToString();
      }
      if(this._start != null)
      {
        rawNode.attributes["start"] = this._start.ToString();
      }
      if(this._end != null)
      {
        rawNode.attributes["end"] = this._end.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_zone_ref()
    {
      return this.zone_ref;
    }
    public void Set_zone_ref(System.String value)
    {
      this.zone_ref = value;
      this.NotifyChange();
    }
    public System.String Get_region_ref()
    {
      return this.region_ref;
    }
    public void Set_region_ref(System.String value)
    {
      this.region_ref = value;
      this.NotifyChange();
    }
    public System.String Get_side()
    {
      return this.side;
    }
    public void Set_side(System.String value)
    {
      this.side = value;
      this.NotifyChange();
    }
    public System.Int32 Get_start()
    {
      return this.start;
    }
    public void Set_start(System.Int32 value)
    {
      this.start = value;
      this.NotifyChange();
    }
    public System.Int32 Get_end()
    {
      return this.end;
    }
    public void Set_end(System.Int32 value)
    {
      this.end = value;
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

    public bool Equals(to? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (to)obj;
        return Equals(zone_ref, other.zone_ref) && Equals(region_ref, other.region_ref) && Equals(side, other.side) && Equals(start, other.start) && Equals(end, other.end);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, zone_ref);
        acc = HashCode.Combine(acc, region_ref);
        acc = HashCode.Combine(acc, side);
        acc = HashCode.Combine(acc, start);
        acc = HashCode.Combine(acc, end);
        return acc;
    }
  }
}