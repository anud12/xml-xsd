using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to {
  public class people  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople.person>? person = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople.person>();
    public people()
    {
    }

    public people(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public people(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing people");
      //Deserialize arguments

      //Deserialize children
      this.person = rawNode.InitializeWithRawNode("person", this.person);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["person"] = person.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing people");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople.person>? Get_person()
    {
      return this.person;
    }
    public List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople.person> GetOrInsertDefault_person()
    {
      if(this.person == null) {
        this.person = new List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople.person>();
      }
      return this.person;
    }
    public void Set_person(List<XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople.person>? value)
    {
      this.person = value;
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
    "name": "people"
  }
*/