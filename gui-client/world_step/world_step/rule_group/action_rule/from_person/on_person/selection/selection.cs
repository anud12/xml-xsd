using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection {}
namespace XSD {
  public interface Itype__person_selection {

    //Children elements
    public type__math_operations? Get_radius();
    public void Set_radius(type__math_operations? value);
    public type__math_operations? Get_min();
    public void Set_min(type__math_operations? value);
    public type__math_operations? Get_max();
    public void Set_max(type__math_operations? value);
    public List<XSD.Ntype__person_selection.property> Get_property();
    public void Set_property(List<XSD.Ntype__person_selection.property> value);
    public List<XSD.Ntype__person_selection.classification> Get_classification();
    public void Set_classification(List<XSD.Ntype__person_selection.classification> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person {
  public class selection : Itype__person_selection {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/from_person/on_person/selection";
    public static string TagName = "selection";

    public string Tag = "selection";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Attributes of type__person_selection

    //Children elements
    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? _from_person_same_location_graph_node = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? from_person_same_location_graph_node {
      get { return _from_person_same_location_graph_node; }
      set { _from_person_same_location_graph_node = value; }
    }

    //Children of type__person_selection
    private type__math_operations? _radius = null;
    public type__math_operations? radius {
      get { return _radius; }
      set { _radius = value; }
    }

    private type__math_operations? _min = null;
    public type__math_operations? min {
      get { return _min; }
      set { _min = value; }
    }

    private type__math_operations? _max = null;
    public type__math_operations? max {
      get { return _max; }
      set { _max = value; }
    }

    private Dictionary<int, XSD.Ntype__person_selection.property> _property = new Dictionary<int, XSD.Ntype__person_selection.property>();
    public List<XSD.Ntype__person_selection.property> property {
      get { return _property.Values.ToList(); }
      set
      {
        _property = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Ntype__person_selection.classification> _classification = new Dictionary<int, XSD.Ntype__person_selection.classification>();
    public List<XSD.Ntype__person_selection.classification> classification {
      get { return _classification.Values.ToList(); }
      set
      {
        _classification = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public selection()
    {
    }

    public selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing selection");
      //Deserialize arguments

      // Deserialize arguments of type__person_selection


      //Deserialize children
      this._from_person_same_location_graph_node = rawNode.InitializeWithRawNode("from_person_same_location_graph_node", this._from_person_same_location_graph_node);

      // Deserialize children of type__person_selection
  this._radius = rawNode.InitializeWithRawNode("radius", this._radius);
  this._min = rawNode.InitializeWithRawNode("min", this._min);
  this._max = rawNode.InitializeWithRawNode("max", this._max);
  this._property = rawNode.InitializeWithRawNode("property", this._property);
  this._classification = rawNode.InitializeWithRawNode("classification", this._classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__person_selection


      //Serialize children
      if(from_person_same_location_graph_node != null) {
        rawNode.children["from_person_same_location_graph_node"] = new List<RawNode> { from_person_same_location_graph_node.SerializeIntoRawNode() };
      }

      // Serialize children of type__person_selection
  if(radius != null) {
    rawNode.children["radius"] = new List<RawNode> { radius.SerializeIntoRawNode() };
  }
  if(min != null) {
    rawNode.children["min"] = new List<RawNode> { min.SerializeIntoRawNode() };
  }
  if(max != null) {
    rawNode.children["max"] = new List<RawNode> { max.SerializeIntoRawNode() };
  }
  rawNode.children["property"] = _property?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
  rawNode.children["classification"] = _classification?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? Get_from_person_same_location_graph_node()
    {
      return this._from_person_same_location_graph_node;
    }
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node GetOrInsertDefault_from_person_same_location_graph_node()
    {
      if(this._from_person_same_location_graph_node == null) {

        // true2
        this._from_person_same_location_graph_node = new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_from_person_same_location_graph_node();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_from_person_same_location_graph_node(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node? value)
    {
        this._from_person_same_location_graph_node = value;
    }
    public type__math_operations? Get_radius()
    {
      return this.radius;
    }
    public void Set_radius(type__math_operations? value)
    {
      this.radius = value;
    }
    public type__math_operations? Get_min()
    {
      return this.min;
    }
    public void Set_min(type__math_operations? value)
    {
      this.min = value;
    }
    public type__math_operations? Get_max()
    {
      return this.max;
    }
    public void Set_max(type__math_operations? value)
    {
      this.max = value;
    }
    public List<XSD.Ntype__person_selection.property>? Get_property()
    {
      return this._property?.Values.ToList();
    }
    public List<XSD.Ntype__person_selection.property> GetOrInsertDefault_property()
    {
      if(this._property == null) {

        // false2
        this._property = new Dictionary<int, XSD.Ntype__person_selection.property>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_property();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_property(List<XSD.Ntype__person_selection.property>? value)
    {
      this._property = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public List<XSD.Ntype__person_selection.classification>? Get_classification()
    {
      return this._classification?.Values.ToList();
    }
    public List<XSD.Ntype__person_selection.classification> GetOrInsertDefault_classification()
    {
      if(this._classification == null) {

        // false2
        this._classification = new Dictionary<int, XSD.Ntype__person_selection.classification>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_classification();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_classification(List<XSD.Ntype__person_selection.classification>? value)
    {
      this._classification = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }


    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node.TagName))
      {
        this.from_person_same_location_graph_node ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.Nselection.from_person_same_location_graph_node.TagName.Length + 3);
        this.from_person_same_location_graph_node.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}