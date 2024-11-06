using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Nlocation_mutation {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person {
  public class location_mutation  {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/
    public System.String on;

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Nlocation_mutation.from> from = new List<XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Nlocation_mutation.from>();
    public location_mutation()
    {
    }

    public location_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_mutation");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("on"))
      {
        var attribute_on = rawNode.attributes["on"];
        this.on = rawNode.attributes["on"];
      }

      //Deserialize children
      this.from = rawNode.InitializeWithRawNode("from", this.from);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.on != null)
      {
        rawNode.attributes["on"] = this.on.ToString();
      }

      //Serialize children
      rawNode.children["from"] = from.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    /* ignored attribute key={key} of type=System.Object*/
    public System.String Get_on()
    {
      return this.on;
    }
    public void Set_on(System.String value)
    {
      this.on = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Nlocation_mutation.from> Get_from()
    {
      return this.from;
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Nlocation_mutation.from> GetOrInsertDefault_from()
    {
      if(this.from == null) {
        this.from = new List<XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Nlocation_mutation.from>();
      }
      return this.from;
    }
    public void Set_from(List<XSD.Nworld_step.Nrule_group.Naction_rule.Nperson_to_person.Nlocation_mutation.from> value)
    {
      this.from = value;
    }
  }
}