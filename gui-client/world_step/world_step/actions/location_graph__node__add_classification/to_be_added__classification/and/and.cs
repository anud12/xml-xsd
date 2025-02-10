using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.Nand {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification {
  public class and  {

    public static string ClassTypeId = "/world_step/actions/location_graph.node.add_classification/to_be_added__classification/and";
    public static string TagName = "and";

    public string Tag = "and";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_classification_rule_ref;
    public System.String _location_classification_rule_ref;

    //Children elements
    public and()
    {
    }

    public and(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public and(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing and");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing and");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_location_classification_rule_ref()
    {
      return this.location_classification_rule_ref;
    }
    public void Set_location_classification_rule_ref(System.String value)
    {
      this.location_classification_rule_ref = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}