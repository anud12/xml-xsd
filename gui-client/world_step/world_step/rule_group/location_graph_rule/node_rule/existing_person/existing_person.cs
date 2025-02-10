using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nexisting_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {
  public class existing_person  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule/node_rule/existing_person";
    public static string TagName = "existing_person";

    public string Tag = "existing_person";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 min;
    public System.Int32 _min;
    public System.Int32? max;
    public System.Int32? _max;

    //Children elements
    private type__person_selection _person_selection = new type__person_selection();
    public type__person_selection person_selection {
      get { return _person_selection; }
      set { _person_selection = value; }
    }
    public existing_person()
    {
    }

    public existing_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public existing_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing existing_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("min"))
      {
        var attribute_min = rawNode.attributes["min"];
        this.min = attribute_min.ToInt();
      }
      if(rawNode.attributes.ContainsKey("max"))
      {
        var attribute_max = rawNode.attributes["max"];
        this.max = attribute_max?.ToInt();
      }

      //Deserialize children
      this._person_selection = rawNode.InitializeWithRawNode("person_selection", this._person_selection);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.min != null)
      {
        rawNode.attributes["min"] = this.min.ToString();
      }
      if(this.max != null)
      {
        rawNode.attributes["max"] = this.max?.ToString();
      }

      //Serialize children
      if(person_selection != null) {
        rawNode.children["person_selection"] = new List<RawNode> { person_selection.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing existing_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_min()
    {
      return this.min;
    }
    public void Set_min(System.Int32 value)
    {
      this.min = value;
    }
    public System.Int32? Get_max()
    {
      return this.max;
    }
    public void Set_max(System.Int32? value)
    {
      this.max = value;
    }
    public type__person_selection Get_person_selection()
    {
      return this.person_selection;
    }
    public void Set_person_selection(type__person_selection value)
    {
      this.person_selection = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__person_selection.TagName))
      {
        xpath = xpath.Substring(type__person_selection.TagName.Length + 3);
        this.person_selection.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}