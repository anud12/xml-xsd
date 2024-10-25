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
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Attributes of type__action

    //Children elements

    //Children of type__action
    public XSD.Ntype__action.from from = new XSD.Ntype__action.from();
    public XSD.Ntype__action.on on = new XSD.Ntype__action.on();
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
  this.from = rawNode.InitializeWithRawNode("from", this.from);
  this.on = rawNode.InitializeWithRawNode("on", this.on);
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

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "attributes": {
        "metaType": "object",
        "value": {
          "id": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        }
      },
      "value": {}
    },
    "name": "entry"
  }
*/