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

    public static string ClassTypeId = "/world_step/rule_group";
    public static string TagName = "rule_group";

    public string Tag = "rule_group";
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    private XSD.Nworld_step.Nrule_group.property_rule? _property_rule = null;
    public XSD.Nworld_step.Nrule_group.property_rule? property_rule {
      get { return _property_rule; }
      set { _property_rule = value; }
    }

    private XSD.Nworld_step.Nrule_group.classification_rule? _classification_rule = null;
    public XSD.Nworld_step.Nrule_group.classification_rule? classification_rule {
      get { return _classification_rule; }
      set { _classification_rule = value; }
    }

    private XSD.Nworld_step.Nrule_group.name_rule? _name_rule = null;
    public XSD.Nworld_step.Nrule_group.name_rule? name_rule {
      get { return _name_rule; }
      set { _name_rule = value; }
    }

    private XSD.Nworld_step.Nrule_group.action_rule? _action_rule = null;
    public XSD.Nworld_step.Nrule_group.action_rule? action_rule {
      get { return _action_rule; }
      set { _action_rule = value; }
    }

    private XSD.Nworld_step.Nrule_group.events_rule? _events_rule = null;
    public XSD.Nworld_step.Nrule_group.events_rule? events_rule {
      get { return _events_rule; }
      set { _events_rule = value; }
    }

    private XSD.Nworld_step.Nrule_group.link_group_rule_list? _link_group_rule_list = null;
    public XSD.Nworld_step.Nrule_group.link_group_rule_list? link_group_rule_list {
      get { return _link_group_rule_list; }
      set { _link_group_rule_list = value; }
    }

    private XSD.Nworld_step.Nrule_group.location_graph_rule? _location_graph_rule = null;
    public XSD.Nworld_step.Nrule_group.location_graph_rule? location_graph_rule {
      get { return _location_graph_rule; }
      set { _location_graph_rule = value; }
    }

    private XSD.Nworld_step.Nrule_group.location_classification_rule? _location_classification_rule = null;
    public XSD.Nworld_step.Nrule_group.location_classification_rule? location_classification_rule {
      get { return _location_classification_rule; }
      set { _location_classification_rule = value; }
    }
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
      this._property_rule = rawNode.InitializeWithRawNode("property_rule", this._property_rule);
      this._classification_rule = rawNode.InitializeWithRawNode("classification_rule", this._classification_rule);
      this._name_rule = rawNode.InitializeWithRawNode("name_rule", this._name_rule);
      this._action_rule = rawNode.InitializeWithRawNode("action_rule", this._action_rule);
      this._events_rule = rawNode.InitializeWithRawNode("events_rule", this._events_rule);
      this._link_group_rule_list = rawNode.InitializeWithRawNode("link_group_rule_list", this._link_group_rule_list);
      this._location_graph_rule = rawNode.InitializeWithRawNode("location_graph_rule", this._location_graph_rule);
      this._location_classification_rule = rawNode.InitializeWithRawNode("location_classification_rule", this._location_classification_rule);
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
      return this._property_rule;
    }
    public XSD.Nworld_step.Nrule_group.property_rule GetOrInsertDefault_property_rule()
    {
      if(this._property_rule == null) {

        // true2
        this._property_rule = new XSD.Nworld_step.Nrule_group.property_rule();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_property_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_property_rule(XSD.Nworld_step.Nrule_group.property_rule? value)
    {
        this._property_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.classification_rule? Get_classification_rule()
    {
      return this._classification_rule;
    }
    public XSD.Nworld_step.Nrule_group.classification_rule GetOrInsertDefault_classification_rule()
    {
      if(this._classification_rule == null) {

        // true2
        this._classification_rule = new XSD.Nworld_step.Nrule_group.classification_rule();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_classification_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_classification_rule(XSD.Nworld_step.Nrule_group.classification_rule? value)
    {
        this._classification_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.name_rule? Get_name_rule()
    {
      return this._name_rule;
    }
    public XSD.Nworld_step.Nrule_group.name_rule GetOrInsertDefault_name_rule()
    {
      if(this._name_rule == null) {

        // true2
        this._name_rule = new XSD.Nworld_step.Nrule_group.name_rule();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_name_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_name_rule(XSD.Nworld_step.Nrule_group.name_rule? value)
    {
        this._name_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.action_rule? Get_action_rule()
    {
      return this._action_rule;
    }
    public XSD.Nworld_step.Nrule_group.action_rule GetOrInsertDefault_action_rule()
    {
      if(this._action_rule == null) {

        // true2
        this._action_rule = new XSD.Nworld_step.Nrule_group.action_rule();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_action_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_action_rule(XSD.Nworld_step.Nrule_group.action_rule? value)
    {
        this._action_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.events_rule? Get_events_rule()
    {
      return this._events_rule;
    }
    public XSD.Nworld_step.Nrule_group.events_rule GetOrInsertDefault_events_rule()
    {
      if(this._events_rule == null) {

        // true2
        this._events_rule = new XSD.Nworld_step.Nrule_group.events_rule();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_events_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_events_rule(XSD.Nworld_step.Nrule_group.events_rule? value)
    {
        this._events_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.link_group_rule_list? Get_link_group_rule_list()
    {
      return this._link_group_rule_list;
    }
    public XSD.Nworld_step.Nrule_group.link_group_rule_list GetOrInsertDefault_link_group_rule_list()
    {
      if(this._link_group_rule_list == null) {

        // true2
        this._link_group_rule_list = new XSD.Nworld_step.Nrule_group.link_group_rule_list();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_link_group_rule_list();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_link_group_rule_list(XSD.Nworld_step.Nrule_group.link_group_rule_list? value)
    {
        this._link_group_rule_list = value;
    }
    public XSD.Nworld_step.Nrule_group.location_graph_rule? Get_location_graph_rule()
    {
      return this._location_graph_rule;
    }
    public XSD.Nworld_step.Nrule_group.location_graph_rule GetOrInsertDefault_location_graph_rule()
    {
      if(this._location_graph_rule == null) {

        // true2
        this._location_graph_rule = new XSD.Nworld_step.Nrule_group.location_graph_rule();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_location_graph_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_location_graph_rule(XSD.Nworld_step.Nrule_group.location_graph_rule? value)
    {
        this._location_graph_rule = value;
    }
    public XSD.Nworld_step.Nrule_group.location_classification_rule? Get_location_classification_rule()
    {
      return this._location_classification_rule;
    }
    public XSD.Nworld_step.Nrule_group.location_classification_rule GetOrInsertDefault_location_classification_rule()
    {
      if(this._location_classification_rule == null) {

        // true2
        this._location_classification_rule = new XSD.Nworld_step.Nrule_group.location_classification_rule();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_location_classification_rule();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_location_classification_rule(XSD.Nworld_step.Nrule_group.location_classification_rule? value)
    {
        this._location_classification_rule = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.property_rule.TagName))
      {
        this.property_rule ??= new XSD.Nworld_step.Nrule_group.property_rule();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.property_rule.TagName.Length + 3);
        this.property_rule.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.classification_rule.TagName))
      {
        this.classification_rule ??= new XSD.Nworld_step.Nrule_group.classification_rule();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.classification_rule.TagName.Length + 3);
        this.classification_rule.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.name_rule.TagName))
      {
        this.name_rule ??= new XSD.Nworld_step.Nrule_group.name_rule();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.name_rule.TagName.Length + 3);
        this.name_rule.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.action_rule.TagName))
      {
        this.action_rule ??= new XSD.Nworld_step.Nrule_group.action_rule();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.action_rule.TagName.Length + 3);
        this.action_rule.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.events_rule.TagName))
      {
        this.events_rule ??= new XSD.Nworld_step.Nrule_group.events_rule();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.events_rule.TagName.Length + 3);
        this.events_rule.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.link_group_rule_list.TagName))
      {
        this.link_group_rule_list ??= new XSD.Nworld_step.Nrule_group.link_group_rule_list();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.link_group_rule_list.TagName.Length + 3);
        this.link_group_rule_list.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.location_graph_rule.TagName))
      {
        this.location_graph_rule ??= new XSD.Nworld_step.Nrule_group.location_graph_rule();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.location_graph_rule.TagName.Length + 3);
        this.location_graph_rule.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.location_classification_rule.TagName))
      {
        this.location_classification_rule ??= new XSD.Nworld_step.Nrule_group.location_classification_rule();
        xpath = xpath.Substring(XSD.Nworld_step.Nrule_group.location_classification_rule.TagName.Length + 3);
        this.location_classification_rule.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}