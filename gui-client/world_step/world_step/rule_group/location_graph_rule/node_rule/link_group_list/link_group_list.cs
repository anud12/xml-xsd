using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule {
  public class link_group_list : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.location_graph_rule.node_rule.link_group_list";
    public static string TagName = "link_group_list";

    public string NodeName {get =>"link_group_list";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<link_group_list>> _callbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference> _reference = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference> reference
    {
      get => _reference;
      set
      {
        _reference = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _reference.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group> _link_group = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group> link_group
    {
      get => _link_group;
      set
      {
        _link_group = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _link_group.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public link_group_list()
    {
    }

    public link_group_list(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_group_list(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<link_group_list> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group_list");
      //Deserialize arguments

      //Deserialize children
      reference = rawNode.InitializeWithRawNode("reference", reference);
      reference.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      link_group = rawNode.InitializeWithRawNode("link_group", link_group);
      link_group.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["reference"] = reference.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["link_group"] = link_group.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_group_list");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.reference.ContainsKey(pathIndex))
        {
          this.reference[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference();
        this.reference[pathIndex] = newEntry;
        newEntry.SetXPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.link_group.ContainsKey(pathIndex))
        {
          this.link_group[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group();
        this.link_group[pathIndex] = newEntry;
        newEntry.SetXPath(childXPath, rawNode);

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
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.reference casted_reference) {
        return this._reference.KeyOf(casted_reference);
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.link_group casted_link_group) {
        return this._link_group.KeyOf(casted_link_group);
      }
      return null;
    }
  }
}