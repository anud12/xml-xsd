using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class rule_group  {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public XSD.Nworld_step.Nrule_group.property_rule? property_rule = null;
    public XSD.Nworld_step.Nrule_group.classification_rule? classification_rule = null;
    public XSD.Nworld_step.Nrule_group.name_rule? name_rule = null;
    public XSD.Nworld_step.Nrule_group.action_rule? action_rule = null;
    public XSD.Nworld_step.Nrule_group.events_rule? events_rule = null;
    public XSD.Nworld_step.Nrule_group.link_group_rule_list? link_group_rule_list = null;
    public XSD.Nworld_step.Nrule_group.location_graph_rule? location_graph_rule = null;
    public XSD.Nworld_step.Nrule_group.location_classification_rule? location_classification_rule = null;
    public rule_group()
    {
    }

    public rule_group(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public rule_group(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing rule_group");
      //Deserialize arguments

      //Deserialize children
      this.property_rule = rawNode.InitializeWithRawNode("property_rule", this.property_rule);
      this.classification_rule = rawNode.InitializeWithRawNode("classification_rule", this.classification_rule);
      this.name_rule = rawNode.InitializeWithRawNode("name_rule", this.name_rule);
      this.action_rule = rawNode.InitializeWithRawNode("action_rule", this.action_rule);
      this.events_rule = rawNode.InitializeWithRawNode("events_rule", this.events_rule);
      this.link_group_rule_list = rawNode.InitializeWithRawNode("link_group_rule_list", this.link_group_rule_list);
      this.location_graph_rule = rawNode.InitializeWithRawNode("location_graph_rule", this.location_graph_rule);
      this.location_classification_rule = rawNode.InitializeWithRawNode("location_classification_rule", this.location_classification_rule);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(property_rule != null) {
        rawNode.children["property_rule"] = new List<RawNode> { property_rule.SerializeIntoRawNode() };
      }
      if(classification_rule != null) {
        rawNode.children["classification_rule"] = new List<RawNode> { classification_rule.SerializeIntoRawNode() };
      }
      if(name_rule != null) {
        rawNode.children["name_rule"] = new List<RawNode> { name_rule.SerializeIntoRawNode() };
      }
      if(action_rule != null) {
        rawNode.children["action_rule"] = new List<RawNode> { action_rule.SerializeIntoRawNode() };
      }
      if(events_rule != null) {
        rawNode.children["events_rule"] = new List<RawNode> { events_rule.SerializeIntoRawNode() };
      }
      if(link_group_rule_list != null) {
        rawNode.children["link_group_rule_list"] = new List<RawNode> { link_group_rule_list.SerializeIntoRawNode() };
      }
      if(location_graph_rule != null) {
        rawNode.children["location_graph_rule"] = new List<RawNode> { location_graph_rule.SerializeIntoRawNode() };
      }
      if(location_classification_rule != null) {
        rawNode.children["location_classification_rule"] = new List<RawNode> { location_classification_rule.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing rule_group");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    /* ignored attribute key={key} of type=System.Object*/
    public XSD.Nworld_step.Nrule_group.property_rule? Get_property_rule()
    {
      return this.property_rule;
    }
    public XSD.Nworld_step.Nrule_group.property_rule GetOrInsertDefault_property_rule()
    {
      if(this.property_rule == null) {
        this.property_rule = new XSD.Nworld_step.Nrule_group.property_rule();
      }
      return this.property_rule;
    }
    public void Set_property_rule(XSD.Nworld_step.Nrule_group.property_rule? value)
    {
      this.property_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.classification_rule? Get_classification_rule()
    {
      return this.classification_rule;
    }
    public XSD.Nworld_step.Nrule_group.classification_rule GetOrInsertDefault_classification_rule()
    {
      if(this.classification_rule == null) {
        this.classification_rule = new XSD.Nworld_step.Nrule_group.classification_rule();
      }
      return this.classification_rule;
    }
    public void Set_classification_rule(XSD.Nworld_step.Nrule_group.classification_rule? value)
    {
      this.classification_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.name_rule? Get_name_rule()
    {
      return this.name_rule;
    }
    public XSD.Nworld_step.Nrule_group.name_rule GetOrInsertDefault_name_rule()
    {
      if(this.name_rule == null) {
        this.name_rule = new XSD.Nworld_step.Nrule_group.name_rule();
      }
      return this.name_rule;
    }
    public void Set_name_rule(XSD.Nworld_step.Nrule_group.name_rule? value)
    {
      this.name_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.action_rule? Get_action_rule()
    {
      return this.action_rule;
    }
    public XSD.Nworld_step.Nrule_group.action_rule GetOrInsertDefault_action_rule()
    {
      if(this.action_rule == null) {
        this.action_rule = new XSD.Nworld_step.Nrule_group.action_rule();
      }
      return this.action_rule;
    }
    public void Set_action_rule(XSD.Nworld_step.Nrule_group.action_rule? value)
    {
      this.action_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.events_rule? Get_events_rule()
    {
      return this.events_rule;
    }
    public XSD.Nworld_step.Nrule_group.events_rule GetOrInsertDefault_events_rule()
    {
      if(this.events_rule == null) {
        this.events_rule = new XSD.Nworld_step.Nrule_group.events_rule();
      }
      return this.events_rule;
    }
    public void Set_events_rule(XSD.Nworld_step.Nrule_group.events_rule? value)
    {
      this.events_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.link_group_rule_list? Get_link_group_rule_list()
    {
      return this.link_group_rule_list;
    }
    public XSD.Nworld_step.Nrule_group.link_group_rule_list GetOrInsertDefault_link_group_rule_list()
    {
      if(this.link_group_rule_list == null) {
        this.link_group_rule_list = new XSD.Nworld_step.Nrule_group.link_group_rule_list();
      }
      return this.link_group_rule_list;
    }
    public void Set_link_group_rule_list(XSD.Nworld_step.Nrule_group.link_group_rule_list? value)
    {
      this.link_group_rule_list = value;
    }
    public XSD.Nworld_step.Nrule_group.location_graph_rule? Get_location_graph_rule()
    {
      return this.location_graph_rule;
    }
    public XSD.Nworld_step.Nrule_group.location_graph_rule GetOrInsertDefault_location_graph_rule()
    {
      if(this.location_graph_rule == null) {
        this.location_graph_rule = new XSD.Nworld_step.Nrule_group.location_graph_rule();
      }
      return this.location_graph_rule;
    }
    public void Set_location_graph_rule(XSD.Nworld_step.Nrule_group.location_graph_rule? value)
    {
      this.location_graph_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.location_classification_rule? Get_location_classification_rule()
    {
      return this.location_classification_rule;
    }
    public XSD.Nworld_step.Nrule_group.location_classification_rule GetOrInsertDefault_location_classification_rule()
    {
      if(this.location_classification_rule == null) {
        this.location_classification_rule = new XSD.Nworld_step.Nrule_group.location_classification_rule();
      }
      return this.location_classification_rule;
    }
    public void Set_location_classification_rule(XSD.Nworld_step.Nrule_group.location_classification_rule? value)
    {
      this.location_classification_rule = value;
    }
  }
}