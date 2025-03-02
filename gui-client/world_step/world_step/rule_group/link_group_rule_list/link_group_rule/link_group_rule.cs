using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list.Nlink_group_rule {}
namespace XSD {
  public interface Itype__link_group {
    //Attributes
    public System.String id { get; set; }
    public System.Int32 angle { get; set; }
    public System.Int32? angleMax { get; set; }
    public System.Int32? limit { get; set; }

    //Children elements
    public LinkedNodeCollection<XSD.Ntype__link_group.to_option> to_option { get; set; }
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);

  }
}
namespace XSD.Nworld_step.Nrule_group.Nlink_group_rule_list {
  public class link_group_rule : XSD.ILinkedNode , Itype__link_group {

    public static string ClassTypeId = ".world_step.rule_group.link_group_rule_list.link_group_rule";
    public static string TagName = "link_group_rule";

    public string NodeName {get =>"link_group_rule";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<link_group_rule>> _callbackList = new();

    //Attributes

    //Attributes of type__link_group
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.Int32 _angle;
    public System.Int32 angle { get => _angle; set => _angle = value; }
    private System.Int32? _angleMax;
    public System.Int32? angleMax { get => _angleMax; set => _angleMax = value; }
    private System.Int32? _limit;
    public System.Int32? limit { get => _limit; set => _limit = value; }

    //Children elements

    //Children of type__link_group

    private LinkedNodeCollection<XSD.Ntype__link_group.to_option> _to_option = new();
    public LinkedNodeCollection<XSD.Ntype__link_group.to_option> to_option
    {
      get => _to_option;
      set
      {
        _to_option = value;
        value.ForEach(linkedNode => linkedNode.ParentNode = this);
        _to_option.OnAdd = (value) =>
        {
          value.ParentNode = this;
          OnChange();
        };
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

    public Action OnChange(Action<link_group_rule> callback)
    {
      _callbackList.Add(callback);
      return () => _callbackList.Remove(callback);
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
  to_option = rawNode.InitializeWithRawNode("to_option", to_option);
  to_option.OnAdd = (value) =>
    {
      value.ParentNode = this;
      OnChange();
    };
      OnChange();
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
  rawNode.children["to_option"] = to_option.Select(x => x.SerializeIntoRawNode()).ToList();
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
      this.OnChange();
    }
    public System.Int32 Get_angle()
    {
      return this.angle;
    }
    public void Set_angle(System.Int32 value)
    {
      this.angle = value;
      this.OnChange();
    }
    public System.Int32? Get_angleMax()
    {
      return this.angleMax;
    }
    public void Set_angleMax(System.Int32? value)
    {
      this.angleMax = value;
      this.OnChange();
    }
    public System.Int32? Get_limit()
    {
      return this.limit;
    }
    public void Set_limit(System.Int32? value)
    {
      this.limit = value;
      this.OnChange();
    }

    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }

      Deserialize(rawNode);
    }

    public void ChildChanged(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _callbackList.ForEach(action => action(this));
      _parentNode.ChildChanged(linkedNodes);
    }

    private void OnChange()
    {
      ChildChanged(new());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      return null;
    }
  }
}