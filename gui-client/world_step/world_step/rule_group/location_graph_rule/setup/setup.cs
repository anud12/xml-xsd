using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule {
  public class setup : IEquatable<setup>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.location_graph_rule.setup";
    public static string TagName = "setup";

    public string NodeName {get =>"setup";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<setup>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node _starting_node = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node();
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node starting_nodeOrCreate
    {
      get
      {
        if(_starting_node == null)
        {
          _starting_node = new();
          _starting_node.ParentNode = this;
          NotifyChange();
        }
        return _starting_node;
      }
      set
      {
        _starting_node = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node starting_node
    {
      get
      {
        return _starting_node;
      }
      set
      {
        _starting_node = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
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
          NotifyChange();
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

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node starting_node)
      {
        this.starting_node = starting_node;
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node> necessary_node)
      {
        this.necessary_node = necessary_node;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node)
      {
        this.starting_node = new();
      }


      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node>)
      {
        this.necessary_node = null;
      }
    }


    public Action OnSelfChange(Action<setup> callback)
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
      // Godot.GD.Print("Deserializing setup");
      //Deserialize arguments

      //Deserialize children
      starting_node = rawNode.InitializeWithRawNode("starting_node", starting_node);

      necessary_node = rawNode.InitializeWithRawNode("necessary_node", necessary_node);
      necessary_node.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      NotifyChange();
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


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node.TagName))
      {
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node.TagName.Length + 3);
        this.starting_node.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.necessary_node.ContainsKey(pathIndex))
        {
          this.necessary_node[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node();
        this.necessary_node[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node casted_starting_node) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node casted_necessary_node) {
        return this._necessary_node.KeyOf(casted_necessary_node);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.starting_node
      || candidateChild is XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.necessary_node
      || false;
    }

    public bool Equals(setup? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (setup)obj;
        return Equals(starting_node, other.starting_node) && Equals(necessary_node, other.necessary_node);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, starting_node);
        acc = HashCode.Combine(acc, necessary_node);
        return acc;
    }
  }
}