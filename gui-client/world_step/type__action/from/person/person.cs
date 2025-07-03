using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__action.Nfrom.Nperson {}
namespace XSD {
}
namespace XSD.Ntype__action.Nfrom {
  public class person : IEquatable<person>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__action.from.person";
    public static string TagName = "person";

    public string NodeName {get =>"person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private type__person_selection? _select = null;
    public type__person_selection selectOrCreate
    {
      get
      {
        if(_select == null)
        {
          _select = new();
          _select.ParentNode = this;
          NotifyChange();
        }
        return _select;
      }
      set
      {
        _select = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__person_selection? select
    {
      get
      {
        return _select;
      }
      set
      {
        _select = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private type__property_mutation? _property_mutation = null;
    public type__property_mutation property_mutationOrCreate
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
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__property_mutation? property_mutation
    {
      get
      {
        return _property_mutation;
      }
      set
      {
        _property_mutation = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public person()
    {
    }

    public person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__person_selection select)
      {
        this.select = select;
      }

      if(linkedNode is type__property_mutation property_mutation)
      {
        this.property_mutation = property_mutation;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__person_selection)
      {
        this.select = null;
      }

      if(linkedNode is type__property_mutation)
      {
        this.property_mutation = null;
      }

    }

    public Action OnSelfChange(Action<person> callback)
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
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments

      //Deserialize children
      select = rawNode.InitializeWithRawNode("select", select);

      property_mutation = rawNode.InitializeWithRawNode("property_mutation", property_mutation);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(select != null) {
        rawNode.children["select"] = new List<RawNode> { select.SerializeIntoRawNode() };
      }
      if(property_mutation != null) {
        rawNode.children["property_mutation"] = new List<RawNode> { property_mutation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__person_selection.TagName))
      {
        this.select ??= new type__person_selection();
        var childXPath = xpath.Substring(type__person_selection.TagName.Length + 3);
        this.select.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(type__property_mutation.TagName))
      {
        this.property_mutation ??= new type__property_mutation();
        var childXPath = xpath.Substring(type__property_mutation.TagName.Length + 3);
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
      if(linkedNode is type__person_selection casted_select) {
        return 0;
      }
      if(linkedNode is type__property_mutation casted_property_mutation) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is type__person_selection
      || candidateChild is type__property_mutation
      || false;
    }

    public bool Equals(person? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (person)obj;
        return Equals(select, other.select) && Equals(property_mutation, other.property_mutation);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, select);
        acc = HashCode.Combine(acc, property_mutation);
        return acc;
    }
  }
}