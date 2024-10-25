using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class data  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Nworld_step.Ndata.people? people = null;
    public XSD.Nworld_step.Ndata.location? location = null;
    public data()
    {
    }

    public data(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public data(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing data");
      //Deserialize arguments

      //Deserialize children
      this.people = rawNode.InitializeWithRawNode("people", this.people);
      this.location = rawNode.InitializeWithRawNode("location", this.location);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      if(location != null) {
        rawNode.children["location"] = new List<RawNode> { location.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing data");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Ndata.people? Get_people()
    {
      return this.people;
    }
    public XSD.Nworld_step.Ndata.people GetOrInsertDefault_people()
    {
      if(this.people == null) {
        this.people = new XSD.Nworld_step.Ndata.people();
      }
      return this.people;
    }
    public void Set_people(XSD.Nworld_step.Ndata.people? value)
    {
      this.people = value;
    }
    public XSD.Nworld_step.Ndata.location? Get_location()
    {
      return this.location;
    }
    public XSD.Nworld_step.Ndata.location GetOrInsertDefault_location()
    {
      if(this.location == null) {
        this.location = new XSD.Nworld_step.Ndata.location();
      }
      return this.location;
    }
    public void Set_location(XSD.Nworld_step.Ndata.location? value)
    {
      this.location = value;
    }
  }
}