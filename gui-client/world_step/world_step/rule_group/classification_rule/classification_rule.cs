using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nclassification_rule {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group {
  public class classification_rule : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.classification_rule";
    public static string TagName = "classification_rule";

    public string NodeName {get =>"classification_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<classification_rule>> _callbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry> _entry = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nclassification_rule.entry> entry
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
    public classification_rule()
    {
    }

    public classification_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public classification_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<classification_rule> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing classification_rule");
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
        // Godot.GD.Print("Serializing classification_rule");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nclassification_rule.entry.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nclassification_rule.entry.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.entry.ContainsKey(pathIndex))
        {
          this.entry[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nclassification_rule.entry();
        this.entry[pathIndex] = newEntry;
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nclassification_rule.entry casted_entry) {
        return this._entry.KeyOf(casted_entry);
      }
      return null;
    }
  }
}