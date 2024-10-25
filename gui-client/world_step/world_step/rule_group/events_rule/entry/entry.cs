using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule {
  public class entry  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Children elements
    public List<type__trigger> when = new List<type__trigger>();
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> then = new List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then>();
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this.when = rawNode.InitializeWithRawNode("when", this.when);
      this.then = rawNode.InitializeWithRawNode("then", this.then);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      rawNode.children["when"] = when.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["then"] = then.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
    }
    public List<type__trigger> Get_when()
    {
      return this.when;
    }
    public void Set_when(List<type__trigger> value)
    {
      this.when = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> Get_then()
    {
      return this.then;
    }
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> GetOrInsertDefault_then()
    {
      if(this.then == null) {
        this.then = new List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then>();
      }
      return this.then;
    }
    public void Set_then(List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> value)
    {
      this.then = value;
    }
  }
}