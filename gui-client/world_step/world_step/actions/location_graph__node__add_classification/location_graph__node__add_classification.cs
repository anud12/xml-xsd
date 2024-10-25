using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class location_graph__node__add_classification  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type__node_graph__selection node_graph_selection = new type__node_graph__selection();
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification to_be_added__classification = new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification();
    public location_graph__node__add_classification()
    {
    }

    public location_graph__node__add_classification(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph__node__add_classification(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph__node__add_classification");
      //Deserialize arguments

      //Deserialize children
      this.node_graph_selection = rawNode.InitializeWithRawNode("node_graph_selection", this.node_graph_selection);
      this.to_be_added__classification = rawNode.InitializeWithRawNode("to_be_added__classification", this.to_be_added__classification);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(node_graph_selection != null) {
        rawNode.children["node_graph_selection"] = new List<RawNode> { node_graph_selection.SerializeIntoRawNode() };
      }
      if(to_be_added__classification != null) {
        rawNode.children["to_be_added__classification"] = new List<RawNode> { to_be_added__classification.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph__node__add_classification");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public type__node_graph__selection Get_node_graph_selection()
    {
      return this.node_graph_selection;
    }
    public void Set_node_graph_selection(type__node_graph__selection value)
    {
      this.node_graph_selection = value;
    }
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification Get_to_be_added__classification()
    {
      return this.to_be_added__classification;
    }
    public XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification GetOrInsertDefault_to_be_added__classification()
    {
      if(this.to_be_added__classification == null) {
        this.to_be_added__classification = new XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification();
      }
      return this.to_be_added__classification;
    }
    public void Set_to_be_added__classification(XSD.Nworld_step.Nactions.Nlocation_graph__node__add_classification.to_be_added__classification value)
    {
      this.to_be_added__classification = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": false,
      "value": {
        "node_graph_selection": {
          "metaType": "reference",
          "value": "type__node_graph__selection",
          "isSingle": true,
          "isNullable": false
        },
        "to_be_added__classification": {
          "metaType": "object",
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
          },
          "isSingle": true,
          "value": {
            "and": {
              "metaType": "object",
              "value": {},
              "isSingle": true,
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
          "isNullable": false
        }
      },
      "isNullable": true
    },
    "name": "location_graph__node__add_classification"
  }
*/