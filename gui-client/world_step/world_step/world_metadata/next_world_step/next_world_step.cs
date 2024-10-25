using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nworld_metadata.Nnext_world_step {}
namespace XSD {
}
namespace XSD.Nworld_step.Nworld_metadata {
  public class next_world_step  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String? value;

    //Children elements
    public next_world_step()
    {
    }

    public next_world_step(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public next_world_step(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing next_world_step");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("value"))
      {
        var attribute_value = rawNode.attributes["value"];
        this.value = rawNode.attributes["value"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.value != null)
      {
        rawNode.attributes["value"] = this.value?.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing next_world_step");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String? Get_value()
    {
      return this.value;
    }
    public void Set_value(System.String? value)
    {
      this.value = value;
    }
  }
}