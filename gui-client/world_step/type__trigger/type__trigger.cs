using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__trigger {}
namespace XSD {
}
namespace XSD {
  public class type__trigger  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Ntype__trigger.person_action_used person_action_used = new XSD.Ntype__trigger.person_action_used();
    public type__trigger()
    {
    }

    public type__trigger(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__trigger(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__trigger");
      //Deserialize arguments

      //Deserialize children
      this.person_action_used = rawNode.InitializeWithRawNode("person_action_used", this.person_action_used);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(person_action_used != null) {
        rawNode.children["person_action_used"] = new List<RawNode> { person_action_used.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__trigger");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__trigger.person_action_used Get_person_action_used()
    {
      return this.person_action_used;
    }
    public XSD.Ntype__trigger.person_action_used GetOrInsertDefault_person_action_used()
    {
      if(this.person_action_used == null) {
        this.person_action_used = new XSD.Ntype__trigger.person_action_used();
      }
      return this.person_action_used;
    }
    public void Set_person_action_used(XSD.Ntype__trigger.person_action_used value)
    {
      this.person_action_used = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": true,
      "value": {
        "person_action_used": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "action_rule_ref": {
                "metaType": "unknown",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        }
      }
    },
    "name": "type__trigger"
  }
*/