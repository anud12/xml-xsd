using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup {
  public class necessary_node  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_rule_ref;
    public System.Int32 min;
    public System.Int32? max;

    //Children elements
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>? or = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>();
    public necessary_node()
    {
    }

    public necessary_node(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public necessary_node(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing necessary_node");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_rule_ref"))
      {
        var attribute_node_rule_ref = rawNode.attributes["node_rule_ref"];
        this.node_rule_ref = rawNode.attributes["node_rule_ref"];
      }
      if(rawNode.attributes.ContainsKey("min"))
      {
        var attribute_min = rawNode.attributes["min"];
        this.min = attribute_min.ToInt();
      }
      if(rawNode.attributes.ContainsKey("max"))
      {
        var attribute_max = rawNode.attributes["max"];
        this.max = attribute_max?.ToInt();
      }

      //Deserialize children
      this.or = rawNode.InitializeWithRawNode("or", this.or);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_rule_ref != null)
      {
        rawNode.attributes["node_rule_ref"] = this.node_rule_ref.ToString();
      }
      if(this.min != null)
      {
        rawNode.attributes["min"] = this.min.ToString();
      }
      if(this.max != null)
      {
        rawNode.attributes["max"] = this.max?.ToString();
      }

      //Serialize children
      rawNode.children["or"] = or.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing necessary_node");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_rule_ref()
    {
      return this.node_rule_ref;
    }
    public void Set_node_rule_ref(System.String value)
    {
      this.node_rule_ref = value;
    }
    public System.Int32 Get_min()
    {
      return this.min;
    }
    public void Set_min(System.Int32 value)
    {
      this.min = value;
    }
    public System.Int32? Get_max()
    {
      return this.max;
    }
    public void Set_max(System.Int32? value)
    {
      this.max = value;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>? Get_or()
    {
      return this.or;
    }
    public List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or> GetOrInsertDefault_or()
    {
      if(this.or == null) {
        this.or = new List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>();
      }
      return this.or;
    }
    public void Set_or(List<XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nsetup.Nnecessary_node.or>? value)
    {
      this.or = value;
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
          "node_rule_ref": {
            "metaType": "primitive",
            "value": "xs:string",
            "isNullable": false
          },
          "min": {
            "metaType": "primitive",
            "value": "xs:int",
            "isNullable": false
          },
          "max": {
            "metaType": "primitive",
            "value": "xs:int",
            "isNullable": true
          }
        }
      },
      "isSingle": false,
      "value": {
        "or": {
          "metaType": "object",
          "value": {},
          "isSingle": false,
          "isNullable": true,
          "attributes": {
            "metaType": "object",
            "value": {
              "node_rule_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              }
            },
            "isNullable": false
          }
        }
      },
      "isNullable": true
    },
    "name": "necessary_node"
  }
*/