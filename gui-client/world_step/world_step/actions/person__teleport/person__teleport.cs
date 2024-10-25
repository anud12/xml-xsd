using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__teleport {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__teleport  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;

    //Children elements
    public XSD.Nworld_step.Nactions.Nperson__teleport.location_graph? location_graph = null;
    public XSD.Nworld_step.Nactions.Nperson__teleport.link_to link_to = new XSD.Nworld_step.Nactions.Nperson__teleport.link_to();
    public person__teleport()
    {
    }

    public person__teleport(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__teleport(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person__teleport");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }

      //Deserialize children
      this.location_graph = rawNode.InitializeWithRawNode("location_graph", this.location_graph);
      this.link_to = rawNode.InitializeWithRawNode("link_to", this.link_to);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }

      //Serialize children
      if(location_graph != null) {
        rawNode.children["location_graph"] = new List<RawNode> { location_graph.SerializeIntoRawNode() };
      }
      if(link_to != null) {
        rawNode.children["link_to"] = new List<RawNode> { link_to.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person__teleport");
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
    public XSD.Nworld_step.Nactions.Nperson__teleport.location_graph? Get_location_graph()
    {
      return this.location_graph;
    }
    public XSD.Nworld_step.Nactions.Nperson__teleport.location_graph GetOrInsertDefault_location_graph()
    {
      if(this.location_graph == null) {
        this.location_graph = new XSD.Nworld_step.Nactions.Nperson__teleport.location_graph();
      }
      return this.location_graph;
    }
    public void Set_location_graph(XSD.Nworld_step.Nactions.Nperson__teleport.location_graph? value)
    {
      this.location_graph = value;
    }
    public XSD.Nworld_step.Nactions.Nperson__teleport.link_to Get_link_to()
    {
      return this.link_to;
    }
    public XSD.Nworld_step.Nactions.Nperson__teleport.link_to GetOrInsertDefault_link_to()
    {
      if(this.link_to == null) {
        this.link_to = new XSD.Nworld_step.Nactions.Nperson__teleport.link_to();
      }
      return this.link_to;
    }
    public void Set_link_to(XSD.Nworld_step.Nactions.Nperson__teleport.link_to value)
    {
      this.link_to = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "attributes": {
        "metaType": "object",
        "value": {
          "person_id_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        },
        "isNullable": false
      },
      "value": {
        "location_graph": {
          "metaType": "object",
          "value": {},
          "isSingle": true,
          "isNullable": true,
          "attributes": {
            "metaType": "object",
            "value": {
              "location_graph_id_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              },
              "node_id_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            }
          }
        },
        "link_to": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "accumulated_progress": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            },
            "isNullable": false
          },
          "isSingle": true,
          "value": {
            "selection": {
              "metaType": "reference",
              "value": "type__link_to__selection",
              "isSingle": true,
              "isNullable": false
            }
          },
          "isNullable": false
        }
      }
    },
    "name": "person__teleport"
  }
*/