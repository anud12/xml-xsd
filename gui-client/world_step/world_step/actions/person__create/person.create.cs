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

    public static string ClassTypeId = "/world_step/actions/person.create";
    public static string TagName = "person.create";

    public string Tag = "person.create";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private type__node_graph__selection _node_graph__selection = new type__node_graph__selection();
    public type__node_graph__selection node_graph__selection {
      get { return _node_graph__selection; }
      set { _node_graph__selection = value; }
    }

    private type__person_selection _person__selection = new type__person_selection();
    public type__person_selection person__selection {
      get { return _person__selection; }
      set { _person__selection = value; }
    }
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
      // Godot.GD.Print("Deserializing person.create");
      //Deserialize arguments

      //Deserialize children
      this._node_graph__selection = rawNode.InitializeWithRawNode("node_graph__selection", this._node_graph__selection);
      this._person__selection = rawNode.InitializeWithRawNode("person__selection", this._person__selection);
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
        // Godot.GD.Print("Serializing person.create");
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

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(type__node_graph__selection.TagName))
      {
        xpath = xpath.Substring(type__node_graph__selection.TagName.Length + 3);
        this.node_graph__selection.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__person_selection.TagName))
      {
        xpath = xpath.Substring(type__person_selection.TagName.Length + 3);
        this.person__selection.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}