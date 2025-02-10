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

    public static string ClassTypeId = "/world_step/rule_group/action_rule";
    public static string TagName = "action_rule";

    public string Tag = "action_rule";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Naction_rule.from_person> _from_person = new Dictionary<int, XSD.Nworld_step.Nrule_group.Naction_rule.from_person>();
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person> from_person {
      get { return _from_person.Values.ToList(); }
      set
      {
        _from_person = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    private XSD.Nworld_step.Nrule_group.Naction_rule.global? _global = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.global? global {
      get { return _global; }
      set { _global = value; }
    }
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
      this._from_person = rawNode.InitializeWithRawNode("from_person", this._from_person);
      this._global = rawNode.InitializeWithRawNode("global", this._global);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["from_person"] = _from_person?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
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
      return this._from_person?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person> GetOrInsertDefault_from_person()
    {
      if(this._from_person == null) {

        // false2
        this._from_person = new Dictionary<int, XSD.Nworld_step.Nrule_group.Naction_rule.from_person>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_from_person();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_from_person(List<XSD.Nworld_step.Nrule_group.Naction_rule.from_person>? value)
    {
      this._from_person = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.global? Get_global()
    {
      return this._global;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.global GetOrInsertDefault_global()
    {
      if(this._global == null) {

        // true2
        this._global = new XSD.Nworld_step.Nrule_group.Naction_rule.global();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_global();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_global(XSD.Nworld_step.Nrule_group.Naction_rule.global? value)
    {
        this._global = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.from_person.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Naction_rule.from_person.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._from_person.ContainsKey(indexString.ToInt()))
        {
          this._from_person[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Naction_rule.from_person();
        newEntry.SetXPath(xpath, rawNode);
        this._from_person.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.global.TagName))
      {
        this.global ??= new XSD.Nworld_step.Nrule_group.Naction_rule.global();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.global.TagName.Length + 3);
        this.global.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}