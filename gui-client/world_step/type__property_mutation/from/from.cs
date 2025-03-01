using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__property_mutation.Nfrom {}
namespace XSD {
}
namespace XSD.Ntype__property_mutation {
  public class from : XSD.ILinkedNode  {

    public static string ClassTypeId = "/type__property_mutation/from";
    public static string TagName = "from";

    public string NodeName {get =>"from";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<from>> _callbackList = new();

    //Attributes
    private System.String _participant;
    public System.String participant { get => _participant; set => _participant = value; }

    //Children elements
    private type__math_operations _operation = new type__math_operations();
    public type__math_operations operation
    {
      get
      {
        if(_operation == null)
        {
          _operation = new();
          _operation.ParentNode = this;
          OnChange();
        }
        return _operation;
      }
      set
      {
        _operation = value;
        _operation.ParentNode = this;
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

    public Action OnChange(Action<from> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
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
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.participant != null)
      {
        rawNode.attributes["participant"] = this.participant.ToString();
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
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("/"))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(type__math_operations.TagName))
      {
        var childXPath = xpath.Substring(type__math_operations.TagName.Length + 3);
        this.operation.SetXPath(childXPath, rawNode);
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
      if(linkedNode is type__math_operations casted_operation) {
        return 0;
      }
      return null;
    }
  }
}