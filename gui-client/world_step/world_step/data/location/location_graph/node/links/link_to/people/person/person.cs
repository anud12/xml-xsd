using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople.Nperson {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nlinks.Nlink_to.Npeople {
  public class person  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String person_id_ref;
    public System.Int32 accumulated_progress;

    //Children elements
    public person()
    {
    }

    public person(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public person(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing person");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("person_id_ref"))
      {
        var attribute_person_id_ref = rawNode.attributes["person_id_ref"];
        this.person_id_ref = rawNode.attributes["person_id_ref"];
      }
      if(rawNode.attributes.ContainsKey("accumulated_progress"))
      {
        var attribute_accumulated_progress = rawNode.attributes["accumulated_progress"];
        this.accumulated_progress = attribute_accumulated_progress.ToInt();
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.person_id_ref != null)
      {
        rawNode.attributes["person_id_ref"] = this.person_id_ref.ToString();
      }
      if(this.accumulated_progress != null)
      {
        rawNode.attributes["accumulated_progress"] = this.accumulated_progress.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing person");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.String Get_person_id_ref()
    {
      return this.person_id_ref;
    }
    public void Set_person_id_ref(System.String value)
    {
      this.person_id_ref = value;
    }
    public System.Int32 Get_accumulated_progress()
    {
      return this.accumulated_progress;
    }
    public void Set_accumulated_progress(System.Int32 value)
    {
      this.accumulated_progress = value;
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
    },
    "name": "person"
  }
*/