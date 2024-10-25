using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ngroup__name_token {}
namespace XSD {
}
namespace XSD {
  public class group__name_token  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Ngroup__name_token.name_token> name_token = new List<XSD.Ngroup__name_token.name_token>();
    public group__name_token()
    {
    }

    public group__name_token(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__name_token(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing group__name_token");
      //Deserialize arguments

      //Deserialize children
      this.name_token = rawNode.InitializeWithRawNode("name_token", this.name_token);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["name_token"] = name_token.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing group__name_token");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Ngroup__name_token.name_token> Get_name_token()
    {
      return this.name_token;
    }
    public void Set_name_token(List<XSD.Ngroup__name_token.name_token> value)
    {
      this.name_token = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": false,
      "value": {
        "name_token": {
          "metaType": "union",
          "value": [
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": true,
              "value": {
                "ref": {
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
                }
              }
            },
            {
              "metaType": "object",
              "isSingle": true,
              "isNullable": false,
              "value": {
                "one_of": {
                  "metaType": "reference",
                  "value": "group__name_token",
                  "isSingle": true,
                  "isNullable": false
                }
              }
            }
          ],
          "isSingle": false,
          "attributes": {
            "metaType": "object",
            "value": {
              "prefix": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
          },
          "isNullable": false
        }
      }
    },
    "name": "group__name_token"
  }
*/