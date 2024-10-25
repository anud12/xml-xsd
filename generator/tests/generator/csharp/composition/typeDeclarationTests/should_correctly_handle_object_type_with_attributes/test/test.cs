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
    public System.String attr;

    //Children elements
    /* ignored children key:prop of type:string*/
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
      if(rawNode.attributes.ContainsKey("attr"))
      {
        var attribute_attr = rawNode.attributes["attr"];
        this.attr = rawNode.attributes["attr"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.attr != null)
      {
        rawNode.attributes["attr"] = this.attr.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing test");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_attr()
    {
      return this.attr;
    }
    public void Set_attr(System.String value)
    {
      this.attr = value;
    }
    /* ignored children key:prop of type:string*/
  }
}