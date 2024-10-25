using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype_icon {}
namespace XSD {
}
namespace XSD {
  public class type_icon  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type_icon()
    {
    }

    public type_icon(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type_icon(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type_icon");
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
        // Godot.GD.Print("Serializing type_icon");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "any"
    },
    "name": "type_icon"
  }
*/