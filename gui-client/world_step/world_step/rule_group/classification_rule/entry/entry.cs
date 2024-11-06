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
    /* ignored attribute key={key} of type=System.Object*/

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

      //Deserialize children
      this.property = rawNode.InitializeWithRawNode("property", this.property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

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
    /* ignored attribute key={key} of type=System.Object*/
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