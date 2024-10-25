using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nactions.Nby {}
namespace XSD {
}
namespace XSD.Nworld_step.Nactions {
  public class by  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_ref;

    //Children elements
    public XSD.Nworld_step.Nactions.Nby._do _do = new XSD.Nworld_step.Nactions.Nby._do();
    public XSD.Nworld_step.Nactions.Nby.move_towards move_towards = new XSD.Nworld_step.Nactions.Nby.move_towards();
    public by()
    {
    }

    public by(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public by(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing by");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_ref"))
      {
        var attribute_person_ref = rawNode.attributes["person_ref"];
        this.person_ref = rawNode.attributes["person_ref"];
      }

      //Deserialize children
      this._do = rawNode.InitializeWithRawNode("do", this._do);
      this.move_towards = rawNode.InitializeWithRawNode("move_towards", this.move_towards);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_ref != null)
      {
        rawNode.attributes["person_ref"] = this.person_ref.ToString();
      }

      //Serialize children
      if(_do != null) {
        rawNode.children["do"] = new List<RawNode> { _do.SerializeIntoRawNode() };
      }
      if(move_towards != null) {
        rawNode.children["move_towards"] = new List<RawNode> { move_towards.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing by");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_person_ref()
    {
      return this.person_ref;
    }
    public void Set_person_ref(System.String value)
    {
      this.person_ref = value;
    }
    public XSD.Nworld_step.Nactions.Nby._do Get__do()
    {
      return this._do;
    }
    public XSD.Nworld_step.Nactions.Nby._do GetOrInsertDefault__do()
    {
      if(this._do == null) {
        this._do = new XSD.Nworld_step.Nactions.Nby._do();
      }
      return this._do;
    }
    public void Set__do(XSD.Nworld_step.Nactions.Nby._do value)
    {
      this._do = value;
    }
    public XSD.Nworld_step.Nactions.Nby.move_towards Get_move_towards()
    {
      return this.move_towards;
    }
    public XSD.Nworld_step.Nactions.Nby.move_towards GetOrInsertDefault_move_towards()
    {
      if(this.move_towards == null) {
        this.move_towards = new XSD.Nworld_step.Nactions.Nby.move_towards();
      }
      return this.move_towards;
    }
    public void Set_move_towards(XSD.Nworld_step.Nactions.Nby.move_towards value)
    {
      this.move_towards = value;
    }
  }
}