using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Non.Nperson {}
namespace XSD {
}
namespace XSD.Non {
  public class person  {

    public static string ClassTypeId = "/on/person";
    public static string TagName = "person";

    public string Tag = "person";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private type__person_selection? _select = null;
    public type__person_selection? select {
      get { return _select; }
      set { _select = value; }
    }

    private type__property_mutation? _property_mutation = null;
    public type__property_mutation? property_mutation {
      get { return _property_mutation; }
      set { _property_mutation = value; }
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

      //Deserialize children
      this._select = rawNode.InitializeWithRawNode("select", this._select);
      this._property_mutation = rawNode.InitializeWithRawNode("property_mutation", this._property_mutation);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(select != null) {
        rawNode.children["select"] = new List<RawNode> { select.SerializeIntoRawNode() };
      }
      if(property_mutation != null) {
        rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public type__person_selection? Get_select()
    {
      return this.select;
    }
    public void Set_select(type__person_selection? value)
    {
      this.select = value;
    }
    public type__property_mutation? Get_property_mutation()
    {
      return this.property_mutation;
    }
    public void Set_property_mutation(type__property_mutation? value)
    {
      this.property_mutation = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__person_selection.TagName))
      {
        this.select ??= new type__person_selection();
        xpath = xpath.Substring(type__person_selection.TagName.Length + 3);
        this.select.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__property_mutation.TagName))
      {
        this.property_mutation ??= new type__property_mutation();
        xpath = xpath.Substring(type__property_mutation.TagName.Length + 3);
        this.property_mutation.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}