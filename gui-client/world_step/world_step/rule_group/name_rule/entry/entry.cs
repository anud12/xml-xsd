using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nname_rule.Nentry {}
namespace XSD {
  public interface Itype__name_token {

    //Children elements
    public List<XSD.Ntype__name_token.name_token> Get_name_token();
    public void Set_name_token(List<XSD.Ntype__name_token.name_token> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }
}
namespace XSD.Nworld_step.Nrule_group.Nname_rule {
  public class entry : Itype__name_token {
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;

    //Attributes of type__name_token

    //Children elements

    //Children of type__name_token
    public List<XSD.Ntype__name_token.name_token> name_token = new List<XSD.Ntype__name_token.name_token>();
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

      // Deserialize arguments of type__name_token

      //Deserialize children

      // Deserialize children of type__name_token
  this.name_token = rawNode.InitializeWithRawNode("name_token", this.name_token);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }

      // Serialize arguments of type__name_token


      //Serialize children

      // Serialize children of type__name_token
  rawNode.children["name_token"] = name_token.Select(x => x.SerializeIntoRawNode()).ToList();
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