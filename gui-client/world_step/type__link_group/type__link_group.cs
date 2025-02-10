using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Ntype__link_group {}
namespace XSD {
}
namespace XSD {
  public class type__link_group  {

    public static string ClassTypeId = "/type__link_group";
    public static string TagName = "type__link_group";

    public string Tag = "type__link_group";
    public RawNode rawNode = new RawNode();
    //Attributes
    public System.String id;
    public System.String _id;
    public System.Int32 angle;
    public System.Int32 _angle;
    public System.Int32? angleMax;
    public System.Int32? _angleMax;
    public System.Int32? limit;
    public System.Int32? _limit;

    //Children elements

    private Dictionary<int, XSD.Ntype__link_group.to_option> _to_option = new Dictionary<int, XSD.Ntype__link_group.to_option>();
    public List<XSD.Ntype__link_group.to_option> to_option {
      get { return _to_option.Values.ToList(); }
      set
      {
        _to_option = value
          .Select((value, index) => new { index, value })
          .ToDictionary(item => item.index, item => item.value);
      }
    }
    public type__link_group()
    {
    }

    public type__link_group(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__link_group(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing type__link_group");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("angle"))
      {
        var attribute_angle = rawNode.attributes["angle"];
        this.angle = attribute_angle.ToInt();
      }
      if(rawNode.attributes.ContainsKey("angleMax"))
      {
        var attribute_angleMax = rawNode.attributes["angleMax"];
        this.angleMax = attribute_angleMax?.ToInt();
      }
      if(rawNode.attributes.ContainsKey("limit"))
      {
        var attribute_limit = rawNode.attributes["limit"];
        this.limit = attribute_limit?.ToInt();
      }

      //Deserialize children
      this._to_option = rawNode.InitializeWithRawNode("to_option", this._to_option);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this.id != null)
      {
        rawNode.attributes["id"] = this.id.ToString();
      }
      if(this.angle != null)
      {
        rawNode.attributes["angle"] = this.angle.ToString();
      }
      if(this.angleMax != null)
      {
        rawNode.attributes["angleMax"] = this.angleMax?.ToString();
      }
      if(this.limit != null)
      {
        rawNode.attributes["limit"] = this.limit?.ToString();
      }

      //Serialize children
      rawNode.children["to_option"] = _to_option?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__link_group");
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
    public System.Int32 Get_angle()
    {
      return this.angle;
    }
    public void Set_angle(System.Int32 value)
    {
      this.angle = value;
    }
    public System.Int32? Get_angleMax()
    {
      return this.angleMax;
    }
    public void Set_angleMax(System.Int32? value)
    {
      this.angleMax = value;
    }
    public System.Int32? Get_limit()
    {
      return this.limit;
    }
    public void Set_limit(System.Int32? value)
    {
      this.limit = value;
    }
    public List<XSD.Ntype__link_group.to_option>? Get_to_option()
    {
      return this._to_option?.Values.ToList();
    }
    public List<XSD.Ntype__link_group.to_option> GetOrInsertDefault_to_option()
    {
      if(this._to_option == null) {

        // false2
        this._to_option = new Dictionary<int, XSD.Ntype__link_group.to_option>();
      }
      #pragma warning disable CS8603 // Possible null reference return.
      return this.Get_to_option();
      #pragma warning restore CS8603 // Possible null reference return.
    }
    public void Set_to_option(List<XSD.Ntype__link_group.to_option>? value)
    {
      this._to_option = value.Select((x, i) => new { Index = i, Value = x }).ToDictionary(x => x.Index, x => x.Value);
    }

    public void SetXPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith(XSD.Ntype__link_group.to_option.TagName + "["))
      {
        var startIndex = (XSD.Ntype__link_group.to_option.TagName + "[").Length;
        var indexString = xpath.Substring(startIndex, startIndex + 1);
        xpath = xpath.Substring(startIndex + 2);
        if(this._to_option.ContainsKey(indexString.ToInt()))
        {
          this._to_option[indexString.ToInt()].SetXPath(xpath, rawNode);
        }
        var newEntry = new XSD.Ntype__link_group.to_option();
        newEntry.SetXPath(xpath, rawNode);
        this._to_option.Add(indexString.ToInt(), newEntry);

        return;
      }

      Deserialize(rawNode);
    }
  }
}