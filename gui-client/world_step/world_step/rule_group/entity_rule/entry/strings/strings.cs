using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry {
  public class strings : IEquatable<strings>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.entity_rule.entry.strings";
    public static string TagName = "strings";

    public string NodeName {get =>"strings";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<strings>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string> _string = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string> string
    {
      get => _string;
      set
      {
        _string = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _string.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public strings()
    {
    }

    public strings(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public strings(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string> string)
      {
        this.string = string;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string>)
      {
        this.string = null;
      }
    }

    public Action OnSelfChange(Action<strings> callback)
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
      // Godot.GD.Print("Deserializing strings");
      //Deserialize arguments

      //Deserialize children
      string = rawNode.InitializeWithRawNode("string", string);
      string.OnAdd = (value) =>
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
      rawNode.children["string"] = string.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing strings");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.string.ContainsKey(pathIndex))
        {
          this.string[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string();
        this.string[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string casted_string) {
        return this._string.KeyOf(casted_string);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.Nstrings.string
      || false;
    }

    public bool Equals(strings? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (strings)obj;
        return Equals(string, other.string);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, string);
        return acc;
    }
  }
}