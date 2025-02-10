using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople.Nperson {
  public class properties  {

    public static string ClassTypeId = "/world_step/data/people/person/properties";
    public static string TagName = "properties";

    public string Tag = "properties";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

    private Dictionary<int, XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property> _property = new Dictionary<int, XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>();
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property> property {
      get { return _property.Values.ToList(); }
      set
      {
        _property = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public properties()
    {
    }

    public properties(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public properties(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing properties");
      //Deserialize arguments

      //Deserialize children
      this._property = rawNode.InitializeWithRawNode("property", this._property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["property"] = _property?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing properties");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>? Get_property()
    {
      return this._property?.Values.ToList();
    }
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property> GetOrInsertDefault_property()
    {
      if(this._property == null) {

        // false2
        this._property = new Dictionary<int, XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_property();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_property(List<XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property>? value)
    {
      this._property = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._property.ContainsKey(indexString.ToInt()))
        {
          this._property[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Ndata.Npeople.Nperson.Nproperties.property();
        newEntry.SetXPath(xpath, rawNode);
        this._property.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}