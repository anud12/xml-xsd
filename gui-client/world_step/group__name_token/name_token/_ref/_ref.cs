using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ngroup__name_token.Nname_token.N_ref {}
namespace XSD {
}
namespace XSD.Ngroup__name_token.Nname_token {
  public class _ref  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String name_rule_ref;

    //Children elements
    public _ref()
    {
    }

    public _ref(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public _ref(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing _ref");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("name_rule_ref"))
      {
        var attribute_name_rule_ref = rawNode.attributes["name_rule_ref"];
        this.name_rule_ref = rawNode.attributes["name_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.name_rule_ref != null)
      {
        rawNode.attributes["name_rule_ref"] = this.name_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing _ref");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_name_rule_ref()
    {
      return this.name_rule_ref;
    }
    public void Set_name_rule_ref(System.String value)
    {
      this.name_rule_ref = value;
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
      "isNullable": true,
      "attributes": {
        "metaType": "object",
        "value": {
          "name_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        },
        "isNullable": false
      }
    },
    "name": "_ref"
  }
*/