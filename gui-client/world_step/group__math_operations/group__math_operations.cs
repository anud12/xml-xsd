using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ngroup__math_operations {}
namespace XSD {
}
namespace XSD {
  public class group__math_operations  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public group__operation__and operation = new group__operation__and();
    public group__math_operations()
    {
    }

    public group__math_operations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public group__math_operations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing group__math_operations");
      //Deserialize arguments

      //Deserialize children
      this.operation = rawNode.InitializeWithRawNode("operation", this.operation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(operation != null) {
        rawNode.children["operation"] = new List<RawNode> { operation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing group__math_operations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public group__operation__and Get_operation()
    {
      return this.operation;
    }
    public void Set_operation(group__operation__and value)
    {
      this.operation = value;
    }
  }
}