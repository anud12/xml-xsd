using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__trigger.Nperson_action_used {}
namespace XSD {
}
namespace XSD.Ntype__trigger {
  public class person_action_used  {

    public static string ClassTypeId = "/type__trigger/person_action_used";
    public static string TagName = "person_action_used";

    public string Tag = "person_action_used";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String action_rule_ref;
    public System.String _action_rule_ref;

    //Children elements
    public person_action_used()
    {
    }

    public person_action_used(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person_action_used(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person_action_used");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("action_rule_ref"))
      {
        var attribute_action_rule_ref = rawNode.attributes["action_rule_ref"];
        this.action_rule_ref = rawNode.attributes["action_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.action_rule_ref != null)
      {
        rawNode.attributes["action_rule_ref"] = this.action_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person_action_used");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_action_rule_ref()
    {
      return this.action_rule_ref;
    }
    public void Set_action_rule_ref(System.String value)
    {
      this.action_rule_ref = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}