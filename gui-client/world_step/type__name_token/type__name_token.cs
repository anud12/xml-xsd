using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__name_token {}
namespace XSD {
}
namespace XSD {
  public class type__name_token : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__name_token";
    public static string TagName = "type__name_token";

    public string NodeName {get =>"type__name_token";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__name_token>> _callbackList = new();
    private List<Action<List<ILinkedNode>>> _bubbleCallbackList = new();

    //Attributes

    //Children elements

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
    public type__name_token()
    {
    }

    public type__name_token(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__name_token(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public Action OnChange(Action<type__name_token> callback)
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
      // Godot.GD.Print("Deserializing type__name_token");
      //Deserialize arguments

      //Deserialize children
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

      //Serialize children
      rawNode.children["name_token"] = name_token.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__name_token");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__name_token.name_token.TagName + "["))
      {
        var startIndex = (XSD.Ntype__name_token.name_token.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Ntype__name_token.name_token.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Ntype__name_token.name_token.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.name_token.ContainsKey(pathIndex))
        {
          this.name_token[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Ntype__name_token.name_token();
        this.name_token[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Ntype__name_token.name_token casted_name_token) {
        return this._name_token.KeyOf(casted_name_token);
      }
      return null;
    }
  }
}