using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__move_to.Npath.Nnode {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nperson__move_to.Npath {
  public class node  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_id_ref;

    //Children elements
    public node()
    {
    }

    public node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public node(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing node");
      //Deserialize arguments
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
      if(this.node_id_ref != null)
      {
        rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
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
      "isSingle": false,
      "isNullable": true,
      "attributes": {
        "metaType": "object",
        "value": {
          "node_id_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        },
        "isNullable": false
      }
    },
    "name": "node"
  }
*/