using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nby.Nmove_towards {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nby {
  public class move_towards  {

    public static string ClassTypeId = "/world_step/actions/by/move_towards";
    public static string TagName = "move_towards";

    public string Tag = "move_towards";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String? layer;
    public System.String? _layer;
    public System.Int32 x;
    public System.Int32 _x;
    public System.Int32 y;
    public System.Int32 _y;

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
    }
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
    }
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}