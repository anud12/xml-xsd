using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nperson__move_to {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class person__move_to  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;

    //Children elements
    public type__node_graph__selection? find_path_towards = null;
    public XSD.Nworld_step.Nactions.Nperson__move_to.path? path = null;
    public person__move_to()
    {
    }

    public person__move_to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person__move_to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person__move_to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }

      //Deserialize children
      this.find_path_towards = rawNode.InitializeWithRawNode("find_path_towards", this.find_path_towards);
      this.path = rawNode.InitializeWithRawNode("path", this.path);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }

      //Serialize children
      if(find_path_towards != null) {
        rawNode.children["find_path_towards"] = new List<RawNode> { find_path_towards.SerializeIntoRawNode() };
      }
      if(path != null) {
        rawNode.children["path"] = new List<RawNode> { path.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person__move_to");
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
    public type__node_graph__selection? Get_find_path_towards()
    {
      return this.find_path_towards;
    }
    public void Set_find_path_towards(type__node_graph__selection? value)
    {
      this.find_path_towards = value;
    }
    public XSD.Nworld_step.Nactions.Nperson__move_to.path? Get_path()
    {
      return this.path;
    }
    public XSD.Nworld_step.Nactions.Nperson__move_to.path GetOrInsertDefault_path()
    {
      if(this.path == null) {
        this.path = new XSD.Nworld_step.Nactions.Nperson__move_to.path();
      }
      return this.path;
    }
    public void Set_path(XSD.Nworld_step.Nactions.Nperson__move_to.path? value)
    {
      this.path = value;
    }
  }
}