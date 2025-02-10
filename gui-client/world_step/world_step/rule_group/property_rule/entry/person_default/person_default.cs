using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.Nperson_default {}
namespace XSD {
  public interface Itype__math_operations {
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }
}
namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry {
  public class person_default : Itype__math_operations {

    public static string ClassTypeId = "/world_step/rule_group/property_rule/entry/person_default";
    public static string TagName = "person_default";

    public string Tag = "person_default";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Attributes of type__math_operations

    //Children elements

    //Children of type__math_operations

    public person_default()
    {
    }

    public person_default(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person_default(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person_default");
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
        // Godot.GD.Print("Serializing person_default");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}