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
  public class rule_group : IEquatable<rule_group>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group";
    public static string TagName = "rule_group";

    public string NodeName {get =>"rule_group";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<rule_group>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    private XSD.Nworld_step.Nrule_group.entity_rule? _entity_rule = null;
    public XSD.Nworld_step.Nrule_group.entity_rule entity_ruleOrCreate
    {
      get
      {
        if(_entity_rule == null)
        {
          _entity_rule = new();
          _entity_rule.ParentNode = this;
          NotifyChange();
        }
        return _entity_rule;
      }
      set
      {
        _entity_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.entity_rule? entity_rule
    {
      get
      {
        return _entity_rule;
      }
      set
      {
        _entity_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.container_rule? _container_rule = null;
    public XSD.Nworld_step.Nrule_group.container_rule container_ruleOrCreate
    {
      get
      {
        if(_container_rule == null)
        {
          _container_rule = new();
          _container_rule.ParentNode = this;
          NotifyChange();
        }
        return _container_rule;
      }
      set
      {
        _container_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.container_rule? container_rule
    {
      get
      {
        return _container_rule;
      }
      set
      {
        _container_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.classification_rule? _classification_rule = null;
    public XSD.Nworld_step.Nrule_group.classification_rule classification_ruleOrCreate
    {
      get
      {
        if(_classification_rule == null)
        {
          _classification_rule = new();
          _classification_rule.ParentNode = this;
          NotifyChange();
        }
        return _classification_rule;
      }
      set
      {
        _classification_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.classification_rule? classification_rule
    {
      get
      {
        return _classification_rule;
      }
      set
      {
        _classification_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.name_rule? _name_rule = null;
    public XSD.Nworld_step.Nrule_group.name_rule name_ruleOrCreate
    {
      get
      {
        if(_name_rule == null)
        {
          _name_rule = new();
          _name_rule.ParentNode = this;
          NotifyChange();
        }
        return _name_rule;
      }
      set
      {
        _name_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.name_rule? name_rule
    {
      get
      {
        return _name_rule;
      }
      set
      {
        _name_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.link_group_rule_list? _link_group_rule_list = null;
    public XSD.Nworld_step.Nrule_group.link_group_rule_list link_group_rule_listOrCreate
    {
      get
      {
        if(_link_group_rule_list == null)
        {
          _link_group_rule_list = new();
          _link_group_rule_list.ParentNode = this;
          NotifyChange();
        }
        return _link_group_rule_list;
      }
      set
      {
        _link_group_rule_list = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.link_group_rule_list? link_group_rule_list
    {
      get
      {
        return _link_group_rule_list;
      }
      set
      {
        _link_group_rule_list = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.location_graph_rule? _location_graph_rule = null;
    public XSD.Nworld_step.Nrule_group.location_graph_rule location_graph_ruleOrCreate
    {
      get
      {
        if(_location_graph_rule == null)
        {
          _location_graph_rule = new();
          _location_graph_rule.ParentNode = this;
          NotifyChange();
        }
        return _location_graph_rule;
      }
      set
      {
        _location_graph_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.location_graph_rule? location_graph_rule
    {
      get
      {
        return _location_graph_rule;
      }
      set
      {
        _location_graph_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.location_classification_rule? _location_classification_rule = null;
    public XSD.Nworld_step.Nrule_group.location_classification_rule location_classification_ruleOrCreate
    {
      get
      {
        if(_location_classification_rule == null)
        {
          _location_classification_rule = new();
          _location_classification_rule.ParentNode = this;
          NotifyChange();
        }
        return _location_classification_rule;
      }
      set
      {
        _location_classification_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.location_classification_rule? location_classification_rule
    {
      get
      {
        return _location_classification_rule;
      }
      set
      {
        _location_classification_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.node_rule? _node_rule = null;
    public XSD.Nworld_step.Nrule_group.node_rule node_ruleOrCreate
    {
      get
      {
        if(_node_rule == null)
        {
          _node_rule = new();
          _node_rule.ParentNode = this;
          NotifyChange();
        }
        return _node_rule;
      }
      set
      {
        _node_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.node_rule? node_rule
    {
      get
      {
        return _node_rule;
      }
      set
      {
        _node_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.portal_rule? _portal_rule = null;
    public XSD.Nworld_step.Nrule_group.portal_rule portal_ruleOrCreate
    {
      get
      {
        if(_portal_rule == null)
        {
          _portal_rule = new();
          _portal_rule.ParentNode = this;
          NotifyChange();
        }
        return _portal_rule;
      }
      set
      {
        _portal_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.portal_rule? portal_rule
    {
      get
      {
        return _portal_rule;
      }
      set
      {
        _portal_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.region_rule? _region_rule = null;
    public XSD.Nworld_step.Nrule_group.region_rule region_ruleOrCreate
    {
      get
      {
        if(_region_rule == null)
        {
          _region_rule = new();
          _region_rule.ParentNode = this;
          NotifyChange();
        }
        return _region_rule;
      }
      set
      {
        _region_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.region_rule? region_rule
    {
      get
      {
        return _region_rule;
      }
      set
      {
        _region_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.zone_rule? _zone_rule = null;
    public XSD.Nworld_step.Nrule_group.zone_rule zone_ruleOrCreate
    {
      get
      {
        if(_zone_rule == null)
        {
          _zone_rule = new();
          _zone_rule.ParentNode = this;
          NotifyChange();
        }
        return _zone_rule;
      }
      set
      {
        _zone_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.zone_rule? zone_rule
    {
      get
      {
        return _zone_rule;
      }
      set
      {
        _zone_rule = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Nworld_step.Nrule_group.scripts? _scripts = null;
    public XSD.Nworld_step.Nrule_group.scripts scriptsOrCreate
    {
      get
      {
        if(_scripts == null)
        {
          _scripts = new();
          _scripts.ParentNode = this;
          NotifyChange();
        }
        return _scripts;
      }
      set
      {
        _scripts = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.scripts? scripts
    {
      get
      {
        return _scripts;
      }
      set
      {
        _scripts = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
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

    public void SetAttribute(string name, string? value)
    {
      /* ignored attribute key={key} of type=System.Object*/
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.entity_rule entity_rule)
      {
        this.entity_rule = entity_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.container_rule container_rule)
      {
        this.container_rule = container_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.classification_rule classification_rule)
      {
        this.classification_rule = classification_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.name_rule name_rule)
      {
        this.name_rule = name_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.link_group_rule_list link_group_rule_list)
      {
        this.link_group_rule_list = link_group_rule_list;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.location_graph_rule location_graph_rule)
      {
        this.location_graph_rule = location_graph_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.location_classification_rule location_classification_rule)
      {
        this.location_classification_rule = location_classification_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.node_rule node_rule)
      {
        this.node_rule = node_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.portal_rule portal_rule)
      {
        this.portal_rule = portal_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.region_rule region_rule)
      {
        this.region_rule = region_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.zone_rule zone_rule)
      {
        this.zone_rule = zone_rule;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.scripts scripts)
      {
        this.scripts = scripts;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.entity_rule)
      {
        this.entity_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.container_rule)
      {
        this.container_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.classification_rule)
      {
        this.classification_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.name_rule)
      {
        this.name_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.link_group_rule_list)
      {
        this.link_group_rule_list = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.location_graph_rule)
      {
        this.location_graph_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.location_classification_rule)
      {
        this.location_classification_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.node_rule)
      {
        this.node_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.portal_rule)
      {
        this.portal_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.region_rule)
      {
        this.region_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.zone_rule)
      {
        this.zone_rule = null;
      }

      if(linkedNode is XSD.Nworld_step.Nrule_group.scripts)
      {
        this.scripts = null;
      }

    }

    public Action OnSelfChange(Action<rule_group> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }

    public Action OnSelfChangeNode(Action<ILinkedNode> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }


    public Action OnChange(Action<List<ILinkedNode>> callback)
    {
      _onChangeCallbackList.Add(callback);
      return () => _onChangeCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing rule_group");
      //Deserialize arguments

      //Deserialize children
      entity_rule = rawNode.InitializeWithRawNode("entity_rule", entity_rule);

      container_rule = rawNode.InitializeWithRawNode("container_rule", container_rule);

      classification_rule = rawNode.InitializeWithRawNode("classification_rule", classification_rule);

      name_rule = rawNode.InitializeWithRawNode("name_rule", name_rule);

      link_group_rule_list = rawNode.InitializeWithRawNode("link_group_rule_list", link_group_rule_list);

      location_graph_rule = rawNode.InitializeWithRawNode("location_graph_rule", location_graph_rule);

      location_classification_rule = rawNode.InitializeWithRawNode("location_classification_rule", location_classification_rule);

      node_rule = rawNode.InitializeWithRawNode("node_rule", node_rule);

      portal_rule = rawNode.InitializeWithRawNode("portal_rule", portal_rule);

      region_rule = rawNode.InitializeWithRawNode("region_rule", region_rule);

      zone_rule = rawNode.InitializeWithRawNode("zone_rule", zone_rule);

      scripts = rawNode.InitializeWithRawNode("scripts", scripts);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(entity_rule != null) {
        rawNode.children["entity_rule"] = new List<RawNode> { entity_rule.SerializeIntoRawNode() };
      }
      if(container_rule != null) {
        rawNode.children["container_rule"] = new List<RawNode> { container_rule.SerializeIntoRawNode() };
      }
      if(classification_rule != null) {
        rawNode.children["classification_rule"] = new List<RawNode> { classification_rule.SerializeIntoRawNode() };
      }
      if(name_rule != null) {
        rawNode.children["name_rule"] = new List<RawNode> { name_rule.SerializeIntoRawNode() };
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
      if(node_rule != null) {
        rawNode.children["node_rule"] = new List<RawNode> { node_rule.SerializeIntoRawNode() };
      }
      if(portal_rule != null) {
        rawNode.children["portal_rule"] = new List<RawNode> { portal_rule.SerializeIntoRawNode() };
      }
      if(region_rule != null) {
        rawNode.children["region_rule"] = new List<RawNode> { region_rule.SerializeIntoRawNode() };
      }
      if(zone_rule != null) {
        rawNode.children["zone_rule"] = new List<RawNode> { zone_rule.SerializeIntoRawNode() };
      }
      if(scripts != null) {
        rawNode.children["scripts"] = new List<RawNode> { scripts.SerializeIntoRawNode() };
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
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.entity_rule.TagName))
      {
        this.entity_rule ??= new XSD.Nworld_step.Nrule_group.entity_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.entity_rule.TagName.Length + 3);
        this.entity_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.container_rule.TagName))
      {
        this.container_rule ??= new XSD.Nworld_step.Nrule_group.container_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.container_rule.TagName.Length + 3);
        this.container_rule.DeserializeAtPath(childXPath, rawNode);
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
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.node_rule.TagName))
      {
        this.node_rule ??= new XSD.Nworld_step.Nrule_group.node_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.node_rule.TagName.Length + 3);
        this.node_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.portal_rule.TagName))
      {
        this.portal_rule ??= new XSD.Nworld_step.Nrule_group.portal_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.portal_rule.TagName.Length + 3);
        this.portal_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.region_rule.TagName))
      {
        this.region_rule ??= new XSD.Nworld_step.Nrule_group.region_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.region_rule.TagName.Length + 3);
        this.region_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.zone_rule.TagName))
      {
        this.zone_rule ??= new XSD.Nworld_step.Nrule_group.zone_rule();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.zone_rule.TagName.Length + 3);
        this.zone_rule.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.scripts.TagName))
      {
        this.scripts ??= new XSD.Nworld_step.Nrule_group.scripts();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.scripts.TagName.Length + 3);
        this.scripts.DeserializeAtPath(childXPath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }

    public void NotifyChange(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _onSelfChangeCallbackList.ForEach(action => action(this));
      _onChangeCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.NotifyChange(linkedNodes);
    }

    public void NotifyChange()
    {
      NotifyChange(new ());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.entity_rule casted_entity_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.container_rule casted_container_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.classification_rule casted_classification_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.name_rule casted_name_rule) {
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.node_rule casted_node_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.portal_rule casted_portal_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.region_rule casted_region_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.zone_rule casted_zone_rule) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.scripts casted_scripts) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.entity_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.container_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.classification_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.name_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.link_group_rule_list
      || candidateChild is XSD.Nworld_step.Nrule_group.location_graph_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.location_classification_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.node_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.portal_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.region_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.zone_rule
      || candidateChild is XSD.Nworld_step.Nrule_group.scripts
      || false;
    }

    public bool Equals(rule_group? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (rule_group)obj;
        return Equals(entity_rule, other.entity_rule) && Equals(container_rule, other.container_rule) && Equals(classification_rule, other.classification_rule) && Equals(name_rule, other.name_rule) && Equals(link_group_rule_list, other.link_group_rule_list) && Equals(location_graph_rule, other.location_graph_rule) && Equals(location_classification_rule, other.location_classification_rule) && Equals(node_rule, other.node_rule) && Equals(portal_rule, other.portal_rule) && Equals(region_rule, other.region_rule) && Equals(zone_rule, other.zone_rule) && Equals(scripts, other.scripts);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, entity_rule);
        acc = HashCode.Combine(acc, container_rule);
        acc = HashCode.Combine(acc, classification_rule);
        acc = HashCode.Combine(acc, name_rule);
        acc = HashCode.Combine(acc, link_group_rule_list);
        acc = HashCode.Combine(acc, location_graph_rule);
        acc = HashCode.Combine(acc, location_classification_rule);
        acc = HashCode.Combine(acc, node_rule);
        acc = HashCode.Combine(acc, portal_rule);
        acc = HashCode.Combine(acc, region_rule);
        acc = HashCode.Combine(acc, zone_rule);
        acc = HashCode.Combine(acc, scripts);
        return acc;
    }
  }
}