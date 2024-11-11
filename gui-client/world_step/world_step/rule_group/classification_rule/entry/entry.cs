using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nclassification_rule {
  public class entry  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>? property = new List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>();
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

      //Deserialize children
      this.property = rawNode.InitializeWithRawNode("property", this.property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
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
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>? Get_property()
    {
      return this.property;
    }
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property> GetOrInsertDefault_property()
    {
      if(this.property == null) {
        this.property = new List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>();
      }
      return this.property;
    }
    public void Set_property(List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>? value)
    {
      this.property = value;
    }
  }
}