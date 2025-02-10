using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__person_selection {}
namespace XSD {
}
namespace XSD {
  public class type__person_selection  {

    public static string ClassTypeId = "/type__person_selection";
    public static string TagName = "type__person_selection";

    public string Tag = "type__person_selection";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
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
    public type__person_selection()
    {
    }

    public type__person_selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__person_selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__person_selection");
      //Deserialize arguments

      //Deserialize children
      this._radius = rawNode.InitializeWithRawNode("radius", this._radius);
      this._min = rawNode.InitializeWithRawNode("min", this._min);
      this._max = rawNode.InitializeWithRawNode("max", this._max);
      this._property = rawNode.InitializeWithRawNode("property", this._property);
      this._classification = rawNode.InitializeWithRawNode("classification", this._classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
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
        // Godot.GD.Print("Serializing type__person_selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
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
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.radius ??= new type__math_operations();
        xpath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.radius.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.min ??= new type__math_operations();
        xpath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.min.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        this.max ??= new type__math_operations();
        xpath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.max.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__person_selection.property.TagName + "["))
      {
        var startIndex = (XSD.Ntype__person_selection.property.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._property.ContainsKey(indexString.ToInt()))
        {
          this._property[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Ntype__person_selection.property();
        newEntry.SetXPath(xpath, rawNode);
        this._property.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Ntype__person_selection.classification.TagName + "["))
      {
        var startIndex = (XSD.Ntype__person_selection.classification.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._classification.ContainsKey(indexString.ToInt()))
        {
          this._classification[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Ntype__person_selection.classification();
        newEntry.SetXPath(xpath, rawNode);
        this._classification.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}