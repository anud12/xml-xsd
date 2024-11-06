using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Ntest.Nexpected {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Ntest {
  public class expected  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String target;

    //Children elements
    public type__math_operations operation = new type__math_operations();
    public expected()
    {
    }

    public expected(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public expected(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing expected");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("target"))
      {
        var attribute_target = rawNode.attributes["target"];
        this.target = rawNode.attributes["target"];
      }

      //Deserialize children
      this.operation = rawNode.InitializeWithRawNode("operation", this.operation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.target != null)
      {
        rawNode.attributes["target"] = this.target.ToString();
      }

      //Serialize children
      if(operation != null) {
        rawNode.children["operation"] = new List<RawNode> { operation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing expected");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_target()
    {
      return this.target;
    }
    public void Set_target(System.String value)
    {
      this.target = value;
    }
    public type__math_operations Get_operation()
    {
      return this.operation;
    }
    public void Set_operation(type__math_operations value)
    {
      this.operation = value;
    }
  }
}