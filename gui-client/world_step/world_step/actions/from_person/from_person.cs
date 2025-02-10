using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nfrom_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class from_person  {

    public static string ClassTypeId = "/world_step/actions/from_person";
    public static string TagName = "from_person";

    public string Tag = "from_person";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.String _person_id_ref;
    public System.String from_person_rule_ref;
    public System.String _from_person_rule_ref;

    //Children elements
    private XSD.Nworld_step.Nactions.Nfrom_person.on_person _on_person = new XSD.Nworld_step.Nactions.Nfrom_person.on_person();
    public XSD.Nworld_step.Nactions.Nfrom_person.on_person on_person {
      get { return _on_person; }
      set { _on_person = value; }
    }
    public from_person()
    {
    }

    public from_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("from_person_rule_ref"))
      {
        var attribute_from_person_rule_ref = rawNode.attributes["from_person_rule_ref"];
        this.from_person_rule_ref = rawNode.attributes["from_person_rule_ref"];
      }

      //Deserialize children
      this._on_person = rawNode.InitializeWithRawNode("on_person", this._on_person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }
      if(this.from_person_rule_ref != null)
      {
        rawNode.attributes["from_person_rule_ref"] = this.from_person_rule_ref.ToString();
      }

      //Serialize children
      if(on_person != null) {
        rawNode.children["on_person"] = new List<RawNode> { on_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public System.String Get_from_person_rule_ref()
    {
      return this.from_person_rule_ref;
    }
    public void Set_from_person_rule_ref(System.String value)
    {
      this.from_person_rule_ref = value;
    }
    public XSD.Nworld_step.Nactions.Nfrom_person.on_person Get_on_person()
    {
      return this._on_person;
    }
    public XSD.Nworld_step.Nactions.Nfrom_person.on_person GetOrInsertDefault_on_person()
    {
      if(this._on_person == null) {

        // true2
        this._on_person = new XSD.Nworld_step.Nactions.Nfrom_person.on_person();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_on_person();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_on_person(XSD.Nworld_step.Nactions.Nfrom_person.on_person value)
    {
        this._on_person = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nactions.Nfrom_person.on_person.TagName))
      {
        xpath = xpath.Substring(XSD.Nworld_step.Nactions.Nfrom_person.on_person.TagName.Length + 3);
        this.on_person.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}