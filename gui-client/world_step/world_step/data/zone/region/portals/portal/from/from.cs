using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nzone.Nregion.Nportals.Nportal.Nfrom {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nzone.Nregion.Nportals.Nportal {
  public class from : IEquatable<from>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.data.zone.region.portals.portal.from";
    public static string TagName = "from";

    public string NodeName {get =>"from";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<from>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _side;
    public System.String side { get => _side; set => _side = value; }
    private System.String _position;
    public System.String position { get => _position; set => _position = value; }
    private System.String? _width;
    public System.String? width { get => _width; set => _width = value; }

    //Children elements
    public from()
    {
    }

    public from(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "side")
      {
        Set_side(value);
      }
      if(name == "position")
      {
        Set_position(value);
      }
      if(name == "width")
      {
        Set_width(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<from> callback)
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
      // Godot.GD.Print("Deserializing from");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("side"))
      {
        var attribute_side = rawNode.attributes["side"];
        this.side = rawNode.attributes["side"];
      }
      if(rawNode.attributes.ContainsKey("position"))
      {
        var attribute_position = rawNode.attributes["position"];
        this.position = rawNode.attributes["position"];
      }
      if(rawNode.attributes.ContainsKey("width"))
      {
        var attribute_width = rawNode.attributes["width"];
        this.width = rawNode.attributes["width"];
      }

      //Deserialize children
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._side != null)
      {
        rawNode.attributes["side"] = this._side.ToString();
      }
      if(this._position != null)
      {
        rawNode.attributes["position"] = this._position.ToString();
      }
      if(this._width != null)
      {
        rawNode.attributes["width"] = this._width?.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
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
    public System.String Get_position()
    {
      return this.position;
    }
    public void Set_position(System.String value)
    {
      this.position = value;
      this.NotifyChange();
    }
    public System.String? Get_width()
    {
      return this.width;
    }
    public void Set_width(System.String? value)
    {
      this.width = value;
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

    public bool Equals(from? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (from)obj;
        return Equals(side, other.side) && Equals(position, other.position) && Equals(width, other.width);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, side);
        acc = HashCode.Combine(acc, position);
        acc = HashCode.Combine(acc, width);
        return acc;
    }
  }
}