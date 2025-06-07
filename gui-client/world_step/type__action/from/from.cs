using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__action.Nfrom {}
namespace XSD {
}
namespace XSD.Ntype__action {
  public class from : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__action.from";
    public static string TagName = "from";

    public string NodeName {get =>"from";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<from>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements
    private XSD.Ntype__action.Nfrom.person? _person = null;
    public XSD.Ntype__action.Nfrom.person person
    {
      get
      {
        if(_person == null)
        {
          _person = new();
          _person.ParentNode = this;
          OnChange();
        }
        return _person;
      }
      set
      {
        _person = value;
        _person.ParentNode = this;
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

    public Action OnChangeBubble(Action<List<ILinkedNode>> callback)
    {
      _bubbleCallbackList.Add(callback);
      return () => _bubbleCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing from");
      //Deserialize arguments

      //Deserialize children
      person = rawNode.InitializeWithRawNode("person", person);
      OnChange();
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
      if(xpath.StartsWith(XSD.Ntype__action.Nfrom.person.TagName))
      {
        this.person ??= new XSD.Ntype__action.Nfrom.person();
        var childXPath = xpath.Substring(XSD.Ntype__action.Nfrom.person.TagName.Length + 3);
        this.person.DeserializeAtPath(childXPath, rawNode);
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
      _bubbleCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      if(linkedNode is XSD.Ntype__action.Nfrom.person casted_person) {
        return 0;
      }
      return null;
    }
  }
}