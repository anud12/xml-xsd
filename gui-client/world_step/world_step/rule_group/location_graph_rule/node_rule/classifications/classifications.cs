using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nclassifications {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {
  public class classifications  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nclassifications.classification>? classification = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nclassifications.classification>();
    public classifications()
    {
    }

    public classifications(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public classifications(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing classifications");
      //Deserialize arguments

      //Deserialize children
      this.classification = rawNode.InitializeWithRawNode("classification", this.classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["classification"] = classification.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing classifications");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nclassifications.classification>? Get_classification()
    {
      return this.classification;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nclassifications.classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nclassifications.classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nclassifications.classification>? value)
    {
      this.classification = value;
    }
  }
}