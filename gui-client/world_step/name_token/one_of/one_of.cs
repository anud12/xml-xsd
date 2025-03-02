using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nname_token.None_of {}
namespace XSD {
}
namespace XSD.Nname_token {
  public class one_of : XSD.ILinkedNode , Itype__name_token {

    public static string ClassTypeId = ".name_token.one_of";
    public static string TagName = "one_of";

    public string NodeName {get =>"one_of";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<one_of>> _callbackList = new();

    //Attributes

    //Attributes of type__name_token

    //Children elements

    //Children of type__name_token

    private LinkedNodeCollection<XSD.Ntype__name_token.name_token> _name_token = new();
    public LinkedNodeCollection<XSD.Ntype__name_token.name_token> name_token
    {
      get => _name_token;
      set
      {
        _name_token = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _name_token.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
      }
    }
    public one_of()
    {
    }

    public one_of(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public one_of(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<one_of> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing one_of");
      //Deserialize arguments

      // Deserialize arguments of type__name_token


      //Deserialize children

      // Deserialize children of type__name_token
  name_token = rawNode.InitializeWithRawNode("name_token", name_token);
  name_token.OnAdd = (value) =>
    {
      value.ParentNode = this;
      OnChange();
    };
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__name_token


      //Serialize children

      // Serialize children of type__name_token
  rawNode.children["name_token"] = name_token.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing one_of");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
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
      return null;
    }
  }
}