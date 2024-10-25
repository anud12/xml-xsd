using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.Nreference {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list {
  public class reference  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String link_group_rule_ref;

    //Children elements
    public reference()
    {
    }

    public reference(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public reference(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing reference");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("link_group_rule_ref"))
      {
        var attribute_link_group_rule_ref = rawNode.attributes["link_group_rule_ref"];
        this.link_group_rule_ref = rawNode.attributes["link_group_rule_ref"];
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.link_group_rule_ref != null)
      {
        rawNode.attributes["link_group_rule_ref"] = this.link_group_rule_ref.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing reference");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_link_group_rule_ref()
    {
      return this.link_group_rule_ref;
    }
    public void Set_link_group_rule_ref(System.String value)
    {
      this.link_group_rule_ref = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "value": {},
      "isSingle": false,
      "isNullable": true,
      "attributes": {
        "metaType": "object",
        "value": {
          "link_group_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          }
        },
        "isNullable": false
      }
    },
    "name": "reference"
  }
*/