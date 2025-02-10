using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation {
  public class location_graph  {

    public static string ClassTypeId = "/world_step/data/location/location_graph";
    public static string TagName = "location_graph";

    public string Tag = "location_graph";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;

    //Children elements
    private XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule _rule = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule();
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule rule {
      get { return _rule; }
      set { _rule = value; }
    }

    private Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> _node = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node>();
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> node {
      get { return _node.Values.ToList(); }
      set
      {
        _node = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public location_graph()
    {
    }

    public location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      this._rule = rawNode.InitializeWithRawNode("rule", this._rule);
      this._node = rawNode.InitializeWithRawNode("node", this._node);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(rule != null) {
        rawNode.children["rule"] = new List<RawNode> { rule.SerializeIntoRawNode() };
      }
      rawNode.children["node"] = _node?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph");
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
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule Get_rule()
    {
      return this._rule;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule GetOrInsertDefault_rule()
    {
      if(this._rule == null) {

        // true2
        this._rule = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_rule(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule value)
    {
        this._rule = value;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> Get_node()
    {
      return this._node?.Values.ToList();
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> GetOrInsertDefault_node()
    {
      if(this._node == null) {

        // false2
        this._node = new Dictionary<int, XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_node();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_node(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node> value)
    {
      this._node = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.rule.TagName.Length + 3);
        this.rule.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._node.ContainsKey(indexString.ToInt()))
        {
          this._node[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.node();
        newEntry.SetXPath(xpath, rawNode);
        this._node.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}