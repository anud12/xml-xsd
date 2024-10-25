using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Ntest {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person {
  public class test  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public group__math_operations value = new group__math_operations();
    public group__math_operations expected = new group__math_operations();
    public test()
    {
    }

    public test(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public test(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing test");
      //Deserialize arguments

      //Deserialize children
      this.value = rawNode.InitializeWithRawNode("value", this.value);
      this.expected = rawNode.InitializeWithRawNode("expected", this.expected);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(value != null) {
        rawNode.children["value"] = new List<RawNode> { value.SerializeIntoRawNode() };
      }
      if(expected != null) {
        rawNode.children["expected"] = new List<RawNode> { expected.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing test");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public group__math_operations Get_value()
    {
      return this.value;
    }
    public void Set_value(group__math_operations value)
    {
      this.value = value;
    }
    public group__math_operations Get_expected()
    {
      return this.expected;
    }
    public void Set_expected(group__math_operations value)
    {
      this.expected = value;
    }
  }
}