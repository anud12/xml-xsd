using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__on_person__property_mutation {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__on_person__property_mutation  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.String target_person_id_ref;
    public System.String action_property_mutation_rule_ref;

    //Children elements
    public person__on_person__property_mutation()
    {
    }

    public person__on_person__property_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__on_person__property_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person__on_person__property_mutation");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("target_person_id_ref"))
      {
        var attribute_target_person_id_ref = rawNode.attributes["target_person_id_ref"];
        this.target_person_id_ref = rawNode.attributes["target_person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("action_property_mutation_rule_ref"))
      {
        var attribute_action_property_mutation_rule_ref = rawNode.attributes["action_property_mutation_rule_ref"];
        this.action_property_mutation_rule_ref = rawNode.attributes["action_property_mutation_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }
      if(this.target_person_id_ref != null)
      {
        rawNode.attributes["target_person_id_ref"] = this.target_person_id_ref.ToString();
      }
      if(this.action_property_mutation_rule_ref != null)
      {
        rawNode.attributes["action_property_mutation_rule_ref"] = this.action_property_mutation_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person__on_person__property_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public System.String Get_target_person_id_ref()
    {
      return this.target_person_id_ref;
    }
    public void Set_target_person_id_ref(System.String value)
    {
      this.target_person_id_ref = value;
    }
    public System.String Get_action_property_mutation_rule_ref()
    {
      return this.action_property_mutation_rule_ref;
    }
    public void Set_action_property_mutation_rule_ref(System.String value)
    {
      this.action_property_mutation_rule_ref = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "value": {},
      "isSingle": false,
      "isNullable": true,
      "attributes": {
        "metaType": "object",
        "value": {
          "person_id_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          },
          "target_person_id_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          },
          "action_property_mutation_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        }
      }
    },
    "name": "person__on_person__property_mutation"
  }
*/