using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nname_token.None_of {}
namespace XSD {
}
namespace XSD.Nname_token {
  public class one_of : Itype__name_token {

    public static string ClassTypeId = "/name_token/one_of";
    public static string TagName = "one_of";

    public string Tag = "one_of";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Attributes of type__name_token

    //Children elements

    //Children of type__name_token

    private Dictionary<int, XSD.Ntype__name_token.name_token> _name_token = new Dictionary<int, XSD.Ntype__name_token.name_token>();
    public List<XSD.Ntype__name_token.name_token> name_token {
      get { return _name_token.Values.ToList(); }
      set
      {
        _name_token = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public one_of()
    {
    }

    public one_of(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public one_of(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing one_of");
      //Deserialize arguments

      // Deserialize arguments of type__name_token

      //Deserialize children

      // Deserialize children of type__name_token
  this._name_token = rawNode.InitializeWithRawNode("name_token", this._name_token);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__name_token


      //Serialize children

      // Serialize children of type__name_token
  rawNode.children["name_token"] = _name_token?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing one_of");
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


    public void SetXPath(string xpath, RawNode rawNode)
    {

      Deserialize(rawNode);
    }
  }
}