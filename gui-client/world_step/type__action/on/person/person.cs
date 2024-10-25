using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__action.Non.Nperson {}
namespace XSD {
}
namespace XSD.Ntype__action.Non {
  public class person  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type__person_selection? select = null;
    public type__property_mutation? property_mutation = null;
    public person()
    {
    }

    public person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments

      //Deserialize children
      this.select = rawNode.InitializeWithRawNode("select", this.select);
      this.property_mutation = rawNode.InitializeWithRawNode("property_mutation", this.property_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(select != null) {
        rawNode.children["select"] = new List<RawNode> { select.SerializeIntoRawNode() };
      }
      if(property_mutation != null) {
        rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public type__person_selection? Get_select()
    {
      return this.select;
    }
    public void Set_select(type__person_selection? value)
    {
      this.select = value;
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