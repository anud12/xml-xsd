using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Ncontainer_rule {
  public class entry : IEquatable<entry>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.container_rule.entry";
    public static string TagName = "entry";

    public string NodeName {get =>"entry";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<entry>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _name;
    public System.String name { get => _name; set => _name = value; }

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity> _allowed_entity = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity> allowed_entity
    {
      get => _allowed_entity;
      set
      {
        _allowed_entity = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _allowed_entity.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "name")
      {
        Set_name(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity> allowed_entity)
      {
        this.allowed_entity = allowed_entity;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity>)
      {
        this.allowed_entity = null;
      }
    }

    public Action OnSelfChange(Action<entry> callback)
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
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("name"))
      {
        var attribute_name = rawNode.attributes["name"];
        this.name = rawNode.attributes["name"];
      }

      //Deserialize children
      allowed_entity = rawNode.InitializeWithRawNode("allowed_entity", allowed_entity);
      allowed_entity.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._name != null)
      {
        rawNode.attributes["name"] = this._name.ToString();
      }

      //Serialize children
      rawNode.children["allowed_entity"] = allowed_entity.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_name()
    {
      return this.name;
    }
    public void Set_name(System.String value)
    {
      this.name = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.allowed_entity.ContainsKey(pathIndex))
        {
          this.allowed_entity[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity();
        this.allowed_entity[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity casted_allowed_entity) {
        return this._allowed_entity.KeyOf(casted_allowed_entity);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Ncontainer_rule.Nentry.allowed_entity
      || false;
    }

    public bool Equals(entry? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (entry)obj;
        return Equals(name, other.name) && Equals(allowed_entity, other.allowed_entity);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, name);
        acc = HashCode.Combine(acc, allowed_entity);
        return acc;
    }
  }
}