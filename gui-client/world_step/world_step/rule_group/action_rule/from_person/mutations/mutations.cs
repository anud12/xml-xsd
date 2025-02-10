using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Nmutations {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person {
  public class mutations  {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/from_person/mutations";
    public static string TagName = "mutations";

    public string Tag = "mutations";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, type__property_mutation> _property_mutation = new Dictionary<int, type__property_mutation>();
    public List<type__property_mutation> property_mutation {
      get { return _property_mutation.Values.ToList(); }
      set
      {
        _property_mutation = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public mutations()
    {
    }

    public mutations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public mutations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing mutations");
      //Deserialize arguments

      //Deserialize children
      this._property_mutation = rawNode.InitializeWithRawNode("property_mutation", this._property_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["property_mutation"] = _property_mutation?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing mutations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<type__property_mutation>? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(List<type__property_mutation>? value)
    {
      this.property_mutation = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__property_mutation.TagName + "["))
      {
        var startIndex = (type__property_mutation.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._property_mutation.ContainsKey(indexString.ToInt()))
        {
          this._property_mutation[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new type__property_mutation();
        newEntry.SetXPath(xpath, rawNode);
        this._property_mutation.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}