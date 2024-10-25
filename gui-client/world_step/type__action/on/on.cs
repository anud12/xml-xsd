using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__action.Non {}
namespace XSD {
}
namespace XSD.Ntype__action {
  public class on  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Ntype__action.Non.person? person = null;
    public on()
    {
    }

    public on(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public on(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on");
      //Deserialize arguments

      //Deserialize children
      this.person = rawNode.InitializeWithRawNode("person", this.person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(person != null) {
        rawNode.children["person"] = new List<RawNode> { person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing on");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__action.Non.person? Get_person()
    {
      return this.person;
    }
    public XSD.Ntype__action.Non.person GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new XSD.Ntype__action.Non.person();
      }
      return this.person;
    }
    public void Set_person(XSD.Ntype__action.Non.person? value)
    {
      this.person = value;
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
        "person": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "select": {
              "metaType": "reference",
              "value": "type__person_selection",
              "isSingle": true,
              "isNullable": true
            },
            "property_mutation": {
              "metaType": "reference",
              "value": "type__property_mutation",
              "isSingle": true,
              "isNullable": true
            }
          },
          "isNullable": true
        }
      },
      "isNullable": false
    },
    "name": "on"
  }
*/