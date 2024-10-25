using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntest {}
namespace XSD {
}
namespace XSD {
  public class test  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
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
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing test");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
  }
}