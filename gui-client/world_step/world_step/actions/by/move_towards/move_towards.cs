using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nby.Nmove_towards {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nby {
  public class move_towards : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.actions.by.move_towards";
    public static string TagName = "move_towards";

    public string NodeName {get =>"move_towards";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<move_towards>> _callbackList = new();

    //Attributes
    private System.String? _layer;
    public System.String? layer { get => _layer; set => _layer = value; }
    private System.Int32 _x;
    public System.Int32 x { get => _x; set => _x = value; }
    private System.Int32 _y;
    public System.Int32 y { get => _y; set => _y = value; }

    //Children elements
    public move_towards()
    {
    }

    public move_towards(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public move_towards(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<move_towards> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing move_towards");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("layer"))
      {
        var attribute_layer = rawNode.attributes["layer"];
        this.layer = rawNode.attributes["layer"];
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
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.layer != null)
      {
        rawNode.attributes["layer"] = this.layer?.ToString();
      }
      if(this.x != null)
      {
        rawNode.attributes["x"] = this.x.ToString();
      }
      if(this.y != null)
      {
        rawNode.attributes["y"] = this.y.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing move_towards");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String? Get_layer()
    {
      return this.layer;
    }
    public void Set_layer(System.String? value)
    {
      this.layer = value;
      this.OnChange();
    }
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
      this.OnChange();
    }
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }

      Deserialize(rawNode);
    }

    public void ChildChanged(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _callbackList.ForEach(action => action(this));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      return null;
    }
  }
}