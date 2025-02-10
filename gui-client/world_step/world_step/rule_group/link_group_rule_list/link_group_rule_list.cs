using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class link_group_rule_list  {

    public static string ClassTypeId = "/world_step/rule_group/link_group_rule_list";
    public static string TagName = "link_group_rule_list";

    public string Tag = "link_group_rule_list";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule> _link_group_rule = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>();
    public List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule> link_group_rule {
      get { return _link_group_rule.Values.ToList(); }
      set
      {
        _link_group_rule = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public link_group_rule_list()
    {
    }

    public link_group_rule_list(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_group_rule_list(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group_rule_list");
      //Deserialize arguments

      //Deserialize children
      this._link_group_rule = rawNode.InitializeWithRawNode("link_group_rule", this._link_group_rule);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["link_group_rule"] = _link_group_rule?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_group_rule_list");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>? Get_link_group_rule()
    {
      return this.link_group_rule;
    }
    public void Set_link_group_rule(List<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>? value)
    {
      this.link_group_rule = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._link_group_rule.ContainsKey(indexString.ToInt()))
        {
          this._link_group_rule[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule();
        newEntry.SetXPath(xpath, rawNode);
        this._link_group_rule.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}