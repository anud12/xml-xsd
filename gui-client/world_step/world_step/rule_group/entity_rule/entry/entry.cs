using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nentity_rule {
  public class entry : IEquatable<entry>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".world_step.rule_group.entity_rule.entry";
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
    private XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers? _containers = null;
    public XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers containersOrCreate
    {
      get
      {
        if(_containers == null)
        {
          _containers = new();
          _containers.ParentNode = this;
          NotifyChange();
        }
        return _containers;
      }
      set
      {
        _containers = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers? containers
    {
      get
      {
        return _containers;
      }
      set
      {
        _containers = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers containers)
      {
        this.containers = containers;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers)
      {
        this.containers = null;
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
      containers = rawNode.InitializeWithRawNode("containers", containers);
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
      if(containers != null) {
        rawNode.children["containers"] = new List<RawNode> { containers.SerializeIntoRawNode() };
      }
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
      if(xpath.StartsWith(XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers.TagName))
      {
        this.containers ??= new XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers();
        var childXPath = xpath.Substring(XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers.TagName.Length + 3);
        this.containers.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers casted_containers) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nworld_step.Nrule_group.Nentity_rule.Nentry.containers
      || false;
    }

    public bool Equals(entry? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (entry)obj;
        return Equals(name, other.name) && Equals(containers, other.containers);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, name);
        acc = HashCode.Combine(acc, containers);
        return acc;
    }
  }
}