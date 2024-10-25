using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nfrom_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class from_person  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.String from_person_rule_ref;

    //Children elements
    public XSD.Nworld_step.Nactions.Nfrom_person.on_person on_person = new XSD.Nworld_step.Nactions.Nfrom_person.on_person();
    public from_person()
    {
    }

    public from_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("from_person_rule_ref"))
      {
        var attribute_from_person_rule_ref = rawNode.attributes["from_person_rule_ref"];
        this.from_person_rule_ref = rawNode.attributes["from_person_rule_ref"];
      }

      //Deserialize children
      this.on_person = rawNode.InitializeWithRawNode("on_person", this.on_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }
      if(this.from_person_rule_ref != null)
      {
        rawNode.attributes["from_person_rule_ref"] = this.from_person_rule_ref.ToString();
      }

      //Serialize children
      if(on_person != null) {
        rawNode.children["on_person"] = new List<RawNode> { on_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from_person");
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
    public System.String Get_from_person_rule_ref()
    {
      return this.from_person_rule_ref;
    }
    public void Set_from_person_rule_ref(System.String value)
    {
      this.from_person_rule_ref = value;
    }
    public XSD.Nworld_step.Nactions.Nfrom_person.on_person Get_on_person()
    {
      return this.on_person;
    }
    public XSD.Nworld_step.Nactions.Nfrom_person.on_person GetOrInsertDefault_on_person()
    {
      if(this.on_person == null) {
        this.on_person = new XSD.Nworld_step.Nactions.Nfrom_person.on_person();
      }
      return this.on_person;
    }
    public void Set_on_person(XSD.Nworld_step.Nactions.Nfrom_person.on_person value)
    {
      this.on_person = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "attributes": {
        "metaType": "object",
        "value": {
          "person_id_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          },
          "from_person_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        }
      },
      "isSingle": false,
      "value": {
        "on_person": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "person_id_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        }
      },
      "isNullable": true
    },
    "name": "from_person"
  }
*/