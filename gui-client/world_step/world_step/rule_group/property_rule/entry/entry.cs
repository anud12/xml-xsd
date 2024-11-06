using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nproperty_rule {
  public class entry  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String units;

    //Children elements
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default? person_default = null;
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default? item_default = null;
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>? property_threshold = new List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>();
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("units"))
      {
        var attribute_units = rawNode.attributes["units"];
        this.units = rawNode.attributes["units"];
      }

      //Deserialize children
      this.person_default = rawNode.InitializeWithRawNode("person_default", this.person_default);
      this.item_default = rawNode.InitializeWithRawNode("item_default", this.item_default);
      this.property_threshold = rawNode.InitializeWithRawNode("property-threshold", this.property_threshold);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.units != null)
      {
        rawNode.attributes["units"] = this.units.ToString();
      }

      //Serialize children
      if(person_default != null) {
        rawNode.children["person_default"] = new List<RawNode> { person_default.SerializeIntoRawNode() };
      }
      if(item_default != null) {
        rawNode.children["item_default"] = new List<RawNode> { item_default.SerializeIntoRawNode() };
      }
      rawNode.children["property-threshold"] = property_threshold.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
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
    public System.String Get_units()
    {
      return this.units;
    }
    public void Set_units(System.String value)
    {
      this.units = value;
    }
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default? Get_person_default()
    {
      return this.person_default;
    }
    public void Set_person_default(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default? value)
    {
      this.person_default = value;
    }
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default? Get_item_default()
    {
      return this.item_default;
    }
    public void Set_item_default(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default? value)
    {
      this.item_default = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>? Get_property_threshold()
    {
      return this.property_threshold;
    }
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold> GetOrInsertDefault_property_threshold()
    {
      if(this.property_threshold == null) {
        this.property_threshold = new List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>();
      }
      return this.property_threshold;
    }
    public void Set_property_threshold(List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>? value)
    {
      this.property_threshold = value;
    }
  }
}