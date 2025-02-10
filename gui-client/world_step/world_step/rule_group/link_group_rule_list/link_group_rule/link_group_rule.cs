using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.Nlink_group_rule {}
namespace XSD {
  public interface Itype__link_group {
    //Attributes
    public System.String Get_id();
    public void Set_id(System.String value);
    public System.Int32 Get_angle();
    public void Set_angle(System.Int32 value);
    public System.Int32? Get_angleMax();
    public void Set_angleMax(System.Int32? value);
    public System.Int32? Get_limit();
    public void Set_limit(System.Int32? value);

    //Children elements
    public List<XSD.Ntype__link_group.to_option> Get_to_option();
    public void Set_to_option(List<XSD.Ntype__link_group.to_option> value);
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);
  }
}
namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list {
  public class link_group_rule : Itype__link_group {

    public static string ClassTypeId = "/world_step/rule_group/link_group_rule_list/link_group_rule";
    public static string TagName = "link_group_rule";

    public string Tag = "link_group_rule";
    public RawNode rawNode = new RawNode();
    //Attributes

    //Attributes of type__link_group
    public System.String id;
    public System.String _id;
    public System.Int32 angle;
    public System.Int32 _angle;
    public System.Int32? angleMax;
    public System.Int32? _angleMax;
    public System.Int32? limit;
    public System.Int32? _limit;

    //Children elements

    //Children of type__link_group

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
    public link_group_rule()
    {
    }

    public link_group_rule(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_group_rule(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group_rule");
      //Deserialize arguments

      // Deserialize arguments of type__link_group
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

      // Deserialize children of type__link_group
  this._to_option = rawNode.InitializeWithRawNode("to_option", this._to_option);
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__link_group
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

      // Serialize children of type__link_group
  rawNode.children["to_option"] = _to_option?.Select(x => x.Value.SerializeIntoRawNode())?.ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_group_rule");
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

      Deserialize(rawNode);
    }
  }
}