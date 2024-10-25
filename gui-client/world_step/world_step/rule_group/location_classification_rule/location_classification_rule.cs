using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_classification_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class location_classification_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nlocation_classification_rule.entry> entry = new List<XSD.Nworld_step.Nrule_group.Nlocation_classification_rule.entry>();
    public location_classification_rule()
    {
    }

    public location_classification_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_classification_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_classification_rule");
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
        // Godot.GD.Print("Serializing location_classification_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_classification_rule.entry> Get_entry()
    {
      return this.entry;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_classification_rule.entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<XSD.Nworld_step.Nrule_group.Nlocation_classification_rule.entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<XSD.Nworld_step.Nrule_group.Nlocation_classification_rule.entry> value)
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
          "metaType": "object",
          "value": {},
          "isSingle": false,
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
        }
      },
      "isNullable": true
    },
    "name": "location_classification_rule"
  }
*/