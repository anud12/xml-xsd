using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule {
  public class entry  {

    public static string ClassTypeId = "/world_step/rule_group/events_rule/entry";
    public static string TagName = "entry";

    public string Tag = "entry";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;

    //Children elements

    private Dictionary<int, type__trigger> _when = new Dictionary<int, type__trigger>();
    public List<type__trigger> when {
      get { return _when.Values.ToList(); }
      set
      {
        _when = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }

    private Dictionary<int, XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> _then = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then>();
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> then {
      get { return _then.Values.ToList(); }
      set
      {
        _then = value
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
      this._when = rawNode.InitializeWithRawNode("when", this._when);
      this._then = rawNode.InitializeWithRawNode("then", this._then);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      rawNode.children["when"] = _when?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      rawNode.children["then"] = _then?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
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
    public List<type__trigger> Get_when()
    {
      return this.when;
    }
    public void Set_when(List<type__trigger> value)
    {
      this.when = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> Get_then()
    {
      return this._then?.Values.ToList();
    }
    public List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> GetOrInsertDefault_then()
    {
      if(this._then == null) {

        // false2
        this._then = new Dictionary<int, XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_then();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_then(List<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> value)
    {
      this._then = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__trigger.TagName + "["))
      {
        var startIndex = (type__trigger.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._when.ContainsKey(indexString.ToInt()))
        {
          this._when[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new type__trigger();
        newEntry.SetXPath(xpath, rawNode);
        this._when.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._then.ContainsKey(indexString.ToInt()))
        {
          this._then[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then();
        newEntry.SetXPath(xpath, rawNode);
        this._then.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}