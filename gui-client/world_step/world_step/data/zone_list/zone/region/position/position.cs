using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion.Nposition {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone_list.Nzone.Nregion {
  public class position : IEquatable<position>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone_list.zone.region.position";
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
    private System.String _rotation;
    public System.String rotation { get => _rotation; set => _rotation = value; }

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
      if(name == "rotation")
      {
        Set_rotation(value);
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
        this.x = attribute_x.ToInt();
      }
      if(rawNode.attributes.ContainsKey("y"))
      {
        var attribute_y = rawNode.attributes["y"];
        this.y = attribute_y.ToInt();
      }
      if(rawNode.attributes.ContainsKey("rotation"))
      {
        var attribute_rotation = rawNode.attributes["rotation"];
        this.rotation = rawNode.attributes["rotation"];
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
      if(this._rotation != null)
      {
        rawNode.attributes["rotation"] = this._rotation.ToString();
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
    public System.String Get_rotation()
    {
      return this.rotation;
    }
    public void Set_rotation(System.String value)
    {
      this.rotation = value;
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
        return Equals(x, other.x) && Equals(y, other.y) && Equals(rotation, other.rotation);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, x);
        acc = HashCode.Combine(acc, y);
        acc = HashCode.Combine(acc, rotation);
        return acc;
    }
  }
}