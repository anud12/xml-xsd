using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.Nproperty {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties {
  public class property  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public property()
    {
    }

    public property(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public property(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing property");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing property");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
    /* ignored attribute key={key} of type=System.Object*/
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
          "property_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          },
          "value": {
            "metaType": "unknown",
            "isNullable": false
          }
        }
      }
    },
    "name": "property"
  }
*/