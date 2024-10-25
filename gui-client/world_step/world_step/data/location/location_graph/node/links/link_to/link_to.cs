using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks {
  public class link_to  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String node_id_ref;
    public System.Int32 total_progress;

    //Children elements
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people? people = null;
    public type__math_operations? person_progress_property = null;
    public link_to()
    {
    }

    public link_to(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_to(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_to");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("node_id_ref"))
      {
        var attribute_node_id_ref = rawNode.attributes["node_id_ref"];
        this.node_id_ref = rawNode.attributes["node_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("total_progress"))
      {
        var attribute_total_progress = rawNode.attributes["total_progress"];
        this.total_progress = attribute_total_progress.ToInt();
      }

      //Deserialize children
      this.people = rawNode.InitializeWithRawNode("people", this.people);
      this.person_progress_property = rawNode.InitializeWithRawNode("person_progress_property", this.person_progress_property);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.node_id_ref != null)
      {
        rawNode.attributes["node_id_ref"] = this.node_id_ref.ToString();
      }
      if(this.total_progress != null)
      {
        rawNode.attributes["total_progress"] = this.total_progress.ToString();
      }

      //Serialize children
      if(people != null) {
        rawNode.children["people"] = new List<RawNode> { people.SerializeIntoRawNode() };
      }
      if(person_progress_property != null) {
        rawNode.children["person_progress_property"] = new List<RawNode> { person_progress_property.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_to");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_node_id_ref()
    {
      return this.node_id_ref;
    }
    public void Set_node_id_ref(System.String value)
    {
      this.node_id_ref = value;
    }
    public System.Int32 Get_total_progress()
    {
      return this.total_progress;
    }
    public void Set_total_progress(System.Int32 value)
    {
      this.total_progress = value;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people? Get_people()
    {
      return this.people;
    }
    public XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people GetOrInsertDefault_people()
    {
      if(this.people == null) {
        this.people = new XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people();
      }
      return this.people;
    }
    public void Set_people(XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.people? value)
    {
      this.people = value;
    }
    public type__math_operations? Get_person_progress_property()
    {
      return this.person_progress_property;
    }
    public void Set_person_progress_property(type__math_operations? value)
    {
      this.person_progress_property = value;
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
    },
    "name": "link_to"
  }
*/