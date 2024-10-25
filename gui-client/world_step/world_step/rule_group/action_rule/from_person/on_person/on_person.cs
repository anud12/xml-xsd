using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person {
  public class on_person  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection? selection = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations? mutations = null;
    public on_person()
    {
    }

    public on_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public on_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on_person");
      //Deserialize arguments

      //Deserialize children
      this.selection = rawNode.InitializeWithRawNode("selection", this.selection);
      this.mutations = rawNode.InitializeWithRawNode("mutations", this.mutations);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(selection != null) {
        rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
      }
      if(mutations != null) {
        rawNode.children["mutations"] = new List<RawNode> { mutations.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing on_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection? Get_selection()
    {
      return this.selection;
    }
    public void Set_selection(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection? value)
    {
      this.selection = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations? Get_mutations()
    {
      return this.mutations;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations GetOrInsertDefault_mutations()
    {
      if(this.mutations == null) {
        this.mutations = new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations();
      }
      return this.mutations;
    }
    public void Set_mutations(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations? value)
    {
      this.mutations = value;
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
    },
    "name": "on_person"
  }
*/