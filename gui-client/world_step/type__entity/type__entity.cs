using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Ntype__entity {}
namespace XSD {
}
namespace XSD {
  public class type__entity : IEquatable<type__entity>, XSD.ILinkedNode  {

    public static string ClassTypeId = ".type__entity";
    public static string TagName = "type__entity";

    public string NodeName {get =>"type__entity";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<type__entity>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String? _entity_rule_ref;
    public System.String? entity_rule_ref { get => _entity_rule_ref; set => _entity_rule_ref = value; }

    //Children elements
    private XSD.Ntype__entity.text_map? _text_map = null;
    public XSD.Ntype__entity.text_map text_mapOrCreate
    {
      get
      {
        if(_text_map == null)
        {
          _text_map = new();
          _text_map.ParentNode = this;
          NotifyChange();
        }
        return _text_map;
      }
      set
      {
        _text_map = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__entity.text_map? text_map
    {
      get
      {
        return _text_map;
      }
      set
      {
        _text_map = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }

    private XSD.Ntype__entity.containers? _containers = null;
    public XSD.Ntype__entity.containers containersOrCreate
    {
      get
      {
        if(_containers == null)
        {
          _containers = new();
          _containers.ParentNode = this;
          NotifyChange();
        }
        return _containers;
      }
      set
      {
        _containers = value;
        if(value != null)
        {
          value.ParentNode = this;
        }

      }
    }
    public XSD.Ntype__entity.containers? containers
    {
      get
      {
        return _containers;
      }
      set
      {
        _containers = value;
        if(value != null)
        {
          value.ParentNode = this;
        }
      }
    }
    public type__entity()
    {
    }

    public type__entity(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public type__entity(XmlElement xmlElement)
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
      if(name == "entity_rule_ref")
      {
        Set_entity_rule_ref(value);
      }
    }

    public void SetChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__entity.text_map text_map)
      {
        this.text_map = text_map;
      }

      if(linkedNode is XSD.Ntype__entity.containers containers)
      {
        this.containers = containers;
      }

    }

    public void ClearChild(dynamic linkedNode)
    {
      if(linkedNode is XSD.Ntype__entity.text_map)
      {
        this.text_map = null;
      }

      if(linkedNode is XSD.Ntype__entity.containers)
      {
        this.containers = null;
      }

    }

    public Action OnSelfChange(Action<type__entity> callback)
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
      // Godot.GD.Print("Deserializing type__entity");
      //Deserialize arguments
      if(rawNode.attributes.ContainsKey("id"))
      {
        var attribute_id = rawNode.attributes["id"];
        this.id = rawNode.attributes["id"];
      }
      if(rawNode.attributes.ContainsKey("entity_rule_ref"))
      {
        var attribute_entity_rule_ref = rawNode.attributes["entity_rule_ref"];
        this.entity_rule_ref = rawNode.attributes["entity_rule_ref"];
      }

      //Deserialize children
      text_map = rawNode.InitializeWithRawNode("text_map", text_map);

      containers = rawNode.InitializeWithRawNode("containers", containers);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments
      if(this._id != null)
      {
        rawNode.attributes["id"] = this._id.ToString();
      }
      if(this._entity_rule_ref != null)
      {
        rawNode.attributes["entity_rule_ref"] = this._entity_rule_ref?.ToString();
      }

      //Serialize children
      if(text_map != null) {
        rawNode.children["text_map"] = new List<RawNode> { text_map.SerializeIntoRawNode() };
      }
      if(containers != null) {
        rawNode.children["containers"] = new List<RawNode> { containers.SerializeIntoRawNode() };
      }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing type__entity");
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
    public System.String? Get_entity_rule_ref()
    {
      return this.entity_rule_ref;
    }
    public void Set_entity_rule_ref(System.String? value)
    {
      this.entity_rule_ref = value;
      this.NotifyChange();
    }


    public void DeserializeAtPath(string xpath, RawNode rawNode)
    {
      if(xpath.StartsWith("."))
      {
        xpath = xpath.Substring(1);
      }
      if(xpath.StartsWith(XSD.Ntype__entity.text_map.TagName))
      {
        this.text_map ??= new XSD.Ntype__entity.text_map();
        var childXPath = xpath.Substring(XSD.Ntype__entity.text_map.TagName.Length + 3);
        this.text_map.DeserializeAtPath(childXPath, rawNode);
        return;
      }
      if(xpath.StartsWith(XSD.Ntype__entity.containers.TagName))
      {
        this.containers ??= new XSD.Ntype__entity.containers();
        var childXPath = xpath.Substring(XSD.Ntype__entity.containers.TagName.Length + 3);
        this.containers.DeserializeAtPath(childXPath, rawNode);
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
      if(linkedNode is XSD.Ntype__entity.text_map casted_text_map) {
        return 0;
      }
      if(linkedNode is XSD.Ntype__entity.containers casted_containers) {
        return 0;
      }
      return null;
    }

    public bool IsValidChildType(ILinkedNode candidateChild) {
      return candidateChild is XSD.Ntype__entity.text_map
      || candidateChild is XSD.Ntype__entity.containers
      || false;
    }

    public bool Equals(type__entity? obj)
    {
        if (obj == null || GetType() != obj.GetType())
            return false;

        var other = (type__entity)obj;
        return Equals(id, other.id) && Equals(entity_rule_ref, other.entity_rule_ref) && Equals(text_map, other.text_map) && Equals(containers, other.containers);
    }

    public override int GetHashCode()
    {
        var acc = 0;

        acc = HashCode.Combine(acc, id);
        acc = HashCode.Combine(acc, entity_rule_ref);
        acc = HashCode.Combine(acc, text_map);
        acc = HashCode.Combine(acc, containers);
        return acc;
    }
  }
}