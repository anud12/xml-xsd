using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__teleport.Nlocation_graph {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nperson__teleport {
  public class location_graph  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String location_graph_id_ref;
    public System.String node_id_ref;

    //Children elements
    public location_graph()
    {
    }

    public location_graph(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public location_graph(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing location_graph");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("location_graph_id_ref"))
      {
        var attribute_location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
        this.location_graph_id_ref = rawNode.attributes["location_graph_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("node_id_ref"))
      {
        var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
        this.node_id_ref = rawNode.attributes["node_id_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.location_graph_id_ref != null)
      {
        rawNode.attributes["location_graph_id_ref"] = this.location_graph_id_ref.ToString();
      }
      if(this.node_id_ref != null)
      {
        rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing location_graph");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_location_graph_id_ref()
    {
      return this.location_graph_id_ref;
    }
    public void Set_location_graph_id_ref(System.String value)
    {
      this.location_graph_id_ref = value;
    }
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
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
    "name": "location_graph"
  }
*/