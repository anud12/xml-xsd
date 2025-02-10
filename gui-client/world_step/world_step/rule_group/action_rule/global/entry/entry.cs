using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal.Nentry {}
namespace XSD {
  public interface Itype__action {

    //Children elements
    public XSD.Ntype__action.from Get_from();
    public void Set_from(XSD.Ntype__action.from value);
    public XSD.Ntype__action.on Get_on();
    public void Set_on(XSD.Ntype__action.on value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }
}
namespace XSD.Nworld_step.Nrule_group.Naction_rule.Nglobal {
  public class entry : Itype__action {

    public static string ClassTypeId = "/world_step/rule_group/action_rule/global/entry";
    public static string TagName = "entry";

    public string Tag = "entry";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;

    //Attributes of type__action

    //Children elements

    //Children of type__action
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
    public entry()
    {
    }

    public entry(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entry(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing entry");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }

      // Deserialize arguments of type__action

      //Deserialize children

      // Deserialize children of type__action
  this._from = rawNode.InitializeWithRawNode("from", this._from);
  this._on = rawNode.InitializeWithRawNode("on", this._on);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      // Serialize arguments of type__action


      //Serialize children

      // Serialize children of type__action
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
        // Godot.GD.Print("Serializing entry");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_id()
    {
      return this.id;
    }
    public void Set_id(System.String value)
    {
      this.id = value;
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

      Deserialize(rawNode);
    }
  }
}