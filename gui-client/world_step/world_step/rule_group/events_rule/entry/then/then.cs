using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry {
  public class then : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.events_rule.entry.then";
    public static string TagName = "then";

    public string NodeName {get =>"then";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<then>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person> _select_person = new();
    public LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person> select_person
    {
      get => _select_person;
      set
      {
        _select_person = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _select_person.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    private XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation? _property_mutation = null;
    public XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation property_mutation
    {
      get
      {
        if(_property_mutation == null)
        {
          _property_mutation = new();
          _property_mutation.ParentNode = this;
          NotifyChange();
        }
        return _property_mutation;
      }
      set
      {
        _property_mutation = value;
        _property_mutation.ParentNode = this;
      }
    }
    public then()
    {
    }

    public then(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public then(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person> select_person)
      {
        this.select_person = select_person;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation property_mutation)
      {
        this.property_mutation = property_mutation;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person>)
      {
        this.select_person = null;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation)
      {
        this.property_mutation = null;
      }

    }

    public Action OnSelfChange(Action<then> callback)
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
      // Godot.GD.Print("Deserializing then");
      //Deserialize arguments

      //Deserialize children
      select_person = rawNode.InitializeWithRawNode("select_person", select_person);
      select_person.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      property_mutation = rawNode.InitializeWithRawNode("property_mutation", property_mutation);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["select_person"] = select_person.Select(x => x.SerializeIntoRawNode()).ToList();
      if(property_mutation != null) {
        rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing then");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person.TagName + "["))
      {
        var startIndex = (XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.select_person.ContainsKey(pathIndex))
        {
          this.select_person[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person();
        this.select_person[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation.TagName))
      {
        this.property_mutation ??= new XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation.TagName.Length + 3);
        this.property_mutation.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.select_person casted_select_person) {
        return this._select_person.KeyOf(casted_select_person);
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nevents_rule.Nentry.Nthen.property_mutation casted_property_mutation) {
        return 0;
      }
      return null;
    }
  }
}