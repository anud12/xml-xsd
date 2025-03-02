using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule {
  public class entry : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.events_rule.entry";
    public static string TagName = "entry";

    public string NodeName {get =>"entry";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<entry>> _callbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements

    private LinkedNodeCollection<type__trigger> _when = new();
    public LinkedNodeCollection<type__trigger> when
    {
      get => _when;
      set
      {
        _when = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _when.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> _then = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then> then
    {
      get => _then;
      set
      {
        _then = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _then.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
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

    public Action OnChange(Action<entry> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      when = rawNode.InitializeWithRawNode("when", when);
      when.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      then = rawNode.InitializeWithRawNode("then", then);
      then.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      //Serialize children
      rawNode.children["when"] = when.Select(x => x.SerializeIntoRawNode()).ToList();
      rawNode.children["then"] = then.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__trigger.TagName + "["))
      {
        var startIndex = (type__trigger.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.when.ContainsKey(pathIndex))
        {
          this.when[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new type__trigger();
        this.when[pathIndex] = newEntry;
        newEntry.SetXPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, 1);
        var childXPath = xpath.Substring(startIndex + 2);
        var pathIndex = indexString.ToInt();
        if(this.then.ContainsKey(pathIndex))
        {
          this.then[pathIndex].SetXPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then();
        this.then[pathIndex] = newEntry;
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
      if(linkedNode is type__trigger casted_when) {
        return this._when.KeyOf(casted_when);
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.then casted_then) {
        return this._then.KeyOf(casted_then);
      }
      return null;
    }
  }
}