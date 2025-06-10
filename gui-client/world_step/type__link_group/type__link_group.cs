using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__link_group {}
namespace XSD {
}
namespace XSD {
  public class type__link_group : XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__link_group";
    public static string TagName = "type__link_group";

    public string NodeName {get =>"type__link_group";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__link_group>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.Int32 _angle;
    public System.Int32 angle { get => _angle; set => _angle = value; }
    private System.Int32? _angleMax;
    public System.Int32? angleMax { get => _angleMax; set => _angleMax = value; }
    private System.Int32? _limit;
    public System.Int32? limit { get => _limit; set => _limit = value; }

    //Children elements

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

    public void SetAttribute(string name, string? value)
    {
      if(name == "id")
      {
        Set_id(value);
      }
      if(name == "angle")
      {
        Set_angle(value?.ToInt() ?? 0);
      }
      if(name == "angleMax")
      {
        Set_angleMax(value?.ToInt() ?? 0);
      }
      if(name == "limit")
      {
        Set_limit(value?.ToInt() ?? 0);
      }
    }

    public void SetChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Ntype__link_group.to_option> to_option)
      {
        this.to_option = to_option;
      }
    }

    public void ClearChild(dynamic linkedNode)
    {

      if(linkedNode is LinkedNodeCollection<XSD.Ntype__link_group.to_option>)
      {
        this.to_option = null;
      }
    }

    public Action OnSelfChange(Action<type__link_group> callback)
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
      rawNode.children["to_option"] = to_option.Select(x => x.SerializeIntoRawNode()).ToList();
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
      if(xpath.StartsWith(XSD.Ntype__link_group.to_option.TagName + "["))
      {
        var startIndex = (XSD.Ntype__link_group.to_option.TagName + "[").Length;
        var startTokens = xpath.Split(XSD.Ntype__link_group.to_option.TagName + "[");
        var endToken = startTokens[1].Split("]");
        var indexString = endToken[0];
        var childXPath = xpath.ReplaceFirst(XSD.Ntype__link_group.to_option.TagName + "[" + indexString + "]", "");
        var pathIndex = indexString.ToInt();
        if(this.to_option.ContainsKey(pathIndex))
        {
          this.to_option[pathIndex].DeserializeAtPath(childXPath, rawNode);
          return;
        }
        var newEntry = new XSD.Ntype__link_group.to_option();
        this.to_option[pathIndex] = newEntry;
        newEntry.DeserializeAtPath(childXPath, rawNode);

        return;
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
      if(linkedNode is XSD.Ntype__link_group.to_option casted_to_option) {
        return this._to_option.KeyOf(casted_to_option);
      }
      return null;
    }
  }
}