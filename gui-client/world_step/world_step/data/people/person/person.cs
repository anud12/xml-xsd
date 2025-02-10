using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople {
  public class person  {

    public static string ClassTypeId = "/world_step/data/people/person";
    public static string TagName = "person";

    public string Tag = "person";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;
    public System.String? name;
    public System.String? _name;

    //Children elements
    private XSD.Nworld_step.Ndata.Npeople.Nperson.properties? _properties = null;
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties? properties {
      get { return _properties; }
      set { _properties = value; }
    }

    private Dictionary<int, XSD.Nworld_step.Ndata.Npeople.Nperson.relations> _relations = new Dictionary<int, XSD.Nworld_step.Ndata.Npeople.Nperson.relations>();
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations> relations {
      get { return _relations.Values.ToList(); }
      set
      {
        _relations = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    private XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? _classifications = null;
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? classifications {
      get { return _classifications; }
      set { _classifications = value; }
    }
    public person()
    {
    }

    public person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }

      //Deserialize children
      this._properties = rawNode.InitializeWithRawNode("properties", this._properties);
      this._relations = rawNode.InitializeWithRawNode("relations", this._relations);
      this._classifications = rawNode.InitializeWithRawNode("classifications", this._classifications);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.name != null)
      {
        rawNode.attributes["name"] = this.name?.ToString();
      }

      //Serialize children
      if(properties != null) {
        rawNode.children["properties"] = new List<RawNode> { properties.SerializeIntoRawNode() };
      }
      rawNode.children["relations"] = _relations?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      if(classifications != null) {
        rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person");
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
    public System.String? Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String? value)
    {
      this.name = value;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties? Get_properties()
    {
      return this._properties;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.properties GetOrInsertDefault_properties()
    {
      if(this._properties == null) {

        // true2
        this._properties = new XSD.Nworld_step.Ndata.Npeople.Nperson.properties();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_properties();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_properties(XSD.Nworld_step.Ndata.Npeople.Nperson.properties? value)
    {
        this._properties = value;
    }
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations>? Get_relations()
    {
      return this._relations?.Values.ToList();
    }
    public List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations> GetOrInsertDefault_relations()
    {
      if(this._relations == null) {

        // false2
        this._relations = new Dictionary<int, XSD.Nworld_step.Ndata.Npeople.Nperson.relations>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_relations();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_relations(List<XSD.Nworld_step.Ndata.Npeople.Nperson.relations>? value)
    {
      this._relations = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? Get_classifications()
    {
      return this._classifications;
    }
    public XSD.Nworld_step.Ndata.Npeople.Nperson.classifications GetOrInsertDefault_classifications()
    {
      if(this._classifications == null) {

        // true2
        this._classifications = new XSD.Nworld_step.Ndata.Npeople.Nperson.classifications();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_classifications();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_classifications(XSD.Nworld_step.Ndata.Npeople.Nperson.classifications? value)
    {
        this._classifications = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Npeople.Nperson.properties.TagName))
      {
        this.properties ??= new XSD.Nworld_step.Ndata.Npeople.Nperson.properties();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Npeople.Nperson.properties.TagName.Length + 3);
        this.properties.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Npeople.Nperson.relations.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Ndata.Npeople.Nperson.relations.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._relations.ContainsKey(indexString.ToInt()))
        {
          this._relations[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Nworld_step.Ndata.Npeople.Nperson.relations();
        newEntry.SetXPath(xpath, rawNode);
        this._relations.Add(indexString.ToInt(), newEntry);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.Npeople.Nperson.classifications.TagName))
      {
        this.classifications ??= new XSD.Nworld_step.Ndata.Npeople.Nperson.classifications();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.Npeople.Nperson.classifications.TagName.Length + 3);
        this.classifications.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}