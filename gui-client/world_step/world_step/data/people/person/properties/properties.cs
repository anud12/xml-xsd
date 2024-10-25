using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople.Nperson {
  public class properties  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>? property = new List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>();
    public properties()
    {
    }

    public properties(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public properties(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing properties");
      //Deserialize arguments

      //Deserialize children
      this.property = rawNode.InitializeWithRawNode("property", this.property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["property"] = property.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing properties");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>? Get_property()
    {
      return this.property;
    }
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property> GetOrInsertDefault_property()
    {
      if(this.property == null) {
        this.property = new List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>();
      }
      return this.property;
    }
    public void Set_property(List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>? value)
    {
      this.property = value;
    }
  }
}