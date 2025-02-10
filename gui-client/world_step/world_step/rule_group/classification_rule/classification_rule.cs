using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nclassification_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class classification_rule  {

    public static string ClassTypeId = "/world_step/rule_group/classification_rule";
    public static string TagName = "classification_rule";

    public string Tag = "classification_rule";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nclassification_rule.entry> _entry = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>();
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry> entry {
      get { return _entry.Values.ToList(); }
      set
      {
        _entry = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public classification_rule()
    {
    }

    public classification_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public classification_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing classification_rule");
      //Deserialize arguments

      //Deserialize children
      this._entry = rawNode.InitializeWithRawNode("entry", this._entry);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["entry"] = _entry?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing classification_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>? Get_entry()
    {
      return this._entry?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry> GetOrInsertDefault_entry()
    {
      if(this._entry == null) {

        // false2
        this._entry = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_entry();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_entry(List<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry>? value)
    {
      this._entry = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nclassification_rule.entry.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nclassification_rule.entry.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._entry.ContainsKey(indexString.ToInt()))
        {
          this._entry[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nclassification_rule.entry();
        newEntry.SetXPath(xpath, rawNode);
        this._entry.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}