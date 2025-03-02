using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule {
  public class from_person : XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.action_rule.from_person";
    public static string TagName = "from_person";

    public string NodeName {get =>"from_person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<from_person>> _callbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }

    //Children elements
    private type__person_selection? _selection = null;
    public type__person_selection selection
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

    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations? _mutations = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations mutations
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

    private XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person? _on_person = null;
    public XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person on_person
    {
      get
      {
        if(_on_person == null)
        {
          _on_person = new();
          _on_person.ParentNode = this;
          OnChange();
        }
        return _on_person;
      }
      set
      {
        _on_person = value;
        _on_person.ParentNode = this;
      }
    }
    public from_person()
    {
    }

    public from_person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from_person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<from_person> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from_person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      //Deserialize children
      selection = rawNode.InitializeWithRawNode("selection", selection);

      mutations = rawNode.InitializeWithRawNode("mutations", mutations);

      on_person = rawNode.InitializeWithRawNode("on_person", on_person);
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
      if(selection != null) {
        rawNode.children["selection"] = new List<RawNode> { selection.SerializeIntoRawNode() };
      }
      if(mutations != null) {
        rawNode.children["mutations"] = new List<RawNode> { mutations.SerializeIntoRawNode() };
      }
      if(on_person != null) {
        rawNode.children["on_person"] = new List<RawNode> { on_person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from_person");
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

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__person_selection.TagName))
      {
        this.selection ??= new type__person_selection();
        var childXPath = xpath.Substring(type__person_selection.TagName.Length + 3);
        this.selection.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations.TagName))
      {
        this.mutations ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations.TagName.Length + 3);
        this.mutations.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person.TagName))
      {
        this.on_person ??= new XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person.TagName.Length + 3);
        this.on_person.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__person_selection casted_selection) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.mutations casted_mutations) {
        return 0;
      }
      if(linkedNode is XSD.Nworld_step.Nrule_group.Naction_rule.Nfrom_person.on_person casted_on_person) {
        return 0;
      }
      return null;
    }
  }
}