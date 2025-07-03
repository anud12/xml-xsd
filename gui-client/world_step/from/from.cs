using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nfrom {}
namespace XSD {
}
namespace XSD {
  public class from : IEquatable<from>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".from";
    public static string TagName = "from";

    public string NodeName {get =>"from";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<from>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Nfrom.person? _person = null;
    public XSD.Nfrom.person personOrCreate
    {
      get
      {
        if(_person == null)
        {
          _person = new();
          _person.ParentNode = this;
          NotifyChange();
        }
        return _person;
      }
      set
      {
        _person = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Nfrom.person? person
    {
      get
      {
        return _person;
      }
      set
      {
        _person = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public from()
    {
    }

    public from(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public from(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nfrom.person person)
      {
        this.person = person;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Nfrom.person)
      {
        this.person = null;
      }

    }

    public Action OnSelfChange(Action<from> callback)
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
      // Godot.GD.Print("Deserializing from");
      //Deserialize arguments

      //Deserialize children
      person = rawNode.InitializeWithRawNode("person", person);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(person != null) {
        rawNode.children["person"] = new List<RawNode> { person.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nfrom.person.TagName))
      {
        this.person ??= new XSD.Nfrom.person();
        var childXPath = xpath.Substring(XSD.Nfrom.person.TagName.Length + 3);
        this.person.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nfrom.person casted_person) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Nfrom.person
      || false;
    }

    public bool Equals(from? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (from)obj;
        return Equals(person, other.person);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, person);
        return acc;
    }
  }
}