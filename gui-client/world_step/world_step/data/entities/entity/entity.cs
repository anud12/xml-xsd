using System;
using System.Collections.Immutable;
using System.Collections.Generic;
using System.Xml;
using System.Linq;
using Guiclient.util;
using Godot;
using XSD;

namespace XSD.Nworld_step.Ndata.Nentities.Nentity {}
namespace XSD {
  public interface Itype__entity {
    //Attributes
    public System.String id { get; set; }
    public System.String? entity_rule_ref { get; set; }

    //Children elements
    public XSD.Ntype__entity.containers containers { get; set; }
    public void Deserialize (RawNode rawNode);

    public RawNode SerializeIntoRawNode();

    public void Serialize(XmlElement element);

  }
}
namespace XSD.Nworld_step.Ndata.Nentities {
  public class entity : IEquatable<entity>, XSD.ILinkedNode , Itype__entity {

    public static string ClassTypeId = ".world_step.data.entities.entity";
    public static string TagName = "entity";

    public string NodeName {get =>"entity";}
    public RawNode rawNode = new RawNode();

    private ILinkedNode? _parentNode;
    public ILinkedNode? ParentNode {get => _parentNode; set => _parentNode = value;}
    private List<Action<entity>> _onSelfChangeCallbackList = new();
    private List<Action<List<ILinkedNode>>> _onChangeCallbackList = new();

    //Attributes

    //Attributes of type__entity
    private System.String _id;
    public System.String id { get => _id; set => _id = value; }
    private System.String? _entity_rule_ref;
    public System.String? entity_rule_ref { get => _entity_rule_ref; set => _entity_rule_ref = value; }

    //Children elements

    //Children of type__entity
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
    public entity()
    {
    }

    public entity(RawNode rawNode)
    {
      Deserialize(rawNode);
    }

    public entity(XmlElement xmlElement)
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

    public Action OnSelfChange(Action<entity> callback)
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
      // Godot.GD.Print("Deserializing entity");
      //Deserialize arguments

      // Deserialize arguments of type__entity
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

      // Deserialize children of type__entity
  containers = rawNode.InitializeWithRawNode("containers", containers);
      NotifyChange();
    }

    public RawNode SerializeIntoRawNode()
    {
      //Serialize arguments

      // Serialize arguments of type__entity
  if(this._id != null)
  {
    rawNode.attributes["id"] = this._id.ToString();
  }
  if(this._entity_rule_ref != null)
  {
    rawNode.attributes["entity_rule_ref"] = this._entity_rule_ref?.ToString();
  }

      //Serialize children

      // Serialize children of type__entity
  if(containers != null) {
    rawNode.children["containers"] = new List<RawNode> { containers.SerializeIntoRawNode() };
  }
      return rawNode;
    }

    public void Serialize(XmlElement element)
    {
        // Godot.GD.Print("Serializing entity");
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

        public bool Equals(entity? obj)
        {
            if (obj == null || GetType() != obj.GetType())
                return false;

            var other = (entity)obj;
            return object.Equals(this, other);
        }

    public int GetHashCode()
    {
        return base.GetHashCode();
    }
  }
}