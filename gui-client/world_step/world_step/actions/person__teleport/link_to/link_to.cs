using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__teleport.Nlink_to {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nperson__teleport {
  public class link_to  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 accumulated_progress;

    //Children elements
    public type__link_to__selection selection = new type__link_to__selection();
    public link_to()
    {
    }

    public link_to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("accumulated_progress"))
      {
        var attribute_accumulated_progress = rawNode.attributes["accumulated_progress"];
        this.accumulated_progress = attribute_accumulated_progress.ToInt();
      }

      //Deserialize children
      this.selection = rawNode.InitializeWithRawNode("selection", this.selection);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.accumulated_progress != null)
      {
        rawNode.attributes["accumulated_progress"] = this.accumulated_progress.ToString();
      }

      //Serialize children
      if(selection != null) {
        rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_accumulated_progress()
    {
      return this.accumulated_progress;
    }
    public void Set_accumulated_progress(System.Int32 value)
    {
      this.accumulated_progress = value;
    }
    public type__link_to__selection Get_selection()
    {
      return this.selection;
    }
    public void Set_selection(type__link_to__selection value)
    {
      this.selection = value;
    }
  }
}