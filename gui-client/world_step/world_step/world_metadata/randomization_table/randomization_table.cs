using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nworld_metadata.Nrandomization_table {}
namespace XSD {
}
namespace XSD.Nworld_step.Nworld_metadata {
  public class randomization_table  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry> entry = new List<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry>();
    public randomization_table()
    {
    }

    public randomization_table(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public randomization_table(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing randomization_table");
      //Deserialize arguments

      //Deserialize children
      this.entry = rawNode.InitializeWithRawNode("entry", this.entry);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing randomization_table");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry> Get_entry()
    {
      return this.entry;
    }
    public List<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry> GetOrInsertDefault_entry()
    {
      if(this.entry == null) {
        this.entry = new List<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry>();
      }
      return this.entry;
    }
    public void Set_entry(List<XSD.Nworld_step.Nworld_metadata.Nrandomization_table.entry> value)
    {
      this.entry = value;
    }
  }
}