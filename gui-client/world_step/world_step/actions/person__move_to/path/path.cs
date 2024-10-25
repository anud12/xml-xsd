using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__move_to.Npath {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions.Nperson__move_to {
  public class path  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>? node = new List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>();
    public path()
    {
    }

    public path(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public path(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing path");
      //Deserialize arguments

      //Deserialize children
      this.node = rawNode.InitializeWithRawNode("node", this.node);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["node"] = node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing path");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>? Get_node()
    {
      return this.node;
    }
    public List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node> GetOrInsertDefault_node()
    {
      if(this.node == null) {
        this.node = new List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>();
      }
      return this.node;
    }
    public void Set_node(List<XSD.Nworld_step.Nactions.Nperson__move_to.Npath.node>? value)
    {
      this.node = value;
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
        "node": {
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
        }
      },
      "isNullable": true
    },
    "name": "path"
  }
*/