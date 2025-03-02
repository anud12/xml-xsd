using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__trigger {}
namespace XSD {
}
namespace XSD {
  public class type__trigger : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__trigger";
    public static string TagName = "type__trigger";

    public string NodeName {get =>"type__trigger";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__trigger>> _callbackList = new();

    //Attributes

    //Children elements
    private XSD.Ntype__trigger.person_action_used _person_action_used = new XSD.Ntype__trigger.person_action_used();
    public XSD.Ntype__trigger.person_action_used person_action_used
    {
      get
      {
        if(_person_action_used == null)
        {
          _person_action_used = new();
          _person_action_used.ParentNode = this;
          OnChange();
        }
        return _person_action_used;
      }
      set
      {
        _person_action_used = value;
        _person_action_used.ParentNode = this;
      }
    }
    public type__trigger()
    {
    }

    public type__trigger(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__trigger(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<type__trigger> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__trigger");
      //Deserialize arguments

      //Deserialize children
      person_action_used = rawNode.InitializeWithRawNode("person_action_used", person_action_used);
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(person_action_used != null) {
        rawNode.children["person_action_used"] = new List<RawNode> { person_action_used.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__trigger");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__trigger.person_action_used.TagName))
      {
        var childXPath = xpath.Substring(XSD.Ntype__trigger.person_action_used.TagName.Length + 3);
        this.person_action_used.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__trigger.person_action_used casted_person_action_used) {
        return 0;
      }
      return null;
    }
  }
}