using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__property_mutation.Nfrom {}
namespace XSD {
}
namespace XSD.Ntype__property_mutation {
  public class from : IEquatable<from>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__property_mutation.from";
    public static string TagName = "from";

    public string NodeName {get =>"from";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<from>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _participant;
    public System.String participant { get => _participant; set => _participant = value; }

    //Children elements
    private type__math_operations _operation = new type__math_operations();
    public type__math_operations operationOrCreate
    {
      get
      {
        if(_operation == null)
        {
          _operation = new();
          _operation.ParentNode = this;
          NotifyChange();
        }
        return _operation;
      }
      set
      {
        _operation = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public type__math_operations operation
    {
      get
      {
        return _operation;
      }
      set
      {
        _operation = value;
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
      if(name == "participant")
      {
        Set_participant(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations operation)
      {
        this.operation = operation;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is type__math_operations)
      {
        this.operation = new();
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
      if(rawNode.attributes.ContainsKey("participant"))
      {
        var attribute_participant = rawNode.attributes["participant"];
        this.participant = rawNode.attributes["participant"];
      }

      //Deserialize children
      operation = rawNode.InitializeWithRawNode("operation", operation);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._participant != null)
      {
        rawNode.attributes["participant"] = this._participant.ToString();
      }

      //Serialize children
      if(operation != null) {
        rawNode.children["operation"] = new List<RawNode> { operation.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing from");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_participant()
    {
      return this.participant;
    }
    public void Set_participant(System.String value)
    {
      this.participant = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.operation.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is type__math_operations casted_operation) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is type__math_operations
      || false;
    }

    public bool Equals(from? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (from)obj;
        return Equals(participant, other.participant) && Equals(operation, other.operation);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, participant);
        acc = HashCode.Combine(acc, operation);
        return acc;
    }
  }
}