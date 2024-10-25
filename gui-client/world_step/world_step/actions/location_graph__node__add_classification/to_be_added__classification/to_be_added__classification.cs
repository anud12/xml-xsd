using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification {
  public class to_be_added__classification  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_classification_rule_ref;

    //Children elements
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? and = null;
    public to_be_added__classification()
    {
    }

    public to_be_added__classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public to_be_added__classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing to_be_added__classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_classification_rule_ref"))
      {
        var attribute_location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
        this.location_classification_rule_ref = rawNode.attributes["location_classification_rule_ref"];
      }

      //Deserialize children
      this.and = rawNode.InitializeWithRawNode("and", this.and);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_classification_rule_ref != null)
      {
        rawNode.attributes["location_classification_rule_ref"] = this.location_classification_rule_ref.ToString();
      }

      //Serialize children
      if(and != null) {
        rawNode.children["and"] = new List<RawNode> { and.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing to_be_added__classification");
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
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? Get_and()
    {
      return this.and;
    }
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and GetOrInsertDefault_and()
    {
      if(this.and == null) {
        this.and = new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and();
      }
      return this.and;
    }
    public void Set_and(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.Nto_be_added__classification.and? value)
    {
      this.and = value;
    }
  }
}