using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule {
  public class global : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.action_rule.global";
    public static string TagName = "global";

    public string NodeName {get =>"global";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<global>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry> _entry = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry> entry
    {
      get => _entry;
      set
      {
        _entry = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _entry.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public global()
    {
    }

    public global(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public global(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<global> callback)
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
      // Godot.GD.Print("Deserializing global");
      //Deserialize arguments

      //Deserialize children
      entry = rawNode.InitializeWithRawNode("entry", entry);
      entry.OnAdd = (value) =>
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
      rawNode.children["entry"] = entry.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing global");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.entry.ContainsKey(pathIndex))
        {
          this.entry[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry();
        this.entry[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.entry casted_entry) {
        return this._entry.KeyOf(casted_entry);
      }
      return null;
    }
  }
}