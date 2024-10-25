using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntest.Nlevel1 {}
namespace XSD {
}
namespace XSD.Ntest {
  public class level1  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    /* ignored children key:level2 of type:boolean*/
    /* ignored children key:anotherLevel2 of type:string*/
    public level1()
    {
    }

    public level1(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public level1(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing level1");
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
        // Godot.GD.Print("Serializing level1");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    /* ignored children key:level2 of type:boolean*/
    /* ignored children key:anotherLevel2 of type:string*/
  }
}