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
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public XSD.Ntype__action.from from = new XSD.Ntype__action.from();
    public XSD.Ntype__action.on on = new XSD.Ntype__action.on();
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
      this.from = rawNode.InitializeWithRawNode("from", this.from);
      this.on = rawNode.InitializeWithRawNode("on", this.on);
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
      return this.from;
    }
    public XSD.Ntype__action.from GetOrInsertDefault_from()
    {
      if(this.from == null) {
        this.from = new XSD.Ntype__action.from();
      }
      return this.from;
    }
    public void Set_from(XSD.Ntype__action.from value)
    {
      this.from = value;
    }
    public XSD.Ntype__action.on Get_on()
    {
      return this.on;
    }
    public XSD.Ntype__action.on GetOrInsertDefault_on()
    {
      if(this.on == null) {
        this.on = new XSD.Ntype__action.on();
      }
      return this.on;
    }
    public void Set_on(XSD.Ntype__action.on value)
    {
      this.on = value;
    }
  }
}