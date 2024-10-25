using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nin__location_graph {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection {
  public class in__location_graph  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id? has__location_graph_id = null;
    public in__location_graph()
    {
    }

    public in__location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public in__location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing in__location_graph");
      //Deserialize arguments

      //Deserialize children
      this.has__location_graph_id = rawNode.InitializeWithRawNode("has__location_graph_id", this.has__location_graph_id);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(has__location_graph_id != null) {
        rawNode.children["has__location_graph_id"] = new List<RawNode> { has__location_graph_id.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing in__location_graph");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id? Get_has__location_graph_id()
    {
      return this.has__location_graph_id;
    }
    public XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id GetOrInsertDefault_has__location_graph_id()
    {
      if(this.has__location_graph_id == null) {
        this.has__location_graph_id = new XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id();
      }
      return this.has__location_graph_id;
    }
    public void Set_has__location_graph_id(XSD.Ntype__node_graph__selection.Nin__location_graph.has__location_graph_id? value)
    {
      this.has__location_graph_id = value;
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
        "has__location_graph_id": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "location_graph_id_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
          },
          "isSingle": true,
          "value": {
            "or": {
              "metaType": "object",
              "value": {},
              "isSingle": false,
              "isNullable": true,
              "attributes": {
                "metaType": "object",
                "value": {
                  "location_graph_id_ref": {
                    "metaType": "primitive",
                    "value": "xs:string",
                    "isNullable": true
                  }
                },
                "isNullable": true
              }
            }
          },
          "isNullable": true
        }
      },
      "isNullable": true
    },
    "name": "in__location_graph"
  }
*/