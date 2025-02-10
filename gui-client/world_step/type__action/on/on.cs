using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__action.Non {}
namespace XSD {
}
namespace XSD.Ntype__action {
  public class on  {

    public static string ClassTypeId = "/type__action/on";
    public static string TagName = "on";

    public string Tag = "on";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Ntype__action.Non.person? _person = null;
    public XSD.Ntype__action.Non.person? person {
      get { return _person; }
      set { _person = value; }
    }
    public on()
    {
    }

    public on(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public on(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on");
      //Deserialize arguments

      //Deserialize children
      this._person = rawNode.InitializeWithRawNode("person", this._person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(person != null) {
        rawNode.children["person"] = new List<RawNode> { person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing on");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__action.Non.person? Get_person()
    {
      return this._person;
    }
    public XSD.Ntype__action.Non.person GetOrInsertDefault_person()
    {
      if(this._person == null) {

        // true2
        this._person = new XSD.Ntype__action.Non.person();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_person();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_person(XSD.Ntype__action.Non.person? value)
    {
        this._person = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__action.Non.person.TagName))
      {
        this.person ??= new XSD.Ntype__action.Non.person();
        xpath = xpath.Substring(XSD.Ntype__action.Non.person.TagName.Length + 3);
        this.person.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}