using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule {
  public class person_to_person  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.test test = new XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.test();
    public type__property_mutation_on? property_mutation = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.location_mutation? location_mutation = null;
    public person_to_person()
    {
    }

    public person_to_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person_to_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person_to_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.test = rawNode.InitializeWithRawNode("test", this.test);
      this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
      this.location_mutation = rawNode.InitializeWithRawNode("location_mutation", this.location_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(test != null) {
        rawNode.children["test"] = new List<RawNode> { test.SerializeIntoRawNode() };
      }
      if(property_mutation != null) {
        rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
      }
      if(location_mutation != null) {
        rawNode.children["location_mutation"] = new List<RawNode> { location_mutation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person_to_person");
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
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.test Get_test()
    {
      return this.test;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.test GetOrInsertDefault_test()
    {
      if(this.test == null) {
        this.test = new XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.test();
      }
      return this.test;
    }
    public void Set_test(XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.test value)
    {
      this.test = value;
    }
    public type__property_mutation_on? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(type__property_mutation_on? value)
    {
      this.property_mutation = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.location_mutation? Get_location_mutation()
    {
      return this.location_mutation;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.location_mutation GetOrInsertDefault_location_mutation()
    {
      if(this.location_mutation == null) {
        this.location_mutation = new XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.location_mutation();
      }
      return this.location_mutation;
    }
    public void Set_location_mutation(XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.location_mutation? value)
    {
      this.location_mutation = value;
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
        "test": {
          "metaType": "object",
          "isSingle": true,
          "value": {
            "value": {
              "metaType": "reference",
              "value": "group__math_operations",
              "isSingle": true,
              "attributes": {
                "metaType": "object",
                "value": {
                  "target": {
                    "metaType": "primitive",
                    "value": "type_person_select",
                    "isNullable": false
                  }
                },
                "isNullable": false
              },
              "isNullable": false
            },
            "expected": {
              "metaType": "reference",
              "value": "group__math_operations",
              "isSingle": true,
              "attributes": {
                "metaType": "object",
                "value": {
                  "target": {
                    "metaType": "primitive",
                    "value": "type_person_select",
                    "isNullable": false
                  }
                },
                "isNullable": false
              },
              "isNullable": false
            }
          },
          "isNullable": false
        },
        "property_mutation": {
          "metaType": "reference",
          "value": "type__property_mutation_on",
          "isSingle": true,
          "isNullable": true
        },
        "location_mutation": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "name": {
                "metaType": "unknown",
                "isNullable": true
              },
              "on": {
                "metaType": "primitive",
                "value": "type_person_select",
                "isNullable": false
              }
            }
          },
          "isSingle": true,
          "value": {
            "from": {
              "metaType": "reference",
              "value": "group__math_operations",
              "isSingle": false,
              "attributes": {
                "metaType": "object",
                "value": {
                  "participant": {
                    "metaType": "primitive",
                    "value": "type_person_select",
                    "isNullable": false
                  }
                },
                "isNullable": false
              },
              "isNullable": false
            }
          },
          "isNullable": true
        }
      },
      "isNullable": true
    },
    "name": "person_to_person"
  }
*/