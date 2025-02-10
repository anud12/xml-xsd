using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__action.Nfrom {}
namespace XSD {
}
namespace XSD.Ntype__action {
  public class from  {

    public static string ClassTypeId = "/type__action/from";
    public static string TagName = "from";

    public string Tag = "from";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Ntype__action.Nfrom.person? _person = null;
    public XSD.Ntype__action.Nfrom.person? person {
      get { return _person; }
      set { _person = value; }
    }
    public from()
    {
    }

    public from(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from");
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
        // Godot.GD.Print("Serializing from");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__action.Nfrom.person? Get_person()
    {
      return this._person;
    }
    public XSD.Ntype__action.Nfrom.person GetOrInsertDefault_person()
    {
      if(this._person == null) {

        // true2
        this._person = new XSD.Ntype__action.Nfrom.person();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_person();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_person(XSD.Ntype__action.Nfrom.person? value)
    {
        this._person = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__action.Nfrom.person.TagName))
      {
        this.person ??= new XSD.Ntype__action.Nfrom.person();
        xpath = xpath.Substring(XSD.Ntype__action.Nfrom.person.TagName.Length + 3);
        this.person.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}