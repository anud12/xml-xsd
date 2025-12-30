using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity.Nposition {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nentity_list.Nentity {
  public class position : IEquatable<position>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region.entity_list.entity.position";
    public static string TagName = "position";

    public string NodeName {get =>"position";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<position>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.Int32 _x;
    public System.Int32 x { get => _x; set => _x = value; }
    private System.Int32 _y;
    public System.Int32 y { get => _y; set => _y = value; }

    //Children elements
    public position()
    {
    }

    public position(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public position(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
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

    public Action OnSelfChange(Action<position> callback)
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
      // Godot.GD.Print("Deserializing position");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("x"))
      {
        var attribute_x = rawNode.attributes["x"];
        this.x = rawNode.attributes["x"];
      }
      if(rawNode.attributes.ContainsKey("y"))
      {
        var attribute_y = rawNode.attributes["y"];
        this.y = rawNode.attributes["y"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
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
        // Godot.GD.Print("Serializing position");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
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

    public bool Equals(position? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (position)obj;
        return Equals(x, other.x) && Equals(y, other.y);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, x);
        acc = HashCode.Combine(acc, y);
        return acc;
    }
  }
}