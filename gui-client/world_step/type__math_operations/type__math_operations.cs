using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__math_operations {}
namespace XSD {
}
namespace XSD {
  public class type__math_operations  {

    public static string ClassTypeId = "/type__math_operations";
    public static string TagName = "type__math_operations";

    public string Tag = "type__math_operations";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type__math_operations()
    {
    }

    public type__math_operations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__math_operations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__math_operations");
      //Deserialize arguments

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__math_operations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}