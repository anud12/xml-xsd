using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule {
  public class from_person  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public type__person_selection? selection = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations? mutations = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person? on_person = null;
    public from_person()
    {
    }

    public from_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.selection = rawNode.InitializeWithRawNode("selection", this.selection);
      this.mutations = rawNode.InitializeWithRawNode("mutations", this.mutations);
      this.on_person = rawNode.InitializeWithRawNode("on_person", this.on_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(selection != null) {
        rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
      }
      if(mutations != null) {
        rawNode.children["mutations"] = new List<RawNode> { mutations.SerializeIntoRawNode() };
      }
      if(on_person != null) {
        rawNode.children["on_person"] = new List<RawNode> { on_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public type__person_selection? Get_selection()
    {
      return this.selection;
    }
    public void Set_selection(type__person_selection? value)
    {
      this.selection = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations? Get_mutations()
    {
      return this.mutations;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations GetOrInsertDefault_mutations()
    {
      if(this.mutations == null) {
        this.mutations = new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations();
      }
      return this.mutations;
    }
    public void Set_mutations(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations? value)
    {
      this.mutations = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person? Get_on_person()
    {
      return this.on_person;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person GetOrInsertDefault_on_person()
    {
      if(this.on_person == null) {
        this.on_person = new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person();
      }
      return this.on_person;
    }
    public void Set_on_person(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person? value)
    {
      this.on_person = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
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
        "selection": {
          "metaType": "reference",
          "value": "type__person_selection",
          "isSingle": true,
          "isNullable": true
        },
        "mutations": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "property_mutation": {
              "metaType": "reference",
              "value": "type__property_mutation",
              "isSingle": false,
              "isNullable": true
            }
          },
          "isNullable": true
        },
        "on_person": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "selection": {
              "metaType": "composition",
              "value": [
                {
                  "metaType": "object",
                  "isSingle": true,
                  "value": {
                    "from_person_same_location_graph_node": {
                      "metaType": "object",
                      "value": {},
                      "isSingle": true,
                      "isNullable": true,
                      "attributes": {
                        "metaType": "object",
                        "value": {
                          "value": {
                            "metaType": "primitive",
                            "value": "xs:boolean",
                            "isNullable": false
                          }
                        },
                        "isNullable": false
                      }
                    }
                  }
                },
                {
                  "metaType": "primitive",
                  "value": "type__person_selection"
                }
              ],
              "isSingle": true,
              "isNullable": true
            },
            "mutations": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "property_mutation": {
                  "metaType": "reference",
                  "value": "type__property_mutation",
                  "isSingle": true,
                  "isNullable": true
                }
              },
              "isNullable": true
            }
          },
          "isNullable": true
        }
      },
      "isNullable": true
    },
    "name": "from_person"
  }
*/