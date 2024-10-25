using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__create {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__create  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type__node_graph__selection node_graph__selection = new type__node_graph__selection();
    public type__person_selection person__selection = new type__person_selection();
    public person__create()
    {
    }

    public person__create(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__create(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person__create");
      //Deserialize arguments

      //Deserialize children
      this.node_graph__selection = rawNode.InitializeWithRawNode("node_graph__selection", this.node_graph__selection);
      this.person__selection = rawNode.InitializeWithRawNode("person__selection", this.person__selection);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(node_graph__selection != null) {
        rawNode.children["node_graph__selection"] = new List<RawNode> { node_graph__selection.SerializeIntoRawNode() };
      }
      if(person__selection != null) {
        rawNode.children["person__selection"] = new List<RawNode> { person__selection.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person__create");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public type__node_graph__selection Get_node_graph__selection()
    {
      return this.node_graph__selection;
    }
    public void Set_node_graph__selection(type__node_graph__selection value)
    {
      this.node_graph__selection = value;
    }
    public type__person_selection Get_person__selection()
    {
      return this.person__selection;
    }
    public void Set_person__selection(type__person_selection value)
    {
      this.person__selection = value;
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
        "node_graph__selection": {
          "metaType": "reference",
          "value": "type__node_graph__selection",
          "isSingle": true,
          "isNullable": false
        },
        "person__selection": {
          "metaType": "reference",
          "value": "type__person_selection",
          "isSingle": true,
          "isNullable": false
        }
      },
      "isNullable": true
    },
    "name": "person__create"
  }
*/