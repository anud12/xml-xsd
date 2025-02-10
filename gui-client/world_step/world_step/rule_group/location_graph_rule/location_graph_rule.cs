using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class location_graph_rule  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule";
    public static string TagName = "location_graph_rule";

    public string Tag = "location_graph_rule";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup _setup = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup();
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup setup {
      get { return _setup; }
      set { _setup = value; }
    }

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule> _node_rule = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>();
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule> node_rule {
      get { return _node_rule.Values.ToList(); }
      set
      {
        _node_rule = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public location_graph_rule()
    {
    }

    public location_graph_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this._setup = rawNode.InitializeWithRawNode("setup", this._setup);
      this._node_rule = rawNode.InitializeWithRawNode("node_rule", this._node_rule);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(setup != null) {
        rawNode.children["setup"] = new List<RawNode> { setup.SerializeIntoRawNode() };
      }
      rawNode.children["node_rule"] = _node_rule?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph_rule");
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
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup Get_setup()
    {
      return this._setup;
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup GetOrInsertDefault_setup()
    {
      if(this._setup == null) {

        // true2
        this._setup = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_setup();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_setup(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup value)
    {
        this._setup = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>? Get_node_rule()
    {
      return this._node_rule?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule> GetOrInsertDefault_node_rule()
    {
      if(this._node_rule == null) {

        // false2
        this._node_rule = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_node_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_node_rule(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule>? value)
    {
      this._node_rule = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.setup.TagName.Length + 3);
        this.setup.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._node_rule.ContainsKey(indexString.ToInt()))
        {
          this._node_rule[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.node_rule();
        newEntry.SetXPath(xpath, rawNode);
        this._node_rule.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}