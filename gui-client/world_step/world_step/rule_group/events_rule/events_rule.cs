using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class events_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.entry>? entry = new List<XSD.Nworld_step.Nrule_group.Nevents_rule.entry>();
    public events_rule()
    {
    }

    public events_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public events_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing events_rule");
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
        // Godot.GD.Print("Serializing events_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.entry>? Get_entry()
    {
      return this.entry;
    }
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<XSD.Nworld_step.Nrule_group.Nevents_rule.entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<XSD.Nworld_step.Nrule_group.Nevents_rule.entry>? value)
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
          },
          "isSingle": false,
          "value": {
            "when": {
              "metaType": "reference",
              "value": "type__trigger",
              "isSingle": false,
              "isNullable": false
            },
            "then": {
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
            }
          },
          "isNullable": true
        }
      },
      "isNullable": true
    },
    "name": "events_rule"
  }
*/