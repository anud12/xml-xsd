using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry {
  public class containers : IEquatable<containers>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.entity_rule.entry.containers";
    public static string TagName = "containers";

    public string NodeName {get =>"containers";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<containers>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container> _container = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container> container
    {
      get => _container;
      set
      {
        _container = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _container.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public containers()
    {
    }

    public containers(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public containers(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container> container)
      {
        this.container = container;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container>)
      {
        this.container = null;
      }
    }

    public Action OnSelfChange(Action<containers> callback)
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
      // Godot.GD.Print("Deserializing containers");
      //Deserialize arguments

      //Deserialize children
      container = rawNode.InitializeWithRawNode("container", container);
      container.OnAdd = (value) =>
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
      rawNode.children["container"] = container.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing containers");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.container.ContainsKey(pathIndex))
        {
          this.container[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container();
        this.container[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container casted_container) {
        return this._container.KeyOf(casted_container);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Ncontainers.container
      || false;
    }

    public bool Equals(containers? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (containers)obj;
        return Equals(container, other.container);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, container);
        return acc;
    }
  }
}