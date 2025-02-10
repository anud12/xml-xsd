using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule {
  public class from_person  {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/from_person";
    public static string TagName = "from_person";

    public string Tag = "from_person";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;

    //Children elements
    private type__person_selection? _selection = null;
    public type__person_selection? selection {
      get { return _selection; }
      set { _selection = value; }
    }

    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations? _mutations = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations? mutations {
      get { return _mutations; }
      set { _mutations = value; }
    }

    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person? _on_person = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person? on_person {
      get { return _on_person; }
      set { _on_person = value; }
    }
    public from_person()
    {
    }

    public from_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this._selection = rawNode.InitializeWithRawNode("selection", this._selection);
      this._mutations = rawNode.InitializeWithRawNode("mutations", this._mutations);
      this._on_person = rawNode.InitializeWithRawNode("on_person", this._on_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(selection != null) {
        rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
      }
      if(mutations != null) {
        rawNode.children["mutations"] = new List<RawNode> { mutations.SerializeIntoRawNode() };
      }
      if(on_person != null) {
        rawNode.children["on_person"] = new List<RawNode> { on_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from_person");
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
    public type__person_selection? Get_selection()
    {
      return this.selection;
    }
    public void Set_selection(type__person_selection? value)
    {
      this.selection = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations? Get_mutations()
    {
      return this._mutations;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations GetOrInsertDefault_mutations()
    {
      if(this._mutations == null) {

        // true2
        this._mutations = new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_mutations();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_mutations(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations? value)
    {
        this._mutations = value;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person? Get_on_person()
    {
      return this._on_person;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person GetOrInsertDefault_on_person()
    {
      if(this._on_person == null) {

        // true2
        this._on_person = new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_on_person();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_on_person(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person? value)
    {
        this._on_person = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__person_selection.TagName))
      {
        this.selection ??= new type__person_selection();
        xpath = xpath.Substring(type__person_selection.TagName.Length + 3);
        this.selection.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations.TagName))
      {
        this.mutations ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations.TagName.Length + 3);
        this.mutations.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person.TagName))
      {
        this.on_person ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person.TagName.Length + 3);
        this.on_person.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}