using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.Nitem_default {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry {
  public class item_default : Itype__math_operations {

    public static string ClassTypeId = "/world_step/rule_group/property_rule/entry/item_default";
    public static string TagName = "item_default";

    public string Tag = "item_default";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Attributes of type__math_operations

    //Children elements

    //Children of type__math_operations

    public item_default()
    {
    }

    public item_default(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public item_default(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing item_default");
      //Deserialize arguments

      // Deserialize arguments of type__math_operations

      //Deserialize children

      // Deserialize children of type__math_operations

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__math_operations


      //Serialize children

      // Serialize children of type__math_operations

      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing item_default");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}