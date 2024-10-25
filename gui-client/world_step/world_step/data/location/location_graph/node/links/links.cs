using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class links  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>? link_to = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>();
    public links()
    {
    }

    public links(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public links(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing links");
      //Deserialize arguments

      //Deserialize children
      this.link_to = rawNode.InitializeWithRawNode("link_to", this.link_to);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["link_to"] = link_to.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing links");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>? Get_link_to()
    {
      return this.link_to;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to> GetOrInsertDefault_link_to()
    {
      if(this.link_to == null) {
        this.link_to = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>();
      }
      return this.link_to;
    }
    public void Set_link_to(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.link_to>? value)
    {
      this.link_to = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "isSingle": true,
      "value": {
        "link_to": {
          "metaType": "object",
          "attributes": {
            "metaType": "object",
            "value": {
              "node_id_ref": {
                "metaType": "primitive",
                "value": "xs:string",
                "isNullable": false
              },
              "total_progress": {
                "metaType": "primitive",
                "value": "xs:int",
                "isNullable": false
              }
            }
          },
          "isSingle": false,
          "value": {
            "people": {
              "metaType": "object",
              "isSingle": true,
              "value": {
                "person": {
                  "metaType": "object",
                  "value": {},
                  "isSingle": false,
                  "isNullable": true,
                  "attributes": {
                    "metaType": "object",
                    "value": {
                      "person_id_ref": {
                        "metaType": "primitive",
                        "value": "xs:string",
                        "isNullable": false
                      },
                      "accumulated_progress": {
                        "metaType": "primitive",
                        "value": "xs:int",
                        "isNullable": false
                      }
                    }
                  }
                }
              },
              "isNullable": true
            },
            "person_progress_property": {
              "metaType": "reference",
              "value": "type__math_operations",
              "isSingle": true,
              "isNullable": true
            }
          },
          "isNullable": true
        }
      },
      "isNullable": true
    },
    "name": "links"
  }
*/