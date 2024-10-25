using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode.Nposition {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph.Nnode {
  public class position  {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.Int32 x;
    public System.Int32 y;

    //Children elements
    public position()
    {
    }

    public position(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public position(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing position");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("x"))
      {
        var attribute_x = rawNode.attributes["x"];
        this.x = attribute_x.ToInt();
      }
      if(rawNode.attributes.ContainsKey("y"))
      {
        var attribute_y = rawNode.attributes["y"];
        this.y = attribute_y.ToInt();
      }

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.x != null)
      {
        rawNode.attributes["x"] = this.x.ToString();
      }
      if(this.y != null)
      {
        rawNode.attributes["y"] = this.y.ToString();
      }

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing position");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public System.Int32 Get_x()
    {
      return this.x;
    }
    public void Set_x(System.Int32 value)
    {
      this.x = value;
    }
    public System.Int32 Get_y()
    {
      return this.y;
    }
    public void Set_y(System.Int32 value)
    {
      this.y = value;
    }
  }
}

/*dependantType
  {
    "type": "element",
    "value": {
      "metaType": "object",
      "value": {},
      "isSingle": true,
      "isNullable": true,
      "attributes": {
        "metaType": "object",
        "value": {
          "x": {
            "metaType": "primitive",
            "value": "xs:int",
            "isNullable": false
          },
          "y": {
            "metaType": "primitive",
            "value": "xs:int",
            "isNullable": false
          }
        }
      }
    },
    "name": "position"
  }
*/