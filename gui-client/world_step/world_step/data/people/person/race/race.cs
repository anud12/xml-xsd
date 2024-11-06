using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nrace {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople.Nperson {
  public class race  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String race_rule_ref;

    //Children elements
    public race()
    {
    }

    public race(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public race(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing race");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("race_rule_ref"))
      {
        var attribute_race_rule_ref = rawNode.attributes["race_rule_ref"];
        this.race_rule_ref = rawNode.attributes["race_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.race_rule_ref != null)
      {
        rawNode.attributes["race_rule_ref"] = this.race_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing race");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_race_rule_ref()
    {
      return this.race_rule_ref;
    }
    public void Set_race_rule_ref(System.String value)
    {
      this.race_rule_ref = value;
    }
  }
}