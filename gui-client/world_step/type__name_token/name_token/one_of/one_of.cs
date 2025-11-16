using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__name_token.Nname_token.None_of {}
namespace XSD {
}
namespace XSD.Ntype__name_token.Nname_token {
  public class one_of : IEquatable<one_of>, XSD.ILinkedNode , Itype__name_token {

    public static string ClassTypeId = ".type__name_token.name_token.one_of";
    public static string TagName = "one_of";

    public string NodeName {get =>"one_of";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<one_of>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

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
          NotifyChange();
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

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }


    public Action OnSelfChange(Action<one_of> callback)
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
      // Godot.GD.Print("Deserializing one_of");
      //Deserialize arguments

      // Deserialize arguments of type__name_token


      //Deserialize children

      // Deserialize children of type__name_token
  name_token = rawNode.InitializeWithRawNode("name_token", name_token);
  name_token.OnAdd = (value) =>
    {
      value.ParentNode = this;
      NotifyChange();
    };
      NotifyChange();
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
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return false;
    }

        public bool Equals(one_of? obj)
        {
            if (obj == null || GetType() != obj.GetType())
                return false;

            var other = (one_of)obj;
            return object.Equals(this, other);
        }

    public int GetHashCode()
    {
        return base.GetHashCode();
    }
  }
}