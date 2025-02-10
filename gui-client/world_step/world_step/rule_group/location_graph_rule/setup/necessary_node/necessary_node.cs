using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup {
  public class necessary_node  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule/setup/necessary_node";
    public static string TagName = "necessary_node";

    public string Tag = "necessary_node";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.String _node_rule_ref;
    public System.Int32 min;
    public System.Int32 _min;
    public System.Int32? max;
    public System.Int32? _max;

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or> _or = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>();
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or> or {
      get { return _or.Values.ToList(); }
      set
      {
        _or = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public necessary_node()
    {
    }

    public necessary_node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public necessary_node(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing necessary_node");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("min"))
      {
        var attribute_min = rawNode.attributes["min"];
        this.min = attribute_min.ToInt();
      }
      if(rawNode.attributes.ContainsKey("max"))
      {
        var attribute_max = rawNode.attributes["max"];
        this.max = attribute_max?.ToInt();
      }

      //Deserialize children
      this._or = rawNode.InitializeWithRawNode("or", this._or);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
      }
      if(this.min != null)
      {
        rawNode.attributes["min"] = this.min.ToString();
      }
      if(this.max != null)
      {
        rawNode.attributes["max"] = this.max?.ToString();
      }

      //Serialize children
      rawNode.children["or"] = _or?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing necessary_node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.Int32 Get_min()
    {
      return this.min;
    }
    public void Set_min(System.Int32 value)
    {
      this.min = value;
    }
    public System.Int32? Get_max()
    {
      return this.max;
    }
    public void Set_max(System.Int32? value)
    {
      this.max = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>? Get_or()
    {
      return this._or?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or> GetOrInsertDefault_or()
    {
      if(this._or == null) {

        // false2
        this._or = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_or();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_or(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>? value)
    {
      this._or = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._or.ContainsKey(indexString.ToInt()))
        {
          this._or[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or();
        newEntry.SetXPath(xpath, rawNode);
        this._or.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}