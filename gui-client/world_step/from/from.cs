using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nfrom {}
namespace XSD {
}
namespace XSD {
  public class from  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Nfrom.person? person = null;
    public from()
    {
    }

    public from(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from");
      //Deserialize arguments

      //Deserialize children
      this.person = rawNode.InitializeWithRawNode("person", this.person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(person != null) {
        rawNode.children["person"] = new List<RawNode> { person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nfrom.person? Get_person()
    {
      return this.person;
    }
    public XSD.Nfrom.person GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new XSD.Nfrom.person();
      }
      return this.person;
    }
    public void Set_person(XSD.Nfrom.person? value)
    {
      this.person = value;
    }
  }
}