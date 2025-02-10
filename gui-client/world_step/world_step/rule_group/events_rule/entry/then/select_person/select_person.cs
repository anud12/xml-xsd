using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.Nselect_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen {
  public class select_person : Itype__person_selection {

    public static string ClassTypeId = "/world_step/rule_group/events_rule/entry/then/select_person";
    public static string TagName = "select_person";

    public string Tag = "select_person";
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=origin*/

    //Attributes of type__person_selection

    //Children elements

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
    public select_person()
    {
    }

    public select_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public select_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing select_person");
      //Deserialize arguments

      // Deserialize arguments of type__person_selection

      //Deserialize children

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
        // Godot.GD.Print("Serializing select_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    /* ignored attribute key={key} of type=origin*/
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

      Deserialize(rawNode);
    }
  }
}