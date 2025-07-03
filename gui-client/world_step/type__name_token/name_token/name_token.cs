using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__name_token.Nname_token {}
namespace XSD {
}
namespace XSD.Ntype__name_token {
  public class name_token : IEquatable<name_token>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__name_token.name_token";
    public static string TagName = "name_token";

    public string NodeName {get =>"name_token";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<name_token>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _prefix;
    public System.String prefix { get => _prefix; set => _prefix = value; }

    //Children elements
    private XSD.Ntype__name_token.Nname_token._ref? __ref = null;
    public XSD.Ntype__name_token.Nname_token._ref _refOrCreate
    {
      get
      {
        if(__ref == null)
        {
          __ref = new();
          __ref.ParentNode = this;
          NotifyChange();
        }
        return __ref;
      }
      set
      {
        __ref = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__name_token.Nname_token._ref? _ref
    {
      get
      {
        return __ref;
      }
      set
      {
        __ref = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Ntype__name_token.Nname_token.one_of? _one_of = null;
    public XSD.Ntype__name_token.Nname_token.one_of one_ofOrCreate
    {
      get
      {
        if(_one_of == null)
        {
          _one_of = new();
          _one_of.ParentNode = this;
          NotifyChange();
        }
        return _one_of;
      }
      set
      {
        _one_of = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__name_token.Nname_token.one_of? one_of
    {
      get
      {
        return _one_of;
      }
      set
      {
        _one_of = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public name_token()
    {
    }

    public name_token(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public name_token(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
      if(name == "prefix")
      {
        Set_prefix(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__name_token.Nname_token._ref _ref)
      {
        this._ref = _ref;
      }

      if(linkedNode is XSD.Ntype__name_token.Nname_token.one_of one_of)
      {
        this.one_of = one_of;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__name_token.Nname_token._ref)
      {
        this._ref = null;
      }

      if(linkedNode is XSD.Ntype__name_token.Nname_token.one_of)
      {
        this.one_of = null;
      }

    }

    public Action OnSelfChange(Action<name_token> callback)
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
      // Godot.GD.Print("Deserializing name_token");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("prefix"))
      {
        var attribute_prefix = rawNode.attributes["prefix"];
        this.prefix = rawNode.attributes["prefix"];
      }

      //Deserialize children
      _ref = rawNode.InitializeWithRawNode("ref", _ref);

      one_of = rawNode.InitializeWithRawNode("one_of", one_of);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._prefix != null)
      {
        rawNode.attributes["prefix"] = this._prefix.ToString();
      }

      //Serialize children
      if(_ref != null) {
        rawNode.children["ref"] = new List<RawNode> { _ref.SerializeIntoRawNode() };
      }
      if(one_of != null) {
        rawNode.children["one_of"] = new List<RawNode> { one_of.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing name_token");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_prefix()
    {
      return this.prefix;
    }
    public void Set_prefix(System.String value)
    {
      this.prefix = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__name_token.Nname_token._ref.TagName))
      {
        this._ref ??= new XSD.Ntype__name_token.Nname_token._ref();
        var childXPath = xpath.Substring(XSD.Ntype__name_token.Nname_token._ref.TagName.Length + 3);
        this._ref.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__name_token.Nname_token.one_of.TagName))
      {
        this.one_of ??= new XSD.Ntype__name_token.Nname_token.one_of();
        var childXPath = xpath.Substring(XSD.Ntype__name_token.Nname_token.one_of.TagName.Length + 3);
        this.one_of.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__name_token.Nname_token._ref casted__ref) {
        return 0;
      }
      if(linkedNode is XSD.Ntype__name_token.Nname_token.one_of casted_one_of) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Ntype__name_token.Nname_token._ref
      || candidateChild is XSD.Ntype__name_token.Nname_token.one_of
      || false;
    }

    public bool Equals(name_token? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (name_token)obj;
        return Equals(prefix, other.prefix) && Equals(_ref, other._ref) && Equals(one_of, other.one_of);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, prefix);
        acc = HashCode.Combine(acc, _ref);
        acc = HashCode.Combine(acc, one_of);
        return acc;
    }
  }
}