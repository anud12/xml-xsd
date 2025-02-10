using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__property_mutation {}
namespace XSD {
}
namespace XSD {
  public class type__property_mutation  {

    public static string ClassTypeId = "/type__property_mutation";
    public static string TagName = "type__property_mutation";

    public string Tag = "type__property_mutation";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String property_rule_ref;
    public System.String _property_rule_ref;

    //Children elements

    private Dictionary<int, XSD.Ntype__property_mutation.from> _from = new Dictionary<int, XSD.Ntype__property_mutation.from>();
    public List<XSD.Ntype__property_mutation.from> from {
      get { return _from.Values.ToList(); }
      set
      {
        _from = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public type__property_mutation()
    {
    }

    public type__property_mutation(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__property_mutation(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__property_mutation");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("property_rule_ref"))
      {
        var attribute_property_rule_ref = rawNode.attributes["property_rule_ref"];
        this.property_rule_ref = rawNode.attributes["property_rule_ref"];
      }

      //Deserialize children
      this._from = rawNode.InitializeWithRawNode("from", this._from);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.property_rule_ref != null)
      {
        rawNode.attributes["property_rule_ref"] = this.property_rule_ref.ToString();
      }

      //Serialize children
      rawNode.children["from"] = _from?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__property_mutation");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_property_rule_ref()
    {
      return this.property_rule_ref;
    }
    public void Set_property_rule_ref(System.String value)
    {
      this.property_rule_ref = value;
    }
    public List<XSD.Ntype__property_mutation.from> Get_from()
    {
      return this._from?.Values.ToList();
    }
    public List<XSD.Ntype__property_mutation.from> GetOrInsertDefault_from()
    {
      if(this._from == null) {

        // false2
        this._from = new Dictionary<int, XSD.Ntype__property_mutation.from>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_from();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_from(List<XSD.Ntype__property_mutation.from> value)
    {
      this._from = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__property_mutation.from.TagName + "["))
      {
        var startIndex = (XSD.Ntype__property_mutation.from.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._from.ContainsKey(indexString.ToInt()))
        {
          this._from[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Ntype__property_mutation.from();
        newEntry.SetXPath(xpath, rawNode);
        this._from.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}