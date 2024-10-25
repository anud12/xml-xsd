using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype_range {}
namespace XSD {
}
namespace XSD {
  public class type_range  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type_range()
    {
    }

    public type_range(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type_range(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type_range");
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
        // Godot.GD.Print("Serializing type_range");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
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
        "metaType": "reference",
        "value": "attributeGroup_range"
      }
    },
    "name": "type_range"
  }
*/