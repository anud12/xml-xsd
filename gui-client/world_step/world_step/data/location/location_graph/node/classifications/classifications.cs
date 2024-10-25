using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class classifications  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>? classification = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>();
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
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>? Get_classification()
    {
      return this.classification;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification> GetOrInsertDefault_classification()
    {
      if(this.classification == null) {
        this.classification = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>();
      }
      return this.classification;
    }
    public void Set_classification(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nclassifications.classification>? value)
    {
      this.classification = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": true,
      "value": {
        "classification": {
          "metaType": "object",
          "value": {},
          "isSingle": false,
          "isNullable": true,
          "attributes": {
            "metaType": "object",
            "value": {
              "location_classification_rule_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        }
      },
      "isNullable": true
    },
    "name": "classifications"
  }
*/