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

    public static string ClassTypeId = "/type__name_token";
    public static string TagName = "type__name_token";

    public string Tag = "type__name_token";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Children elements

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
      this._name_token = rawNode.InitializeWithRawNode("name_token", this._name_token);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      //Serialize children
      rawNode.children["name_token"] = _name_token?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
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

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__name_token.name_token.TagName + "["))
      {
        var startIndex = (XSD.Ntype__name_token.name_token.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._name_token.ContainsKey(indexString.ToInt()))
        {
          this._name_token[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Ntype__name_token.name_token();
        newEntry.SetXPath(xpath, rawNode);
        this._name_token.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}