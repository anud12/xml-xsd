using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {
  public class link_group_list  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule/node_rule/link_group_list";
    public static string TagName = "link_group_list";

    public string Tag = "link_group_list";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference> _reference = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>();
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference> reference {
      get { return _reference.Values.ToList(); }
      set
      {
        _reference = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group> _link_group = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group>();
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group> link_group {
      get { return _link_group.Values.ToList(); }
      set
      {
        _link_group = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public link_group_list()
    {
    }

    public link_group_list(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_group_list(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group_list");
      //Deserialize arguments

      //Deserialize children
      this._reference = rawNode.InitializeWithRawNode("reference", this._reference);
      this._link_group = rawNode.InitializeWithRawNode("link_group", this._link_group);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["reference"] = _reference?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      rawNode.children["link_group"] = _link_group?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_group_list");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>? Get_reference()
    {
      return this._reference?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference> GetOrInsertDefault_reference()
    {
      if(this._reference == null) {

        // false2
        this._reference = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_reference();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_reference(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference>? value)
    {
      this._reference = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group>? Get_link_group()
    {
      return this.link_group;
    }
    public void Set_link_group(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group>? value)
    {
      this.link_group = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._reference.ContainsKey(indexString.ToInt()))
        {
          this._reference[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference();
        newEntry.SetXPath(xpath, rawNode);
        this._reference.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._link_group.ContainsKey(indexString.ToInt()))
        {
          this._link_group[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group();
        newEntry.SetXPath(xpath, rawNode);
        this._link_group.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}