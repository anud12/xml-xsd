using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class link_group_rule_list : IEquatable<link_group_rule_list>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.link_group_rule_list";
    public static string TagName = "link_group_rule_list";

    public string NodeName {get =>"link_group_rule_list";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<link_group_rule_list>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule> _link_group_rule = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule> link_group_rule
    {
      get => _link_group_rule;
      set
      {
        _link_group_rule = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _link_group_rule.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public link_group_rule_list()
    {
    }

    public link_group_rule_list(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_group_rule_list(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule> link_group_rule)
      {
        this.link_group_rule = link_group_rule;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule>)
      {
        this.link_group_rule = null;
      }
    }

    public Action OnSelfChange(Action<link_group_rule_list> callback)
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
      // Godot.GD.Print("Deserializing link_group_rule_list");
      //Deserialize arguments

      //Deserialize children
      link_group_rule = rawNode.InitializeWithRawNode("link_group_rule", link_group_rule);
      link_group_rule.OnAdd = (value) =>
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
      rawNode.children["link_group_rule"] = link_group_rule.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_group_rule_list");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.link_group_rule.ContainsKey(pathIndex))
        {
          this.link_group_rule[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule();
        this.link_group_rule[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule casted_link_group_rule) {
        return this._link_group_rule.KeyOf(casted_link_group_rule);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.link_group_rule
      || false;
    }

    public bool Equals(link_group_rule_list? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (link_group_rule_list)obj;
        return Equals(link_group_rule, other.link_group_rule);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, link_group_rule);
        return acc;
    }
  }
}