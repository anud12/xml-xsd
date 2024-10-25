using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__math_operations {}
namespace XSD {
}
namespace XSD {
  public class type__math_operations  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 initial;

    //Children elements
    public type__math_operations()
    {
    }

    public type__math_operations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__math_operations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__math_operations");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("initial"))
      {
        var attribute_initial = rawNode.attributes["initial"];
        this.initial = attribute_initial.ToInt();
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.initial != null)
      {
        rawNode.attributes["initial"] = this.initial.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__math_operations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_initial()
    {
      return this.initial;
    }
    public void Set_initial(System.Int32 value)
    {
      this.initial = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "reference",
      "value": "group__operation__and",
      "isSingle": true,
      "attributes": {
        "metaType": "object",
        "value": {
          "initial": {
            "metaType": "primitive",
            "value": "xs:int",
            "isNullable": false
          }
        },
        "isNullable": false
      }
    },
    "name": "type__math_operations"
  }
*/