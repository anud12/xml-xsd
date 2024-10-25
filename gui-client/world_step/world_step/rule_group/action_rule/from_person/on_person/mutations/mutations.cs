using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nmutations {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person {
  public class mutations  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type__property_mutation? property_mutation = null;
    public mutations()
    {
    }

    public mutations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public mutations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing mutations");
      //Deserialize arguments

      //Deserialize children
      this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(property_mutation != null) {
        rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing mutations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public type__property_mutation? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(type__property_mutation? value)
    {
      this.property_mutation = value;
    }
  }
}