using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__name_token.Nname_token {}
namespace XSD {
}
namespace XSD.Ntype__name_token {
  public class name_token  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String prefix;

    //Children elements
    public XSD.Ntype__name_token.Nname_token._ref? _ref = null;
    public XSD.Ntype__name_token.Nname_token.one_of? one_of = null;
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
      this._ref = rawNode.InitializeWithRawNode("ref", this._ref);
      this.one_of = rawNode.InitializeWithRawNode("one_of", this.one_of);
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
    public XSD.Ntype__name_token.Nname_token._ref? Get__ref()
    {
      return this._ref;
    }
    public XSD.Ntype__name_token.Nname_token._ref GetOrInsertDefault__ref()
    {
      if(this._ref == null) {
        this._ref = new XSD.Ntype__name_token.Nname_token._ref();
      }
      return this._ref;
    }
    public void Set__ref(XSD.Ntype__name_token.Nname_token._ref? value)
    {
      this._ref = value;
    }
    public XSD.Ntype__name_token.Nname_token.one_of? Get_one_of()
    {
      return this.one_of;
    }
    public void Set_one_of(XSD.Ntype__name_token.Nname_token.one_of? value)
    {
      this.one_of = value;
    }
  }
}