using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group {}
namespace XSD {
}
namespace XSD.Nworld_step {
  public class rule_group : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group";
    public static string TagName = "rule_group";

    public string NodeName {get =>"rule_group";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<rule_group>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    private XSD.Nworld_step.Nrule_group.property_rule? _property_rule = null;
    public XSD.Nworld_step.Nrule_group.property_rule property_rule
    {
      get
      {
        if(_property_rule == null)
        {
          _property_rule = new();
          _property_rule.ParentNode = this;
          OnChange();
        }
        return _property_rule;
      }
      set
      {
        _property_rule = value;
        _property_rule.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.classification_rule? _classification_rule = null;
    public XSD.Nworld_step.Nrule_group.classification_rule classification_rule
    {
      get
      {
        if(_classification_rule == null)
        {
          _classification_rule = new();
          _classification_rule.ParentNode = this;
          OnChange();
        }
        return _classification_rule;
      }
      set
      {
        _classification_rule = value;
        _classification_rule.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.name_rule? _name_rule = null;
    public XSD.Nworld_step.Nrule_group.name_rule name_rule
    {
      get
      {
        if(_name_rule == null)
        {
          _name_rule = new();
          _name_rule.ParentNode = this;
          OnChange();
        }
        return _name_rule;
      }
      set
      {
        _name_rule = value;
        _name_rule.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.action_rule? _action_rule = null;
    public XSD.Nworld_step.Nrule_group.action_rule action_rule
    {
      get
      {
        if(_action_rule == null)
        {
          _action_rule = new();
          _action_rule.ParentNode = this;
          OnChange();
        }
        return _action_rule;
      }
      set
      {
        _action_rule = value;
        _action_rule.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.events_rule? _events_rule = null;
    public XSD.Nworld_step.Nrule_group.events_rule events_rule
    {
      get
      {
        if(_events_rule == null)
        {
          _events_rule = new();
          _events_rule.ParentNode = this;
          OnChange();
        }
        return _events_rule;
      }
      set
      {
        _events_rule = value;
        _events_rule.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.link_group_rule_list? _link_group_rule_list = null;
    public XSD.Nworld_step.Nrule_group.link_group_rule_list link_group_rule_list
    {
      get
      {
        if(_link_group_rule_list == null)
        {
          _link_group_rule_list = new();
          _link_group_rule_list.ParentNode = this;
          OnChange();
        }
        return _link_group_rule_list;
      }
      set
      {
        _link_group_rule_list = value;
        _link_group_rule_list.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.location_graph_rule? _location_graph_rule = null;
    public XSD.Nworld_step.Nrule_group.location_graph_rule location_graph_rule
    {
      get
      {
        if(_location_graph_rule == null)
        {
          _location_graph_rule = new();
          _location_graph_rule.ParentNode = this;
          OnChange();
        }
        return _location_graph_rule;
      }
      set
      {
        _location_graph_rule = value;
        _location_graph_rule.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.location_classification_rule? _location_classification_rule = null;
    public XSD.Nworld_step.Nrule_group.location_classification_rule location_classification_rule
    {
      get
      {
        if(_location_classification_rule == null)
        {
          _location_classification_rule = new();
          _location_classification_rule.ParentNode = this;
          OnChange();
        }
        return _location_classification_rule;
      }
      set
      {
        _location_classification_rule = value;
        _location_classification_rule.ParentNode = this;
      }
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

    public Action OnChange(Action<rule_group> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public Action OnChangeBubble(Action<List<ILinkedNode>> callback)
    {
      _bubbleCallbackList.Add(callback);
      return () => _bubbleCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing rule_group");
      //Deserialize arguments

      //Deserialize children
      property_rule = rawNode.InitializeWithRawNode("property_rule", property_rule);

      classification_rule = rawNode.InitializeWithRawNode("classification_rule", classification_rule);

      name_rule = rawNode.InitializeWithRawNode("name_rule", name_rule);

      action_rule = rawNode.InitializeWithRawNode("action_rule", action_rule);

      events_rule = rawNode.InitializeWithRawNode("events_rule", events_rule);

      link_group_rule_list = rawNode.InitializeWithRawNode("link_group_rule_list", link_group_rule_list);

      location_graph_rule = rawNode.InitializeWithRawNode("location_graph_rule", location_graph_rule);

      location_classification_rule = rawNode.InitializeWithRawNode("location_classification_rule", location_classification_rule);
      OnChange();
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

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.property_rule.TagName))
      {
        this.property_rule ??= new XSD.Nworld_step.Nrule_group.property_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.property_rule.TagName.Length + 3);
        this.property_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.classification_rule.TagName))
      {
        this.classification_rule ??= new XSD.Nworld_step.Nrule_group.classification_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.classification_rule.TagName.Length + 3);
        this.classification_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.name_rule.TagName))
      {
        this.name_rule ??= new XSD.Nworld_step.Nrule_group.name_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.name_rule.TagName.Length + 3);
        this.name_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.action_rule.TagName))
      {
        this.action_rule ??= new XSD.Nworld_step.Nrule_group.action_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.action_rule.TagName.Length + 3);
        this.action_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.events_rule.TagName))
      {
        this.events_rule ??= new XSD.Nworld_step.Nrule_group.events_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.events_rule.TagName.Length + 3);
        this.events_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.link_group_rule_list.TagName))
      {
        this.link_group_rule_list ??= new XSD.Nworld_step.Nrule_group.link_group_rule_list();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.link_group_rule_list.TagName.Length + 3);
        this.link_group_rule_list.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.location_graph_rule.TagName))
      {
        this.location_graph_rule ??= new XSD.Nworld_step.Nrule_group.location_graph_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.location_graph_rule.TagName.Length + 3);
        this.location_graph_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.location_classification_rule.TagName))
      {
        this.location_classification_rule ??= new XSD.Nworld_step.Nrule_group.location_classification_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.location_classification_rule.TagName.Length + 3);
        this.location_classification_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }

    public void ChildChanged(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _callbackList.ForEach(action => action(this));
      _bubbleCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.property_rule casted_property_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.classification_rule casted_classification_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.name_rule casted_name_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.action_rule casted_action_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.events_rule casted_events_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.link_group_rule_list casted_link_group_rule_list) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.location_graph_rule casted_location_graph_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.location_classification_rule casted_location_classification_rule) {
        return 0;
      }
      return null;
    }
  }
}