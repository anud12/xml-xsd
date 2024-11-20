using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__name_token {}
namespace XSD {
}
namespace XSD {
  public class type__name_token  {
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements
    public List<XSD.Ntype__name_token.name_token> name_token = new List<XSD.Ntype__name_token.name_token>();
    public type__name_token()
    {
    }

    public type__name_token(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__name_token(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__name_token");
      //Deserialize arguments

      //Deserialize children
      this.name_token = rawNode.InitializeWithRawNode("name_token", this.name_token);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["name_token"] = name_token.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__name_token");
        var updatedRawNode = SerializeIntoRawNode();
        updatedRawNode.Serialize(element);
    }
    public List<XSD.Ntype__name_token.name_token> Get_name_token()
    {
      return this.name_token;
    }
    public void Set_name_token(List<XSD.Ntype__name_token.name_token> value)
    {
      this.name_token = value;
    }
  }
}