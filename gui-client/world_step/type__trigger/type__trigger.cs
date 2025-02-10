using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__trigger {}
namespace XSD {
}
namespace XSD {
  public class type__trigger  {

    public static string ClassTypeId = "/type__trigger";
    public static string TagName = "type__trigger";

    public string Tag = "type__trigger";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Ntype__trigger.person_action_used _person_action_used = new XSD.Ntype__trigger.person_action_used();
    public XSD.Ntype__trigger.person_action_used person_action_used {
      get { return _person_action_used; }
      set { _person_action_used = value; }
    }
    public type__trigger()
    {
    }

    public type__trigger(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__trigger(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__trigger");
      //Deserialize arguments

      //Deserialize children
      this._person_action_used = rawNode.InitializeWithRawNode("person_action_used", this._person_action_used);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(person_action_used != null) {
        rawNode.children["person_action_used"] = new List<RawNode> { person_action_used.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__trigger");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__trigger.person_action_used Get_person_action_used()
    {
      return this._person_action_used;
    }
    public XSD.Ntype__trigger.person_action_used GetOrInsertDefault_person_action_used()
    {
      if(this._person_action_used == null) {

        // true2
        this._person_action_used = new XSD.Ntype__trigger.person_action_used();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_person_action_used();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_person_action_used(XSD.Ntype__trigger.person_action_used value)
    {
        this._person_action_used = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__trigger.person_action_used.TagName))
      {
        xpath = xpath.Substring(XSD.Ntype__trigger.person_action_used.TagName.Length + 3);
        this.person_action_used.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}