using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule {
  public class global  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry>? entry = new List<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry>();
    public global()
    {
    }

    public global(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public global(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing global");
      //Deserialize arguments

      //Deserialize children
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing global");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry>? Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry>? value)
    {
      this.entry = value;
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
        "entry": {
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
                  "id": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": false
                  }
                },
                "isNullable": false
              }
            },
            {
              "metaType": "primitive",
              "value": "type__action"
            }
          ],
          "isSingle": false,
          "isNullable": true
        }
      },
      "isNullable": true
    },
    "name": "global"
  }
*/