using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nproperty_rule {
  public class entry  {

    public static string ClassTypeId = "/world_step/rule_group/property_rule/entry";
    public static string TagName = "entry";

    public string Tag = "entry";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;
    public System.String units;
    public System.String _units;

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default? _person_default = null;
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default? person_default {
      get { return _person_default; }
      set { _person_default = value; }
    }

    private XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default? _item_default = null;
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default? item_default {
      get { return _item_default; }
      set { _item_default = value; }
    }

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold> _property_threshold = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>();
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold> property_threshold {
      get { return _property_threshold.Values.ToList(); }
      set
      {
        _property_threshold = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("units"))
      {
        var attribute_units = rawNode.attributes["units"];
        this.units = rawNode.attributes["units"];
      }

      //Deserialize children
      this._person_default = rawNode.InitializeWithRawNode("person_default", this._person_default);
      this._item_default = rawNode.InitializeWithRawNode("item_default", this._item_default);
      this._property_threshold = rawNode.InitializeWithRawNode("property-threshold", this._property_threshold);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.units != null)
      {
        rawNode.attributes["units"] = this.units.ToString();
      }

      //Serialize children
      if(person_default != null) {
        rawNode.children["person_default"] = new List<RawNode> { person_default.SerializeIntoRawNode() };
      }
      if(item_default != null) {
        rawNode.children["item_default"] = new List<RawNode> { item_default.SerializeIntoRawNode() };
      }
      rawNode.children["property-threshold"] = _property_threshold?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
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
    public System.String Get_units()
    {
      return this.units;
    }
    public void Set_units(System.String value)
    {
      this.units = value;
    }
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default? Get_person_default()
    {
      return this.person_default;
    }
    public void Set_person_default(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default? value)
    {
      this.person_default = value;
    }
    public XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default? Get_item_default()
    {
      return this.item_default;
    }
    public void Set_item_default(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default? value)
    {
      this.item_default = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>? Get_property_threshold()
    {
      return this._property_threshold?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold> GetOrInsertDefault_property_threshold()
    {
      if(this._property_threshold == null) {

        // false2
        this._property_threshold = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_property_threshold();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_property_threshold(List<XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold>? value)
    {
      this._property_threshold = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default.TagName))
      {
        this.person_default ??= new XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.person_default.TagName.Length + 3);
        this.person_default.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default.TagName))
      {
        this.item_default ??= new XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.item_default.TagName.Length + 3);
        this.item_default.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._property_threshold.ContainsKey(indexString.ToInt()))
        {
          this._property_threshold[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nproperty_rule.Nentry.property_threshold();
        newEntry.SetXPath(xpath, rawNode);
        this._property_threshold.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}