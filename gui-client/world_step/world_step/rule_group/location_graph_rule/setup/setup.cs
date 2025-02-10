using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {
  public class setup  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule/setup";
    public static string TagName = "setup";

    public string Tag = "setup";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node _starting_node = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node();
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node starting_node {
      get { return _starting_node; }
      set { _starting_node = value; }
    }

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node> _necessary_node = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>();
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node> necessary_node {
      get { return _necessary_node.Values.ToList(); }
      set
      {
        _necessary_node = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public setup()
    {
    }

    public setup(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public setup(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing setup");
      //Deserialize arguments

      //Deserialize children
      this._starting_node = rawNode.InitializeWithRawNode("starting_node", this._starting_node);
      this._necessary_node = rawNode.InitializeWithRawNode("necessary_node", this._necessary_node);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(starting_node != null) {
        rawNode.children["starting_node"] = new List<RawNode> { starting_node.SerializeIntoRawNode() };
      }
      rawNode.children["necessary_node"] = _necessary_node?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing setup");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node Get_starting_node()
    {
      return this._starting_node;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node GetOrInsertDefault_starting_node()
    {
      if(this._starting_node == null) {

        // true2
        this._starting_node = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_starting_node();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_starting_node(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node value)
    {
        this._starting_node = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>? Get_necessary_node()
    {
      return this._necessary_node?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node> GetOrInsertDefault_necessary_node()
    {
      if(this._necessary_node == null) {

        // false2
        this._necessary_node = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_necessary_node();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_necessary_node(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>? value)
    {
      this._necessary_node = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node.TagName.Length + 3);
        this.starting_node.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._necessary_node.ContainsKey(indexString.ToInt()))
        {
          this._necessary_node[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node();
        newEntry.SetXPath(xpath, rawNode);
        this._necessary_node.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}