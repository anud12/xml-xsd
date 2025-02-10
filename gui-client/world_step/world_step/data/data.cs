using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class data  {

    public static string ClassTypeId = "/world_step/data";
    public static string TagName = "data";

    public string Tag = "data";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Nworld_step.Ndata.people? _people = null;
    public XSD.Nworld_step.Ndata.people? people {
      get { return _people; }
      set { _people = value; }
    }

    private XSD.Nworld_step.Ndata.location? _location = null;
    public XSD.Nworld_step.Ndata.location? location {
      get { return _location; }
      set { _location = value; }
    }
    public data()
    {
    }

    public data(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public data(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing data");
      //Deserialize arguments

      //Deserialize children
      this._people = rawNode.InitializeWithRawNode("people", this._people);
      this._location = rawNode.InitializeWithRawNode("location", this._location);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      if(location != null) {
        rawNode.children["location"] = new List<RawNode> { location.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing data");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.Ndata.people? Get_people()
    {
      return this._people;
    }
    public XSD.Nworld_step.Ndata.people GetOrInsertDefault_people()
    {
      if(this._people == null) {

        // true2
        this._people = new XSD.Nworld_step.Ndata.people();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_people();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_people(XSD.Nworld_step.Ndata.people? value)
    {
        this._people = value;
    }
    public XSD.Nworld_step.Ndata.location? Get_location()
    {
      return this._location;
    }
    public XSD.Nworld_step.Ndata.location GetOrInsertDefault_location()
    {
      if(this._location == null) {

        // true2
        this._location = new XSD.Nworld_step.Ndata.location();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_location();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_location(XSD.Nworld_step.Ndata.location? value)
    {
        this._location = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.people.TagName))
      {
        this.people ??= new XSD.Nworld_step.Ndata.people();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.people.TagName.Length + 3);
        this.people.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Ndata.location.TagName))
      {
        this.location ??= new XSD.Nworld_step.Ndata.location();
        xpath = xpath.Substring(XSD.Nworld_step.Ndata.location.TagName.Length + 3);
        this.location.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}