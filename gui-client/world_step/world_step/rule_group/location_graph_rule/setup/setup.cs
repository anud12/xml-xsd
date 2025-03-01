using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {
  public class setup : XSD.ILinkedNode  {

    public static string ClassTypeId = "/world_step/rule_group/location_graph_rule/setup";
    public static string TagName = "setup";

    public string NodeName {get =>"setup";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<setup>> _callbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node _starting_node = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node();
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node starting_node
    {
      get
      {
        if(_starting_node == null)
        {
          _starting_node = new();
          _starting_node.ParentNode = this;
          OnChange();
        }
        return _starting_node;
      }
      set
      {
        _starting_node = value;
        _starting_node.ParentNode = this;
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node> _necessary_node = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node> necessary_node
    {
      get => _necessary_node;
      set
      {
        _necessary_node = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _necessary_node.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public setup()
    {
    }

    public setup(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public setup(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<setup> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing setup");
      //Deserialize arguments

      //Deserialize children
      starting_node = rawNode.InitializeWithRawNode("starting_node", starting_node);

      necessary_node = rawNode.InitializeWithRawNode("necessary_node", necessary_node);
      necessary_node.OnAdd = (value) =>
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
      if(starting_node != null) {
        rawNode.children["starting_node"] = new List<RawNode> { starting_node.SerializeIntoRawNode() };
      }
      rawNode.children["necessary_node"] = necessary_node.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing setup");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("/"))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node.TagName.Length + 3);
        this.starting_node.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.necessary_node.ContainsKey(pathIndex))
        {
          this.necessary_node[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node();
        this.necessary_node[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node casted_starting_node) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node casted_necessary_node) {
        return this._necessary_node.KeyOf(casted_necessary_node);
      }
      return null;
    }
  }
}