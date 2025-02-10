using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nname_token {}
namespace XSD {
}
namespace XSD {
  public class name_token  {

    public static string ClassTypeId = "/name_token";
    public static string TagName = "name_token";

    public string Tag = "name_token";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String prefix;
    public System.String _prefix;

    //Children elements
    private XSD.Nname_token._ref? __ref = null;
    public XSD.Nname_token._ref? _ref {
      get { return __ref; }
      set { __ref = value; }
    }

    private XSD.Nname_token.one_of? _one_of = null;
    public XSD.Nname_token.one_of? one_of {
      get { return _one_of; }
      set { _one_of = value; }
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
      this.__ref = rawNode.InitializeWithRawNode("ref", this.__ref);
      this._one_of = rawNode.InitializeWithRawNode("one_of", this._one_of);
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
    }
    public XSD.Nname_token._ref? Get__ref()
    {
      return this.__ref;
    }
    public XSD.Nname_token._ref GetOrInsertDefault__ref()
    {
      if(this.__ref == null) {

        // true2
        this.__ref = new XSD.Nname_token._ref();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get__ref();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set__ref(XSD.Nname_token._ref? value)
    {
        this.__ref = value;
    }
    public XSD.Nname_token.one_of? Get_one_of()
    {
      return this.one_of;
    }
    public void Set_one_of(XSD.Nname_token.one_of? value)
    {
      this.one_of = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Nname_token._ref.TagName))
      {
        this._ref ??= new XSD.Nname_token._ref();
        xpath = xpath.Substring(XSD.Nname_token._ref.TagName.Length + 3);
        this._ref.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Nname_token.one_of.TagName))
      {
        this.one_of ??= new XSD.Nname_token.one_of();
        xpath = xpath.Substring(XSD.Nname_token.one_of.TagName.Length + 3);
        this.one_of.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}