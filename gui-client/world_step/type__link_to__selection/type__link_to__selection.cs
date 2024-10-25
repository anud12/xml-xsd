using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__link_to__selection {}
namespace XSD {
}
namespace XSD {
  public class type__link_to__selection  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public type__node_graph__selection? origin__node_graph__selection = null;
    public type__node_graph__selection? destination__node_graph__selection = null;
    public type__link_to__selection()
    {
    }

    public type__link_to__selection(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__link_to__selection(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__link_to__selection");
      //Deserialize arguments

      //Deserialize children
      this.origin__node_graph__selection = rawNode.InitializeWithRawNode("origin__node_graph__selection", this.origin__node_graph__selection);
      this.destination__node_graph__selection = rawNode.InitializeWithRawNode("destination__node_graph__selection", this.destination__node_graph__selection);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(origin__node_graph__selection != null) {
        rawNode.children["origin__node_graph__selection"] = new List<RawNode> { origin__node_graph__selection.SerializeIntoRawNode() };
      }
      if(destination__node_graph__selection != null) {
        rawNode.children["destination__node_graph__selection"] = new List<RawNode> { destination__node_graph__selection.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__link_to__selection");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public type__node_graph__selection? Get_origin__node_graph__selection()
    {
      return this.origin__node_graph__selection;
    }
    public void Set_origin__node_graph__selection(type__node_graph__selection? value)
    {
      this.origin__node_graph__selection = value;
    }
    public type__node_graph__selection? Get_destination__node_graph__selection()
    {
      return this.destination__node_graph__selection;
    }
    public void Set_destination__node_graph__selection(type__node_graph__selection? value)
    {
      this.destination__node_graph__selection = value;
    }
  }
}