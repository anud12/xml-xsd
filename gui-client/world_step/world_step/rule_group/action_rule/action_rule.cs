using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class action_rule : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.action_rule";
    public static string TagName = "action_rule";

    public string NodeName {get =>"action_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<action_rule>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Naction_rule.from_person> _from_person = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Naction_rule.from_person> from_person
    {
      get => _from_person;
      set
      {
        _from_person = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _from_person.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    private XSD.Nworld_step.Nrule_group.Naction_rule.global? _global = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.global global
    {
      get
      {
        if(_global == null)
        {
          _global = new();
          _global.ParentNode = this;
          OnChange();
        }
        return _global;
      }
      set
      {
        _global = value;
        _global.ParentNode = this;
      }
    }
    public action_rule()
    {
    }

    public action_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public action_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<action_rule> callback)
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
      // Godot.GD.Print("Deserializing action_rule");
      //Deserialize arguments

      //Deserialize children
      from_person = rawNode.InitializeWithRawNode("from_person", from_person);
      from_person.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      global = rawNode.InitializeWithRawNode("global", global);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["from_person"] = from_person.Select(x => x.SerializeIntoRawNode()).ToList();
      if(global != null) {
        rawNode.children["global"] = new List<RawNode> { global.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing action_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.from_person.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Naction_rule.from_person.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Naction_rule.from_person.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Naction_rule.from_person.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.from_person.ContainsKey(pathIndex))
        {
          this.from_person[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Naction_rule.from_person();
        this.from_person[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.global.TagName))
      {
        this.global ??= new XSD.Nworld_step.Nrule_group.Naction_rule.global();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.global.TagName.Length + 3);
        this.global.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.from_person casted_from_person) {
        return this._from_person.KeyOf(casted_from_person);
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.global casted_global) {
        return 0;
      }
      return null;
    }
  }
}