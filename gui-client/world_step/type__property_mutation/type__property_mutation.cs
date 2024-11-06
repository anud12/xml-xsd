using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__property_mutation {}
namespace XSD {
}
namespace XSD {
  public class type__property_mutation  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;

    //Children elements
    public List<XSD.Ntype__property_mutation.from> from = new List<XSD.Ntype__property_mutation.from>();
    public type__property_mutation()
    {
    }

    public type__property_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__property_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__property_mutation");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }

      //Deserialize children
      this.from = rawNode.InitializeWithRawNode("from", this.from);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }

      //Serialize children
      rawNode.children["from"] = from.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__property_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
    public List<XSD.Ntype__property_mutation.from> Get_from()
    {
      return this.from;
    }
    public List<XSD.Ntype__property_mutation.from> GetOrInsertDefault_from()
    {
      if(this.from == null) {
        this.from = new List<XSD.Ntype__property_mutation.from>();
      }
      return this.from;
    }
    public void Set_from(List<XSD.Ntype__property_mutation.from> value)
    {
      this.from = value;
    }
  }
}