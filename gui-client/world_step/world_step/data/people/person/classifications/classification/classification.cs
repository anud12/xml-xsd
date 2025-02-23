using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nclassifications.Nclassification {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nclassifications {
  public class classification  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String classification_rule_ref;

    //Children elements
    public classification()
    {
    }

    public classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing classification");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("classification_rule_ref"))
      {
        var attribute_classification_rule_ref = rawNode.attributes["classification_rule_ref"];
        this.classification_rule_ref = rawNode.attributes["classification_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.classification_rule_ref != null)
      {
        rawNode.attributes["classification_rule_ref"] = this.classification_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_classification_rule_ref()
    {
      return this.classification_rule_ref;
    }
    public void Set_classification_rule_ref(System.String value)
    {
      this.classification_rule_ref = value;
    }
  }
}