using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person {
  public class on_person : XSD.ILinkedNode  {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/from_person/on_person";
    public static string TagName = "on_person";

    public string NodeName {get =>"on_person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<on_person>> _callbackList = new();

    //Attributes

    //Children elements
    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection? _selection = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection selection
    {
      get
      {
        if(_selection == null)
        {
          _selection = new();
          _selection.ParentNode = this;
          OnChange();
        }
        return _selection;
      }
      set
      {
        _selection = value;
        _selection.ParentNode = this;
      }
    }

    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations? _mutations = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations mutations
    {
      get
      {
        if(_mutations == null)
        {
          _mutations = new();
          _mutations.ParentNode = this;
          OnChange();
        }
        return _mutations;
      }
      set
      {
        _mutations = value;
        _mutations.ParentNode = this;
      }
    }
    public on_person()
    {
    }

    public on_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public on_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<on_person> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing on_person");
      //Deserialize arguments

      //Deserialize children
      selection = rawNode.InitializeWithRawNode("selection", selection);

      mutations = rawNode.InitializeWithRawNode("mutations", mutations);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(selection != null) {
        rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
      }
      if(mutations != null) {
        rawNode.children["mutations"] = new List<RawNode> { mutations.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing on_person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("/"))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection.TagName))
      {
        this.selection ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection.TagName.Length + 3);
        this.selection.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations.TagName))
      {
        this.mutations ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations.TagName.Length + 3);
        this.mutations.SetXPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.selection casted_selection) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.Non_person.mutations casted_mutations) {
        return 0;
      }
      return null;
    }
  }
}