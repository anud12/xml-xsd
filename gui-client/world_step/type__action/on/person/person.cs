using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__action.Non.Nperson {}
namespace XSD {
}
namespace XSD.Ntype__action.Non {
  public class person : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__action.on.person";
    public static string TagName = "person";

    public string NodeName {get =>"person";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<person>> _callbackList = new();

    //Attributes

    //Children elements
    private type__person_selection? _select = null;
    public type__person_selection select
    {
      get
      {
        if(_select == null)
        {
          _select = new();
          _select.ParentNode = this;
          OnChange();
        }
        return _select;
      }
      set
      {
        _select = value;
        _select.ParentNode = this;
      }
    }

    private type__property_mutation? _property_mutation = null;
    public type__property_mutation property_mutation
    {
      get
      {
        if(_property_mutation == null)
        {
          _property_mutation = new();
          _property_mutation.ParentNode = this;
          OnChange();
        }
        return _property_mutation;
      }
      set
      {
        _property_mutation = value;
        _property_mutation.ParentNode = this;
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

    public Action OnChange(Action<person> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments

      //Deserialize children
      select = rawNode.InitializeWithRawNode("select", select);

      property_mutation = rawNode.InitializeWithRawNode("property_mutation", property_mutation);
      OnChange();
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
      if(linkedNode is type__person_selection casted_select) {
        return 0;
      }
      if(linkedNode is type__property_mutation casted_property_mutation) {
        return 0;
      }
      return null;
    }
  }
}