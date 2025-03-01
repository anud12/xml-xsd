using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nname_token {}
namespace XSD {
}
namespace XSD {
  public class name_token : XSD.ILinkedNode  {

    public static string ClassTypeId = "/name_token";
    public static string TagName = "name_token";

    public string NodeName {get =>"name_token";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<name_token>> _callbackList = new();

    //Attributes
    private System.String _prefix;
    public System.String prefix { get => _prefix; set => _prefix = value; }

    //Children elements
    private XSD.Nname_token._ref? __ref = null;
    public XSD.Nname_token._ref _ref
    {
      get
      {
        if(__ref == null)
        {
          __ref = new();
          __ref.ParentNode = this;
          OnChange();
        }
        return __ref;
      }
      set
      {
        __ref = value;
        __ref.ParentNode = this;
      }
    }

    private XSD.Nname_token.one_of? _one_of = null;
    public XSD.Nname_token.one_of one_of
    {
      get
      {
        if(_one_of == null)
        {
          _one_of = new();
          _one_of.ParentNode = this;
          OnChange();
        }
        return _one_of;
      }
      set
      {
        _one_of = value;
        _one_of.ParentNode = this;
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

    public Action OnChange(Action<name_token> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
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
      OnChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.prefix != null)
      {
        rawNode.attributes["prefix"] = this.prefix.ToString();
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
      this.OnChange();
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("/"))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Nname_token._ref.TagName))
      {
        this._ref ??= new XSD.Nname_token._ref();
        var childXPath = xpath.Substring(XSD.Nname_token._ref.TagName.Length + 3);
        this._ref.SetXPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nname_token.one_of.TagName))
      {
        this.one_of ??= new XSD.Nname_token.one_of();
        var childXPath = xpath.Substring(XSD.Nname_token.one_of.TagName.Length + 3);
        this.one_of.SetXPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Nname_token._ref casted__ref) {
        return 0;
      }
      if(linkedNode is XSD.Nname_token.one_of casted_one_of) {
        return 0;
      }
      return null;
    }
  }
}