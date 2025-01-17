using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step {}
namespace XSD {
}
namespace XSD {
  public class world_step  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Nworld_step.world_metadata? world_metadata = null;
    public List<XSD.Nworld_step.rule_group>? rule_group = new List<XSD.Nworld_step.rule_group>();
    public XSD.Nworld_step.data? data = null;
    public XSD.Nworld_step.actions? actions = null;
    public world_step()
    {
    }

    public world_step(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public world_step(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing world_step");
      //Deserialize arguments

      //Deserialize children
      this.world_metadata = rawNode.InitializeWithRawNode("world_metadata", this.world_metadata);
      this.rule_group = rawNode.InitializeWithRawNode("rule_group", this.rule_group);
      this.data = rawNode.InitializeWithRawNode("data", this.data);
      this.actions = rawNode.InitializeWithRawNode("actions", this.actions);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(world_metadata != null) {
        rawNode.children["world_metadata"] = new List<RawNode> { world_metadata.SerializeIntoRawNode() };
      }
      rawNode.children["rule_group"] = rule_group.Select(x => x.SerializeIntoRawNode()).ToList();
      if(data != null) {
        rawNode.children["data"] = new List<RawNode> { data.SerializeIntoRawNode() };
      }
      if(actions != null) {
        rawNode.children["actions"] = new List<RawNode> { actions.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing world_step");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Nworld_step.world_metadata? Get_world_metadata()
    {
      return this.world_metadata;
    }
    public XSD.Nworld_step.world_metadata GetOrInsertDefault_world_metadata()
    {
      if(this.world_metadata == null) {
        this.world_metadata = new XSD.Nworld_step.world_metadata();
      }
      return this.world_metadata;
    }
    public void Set_world_metadata(XSD.Nworld_step.world_metadata? value)
    {
      this.world_metadata = value;
    }
    public List<XSD.Nworld_step.rule_group>? Get_rule_group()
    {
      return this.rule_group;
    }
    public List<XSD.Nworld_step.rule_group> GetOrInsertDefault_rule_group()
    {
      if(this.rule_group == null) {
        this.rule_group = new List<XSD.Nworld_step.rule_group>();
      }
      return this.rule_group;
    }
    public void Set_rule_group(List<XSD.Nworld_step.rule_group>? value)
    {
      this.rule_group = value;
    }
    public XSD.Nworld_step.data? Get_data()
    {
      return this.data;
    }
    public XSD.Nworld_step.data GetOrInsertDefault_data()
    {
      if(this.data == null) {
        this.data = new XSD.Nworld_step.data();
      }
      return this.data;
    }
    public void Set_data(XSD.Nworld_step.data? value)
    {
      this.data = value;
    }
    public XSD.Nworld_step.actions? Get_actions()
    {
      return this.actions;
    }
    public XSD.Nworld_step.actions GetOrInsertDefault_actions()
    {
      if(this.actions == null) {
        this.actions = new XSD.Nworld_step.actions();
      }
      return this.actions;
    }
    public void Set_actions(XSD.Nworld_step.actions? value)
    {
      this.actions = value;
    }
  }
}