using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nclassification_rule {
  public class entry  {

    public static string ClassTypeId = "/world_step/rule_group/classification_rule/entry";
    public static string TagName = "entry";

    public string Tag = "entry";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property> _property = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>();
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property> property {
      get { return _property.Values.ToList(); }
      set
      {
        _property = value
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

      //Deserialize children
      this._property = rawNode.InitializeWithRawNode("property", this._property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      rawNode.children["property"] = _property?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
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
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>? Get_property()
    {
      return this._property?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property> GetOrInsertDefault_property()
    {
      if(this._property == null) {

        // false2
        this._property = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_property();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_property(List<XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property>? value)
    {
      this._property = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._property.ContainsKey(indexString.ToInt()))
        {
          this._property[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nclassification_rule.Nentry.property();
        newEntry.SetXPath(xpath, rawNode);
        this._property.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}