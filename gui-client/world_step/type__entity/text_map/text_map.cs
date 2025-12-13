using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__entity.Ntext_map {}
namespace XSD {
}
namespace XSD.Ntype__entity {
  public class text_map : IEquatable<text_map>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__entity.text_map";
    public static string TagName = "text_map";

    public string NodeName {get =>"text_map";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<text_map>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Children elements

    private LinkedNodeCollection<XSD.Ntype__entity.Ntext_map.text> _text = new();
    public LinkedNodeCollection<XSD.Ntype__entity.Ntext_map.text> text
    {
      get => _text;
      set
      {
        _text = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _text.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      }
    }
    public text_map()
    {
    }

    public text_map(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public text_map(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Ntype__entity.Ntext_map.text> text)
      {
        this.text = text;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Ntype__entity.Ntext_map.text>)
      {
        this.text = null;
      }
    }

    public Action OnSelfChange(Action<text_map> callback)
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
      // Godot.GD.Print("Deserializing text_map");
      //Deserialize arguments

      //Deserialize children
      text = rawNode.InitializeWithRawNode("text", text);
      text.OnAdd = (value) =>
        {
          value.ParentNode = this;
          NotifyChange();
        };
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["text"] = text.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing text_map");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__entity.Ntext_map.text.TagName + "["))
      {
        var startIndex = (XSD.Ntype__entity.Ntext_map.text.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Ntype__entity.Ntext_map.text.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Ntype__entity.Ntext_map.text.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.text.ContainsKey(pathIndex))
        {
          this.text[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Ntype__entity.Ntext_map.text();
        this.text[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

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
      if(linkedNode is XSD.Ntype__entity.Ntext_map.text casted_text) {
        return this._text.KeyOf(casted_text);
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Ntype__entity.Ntext_map.text
      || false;
    }

    public bool Equals(text_map? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (text_map)obj;
        return Equals(text, other.text);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, text);
        return acc;
    }
  }
}