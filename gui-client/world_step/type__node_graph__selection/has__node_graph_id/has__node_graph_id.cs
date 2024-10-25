using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__node_graph__selection.Nhas__node_graph_id {}
namespace XSD {
}
namespace XSD.Ntype__node_graph__selection {
  public class has__node_graph_id  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_graph_id_ref;

    //Children elements
    public List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>? or = new List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>();
    public has__node_graph_id()
    {
    }

    public has__node_graph_id(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public has__node_graph_id(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing has__node_graph_id");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_graph_id_ref"))
      {
        var attribute_node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
        this.node_graph_id_ref = rawNode.attributes["node_graph_id_ref"];
      }

      //Deserialize children
      this.or = rawNode.InitializeWithRawNode("or", this.or);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_graph_id_ref != null)
      {
        rawNode.attributes["node_graph_id_ref"] = this.node_graph_id_ref.ToString();
      }

      //Serialize children
      rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing has__node_graph_id");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_graph_id_ref()
    {
      return this.node_graph_id_ref;
    }
    public void Set_node_graph_id_ref(System.String value)
    {
      this.node_graph_id_ref = value;
    }
    public List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>? Get_or()
    {
      return this.or;
    }
    public List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or> GetOrInsertDefault_or()
    {
      if(this.or == null) {
        this.or = new List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>();
      }
      return this.or;
    }
    public void Set_or(List<XSD.Ntype__node_graph__selection.Nhas__node_graph_id.or>? value)
    {
      this.or = value;
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
          "node_graph_id_ref": {
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
              "node_graph_id_ref": {
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
    },
    "name": "has__node_graph_id"
  }
*/