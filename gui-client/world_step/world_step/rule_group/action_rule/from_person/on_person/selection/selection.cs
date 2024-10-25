using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection {}
namespace XSD {
  public interface Itype__person_selection {

    //Children elements
    public type__math_operations? Get_radius();
    public void Set_radius(type__math_operations? value);
    public type__math_operations? Get_min();
    public void Set_min(type__math_operations? value);
    public type__math_operations? Get_max();
    public void Set_max(type__math_operations? value);
    public List<XSD.Ntype__person_selection.property> Get_property();
    public void Set_property(List<XSD.Ntype__person_selection.property> value);
    public List<XSD.Ntype__person_selection.classification> Get_classification();
    public void Set_classification(List<XSD.Ntype__person_selection.classification> value);
    public XSD.Ntype__person_selection.race Get_race();
    public void Set_race(XSD.Ntype__person_selection.race value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person {
  public class selection : Itype__person_selection {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Attributes of type__person_selection

    //Children elements
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? from_person_same_location_graph_node = null;

    //Children of type__person_selection
    public type__math_operations? radius = null;
    public type__math_operations? min = null;
    public type__math_operations? max = null;
    public List<XSD.Ntype__person_selection.property>? property = new List<XSD.Ntype__person_selection.property>();
    public List<XSD.Ntype__person_selection.classification>? classification = new List<XSD.Ntype__person_selection.classification>();
    public XSD.Ntype__person_selection.race? race = null;
    public selection()
    {
    }

    public selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing selection");
      //Deserialize arguments

      // Deserialize arguments of type__person_selection

      //Deserialize children
      this.from_person_same_location_graph_node = rawNode.InitializeWithRawNode("from_person_same_location_graph_node", this.from_person_same_location_graph_node);

      // Deserialize children of type__person_selection
  this.radius = rawNode.InitializeWithRawNode("radius", this.radius);
  this.min = rawNode.InitializeWithRawNode("min", this.min);
  this.max = rawNode.InitializeWithRawNode("max", this.max);
  this.property = rawNode.InitializeWithRawNode("property", this.property);
  this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
  this.race = rawNode.InitializeWithRawNode("race", this.race);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__person_selection


      //Serialize children
      if(from_person_same_location_graph_node != null) {
        rawNode.children["from_person_same_location_graph_node"] = new List<RawNode> { from_person_same_location_graph_node.SerializeIntoRawNode() };
      }

      // Serialize children of type__person_selection
  if(radius != null) {
    rawNode.children["radius"] = new List<RawNode> { radius.SerializeIntoRawNode() };
  }
  if(min != null) {
    rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
  }
  if(max != null) {
    rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
  }
  rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
  rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
  if(race != null) {
    rawNode.children["race"] = new List<RawNode> { race.SerializeIntoRawNode() };
  }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? Get_from_person_same_location_graph_node()
    {
      return this.from_person_same_location_graph_node;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node GetOrInsertDefault_from_person_same_location_graph_node()
    {
      if(this.from_person_same_location_graph_node == null) {
        this.from_person_same_location_graph_node = new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node();
      }
      return this.from_person_same_location_graph_node;
    }
    public void Set_from_person_same_location_graph_node(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? value)
    {
      this.from_person_same_location_graph_node = value;
    }
    public type__math_operations? Get_radius()
    {
      return this.radius;
    }
    public void Set_radius(type__math_operations? value)
    {
      this.radius = value;
    }
    public type__math_operations? Get_min()
    {
      return this.min;
    }
    public void Set_min(type__math_operations? value)
    {
      this.min = value;
    }
    public type__math_operations? Get_max()
    {
      return this.max;
    }
    public void Set_max(type__math_operations? value)
    {
      this.max = value;
    }
    public List<XSD.Ntype__person_selection.property>? Get_property()
    {
      return this.property;
    }
    public List<XSD.Ntype__person_selection.property> GetOrInsertDefault_property()
    {
      if(this.property == null) {
        this.property = new List<XSD.Ntype__person_selection.property>();
      }
      return this.property;
    }
    public void Set_property(List<XSD.Ntype__person_selection.property>? value)
    {
      this.property = value;
    }
    public List<XSD.Ntype__person_selection.classification>? Get_classification()
    {
      return this.classification;
    }
    public List<XSD.Ntype__person_selection.classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<XSD.Ntype__person_selection.classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<XSD.Ntype__person_selection.classification>? value)
    {
      this.classification = value;
    }
    public XSD.Ntype__person_selection.race? Get_race()
    {
      return this.race;
    }
    public XSD.Ntype__person_selection.race GetOrInsertDefault_race()
    {
      if(this.race == null) {
        this.race = new XSD.Ntype__person_selection.race();
      }
      return this.race;
    }
    public void Set_race(XSD.Ntype__person_selection.race? value)
    {
      this.race = value;
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
        "value": {}
      },
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
    "name": "selection"
  }
*/