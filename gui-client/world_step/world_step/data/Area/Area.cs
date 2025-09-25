using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.NNodes.NNode.NArea {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.NNodes.NNode {
  public class Area : IEquatable<Area>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.Nodes.Node.Area";
    public static string TagName = "Area";

    public string NodeName {get =>"Area";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<Area>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.Int32 _width;
    public System.Int32 width { get => _width; set => _width = value; }
    private System.Int32 _height;
    public System.Int32 height { get => _height; set => _height = value; }
    private System.Int32? _orientation;
    public System.Int32? orientation { get => _orientation; set => _orientation = value; }

    //Children elements
    public Area()
    {
    }

    public Area(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public Area(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "width")
      {
        Set_width(value?.ToInt() ?? 0);
      }
      if(name == "height")
      {
        Set_height(value?.ToInt() ?? 0);
      }
      if(name == "orientation")
      {
        Set_orientation(value?.ToInt() ?? 0);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<Area> callback)
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
      // Godot.GD.Print("Deserializing Area");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("width"))
      {
        var attribute_width = rawNode.attributes["width"];
        this.width = rawNode.attributes["width"];
      }
      if(rawNode.attributes.ContainsKey("height"))
      {
        var attribute_height = rawNode.attributes["height"];
        this.height = rawNode.attributes["height"];
      }
      if(rawNode.attributes.ContainsKey("orientation"))
      {
        var attribute_orientation = rawNode.attributes["orientation"];
        this.orientation = rawNode.attributes["orientation"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._width != null)
      {
        rawNode.attributes["width"] = this._width.ToString();
      }
      if(this._height != null)
      {
        rawNode.attributes["height"] = this._height.ToString();
      }
      if(this._orientation != null)
      {
        rawNode.attributes["orientation"] = this._orientation?.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing Area");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_width()
    {
      return this.width;
    }
    public void Set_width(System.Int32 value)
    {
      this.width = value;
      this.NotifyChange();
    }
    public System.Int32 Get_height()
    {
      return this.height;
    }
    public void Set_height(System.Int32 value)
    {
      this.height = value;
      this.NotifyChange();
    }
    public System.Int32? Get_orientation()
    {
      return this.orientation;
    }
    public void Set_orientation(System.Int32? value)
    {
      this.orientation = value;
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

    public bool Equals(Area? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (Area)obj;
        return Equals(width, other.width) && Equals(height, other.height) && Equals(orientation, other.orientation);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, width);
        acc = HashCode.Combine(acc, height);
        acc = HashCode.Combine(acc, orientation);
        return acc;
    }
  }
}