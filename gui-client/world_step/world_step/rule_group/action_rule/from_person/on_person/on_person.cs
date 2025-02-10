using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person {
  public class on_person  {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/from_person/on_person";
    public static string TagName = "on_person";

    public string Tag = "on_person";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection? _selection = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection? selection {
      get { return _selection; }
      set { _selection = value; }
    }

    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations? _mutations = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations? mutations {
      get { return _mutations; }
      set { _mutations = value; }
    }
    public on_person()
    {
    }

    public on_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public on_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on_person");
      //Deserialize arguments

      //Deserialize children
      this._selection = rawNode.InitializeWithRawNode("selection", this._selection);
      this._mutations = rawNode.InitializeWithRawNode("mutations", this._mutations);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(selection != null) {
        rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
      }
      if(mutations != null) {
        rawNode.children["mutations"] = new List<RawNode> { mutations.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing on_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection? Get_selection()
    {
      return this.selection;
    }
    public void Set_selection(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection? value)
    {
      this.selection = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations? Get_mutations()
    {
      return this._mutations;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations GetOrInsertDefault_mutations()
    {
      if(this._mutations == null) {

        // true2
        this._mutations = new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_mutations();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_mutations(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations? value)
    {
        this._mutations = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection.TagName))
      {
        this.selection ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection.TagName.Length + 3);
        this.selection.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations.TagName))
      {
        this.mutations ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations.TagName.Length + 3);
        this.mutations.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}