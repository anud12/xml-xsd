using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry {
  public class then  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person>? select_person = new List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person>();
    public XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation? property_mutation = null;
    public then()
    {
    }

    public then(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public then(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing then");
      //Deserialize arguments

      //Deserialize children
      this.select_person = rawNode.InitializeWithRawNode("select_person", this.select_person);
      this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["select_person"] = select_person.Select(x => x.SerializeIntoRawNode()).ToList();
      if(property_mutation != null) {
        rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing then");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person>? Get_select_person()
    {
      return this.select_person;
    }
    public void Set_select_person(List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person>? value)
    {
      this.select_person = value;
    }
    public XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation? value)
    {
      this.property_mutation = value;
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
        "select_person": {
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
                  "origin": {
                    "metaType": "union",
                    "value": [
                      {
                        "metaType": "primitive",
                        "value": "\"target\""
                      },
                      {
                        "metaType": "primitive",
                        "value": "\"self\""
                      }
                    ]
                  }
                }
              }
            },
            {
              "metaType": "primitive",
              "value": "type__person_selection"
            }
          ],
          "isSingle": false,
          "isNullable": true
        },
        "property_mutation": {
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
                  "property_rule_ref": {
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
              "value": "type__math_operations"
            }
          ],
          "isSingle": true,
          "isNullable": true
        }
      },
      "isNullable": false
    },
    "name": "then"
  }
*/