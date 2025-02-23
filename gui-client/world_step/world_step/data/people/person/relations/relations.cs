using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Npeople.Nperson.Nrelations {}
namespace XSD {
}
namespace XSD.Nworld_step.Ndata.Npeople.Nperson {
  public class relations  {
    public RawNode rawNode = new RawNode();
    //Attributes
    /* ignored attribute key={key} of type=System.Object*/

    //Children elements
    public relations()
    {
    }

    public relations(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public relations(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing relations");
      //Deserialize arguments

      //Deserialize children
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing relations");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    /* ignored attribute key={key} of type=System.Object*/
  }
}