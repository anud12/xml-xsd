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
    public List<XSD.Ntest.level1> level1 = new List<XSD.Ntest.level1>();
    /* ignored children key:anotherLevel1 of type:number*/
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
      this.level1 = rawNode.InitializeWithRawNode("level1", this.level1);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["level1"] = level1.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing test");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Ntest.level1> Get_level1()
    {
      return this.level1;
    }
    public List<XSD.Ntest.level1> GetOrInsertDefault_level1()
    {
      if(this.level1 == null) {
        this.level1 = new List<XSD.Ntest.level1>();
      }
      return this.level1;
    }
    public void Set_level1(List<XSD.Ntest.level1> value)
    {
      this.level1 = value;
    }
    /* ignored children key:anotherLevel1 of type:number*/
  }
}