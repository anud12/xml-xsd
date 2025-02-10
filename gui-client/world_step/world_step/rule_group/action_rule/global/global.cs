using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule {
  public class global  {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/global";
    public static string TagName = "global";

    public string Tag = "global";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry> _entry = new Dictionary<int, XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry>();
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry> entry {
      get { return _entry.Values.ToList(); }
      set
      {
        _entry = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public global()
    {
    }

    public global(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public global(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing global");
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
        // Godot.GD.Print("Serializing global");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry>? Get_entry()
    {
      return this.entry;
    }
    public void Set_entry(List<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry>? value)
    {
      this.entry = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._entry.ContainsKey(indexString.ToInt()))
        {
          this._entry[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry();
        newEntry.SetXPath(xpath, rawNode);
        this._entry.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}