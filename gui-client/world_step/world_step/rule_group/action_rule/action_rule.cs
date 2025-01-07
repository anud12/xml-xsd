using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class action_rule  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>? from_person = new List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>();
    public XSD.Nworld_step.Nrule_group.Naction_rule.global? global = null;
    public action_rule()
    {
    }

    public action_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public action_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing action_rule");
      //Deserialize arguments

      //Deserialize children
      this.from_person = rawNode.InitializeWithRawNode("from_person", this.from_person);
      this.global = rawNode.InitializeWithRawNode("global", this.global);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["from_person"] = from_person.Select(x => x.SerializeIntoRawNode()).ToList();
      if(global != null) {
        rawNode.children["global"] = new List<RawNode> { global.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing action_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>? Get_from_person()
    {
      return this.from_person;
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person> GetOrInsertDefault_from_person()
    {
      if(this.from_person == null) {
        this.from_person = new List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>();
      }
      return this.from_person;
    }
    public void Set_from_person(List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>? value)
    {
      this.from_person = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.global? Get_global()
    {
      return this.global;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.global GetOrInsertDefault_global()
    {
      if(this.global == null) {
        this.global = new XSD.Nworld_step.Nrule_group.Naction_rule.global();
      }
      return this.global;
    }
    public void Set_global(XSD.Nworld_step.Nrule_group.Naction_rule.global? value)
    {
      this.global = value;
    }
  }
}