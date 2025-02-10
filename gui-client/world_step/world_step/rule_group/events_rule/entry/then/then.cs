using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry {
  public class then  {

    public static string ClassTypeId = "/world_step/rule_group/events_rule/entry/then";
    public static string TagName = "then";

    public string Tag = "then";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person> _select_person = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person>();
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person> select_person {
      get { return _select_person.Values.ToList(); }
      set
      {
        _select_person = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    private XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation? _property_mutation = null;
    public XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation? property_mutation {
      get { return _property_mutation; }
      set { _property_mutation = value; }
    }
    public then()
    {
    }

    public then(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public then(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing then");
      //Deserialize arguments

      //Deserialize children
      this._select_person = rawNode.InitializeWithRawNode("select_person", this._select_person);
      this._property_mutation = rawNode.InitializeWithRawNode("property_mutation", this._property_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["select_person"] = _select_person?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      if(property_mutation != null) {
        rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing then");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person>? Get_select_person()
    {
      return this.select_person;
    }
    public void Set_select_person(List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person>? value)
    {
      this.select_person = value;
    }
    public XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation? value)
    {
      this.property_mutation = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._select_person.ContainsKey(indexString.ToInt()))
        {
          this._select_person[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person();
        newEntry.SetXPath(xpath, rawNode);
        this._select_person.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation.TagName))
      {
        this.property_mutation ??= new XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation.TagName.Length + 3);
        this.property_mutation.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}