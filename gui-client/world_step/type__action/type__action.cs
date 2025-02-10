using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__action {}
namespace XSD {
}
namespace XSD {
  public class type__action  {

    public static string ClassTypeId = "/type__action";
    public static string TagName = "type__action";

    public string Tag = "type__action";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    private XSD.Ntype__action.from _from = new XSD.Ntype__action.from();
    public XSD.Ntype__action.from from {
      get { return _from; }
      set { _from = value; }
    }

    private XSD.Ntype__action.on _on = new XSD.Ntype__action.on();
    public XSD.Ntype__action.on on {
      get { return _on; }
      set { _on = value; }
    }
    public type__action()
    {
    }

    public type__action(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__action(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__action");
      //Deserialize arguments

      //Deserialize children
      this._from = rawNode.InitializeWithRawNode("from", this._from);
      this._on = rawNode.InitializeWithRawNode("on", this._on);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      if(from != null) {
        rawNode.children["from"] = new List<RawNode> { from.SerializeIntoRawNode() };
      }
      if(on != null) {
        rawNode.children["on"] = new List<RawNode> { on.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__action");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public XSD.Ntype__action.from Get_from()
    {
      return this._from;
    }
    public XSD.Ntype__action.from GetOrInsertDefault_from()
    {
      if(this._from == null) {

        // true2
        this._from = new XSD.Ntype__action.from();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_from();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_from(XSD.Ntype__action.from value)
    {
        this._from = value;
    }
    public XSD.Ntype__action.on Get_on()
    {
      return this._on;
    }
    public XSD.Ntype__action.on GetOrInsertDefault_on()
    {
      if(this._on == null) {

        // true2
        this._on = new XSD.Ntype__action.on();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_on();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_on(XSD.Ntype__action.on value)
    {
        this._on = value;
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__action.from.TagName))
      {
        xpath = xpath.Substring(XSD.Ntype__action.from.TagName.Length + 3);
        this.from.SetXPath(xpath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__action.on.TagName))
      {
        xpath = xpath.Substring(XSD.Ntype__action.on.TagName.Length + 3);
        this.on.SetXPath(xpath, rawNode);
        return;
      }

      Deserialize(rawNode);
    }
  }
}