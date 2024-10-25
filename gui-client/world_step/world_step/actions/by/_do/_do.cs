using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nby.N_do {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nby {
  public class _do  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String? action_rule_ref;
    public System.String? action_ref;
    public System.String person_ref;

    //Children elements
    public _do()
    {
    }

    public _do(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public _do(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing _do");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("action_rule_ref"))
      {
        var attribute_action_rule_ref = rawNode.attributes["action_rule_ref"];
        this.action_rule_ref = rawNode.attributes["action_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("action_ref"))
      {
        var attribute_action_ref = rawNode.attributes["action_ref"];
        this.action_ref = rawNode.attributes["action_ref"];
      }
      if(rawNode.attributes.ContainsKey("person_ref"))
      {
        var attribute_person_ref = rawNode.attributes["person_ref"];
        this.person_ref = rawNode.attributes["person_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.action_rule_ref != null)
      {
        rawNode.attributes["action_rule_ref"] = this.action_rule_ref?.ToString();
      }
      if(this.action_ref != null)
      {
        rawNode.attributes["action_ref"] = this.action_ref?.ToString();
      }
      if(this.person_ref != null)
      {
        rawNode.attributes["person_ref"] = this.person_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing _do");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String? Get_action_rule_ref()
    {
      return this.action_rule_ref;
    }
    public void Set_action_rule_ref(System.String? value)
    {
      this.action_rule_ref = value;
    }
    public System.String? Get_action_ref()
    {
      return this.action_ref;
    }
    public void Set_action_ref(System.String? value)
    {
      this.action_ref = value;
    }
    public System.String Get_person_ref()
    {
      return this.person_ref;
    }
    public void Set_person_ref(System.String value)
    {
      this.person_ref = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "value": {},
      "isSingle": true,
      "isNullable": false,
      "attributes": {
        "metaType": "object",
        "value": {
          "action_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": true
          },
          "action_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": true
          },
          "person_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        }
      }
    },
    "name": "_do"
  }
*/