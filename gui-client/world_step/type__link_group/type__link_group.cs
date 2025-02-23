using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__link_group {}
namespace XSD {
}
namespace XSD {
  public class type__link_group  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.Int32 angle;
    public System.Int32? angleMax;
    public System.Int32? limit;

    //Children elements
    public List<XSD.Ntype__link_group.to_option>? to_option = new List<XSD.Ntype__link_group.to_option>();
    public type__link_group()
    {
    }

    public type__link_group(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__link_group(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__link_group");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("angle"))
      {
        var attribute_angle = rawNode.attributes["angle"];
        this.angle = attribute_angle.ToInt();
      }
      if(rawNode.attributes.ContainsKey("angleMax"))
      {
        var attribute_angleMax = rawNode.attributes["angleMax"];
        this.angleMax = attribute_angleMax?.ToInt();
      }
      if(rawNode.attributes.ContainsKey("limit"))
      {
        var attribute_limit = rawNode.attributes["limit"];
        this.limit = attribute_limit?.ToInt();
      }

      //Deserialize children
      this.to_option = rawNode.InitializeWithRawNode("to_option", this.to_option);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.angle != null)
      {
        rawNode.attributes["angle"] = this.angle.ToString();
      }
      if(this.angleMax != null)
      {
        rawNode.attributes["angleMax"] = this.angleMax?.ToString();
      }
      if(this.limit != null)
      {
        rawNode.attributes["limit"] = this.limit?.ToString();
      }

      //Serialize children
      rawNode.children["to_option"] = to_option.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__link_group");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public System.Int32 Get_angle()
    {
      return this.angle;
    }
    public void Set_angle(System.Int32 value)
    {
      this.angle = value;
    }
    public System.Int32? Get_angleMax()
    {
      return this.angleMax;
    }
    public void Set_angleMax(System.Int32? value)
    {
      this.angleMax = value;
    }
    public System.Int32? Get_limit()
    {
      return this.limit;
    }
    public void Set_limit(System.Int32? value)
    {
      this.limit = value;
    }
    public List<XSD.Ntype__link_group.to_option>? Get_to_option()
    {
      return this.to_option;
    }
    public List<XSD.Ntype__link_group.to_option> GetOrInsertDefault_to_option()
    {
      if(this.to_option == null) {
        this.to_option = new List<XSD.Ntype__link_group.to_option>();
      }
      return this.to_option;
    }
    public void Set_to_option(List<XSD.Ntype__link_group.to_option>? value)
    {
      this.to_option = value;
    }
  }
}