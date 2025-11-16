using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list.Nlink_group {}
namespace XSD {
}
namespace XSD.Nworld_step.Nrule_group.Nlocation_graph_rule.Nnode_rule.Nlink_group_list {
  public class link_group : IEquatable<link_group>, XSD.ILinkedNode , Itype__link_group {

    public static string ClassTypeId = ".world_step.rule_group.location_graph_rule.node_rule.link_group_list.link_group";
    public static string TagName = "link_group";

    public string NodeName {get =>"link_group";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<link_group>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

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
          NotifyChange();
        };
      }
    }
    public link_group()
    {
    }

    public link_group(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public link_group(XmlElement xmlElement)
    {
      this.rawNode.Deserialize(xmlElement);
      Deserialize(rawNode);
    }

    public void SetAttribute(string name, string? value)
    {
    }

    public void SetChild(dynamic linkedNode)
    {
    }

    public void ClearChild(dynamic linkedNode)
    {
    }

    public Action OnSelfChange(Action<link_group> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }

    public Action OnSelfChangeNode(Action<ILinkedNode> callback)
    {
      _onSelfChangeCallbackList.Add(callback);
      return () => _onSelfChangeCallbackList.Remove(callback);
    }


    public Action OnChange(Action<List<ILinkedNode>> callback)
    {
      _onChangeCallbackList.Add(callback);
      return () => _onChangeCallbackList.Remove(callback);
    }

    public void Deserialize (RawNode rawNode)
    {
      this.rawNode = rawNode;
      // Godot.GD.Print("Deserializing link_group");
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
      NotifyChange();
    };
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__link_group
  if(this._id != null)
  {
    rawNode.attributes["id"] = this._id.ToString();
  }
  if(this._angle != null)
  {
    rawNode.attributes["angle"] = this._angle.ToString();
  }
  if(this._angleMax != null)
  {
    rawNode.attributes["angleMax"] = this._angleMax?.ToString();
  }
  if(this._limit != null)
  {
    rawNode.attributes["limit"] = this._limit?.ToString();
  }

      //Serialize children

      // Serialize children of type__link_group
  rawNode.children["to_option"] = to_option.Select(x => x.SerializeIntoRawNode()).ToList();
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing link_group");
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
      this.NotifyChange();
    }
    public System.Int32 Get_angle()
    {
      return this.angle;
    }
    public void Set_angle(System.Int32 value)
    {
      this.angle = value;
      this.NotifyChange();
    }
    public System.Int32? Get_angleMax()
    {
      return this.angleMax;
    }
    public void Set_angleMax(System.Int32? value)
    {
      this.angleMax = value;
      this.NotifyChange();
    }
    public System.Int32? Get_limit()
    {
      return this.limit;
    }
    public void Set_limit(System.Int32? value)
    {
      this.limit = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }

      Deserialize(rawNode);
    }

    public void NotifyChange(List<ILinkedNode> linkedNodes)
    {
      if(_parentNode == null)
        return;
      linkedNodes.Add(this);
      _onSelfChangeCallbackList.ForEach(action => action(this));
      _onChangeCallbackList.ForEach(action => action(linkedNodes));
      _parentNode.NotifyChange(linkedNodes);
    }

    public void NotifyChange()
    {
      NotifyChange(new ());
    }

    public int? BuildIndexForChild(ILinkedNode linkedNode)
    {
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return false;
    }

        public bool Equals(link_group? obj)
        {
            if (obj == null || GetType() != obj.GetType())
                return false;

            var other = (link_group)obj;
            return object.Equals(this, other);
        }

    public int GetHashCode()
    {
        return base.GetHashCode();
    }
  }
}