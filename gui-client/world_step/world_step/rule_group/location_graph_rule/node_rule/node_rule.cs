using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {
  public class node_rule : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.location_graph_rule.node_rule";
    public static string TagName = "node_rule";

    public string NodeName {get =>"node_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<node_rule>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name? _name = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name name
    {
      get
      {
        if(_name == null)
        {
          _name = new();
          _name.ParentNode = this;
          OnChange();
        }
        return _name;
      }
      set
      {
        _name = value;
        _name.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications? _classifications = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications classifications
    {
      get
      {
        if(_classifications == null)
        {
          _classifications = new();
          _classifications.ParentNode = this;
          OnChange();
        }
        return _classifications;
      }
      set
      {
        _classifications = value;
        _classifications.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list? _link_group_list = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list link_group_list
    {
      get
      {
        if(_link_group_list == null)
        {
          _link_group_list = new();
          _link_group_list.ParentNode = this;
          OnChange();
        }
        return _link_group_list;
      }
      set
      {
        _link_group_list = value;
        _link_group_list.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person? _existing_person = null;
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person existing_person
    {
      get
      {
        if(_existing_person == null)
        {
          _existing_person = new();
          _existing_person.ParentNode = this;
          OnChange();
        }
        return _existing_person;
      }
      set
      {
        _existing_person = value;
        _existing_person.ParentNode = this;
      }
    }
    public node_rule()
    {
    }

    public node_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public node_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<node_rule> callback)
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
      // Godot.GD.Print("Deserializing node_rule");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      name = rawNode.InitializeWithRawNode("name", name);

      classifications = rawNode.InitializeWithRawNode("classifications", classifications);

      link_group_list = rawNode.InitializeWithRawNode("link_group_list", link_group_list);

      existing_person = rawNode.InitializeWithRawNode("existing_person", existing_person);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      if(name != null) {
        rawNode.children["name"] = new List<RawNode> { name.SerializeIntoRawNode() };
      }
      if(classifications != null) {
        rawNode.children["classifications"] = new List<RawNode> { classifications.SerializeIntoRawNode() };
      }
      if(link_group_list != null) {
        rawNode.children["link_group_list"] = new List<RawNode> { link_group_list.SerializeIntoRawNode() };
      }
      if(existing_person != null) {
        rawNode.children["existing_person"] = new List<RawNode> { existing_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing node_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name.TagName))
      {
        this.name ??= new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name.TagName.Length + 3);
        this.name.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications.TagName))
      {
        this.classifications ??= new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications.TagName.Length + 3);
        this.classifications.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list.TagName))
      {
        this.link_group_list ??= new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list.TagName.Length + 3);
        this.link_group_list.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person.TagName))
      {
        this.existing_person ??= new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person.TagName.Length + 3);
        this.existing_person.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.name casted_name) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.classifications casted_classifications) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.link_group_list casted_link_group_list) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.existing_person casted_existing_person) {
        return 0;
      }
      return null;
    }
  }
}