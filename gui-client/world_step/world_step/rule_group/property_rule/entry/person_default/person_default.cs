using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.Nperson_default {}
namespace XSD {
  public interface Itype__math_operations {
    //Attributes
    public System.Int32 Get_initial();
    public void Set_initial(System.Int32 value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }
}
namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry {
  public class person_default : Itype__math_operations {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Attributes of type__math_operations
    public System.Int32 initial;

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
  if(rawNode.attributes.ContainsKey("initial"))
  {
    var attribute_initial = rawNode.attributes["initial"];
    this.initial = attribute_initial.ToInt();
  }

      //Deserialize children

      // Deserialize children of type__math_operations

    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__math_operations
  if(this.initial != null)
  {
    rawNode.attributes["initial"] = this.initial.ToString();
  }

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
    public System.Int32 Get_initial()
    {
      return this.initial;
    }
    public void Set_initial(System.Int32 value)
    {
      this.initial = value;
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
      "value": {}
    },
    "name": "person_default"
  }
*/