using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__property_mutation_on {}
namespace XSD {
}
namespace XSD {
  public class type__property_mutation_on  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type__property_mutation_on()
    {
    }

    public type__property_mutation_on(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__property_mutation_on(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__property_mutation_on");
      //Deserialize arguments

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__property_mutation_on");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "composition",
      "value": [
        {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "on": {
                "metaType": "primitive",
                "value": "type_person_select",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        },
        {
          "metaType": "primitive",
          "value": "type__property_mutation"
        }
      ]
    },
    "name": "type__property_mutation_on"
  }
*/